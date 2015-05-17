package game;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class TurnsTest {

	@Before
	public void start(){
		
		TreeSet<String> set = new TreeSet<String>() ;
		set.add("¿·");
		set.add("¡‚");
		Game game=new Game(set);
		
	}
	
	@Test
	public void testTurn() {
		assertTrue(true);
	}

}
