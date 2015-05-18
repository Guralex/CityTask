package game;


import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

import org.apache.log4j.Logger;

public class Game {

	private TreeSet<String> set;
	private char lastchar;
	final Logger log = Logger.getLogger(Game.class);
	Game(TreeSet<String> set) {

		this.set = set;
		lastchar = 'а';
	}

	public char getLastchar() {
		return lastchar;
	}

	public boolean turn(String city) {

		if (city.charAt(0) != lastchar) {

			System.out.println("Слово начинается на неправильную букву!");
			return false;
		}

		if (set.remove(city) != true) {
			System.out.println("Словa нет в списке!");
			return false;
		}

		if(city.toLowerCase().charAt(city.length() - 1)=='ы'||city.toLowerCase().charAt(city.length() - 1)=='ь') lastchar = city.toLowerCase().charAt(city.length() - 2);
		else lastchar = city.toLowerCase().charAt(city.length() - 1);
		System.out.println("Ход :" + city);
		log.info("Ход : "+city);
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
		Date d = new Date();
		
		log.info("------------------------------------------\n"+"ИГРА "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"------------------------------------------\n");
		outer: while (true) {

			if (!pcTurn()) {
				System.out.println("Вы победили");
				log.info("Победил игрок");
				break;
			}
			do {

				turn = sc.nextLine().toLowerCase();
				if (turn.equals("выход")) {
					System.out.println("Вы проиграли");
					log.info("Победил компьютер");
					break outer;
				}
			} while (!turn(turn));

		}

		System.out.println("Конец игры!");
	}
}
