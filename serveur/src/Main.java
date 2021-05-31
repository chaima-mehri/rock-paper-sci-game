import java.util.Objects;

public class Main {

	public static serveur s;
	public static game g;

	public static void main(String[] args) {
		s=new serveur(); 

		g=new game();
		g.start();
	}

}
