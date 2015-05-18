package game;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class TurnsTest {

	Game game;
	@Before
	public void start(){
		
		TreeSet<String> set = new TreeSet<String>() ;
		set.add("��");
		set.add("a�");
		set.add("a�");
		game=new Game(set);
		
		
	}
	
	@Test
	public void lastCharTest() {
		assertEquals(game.getLastchar(),'�');
		game.turn("��");
		assertEquals(game.getLastchar(),'�');
	}
	
	@Test
	public void illegalCharTest() {
		assertEquals(game.getLastchar(),'�');
		assertFalse(game.turn("!!"));
	}
	
	@Test
	public void specialCharTest() {
		assertEquals(game.getLastchar(),'�');
		game.turn("a�");
		assertEquals(game.getLastchar(),'�');
		game.turn("��");
		assertEquals(game.getLastchar(),'�');
	}
	
	
	
	

}
