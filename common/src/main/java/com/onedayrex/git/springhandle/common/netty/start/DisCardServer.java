package com.onedayrex.git.springhandle.common.netty.start;

import com.onedayrex.git.springhandle.common.netty.server.handle.DisCardServerHandle;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisCardServer {
    private static final Logger logger = LoggerFactory.getLogger(DisCardServer.class);

    private int port = 8888;

    public void run() {
        //1、创建bossgroup用来接收消息
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //2、创建workergroup用来处理消息
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //3、创建启动参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DisCardServerHandle());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            //4、绑定端口
            ChannelFuture sync = bootstrap.bind(port).sync();
            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("error:", e);
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        DisCardServer disCardServer = new DisCardServer();
        disCardServer.run();
    }
}
