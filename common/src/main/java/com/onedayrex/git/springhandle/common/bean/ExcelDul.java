package com.onedayrex.git.springhandle.common.bean;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelDul {

    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("C:/1.xlsx");
        List<Map<String, Object>> code = reader.readAll();
        List<String> codeList = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : code) {
            codeList.add((String) stringObjectMap.get("营业厅编码"));
        }
        List<String> title = CollUtil.newArrayList("序号","上级商户营业执照号","名称","类型","营业厅编码","营业执照号","法人姓名","法人身份证","联系电话","商户省","市","区","详细地址","户名","银行账号","开户行","账户类型","商户状态");
        ExcelReader descReader = ExcelUtil.getReader("C:/123.xlsx");
        List<Map<String, Object>> desc = descReader.readAll();
        List<List<String>> rows = CollUtil.newArrayList();
        for (Map<String, Object> descMap : desc) {
            String codeName = String.valueOf(descMap.get("营业厅编码"));
            if (codeList.contains(codeName)) {
                List<String> col = CollUtil.newArrayList();
                for (String s : title) {
                    col.add(String.valueOf(descMap.get(s)));
                }
                rows.add(col);
            }
        }
        ExcelWriter writer = ExcelUtil.getWriter("C:/Users/537002/Documents/writeTest.xlsx");
        writer.writeHeadRow(title);
        writer.write(rows);
        writer.close();
        System.out.println(code);
    }
}
