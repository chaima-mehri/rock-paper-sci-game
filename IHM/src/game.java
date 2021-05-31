import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class game extends Thread{

	private PrintWriter pw;
	private String msg;
	private String msg_p;
	private int result;

	public void run(){
		
		
		try {
			Socket socketClient = new Socket("127.0.0.1", 9000);
			System.out.println("je suis connecte");

			pw = new PrintWriter(socketClient.getOutputStream());

			session sess;
			
			
			

			while (true) {
				
				sess=new session(socketClient);
				sess.start();

				msg = "";
				msg_p="";


				while(msg.equals("") && msg_p.equals("")) {
					msg=sess.getMsg();
					msg_p=Main.I.getmsg_p();
				}
				
				
				if(msg.equals("")) {
					Main.I.addmsg("You have played ");
					Main.I.addmsg(Main.I.getmsg_p());

					sess.join();
					
					msg=sess.getMsg();
				}else {
					Main.I.addmsg("Server have played ");
					while(msg_p.equals("")) {
						msg_p=Main.I.getmsg_p();
					}
					
				}
				
				
				System.out.println(msg_p+"  "+msg);

				if ((msg_p.equals("Rock")) && (msg.equals("Rock"))) {
					result = 2;

				} else if ((msg_p.equals("Scissor")) && (msg.equals("Scissor"))) {
					result = 2;

				} else if ((msg_p.equals("Paper")) && (msg.equals("Paper"))) {
					result = 2;

				} else if ((msg_p.equals("Rock")) && (msg.equals("Scissor"))) {
					result = 1;

				} else if ((msg_p.equals("Scissor")) && (msg.equals("Paper"))) {
					result = 1;

				} else if ((msg_p.equals("Paper")) && (msg.equals("Rock"))) {
					result = 1;

				} else {
					result = 0;
				}
				
				
				if (result == 1) {
					Main.I.addmsg("You won!!");
				} else if (result == 0) {
					Main.I.addmsg("You Lost!!");
				} else {
					Main.I.addmsg("tie!!");
				}
				

				sess.setMsg("");
				Main.I.setmsg_p("");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void send(String msg) {
		pw.println(msg);
		pw.flush();
	}

}
