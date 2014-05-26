package hu.diablo.paragon;
import java.io.IOException;
import java.math.BigInteger;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for storing the formula for calculations.
 * @author Dyingsoul
 */

public class ParagonCalculator {
	/**
	 * Creating new logger.
	 */
	 protected static Logger logger = LoggerFactory.getLogger(ParagonCalculator.class);
	 
/**
 * The method calculateParagon calculates the amount of experience required to the next level,
 * the amount of hours needed to reach the next level,
 * the amount of experience required to the desired level,
 * the amount of hours needed to reach the desired level.
 * @param currentLevel is the user's current level.
 * @param expPerHour is the user's experience gain per hour.
 * @param desiredLevel is the user's desired level.
 * @param hoursPlayedPerDay tells how many hours does the user playing per day.
 * @return the result.
 * @throws ParserConfigurationException is the Exception upon ParserConfiguration.
 * @throws SAXException is the Exception upon SAX.
 * @throws IOException	is the Exception upon IO.
 */
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
