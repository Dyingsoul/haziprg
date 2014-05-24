import java.math.BigInteger;

/**
 * Class for costructing the result.
 * @author Dyingsoul
 *
 */
public class ParagonResult {
	private BigInteger expNextLevel;
	private int hoursNextLevel;
	private BigInteger expToDesiredLevel;
	private int hoursToDesiredLevel;
	private int daysToDesiredLevel;

	/**
	 * 
	 * @param expNextLevel stores the amount of experience required to the next level.
	 * @param hoursNextLevel stores the amount of hours needed to reach the next level.
	 * @param expToDesiredLevel stores the amount of experience required to the desired level.
	 * @param hoursToDesiredLevel stores the amount of hours needed to reach the desired level.
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
	 * @return the days needed tp reach the desired level.
	 */
	public int getDaysToDesiredLevel() {
		return daysToDesiredLevel;
	}

	/**
	 * @return the amount of experience needed to next level.
	 */
	public BigInteger getExpNextLevel() {
		return expNextLevel;
	}

	/**
	 * @return the amount of hours needed to reach the next level.
	 */
	public int getHoursNextLevel() {
		return hoursNextLevel;
	}

	/**
	 * @return the amount of experience required to the desired level.
	 */
	public BigInteger getExpToDesiredLevel() {
		return expToDesiredLevel;
	}

	/**
	 * @return the amount of hours needed to reach the desired level.
	 */
	public int getHoursToDesiredLevel() {
		return hoursToDesiredLevel;
	}
}
