import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TestParagonCalculator  {

	@Test
	public void testcalculateParagon1() throws ParserConfigurationException, SAXException, IOException {
		ParagonResult result = ParagonCalculator.calculateParagon(150,10,155,5);
		//ParagonResult expectedResult = new ParagonResult (new BigInteger ("220320000"),22,new BigInteger ("1122000000"),112,22);
		//assertTrue(result.equals(expectedResult));
		assertEquals(new BigInteger ("220320000"), result.getExpNextLevel());
		assertEquals(22, result.getHoursNextLevel());
		assertEquals(new BigInteger ("1122000000"), result.getExpToDesiredLevel());
		assertEquals(112, result.getHoursToDesiredLevel());
		assertEquals(22, result.getDaysToDesiredLevel());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testcalculateParagon2() throws ParserConfigurationException, SAXException, IOException {
		ParagonResult result = ParagonCalculator.calculateParagon(245,11,310,12);
		assertEquals(new BigInteger ("414120000"), result.getExpNextLevel());
		assertEquals(37, result.getHoursNextLevel());
		assertEquals(new BigInteger ("34894200000"), result.getExpToDesiredLevel());
		assertEquals(3172, result.getHoursToDesiredLevel());
		assertEquals(264, result.getDaysToDesiredLevel());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testcalculateParagon3() throws ParserConfigurationException, SAXException, IOException {
		ParagonResult result = ParagonCalculator.calculateParagon(365,280,450,7);
		assertEquals(new BigInteger ("928200000"), result.getExpNextLevel());
		assertEquals(3, result.getHoursNextLevel());
		assertEquals(new BigInteger ("100747440000"), result.getExpToDesiredLevel());
		assertEquals(359, result.getHoursToDesiredLevel());
		assertEquals(51, result.getDaysToDesiredLevel());
		
		//fail("Not yet implemented");
	}
	
}
