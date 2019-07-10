package com.topica.maitrongnghia.sendfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static final String PATH_FILE = "D:\\video\\video.mp4";
	public static final String HOST = "127.0.0.1";
	public static final Integer POST = 4444;
	public static final Integer SIZE_PER_READING = 64 * 1024;

	public static void main(String[] args) throws IOException {

		Socket socket = null;

		int DataSend;
		byte[] bytes = new byte[SIZE_PER_READING];

		socket = new Socket(HOST, POST);

		File file = new File(PATH_FILE);
		InputStream in = new FileInputStream(file);
		OutputStream out = socket.getOutputStream();

		while ((DataSend = in.read(bytes)) > 0) {
			out.write(bytes, 0, DataSend);
		}

		out.close();
		in.close();
		socket.close();
	}
}