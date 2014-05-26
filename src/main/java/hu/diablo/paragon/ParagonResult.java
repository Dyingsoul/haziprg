package hu.diablo.paragon;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for costructing the result.
 * @author Dyingsoul
 */
public class ParagonResult {
	/**
	 * Creating new logger.
	 */
	protected static Logger logger = LoggerFactory.getLogger(ParagonResult.class);
	
	/**
	 * @value expNextLevel Stores the amount of experience required to the next level.
	 * @value hoursNextLevel Stores the amount of hours needed to reach the next level.
	 * @value expToDesiredLevel Stores the amount of experience required to the desired level.
	 * @value hoursToDesiredLevel Stores the amount of hours needed to reach the desired level.
	 */
	private BigInteger expNextLevel;
	private int hoursNextLevel;
	private BigInteger expToDesiredLevel;
	private int hoursToDesiredLevel;
	private int daysToDesiredLevel;

	/**
	 * @param expNextLevel Stores the amount of experience required to the next level.
	 * @param hoursNextLevel Stores the amount of hours needed to reach the next level.
	 * @param expToDesiredLevel Stores the amount of experience required to the desired level.
	 * @param hoursToDesiredLevel Stores the amount of hours needed to reach the desired level.
	 * @param daysToDesiredLevel Stores the amount of days needed to reach the desired level.
	 */
	public ParagonResult(BigInteger expNextLevel, int hoursNextLevel,
			BigInteger expToDesiredLevel, int hoursToDesiredLevel,
			int daysToDesiredLevel) {
		super();
		this.expNextLevel = expNextLevel;
		this.hoursNextLevel = hoursNextLevel;
		this.expToDesiredLevel = expToDesiredLevel;
		this.hoursToDesiredLevel = hoursToDesiredLevel;
		this.daysToDesiredLevel = daysToDesiredLevel;
	}

	/**
	 * @return The days needed to reach the desired level.
	 */
	public int getDaysToDesiredLevel() {
		return daysToDesiredLevel;
	}

	/**
	 * @return The amount of experience needed to next level.
	 */
	public BigInteger getExpNextLevel() {
		return expNextLevel;
	}

	/**
	 * @return The amount of hours needed to reach the next level.
	 */
	public int getHoursNextLevel() {
		return hoursNextLevel;
	}

	/**
	 * @return The amount of experience required to the desired level.
	 */
	public BigInteger getExpToDesiredLevel() {
		return expToDesiredLevel;
	}

	/**
	 * @return The amount of hours needed to reach the desired level.
	 */
	public int getHoursToDesiredLevel() {
		return hoursToDesiredLevel;
	}
}
