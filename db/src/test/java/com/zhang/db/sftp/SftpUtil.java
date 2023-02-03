package com.zhang.db.sftp;

import com.jcraft.jsch.*;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/17 10:52
 */
public class SftpUtil {
    public static void main(String[] args) throws JSchException, SftpException {
        JSch jSch = new JSch();
        Session session = jSch.getSession("zhangjiwei", "access.yz.corpautohome.com", 22);
        session.setPassword("Zz741963");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        Channel channel = session.openChannel("sftp");
        channel.connect();
        System.out.println(channel);
        ChannelSftp sftp = (ChannelSftp) channel;
        sftp.cd("/home");


        System.out.println("home:" + sftp.getHome());
        System.out.println("pwd:"+sftp.lpwd());

        sftp.disconnect();
        session.disconnect();
    }
}
