import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class game extends Thread{

	private PrintWriter pw;
	private String msg_p;
	private String msg;
	private int result;

	public void run() {
		
		
		ServerSocket server;
		try {
			server = new ServerSocket(9000);
			System.out.println("serveur en etat d ecoute");
			Socket s = server.accept();
			System.out.println("client est connecte");

			pw = new PrintWriter(s.getOutputStream());

			session sess;

			while (true) {
				
				sess=new session(s);
				sess.start();
				
				msg="";
				msg_p = "";
				
				
				while(msg_p.equals("") && msg.equals("")) {
					msg_p=sess.getMsg_p();
					msg=Main.s.getmsg();
				}
				
				
				if(msg_p.equals("")) {
					Main.s.addmsg("You have played ");
					Main.s.addmsg(Main.s.getmsg());
					
					sess.join();
					msg_p=sess.getMsg_p();
					
					
				}else {
					Main.s.addmsg("Client have played ");
					while(msg.equals("")) {
						msg=Main.s.getmsg();
					}
				}
				
				
				System.out.println(msg+"  "+msg_p);

				if ((msg.equals("Rock")) && (msg_p.equals("Rock"))) {
					result = 2;

				} else if ((msg.equals("Scissor")) && (msg_p.equals("Scissor"))) {
					result = 2;

				} else if ((msg.equals("Paper")) && (msg_p.equals("Paper"))) {
					result = 2;

				} else if ((msg.equals("Rock")) && (msg_p.equals("Scissor"))) {
					result = 1;

				} else if ((msg.equals("Scissor")) && (msg_p.equals("Paper"))) {
					result = 1;

				} else if ((msg.equals("Paper")) && (msg_p.equals("Rock"))) {
					result = 1;

				} else {
					result = 0;
				}
				
				
				if (result == 1) {
					Main.s.addmsg("You won!!");
				} else if (result == 0) {
					Main.s.addmsg("You Lost!!");
				} else {
					Main.s.addmsg("tie !!");
				}
				
				sess.setMsg_p("");
				Main.s.setmsg("");
				
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
