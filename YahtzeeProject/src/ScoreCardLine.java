/*
 * Author: Daniel Abrahms
 * Last Edited: 2/14/17
 * Class: CPSC 224-02
 * Class: ScoreCardLine
 * Description: This is the ScoreCardLine Class. It has a name, points, and used factor.
 * It has a method for printing itself and the possible points, based on a multiplier.
 */
public class ScoreCardLine {
	// the name of the ScoreCardLine (i.e. Full House)
	String name;
	// how many points this will be scored for, works in tatum with multiplier
	int points;
	// how many points this was scored for
	int multiplier;
	// the multiplier of how many points this will be scored, 1 if dependent on dice, otherwise certain score, like 35, 25, etc.
	int pointsEarned;
	// whether or not the ScoreCardLine has been used this game.
	boolean used;

	/* @param newName: String value of name attribute
	   @param newPoints: int value of points attribute
	   @param newUsed: boolean value of used attribute
	   @see ScoreCardLine
	 */
	public ScoreCardLine(String newName, int newPoints, boolean newUsed) {
	    pointsEarned = 0;
		name = newName;
		points = newPoints;
		used = newUsed;
	}

    // @param newName: String value of the name attribute
	// @see setName
	public void setName(String newName) {
		name = newName;
	}

    // @return the attribute name
	// @see getName
	public String getName() {
		return name;
	}

	// @param newPoints: int value of points attribute
	// @setPoints
	public void setPoints(int newPoints) {
		points = newPoints;
	}

    // @return the attribute points
	// @see getPoints
	public int getPoints() {
		return points;
	}

    // @param newPointsEarned: int value of pointsEarned attribute
	// @see newPointsEarned
    public void setPointsEarned() {
        pointsEarned = points * multiplier;
    }

    // @return the attribute pointsEarned
	// @see getPointsEarned
    public int getPointsEarned() {
        return pointsEarned;
    }

    // @param newUsed: boolean value of used attribute
	// @see setUsed
	public void setUsed(boolean newUsed) {
		used = newUsed;
	}

    // @return the attribute used
	// @see getUsed
	public boolean getUsed() {
		return used;
	}

	// @param newMult: int value for the multipier attribute
	// @see setMultipier
	public void setMultiplier(int newMult) {
		multiplier = newMult;
	}

	// @return the attribute multiplier
	// @see getMultipler
	public int getMultiplier() {
		return multiplier;
	}

	// @print the points possible for the multiplier given to the scorecardline
	// @param: multiplier should be 0 for failed check of scorecardline qualification (i.e. scorecardline is fullhouse, hand failed this qualification)
	// @param nowUsed: boolean on whether or not the line is used on this turn
	// @see printUsex
	public void printUnused(int newMult, boolean nowUsed) {
		multiplier = newMult;

		if (used) {
			System.out.println("--------------------");
			return;
		}
		System.out.print(name + ": ");
		for (int i = 0 ; i < 20 - name.length(); i++) {
			System.out.print(" ");
		}
		System.out.println(points * multiplier);
	}

	/*
		@print prints the line for scorecard, not for possible scores
		@see printUsed
	 */
	public void printUsed() {
        System.out.print(name + ": ");
        for (int i = 0 ; i < 20 - name.length(); i++) {
            System.out.print(" ");
        }
        if (!used && pointsEarned
				==0) {
			System.out.println("-");
		} else {
			System.out.println(pointsEarned);
		}
    }


}
