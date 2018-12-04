package com.gvea.sender;



abstract class Sender {
	
	private String hostName;
	private String userName;
	private String userPass;
	private int port;
	private String fileToTransfer;
	
	public Sender() {
		//Auto-generated constructor stub
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getFileToTransfer() {
		return fileToTransfer;
	}

	public void setFileToTransfer(String fileToTransfer) {
		this.fileToTransfer = fileToTransfer;
	}
   
		
}



