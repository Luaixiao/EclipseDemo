package Test;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSockCliet {
	public static void main(String args[]) {
		InputStream is = null;
		OutputStream out = null;
		String str = null;
		try {
			Socket socket = new Socket("localhost", 8888);
			is = socket.getInputStream();
			out = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF("客户端提交信息到服务器....");
			if ((str = dis.readUTF()) != null) {
				System.out.println(str);
			}
			dos.close();
			dis.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
