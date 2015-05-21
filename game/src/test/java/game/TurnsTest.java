package game;

import static org.junit.Assert.*;

import java.util.TreeSet;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class TurnsTest {

	Game game;
	Parsing mock;
	TreeSet<String> fakeset=new TreeSet<String>();
	
	
	@Before
	public void start(){
		fakeset.add("אא");
		fakeset.add("אב");
		fakeset.add("בג");
		fakeset.add("אû");
		fakeset.add("אü");
		mock = EasyMock.createMock(Parsing.class);
		EasyMock.expect(mock.parse("")).andReturn(fakeset);
		EasyMock.replay(mock);
		TreeSet<String> set=mock.parse("");
		game=new Game(set);
				
	}
	
	@Test
	public void turnTest() {
		
		assertTrue(game.getSet().contains("אב"));
		assertEquals(game.getLastchar(),'א');
		assertTrue(game.turn("אב"));
		EasyMock.verify(mock);
	}

	
	@Test
	public void lastCharTest() {
		
		assertEquals(game.getLastchar(),'א');
		game.turn("אב");
		assertEquals(game.getLastchar(),'ב');
		EasyMock.verify(mock);
	}
	
	
	
	@Test
	public void illegalWordTest() {
		
		assertEquals(game.getLastchar(),'א');
		assertFalse(game.turn("!!"));
		EasyMock.verify(mock);
	}
	
	@Test
	public void specialCharTest() {
		
		assertEquals(game.getLastchar(),'א');
		game.turn("אü");
		assertEquals(game.getLastchar(),'א');
		game.turn("אû");
		assertEquals(game.getLastchar(),'א');
		EasyMock.verify(mock);
	}
	
	
	@Test
	public void setTest() {
		
		assertTrue(game.getSet().contains("אב"));
		assertTrue(game.turn("אב"));
		assertFalse(game.getSet().contains("אב"));
		EasyMock.verify(mock);
	}
	

}
