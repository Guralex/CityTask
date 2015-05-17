package game;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("Анапа".toLowerCase());
		set.add("Аргентина".toLowerCase());
		set.add("бооб".toLowerCase());
		set.add("Аналб".toLowerCase());
		System.out.println(set);
		
		Game game=new Game(set);
		
		game.start();
	}

}
