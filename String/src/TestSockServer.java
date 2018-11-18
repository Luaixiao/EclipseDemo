import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSockServer {
	public static void main(String args[]) {
		InputStream in = null;
		OutputStream out = null;
		try {
			ServerSocket s= new ServerSocket(8888);
			System.out.println("服务器启动.....");
			Socket s1=s.accept();
			in = s1.getInputStream();
			out = s1.getOutputStream();
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			String str = null;
			if((str=dis.readUTF())!=null)
			{
				System.out.println("客户端输入内容："+str);
				System.out.println("客户端IP地址："+s1.getInetAddress().getHostAddress());
				System.out.println("客户端端口号："+s1.getPort());
			}
			dos.writeUTF("服务器端反馈客户端！");
			dis.close();
			dos.close();
			s1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
