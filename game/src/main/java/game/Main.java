package game;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		Parsing parser=Factory.getParse("XML");
		
		TreeSet<String> set ;
		
		set = parser.parse("");
		System.out.println(set);
		
		Game game=new Game(set);
		
		game.start();
	}

}
