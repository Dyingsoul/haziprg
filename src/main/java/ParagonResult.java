import java.math.BigInteger;

public class ParagonResult {
	private BigInteger expNextLevel;
	private int hoursNextLevel;
	private BigInteger expToDesiredLevel;
	private int hoursToDesiredLevel;
	private int daysToDesiredLevel;

	/**
	 * @param expNextLevel
	 * @param hoursNextLevel
	 * @param expToDesiredLevel
	 * @param hoursToDesiredLevel
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
	 * @return the daysToDesiredLevel
	 */
	public int getDaysToDesiredLevel() {
		return daysToDesiredLevel;
	}

	/**
	 * @param daysToDesiredLevel
	 *            the daysToDesiredLevel to set
	 */
	public void setDaysToDesiredLevel(int daysToDesiredLevel) {
		this.daysToDesiredLevel = daysToDesiredLevel;
	}

	/**
	 * @return the expNextLevel
	 */
	public BigInteger getExpNextLevel() {
		return expNextLevel;
	}

	/**
	 * @return the hoursNextLevel
	 */
	public int getHoursNextLevel() {
		return hoursNextLevel;
	}

	/**
	 * @return the expToDesiredLevel
	 */
	public BigInteger getExpToDesiredLevel() {
		return expToDesiredLevel;
	}

	/**
	 * @return the hoursToDesiredLevel
	 */
	public int getHoursToDesiredLevel() {
		return hoursToDesiredLevel;
	}
}
