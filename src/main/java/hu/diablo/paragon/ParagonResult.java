package hu.diablo.paragon;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>ParagonResult</code>Class for costructing the result.
 * @author Dyingsoul
 */
public class ParagonResult {
	/**
	 * Creating new logger: <code>Logger</code>.
	 */
	protected static Logger logger = LoggerFactory.getLogger(ParagonResult.class);
	
	/**
	 * @value expNextLevel <code>expNextLevel</code> stores the amount of experience required to the next level.
	 */
	private BigInteger expNextLevel;
	/**
	 * @value hoursNextLevel <code>hoursNextLevel</code> stores the amount of hours needed to reach the next level.
	 */
	private int hoursNextLevel;
	/**
	 * @value expToDesiredLevel <code>expToDesiredLevel</code> stores the amount of experience required to the desired level.
	 */
	private BigInteger expToDesiredLevel;
	/**
	 * @value hoursToDesiredLevel <code>hoursToDesiredLevel</code> stores the amount of hours needed to reach the desired level.
	 */
	private int hoursToDesiredLevel;
	/**
	 * @value daysToDesiredLevel <code>daysToDesiredLevel</code> stores the amount of hours needed to reach the desired level.
	 */
	private int daysToDesiredLevel;

	/**
	 * @param expNextLevel <code>expNextLevel</code> stores the amount of experience required to the next level.
	 * @param hoursNextLevel <code>hoursNextLevel</code> stores the amount of hours needed to reach the next level.
	 * @param expToDesiredLevel <code>expToDesiredLevel</code> stores the amount of experience required to the desired level.
	 * @param hoursToDesiredLevel <code>hoursToDesiredLevel</code> stores the amount of hours needed to reach the desired level.
	 * @param daysToDesiredLevel <code>daysToDesiredLevel</code> stores the amount of days needed to reach the desired level.
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
