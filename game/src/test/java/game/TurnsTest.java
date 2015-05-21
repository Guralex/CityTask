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
		fakeset.add("��");
		fakeset.add("��");
		fakeset.add("��");
		fakeset.add("��");
		fakeset.add("��");
		mock = EasyMock.createMock(Parsing.class);
		EasyMock.expect(mock.parse("")).andReturn(fakeset);
		EasyMock.replay(mock);
		TreeSet<String> set=mock.parse("");
		game=new Game(set);
				
	}
	
	@Test
	public void turnTest() {
		
		assertTrue(game.getSet().contains("��"));
		assertEquals(game.getLastchar(),'�');
		assertTrue(game.turn("��"));
		EasyMock.verify(mock);
	}

	
	@Test
	public void lastCharTest() {
		
		assertEquals(game.getLastchar(),'�');
		game.turn("��");
		assertEquals(game.getLastchar(),'�');
		EasyMock.verify(mock);
	}
	
	
	
	@Test
	public void illegalWordTest() {
		
		assertEquals(game.getLastchar(),'�');
		assertFalse(game.turn("!!"));
		EasyMock.verify(mock);
	}
	
	@Test
	public void specialCharTest() {
		
		assertEquals(game.getLastchar(),'�');
		game.turn("��");
		assertEquals(game.getLastchar(),'�');
		game.turn("��");
		assertEquals(game.getLastchar(),'�');
		EasyMock.verify(mock);
	}
	
	
	@Test
	public void setTest() {
		
		assertTrue(game.getSet().contains("��"));
		assertTrue(game.turn("��"));
		assertFalse(game.getSet().contains("��"));
		EasyMock.verify(mock);
	}
	

}
