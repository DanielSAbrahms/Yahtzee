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
	// the number of points that line is worth, 1 if dependent on total dice
	int points;
	// whether or not the SscoreCardLine has been used this game. 
	boolean used;
	
	/* @param newName: String value of name attribute
	   @param newPoints: int value of points attribute
	   @param newUsed: boolean value of used attribute
	 */
	public ScoreCardLine(String newName, int newPoints, boolean newUsed) {
		name = newName;
		points = newPoints;
		used = newUsed;
	}

    // @param newName: String value of the name attribute
	public void setName(String newName) {
		name = newName;
	}

    // @return the attribute name
	public String getName() {
		return name;
	}
	
	// @param newPoints: int value of points attribute
	public void setPoints(int newPoints) {
		points = newPoints;
	}

    // @return the attribute points
	public int getPoints() {
		return points;
	}
	
	// @param newUsed: boolean value of used attribute
	public void setUsed(boolean newUsed) {
		used = newUsed;
	}

    // @return the attribute used
	public boolean getUsed() {
		return used;
	}
	
	// @print the points possible for the multiplier given to the scorecardline
	// @param: multiplier should be 0 for failed check of scorecardline qualification (i.e. scorecardline is fullhouse, hand failed this qualification) 
	public void print(int multiplier) {
		if (used) {
			System.out.println("-------------------------------------------------");
			return;
		}
		System.out.print(name + ": ");
		for (int i = 0 ; i < 20 - name.length(); i++) {
			System.out.print(" ");
		}
		System.out.println(points*multiplier);
	}
}
