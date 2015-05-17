package game;

import java.util.Scanner;
import java.util.TreeSet;

public class Game {

	private TreeSet<String> set;
	private char lastchar;

	Game(TreeSet<String> set) {

		this.set = set;
		lastchar = 'а';
	}

	private boolean turn(String city) {

		if (city.charAt(0) != lastchar) {

			System.out.println("Слово начинается на неправильную букву!");
			return false;
		}

		if (set.remove(city) != true) {
			System.out.println("Словa нет в списке!");
			return false;
		}

		if(city.toLowerCase().charAt(city.length() - 1)=='ы') lastchar = city.toLowerCase().charAt(city.length() - 2);
		else lastchar = city.toLowerCase().charAt(city.length() - 1);
		System.out.println("Ход :" + city);
		return true;

	}

	public boolean pcTurn() {
		for (String s : set) {
			if (s.charAt(0) == lastchar) {
				turn(s);
				return true;
			}
		}

		return false;
	}

	public void start() {

		Scanner sc = new Scanner(System.in);
		String turn;
		outer: while (true) {

			if (!pcTurn()) {
				System.out.println("Вы победили");
				break;
			}
			do {

				turn = sc.nextLine().toLowerCase();
				if (turn.equals("выход")) {
					System.out.println("Вы проиграли");
					break outer;
				}
			} while (!turn(turn));

		}

		System.out.println("Конец игры!");
	}
}
