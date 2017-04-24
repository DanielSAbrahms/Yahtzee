/**
 * @author - Daniel Abrahms
 * @version 1.0
 * Last Edited- 2/14/17
 * Class- CPSC 224-02
 * Class- ScoreCardLine
 * Description- This is the ScoreCardLine Class. It has a name, points, and used factor.
 * It has a method for printing itself and the possible points, based on a multiplier.
 */
public class ScoreCardLine {
	// the name of the ScoreCardLine (i.e. Full House)
	private String name;
	// how many points this was scored for
	int pointsEarned;
	// whether or not the ScoreCardLine has been used this game.
	boolean used;

	private String wordScored;

	/**
	 *  @param newName- String value of name attribute
	 *  @param newPoints- int value of points attribute
	 *  @param newUsed- boolean value of used attribute
	 */
	public ScoreCardLine(String newName, int newPoints, boolean newUsed) {
	    pointsEarned = 0;
		name = newName;
		used = newUsed;
	}

	/**
	 * @return The word scored for this line
	 */
    public String getWordScored() {
        return wordScored;
    }

	/**
	 * @param wordScored the Word to be set for the wordScored value
	 */
	public void setWordScored(String wordScored) {
        this.wordScored = wordScored;
    }


	/**
	 * @return the attribute name
	*/
	public String getName() {
		return name;
	}

	/**
	 * @param newName- String value of the name attribute
 	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * @return the attribute pointsEarned
	*/
    public int getPointsEarned() {
        return pointsEarned;
    }

	/**
	 * @param newPointsEarned The points earned for this line
	 */
	public void setPointsEarned(int newPointsEarned) {
		pointsEarned = newPointsEarned;
	}

	/**
	 * @return the attribute used
	*/
	public boolean getUsed() {
		return used;
	}

	/**
	 *  @param newUsed- boolean value of used attribute
 	 */
	public void setUsed(boolean newUsed) {
		used = newUsed;
	}
}
