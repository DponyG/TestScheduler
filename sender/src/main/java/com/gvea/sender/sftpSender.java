package com.gvea.sender;


import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.faces.bean.ManagedBean;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@ManagedBean
@Stateless
public class sftpSender extends Sender {

	public sftpSender() {
		// TODO Auto-generated constructor stub
	}
	
	static Logger logger = Logger.getLogger("sftpSender");
	

	public void send() {
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		System.out.println("preparing the host information for sftp");

		try {
			JSch jsch = new JSch();
			session = jsch.getSession(getUserName(), getHostName(), getPort());
			session.setPassword(getUserPass());
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			System.out.println("Host connected.");
			channel = session.openChannel("sftp");
			channel.connect();
			System.out.println("sftp channel opened and connected.");
			channelSftp = (ChannelSftp) channel;
			channelSftp.put("C:\\Users\\dpony\\Desktop\\test\\test.txt", "\\");
		} catch (Exception ex) {
			System.out.println("Exception found while tranfering the response.");
		} finally {
			channelSftp.exit();
			System.out.println("sftp Channel exited.");
			channel.disconnect();
			System.out.println("Channel disconnected.");
			session.disconnect();
			System.out.println("Host Session disconnected.");
		}
	}
}
