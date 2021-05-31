import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class session extends Thread{

	Socket s;
	 volatile String msg_p=""; 



	public session(Socket s) {
		this.s=s;
	}

	public void run() {
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			msg_p=reader.readLine();


		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	public String getMsg_p() {
		return msg_p;
	}

	public void setMsg_p(String msg_p) {
		this.msg_p = msg_p;
	}

}
