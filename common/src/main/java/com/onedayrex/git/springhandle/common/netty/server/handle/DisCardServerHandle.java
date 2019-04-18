package com.onedayrex.git.springhandle.common.netty.server.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisCardServerHandle extends ChannelHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(DisCardServerHandle.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ((ByteBuf) msg).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常关闭
        logger.error("error:", cause);
        ctx.close();
    }
}
