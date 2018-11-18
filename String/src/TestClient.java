import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	public static void main(String args[])
	{
		try {
			Socket s = new Socket("127.0.0.1",8888);
			InputStream is =s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("服务器连接失败！！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
