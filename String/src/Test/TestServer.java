package Test;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TestServer {
	public static void main(String args[]) {
		try {
			ServerSocket s = new ServerSocket(8888); // 创建ServerSocket对象，并指定端口号为8888
			while (true) // 循环接收消息
			{
				Socket ss = s.accept(); // 监听并接收套接字
				OutputStream os = ss.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("客户端IP：" + ss.getInetAddress().getHostAddress() + "客户端端口号:" + ss.getPort());
				dos.close();
				ss.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("程序出错！！");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
