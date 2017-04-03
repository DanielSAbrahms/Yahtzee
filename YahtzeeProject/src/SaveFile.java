import java.io.*;

/*
 * @author Daniel Abrahms
 * Last Edited- 2/14/17
 * Class- CPSC 224-02
 * Class- SaveFile
 * Description- This class allows the user to save current setting about the game
 */
public class SaveFile {
    private int sidesPerDice;
    private int diceInGame;
    private int rollsPerTurn;

    /**
        @see SaveFile
        SaveFile object is created
        @param newSidesPerDice- int value for how many sides per dice
        @param newDiceInGame- int value for how many dice in gme
        @param newRollsPerTurn- int value for how many rolls the user gets per turn
     */
    public SaveFile(int newSidesPerDice, int newDiceInGame, int newRollsPerTurn) {
        sidesPerDice = newSidesPerDice;
        diceInGame = newDiceInGame;
        rollsPerTurn = newRollsPerTurn;
    }

    /**
     * The attributes are changed to the specified data in file
     */
    public void read() {

        String saveFile = "saveFile.txt";
        String line = null;

        try {
            FileReader fileReader = new FileReader(saveFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int lineNum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                switch (lineNum) {
                    case 0: {
                        sidesPerDice = Integer.parseInt(line);
                        break;
                    }
                    case 1: {
                        diceInGame = Integer.parseInt(line);
                        break;
                    }
                    case 2: {
                        rollsPerTurn = Integer.parseInt(line);
                        break;
                    }
                }
                lineNum++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to Open Save File");
        } catch (IOException ex) {
            System.out.println("Unable to Read Save File");
        }
    }

    /**
     * the data file is changed according to the attributes
     * @param newSidesPerDice The number of sides per dice
     * @param newDiceInGame The number of dice per game
     * @param newRollsPerTurn The number of rolls per turn
     */
    public void write(int newSidesPerDice, int newDiceInGame, int newRollsPerTurn) {
        String saveFile = "saveFile.txt";

        try {
            FileWriter  fileWriter = new FileWriter(saveFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(String.valueOf(newSidesPerDice));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(newDiceInGame));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(newRollsPerTurn));
            bufferedWriter.newLine();

            bufferedWriter.close();

        }
        catch (IOException ex) {
            System.out.println("Error Writing to File");
        }
    }
    /**
     * @return the attribute sidesPerDice
      */
    public int getSidesPerDice(){
        return sidesPerDice;
    }
    /**
     *  @return the attribute diceInGame
     */
    public int getDiceInGame(){
        return diceInGame;
    }
    /**
     * @return the attribute rollsPerTurn
      */
    public int getRollsPerTurn(){
        return rollsPerTurn;
    }

    public void writeScoreCard(ScoreCard sc, Hand hand){
        String saveFile = "ScoreCardSaveFile.txt";

        try {
            FileWriter  fileWriter = new FileWriter(saveFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < hand.getDiceRange()+7; i++) {
                bufferedWriter.write(sc.getLine(i).getName() + ";" + sc.getLine(i).getPoints() + ";"+ sc.getLine(i).getMultiplier() + ";" + sc.getLine(i).getPointsEarned() + ";" + sc.getLine(i).getUsed() + ";");
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        }
        catch (IOException ex) {
            System.out.println("Error Writing to File");
        }
    }

    public void readScoreCard(ScoreCard sc) {
        String saveFile = "ScoreCardSaveFile.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(saveFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < diceInGame + 7; i++) {
                line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                }
                String name = "";
                int points = 0;
                int multiplier = 0;
                int pointsEarned = 0;
                boolean used = true;
                String sum = "";

                int stopperCount = 0;

                for (int l = 0; l < line.length(); l++) {
                    char letter = line.charAt(l);
                    if (stopperCount == 0) {
                        if (letter == ';') {
                            stopperCount++;
                            sum = "";
                        } else {
                            name += letter;
                        }
                    } else if (stopperCount == 1) {
                        if (letter == ';') {
                            points = Integer.valueOf(sum);
                            stopperCount++;
                            sum = "";
                        } else {
                            sum += letter;
                        }
                    } else if (stopperCount == 2) {
                        if (letter == ';') {
                            multiplier = Integer.valueOf(sum);
                            stopperCount++;
                            sum = "";
                        } else {
                            sum += letter;
                        }
                    } else if (stopperCount == 3) {
                        if (letter == ';') {
                            pointsEarned = Integer.valueOf(sum);
                            stopperCount++;
                            sum = "";
                        } else {
                            sum += letter;
                        }
                    } else if (stopperCount == 4) {
                        if (letter == 't') {
                            used = true;
                        } else {
                            used = false;
                        }
                    }
                }
                sc.getLine(i).setName(name);
                sc.getLine(i).setPoints(points);
                sc.getLine(i).setMultiplier(multiplier);
                sc.getLine(i).setPointsEarned(pointsEarned);
                sc.getLine(i).setUsed(used);
            }
            fileReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to Open ScoreCard Save File");
        } catch (IOException ex) {
            System.out.println("Unable to Read ScoreCard Save File");
        }
    }



}
