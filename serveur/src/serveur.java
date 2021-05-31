import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class serveur extends JFrame{

	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JTextArea a1;
	private volatile String msg="";
	private ImageIcon icone1;
	private ImageIcon icone2;
	private ImageIcon icone3;



	public serveur() {

		 
		setPreferredSize(new Dimension(800, 800));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Server");
		setLayout(new GridLayout(1,2));
		
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,1));
		JPanel p1=new JPanel(new FlowLayout());
		JPanel p2=new JPanel(new FlowLayout());
		JPanel p3=new JPanel(new FlowLayout());

		bt1 = new JButton("Rock");
		bt2 = new JButton("Paper");
		bt3 = new JButton("Scissor");

		bt1.addActionListener(new Ecouteur());
		bt2.addActionListener(new Ecouteur());
		bt3.addActionListener(new Ecouteur());

		icone1 = new ImageIcon(getClass().getResource("rock.png"));
		JLabel	lbl_icone1 = new JLabel(icone1);
		
		p1.add(lbl_icone1);
		p1.add(bt1);

		icone2 = new ImageIcon(getClass().getResource("paper.png"));
		JLabel	lbl_icone2 = new JLabel(icone2);

		p2.add(lbl_icone2);
		p2.add(bt2);


		icone3 = new ImageIcon(getClass().getResource("sci.png"));
		JLabel	lbl_icone3 = new JLabel(icone3);

		p3.add(lbl_icone3);
		p3.add(bt3);
		
		p.add(p1);
		p.add(p2);
		p.add(p3);
		
		add(p);
		
		a1 = new JTextArea();
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		
		JScrollPane JS=new JScrollPane(a1);
		
		add(JS);
		
		
		
		pack();
		
	}



	public class Ecouteur implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bt1) {
				msg = "Rock";
			}
			if (e.getSource() == bt2) {
				msg = "Paper";
			}
			if (e.getSource() == bt3) {
				msg = "Scissor";
			}
			Main.g.send(msg);

		}

	}
	
	public void addmsg(String m) {
		a1.append(m+"\n");
		a1.revalidate();
		a1.repaint();
		
	}
	
	public String getmsg() {
		return msg;
	}
	
	public void setmsg(String m) {
		msg=m;
	}
}
