/* 
 * Author: Daniel Abrahms
 * Last Edited: 2/5/17
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
	
	// Constructor for ScoreCardLine, sets name, points, and used attributes
	public ScoreCardLine(String newName, int newPoints, boolean newUsed) {
		name = newName;
		points = newPoints;
		used = newUsed;
	}
	
	// sets the Name attribute
	public void setName(String newName) {
		name = newName;
	}
	
	// returns the name attribute
	public String getName() {
		return name;
	}
	
	// sets the points attribute
	public void setPoints(int newPoints) {
		points = newPoints;
	}
	
	// returns the points attribute
	public int getPoints() {
		return points;
	}
	
	// sets the used attribute
	public void setUsed(boolean newUsed) {
		used = newUsed;
	}
	
	// gets the used attribute
	public boolean getUsed() {
		return used;
	}
	
	// prints the points possible for the multiplier given to the scorecardline
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
