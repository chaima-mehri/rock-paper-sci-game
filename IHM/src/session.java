import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class session extends Thread{

	Socket s;
	volatile String msg=""; 



	public session(Socket s) {
		this.s=s;
	}

	public void run() {
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			msg=reader.readLine();


		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
