package game;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("�����".toLowerCase());
		set.add("���������".toLowerCase());
		set.add("����".toLowerCase());
		set.add("�����".toLowerCase());
		System.out.println(set);
		
		Game game=new Game(set);
		
		game.start();
	}

}
