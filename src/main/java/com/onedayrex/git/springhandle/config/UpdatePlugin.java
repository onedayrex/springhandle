package com.onedayrex.git.springhandle.config;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLCharExpr;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.SQLInsertStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlInsertStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUpdateStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.util.JdbcConstants;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})})
public class UpdatePlugin implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(UpdatePlugin.class);
    private static final String[] INSERT_CATE = {"create_time", "update_time"};
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler routingStatementHandler = (RoutingStatementHandler) invocation.getTarget();
            BoundSql boundSql = routingStatementHandler.getBoundSql();
            String sql = boundSql.getSql();
            SQLStatement sqlStatement = new MySqlStatementParser(sql).parseStatement();
            if (sqlStatement instanceof MySqlInsertStatement) {
                this.insertSql((MySqlInsertStatement)sqlStatement);
                Field field = BoundSql.class.getDeclaredField("sql");
                field.setAccessible(true);
                field.set(boundSql,SQLUtils.toMySqlString(sqlStatement));
            } else if (sqlStatement instanceof MySqlUpdateStatement) {
                this.updateSql((MySqlUpdateStatement) sqlStatement);
            }
            logger.info("sql==>{}", boundSql.getSql());
        }
        return invocation.proceed();
    }

    private void updateSql(MySqlUpdateStatement sqlStatement) {
        SchemaStatVisitor schemaStatVisitor = SQLUtils.createSchemaStatVisitor(JdbcConstants.MYSQL);
        sqlStatement.accept(schemaStatVisitor);
        Collection<TableStat.Column> columns = schemaStatVisitor.getColumns();
    }

    private void insertSql(MySqlInsertStatement sqlStatement) {
        SchemaStatVisitor schemaStatVisitor = SQLUtils.createSchemaStatVisitor(JdbcConstants.MYSQL);
        sqlStatement.accept(schemaStatVisitor);
        Collection<TableStat.Column> columns = schemaStatVisitor.getColumns();
        List<String> insertValue = Arrays.asList(INSERT_CATE);
        for (String insert : INSERT_CATE) {
            if (insert.equals(columns)) {
                insertValue.remove(insert);
            }
        }
        for (String s : insertValue) {
            sqlStatement.getColumns().add(new SQLIdentifierExpr(s));
            for (SQLInsertStatement.ValuesClause valuesClause : sqlStatement.getValuesList()) {
                valuesClause.addValue(new SQLCharExpr("2017-07-01 12:00:00"));
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof RoutingStatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
