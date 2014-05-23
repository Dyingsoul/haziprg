import java.io.IOException;
import java.math.BigInteger;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParagonCalculator {

	public static ParagonResult calculateParagon(int currentLevel,
			int expPerHour, int desiredLevel, int hoursPlayedPerDay) throws ParserConfigurationException, SAXException, IOException {

		BigInteger sumExp = new BigInteger("0");
		BigInteger expPerHourInMillions = new BigInteger(String.valueOf(expPerHour*1000000));
		int hoursToDesiredLevel;
		int daysToReachLevel;
		int hoursToNextLevel;
		BigInteger expToNextLevel = new BigInteger ("0");
		NodeList levels = XmlLoader.getLevels();
		Node nextlevel = levels.item(currentLevel+1);
		Node currentLevelNode = levels.item(currentLevel);
		Node desiredLevelNode = levels.item(desiredLevel);
		
		expToNextLevel = expToNextLevel.add(new BigInteger (((Element) nextlevel).getAttribute("exp")).subtract(new BigInteger (((Element) currentLevelNode).getAttribute("exp"))));
				
		sumExp = sumExp.add(new BigInteger (((Element) desiredLevelNode).getAttribute("exp")).subtract(new BigInteger (((Element) currentLevelNode).getAttribute("exp"))));
		
		hoursToNextLevel = expToNextLevel.divide(expPerHourInMillions).intValue();
		hoursToDesiredLevel = sumExp.divide(expPerHourInMillions).intValue();
		daysToReachLevel = hoursToDesiredLevel/hoursPlayedPerDay;
		
		return new ParagonResult(expToNextLevel, hoursToNextLevel, sumExp, hoursToDesiredLevel, daysToReachLevel);
	}

}
