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
		set.add("אב");
		set.add("aü");
		set.add("aû");
		game=new Game(set);
		
		
	}
	
	@Test
	public void lastCharTest() {
		assertEquals(game.getLastchar(),'א');
		game.turn("אב");
		assertEquals(game.getLastchar(),'ב');
	}
	
	@Test
	public void illegalCharTest() {
		assertEquals(game.getLastchar(),'א');
		assertFalse(game.turn("!!"));
	}
	
	@Test
	public void specialCharTest() {
		assertEquals(game.getLastchar(),'א');
		game.turn("aü");
		assertEquals(game.getLastchar(),'א');
		game.turn("אû");
		assertEquals(game.getLastchar(),'א');
	}
	
	
	
	

}
