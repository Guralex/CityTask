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
		mock = EasyMock.createMock(Parsing.class);
		EasyMock.expect(mock.parse("")).andReturn(fakeset);
		EasyMock.replay(mock);
		TreeSet<String> set=mock.parse("");
		game=new Game(set);
				
	}
	
	@Test
	public void lastCharTest() {
		
		assertEquals(game.getLastchar(),'א');
		game.turn("אב");
		assertEquals(game.getLastchar(),'ב');
		EasyMock.verify(mock);
	}
	
	@Test
	public void illegalCharTest() {
		
		assertEquals(game.getLastchar(),'א');
		assertFalse(game.turn("!!"));
		EasyMock.verify(mock);
	}
	
	@Test
	public void specialCharTest() {
		
		assertEquals(game.getLastchar(),'א');
		game.turn("aü");
		assertEquals(game.getLastchar(),'א');
		game.turn("אû");
		assertEquals(game.getLastchar(),'א');
		EasyMock.verify(mock);
	}
	
	
	
	

}
