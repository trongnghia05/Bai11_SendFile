package com.topica.maitrongnghia.sendfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final String PATH_FILE = "D:\\video2\\video.mp4";
	public static final Integer PORT = 4444;
	public static final Integer SIZE_PER_READING = 64 * 1024;

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] bytes = new byte[SIZE_PER_READING];
		int DataReceived;

		serverSocket = new ServerSocket(PORT);
		socket = serverSocket.accept();

		inputStream = socket.getInputStream();
		outputStream = new FileOutputStream(PATH_FILE);

		while ((DataReceived = inputStream.read(bytes)) > 0) {
			outputStream.write(bytes, 0, DataReceived);
		}

		outputStream.close();
		inputStream.close();
		socket.close();
		serverSocket.close();
	}
}