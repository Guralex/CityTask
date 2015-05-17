package game;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		Parsing parse = Factory.getParse("XML");
		
		parse.parse("");

	}

}
