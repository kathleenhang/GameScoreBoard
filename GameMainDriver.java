/*  Program: GameMainDriver
    Author: Kathleen Hang
    Class: CSCI 220
    Date: 09/15/2017
    Description: 
    						[ PROJECT 1: GAME SCORES ]
    
    			   This program maintains a list of top 10 game scores. 
    			 - Methods for adding, removing, and printing game scores.
    			 - Reads from MoreGameScores.txt and inserts those game scores into the top 10 score board
    			 - Updates MoreGameScores.txt with the latest scores from the program + text file combined.

    I certify that the code below is my own work.
*/
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameMainDriver
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Author: Kathleen Hang");
		System.out.println("Project 1: [ GAME SCORES ]");
		System.out.println();
	
		// add 5 new game score entries
		GameEntry gameEntry1 = new GameEntry("Kat", 980, "08/05/2017");
		GameEntry gameEntry2 = new GameEntry("Uba", 245, "09/10/2017");
		GameEntry gameEntry3 = new GameEntry("Grandma", 780, "07/22/2017");
		GameEntry gameEntry4 = new GameEntry("Blake", 480, "02/07/2017");
		GameEntry gameEntry5 = new GameEntry("Joseph", 760, "03/01/2017");
		
		// create a new top 10 high scores
		GameScore gameScore1 = new GameScore("----[ PUZZLE BOBBLE NEO HI-SCORES ]----");
		
		System.out.println(gameScore1.getGameName());
		System.out.println();
		System.out.println("--------[ Added 4 high scores ]--------");
		
		// add 4 entries to game score object
		gameScore1.add(gameEntry1);
		gameScore1.add(gameEntry2);
		gameScore1.add(gameEntry3);
		gameScore1.add(gameEntry4);
		
		gameScore1.print();
		System.out.println("----------------------------------------");
		System.out.println();
		
		System.out.println("----[ Added 5th high score from Joseph ]----");
		gameScore1.add(gameEntry5);
		gameScore1.print();
		System.out.println("----------------------------------------");
		System.out.println();
		
		System.out.println("----[ Removed Grandma's high score ]----");
		gameScore1.remove(1);
		gameScore1.print();
		System.out.println("----------------------------------------");
		System.out.println();
		
		System.out.println("----[ Removed all high scores before 09/09/2017 ]----");
		gameScore1.remove("09/09/2017");
		gameScore1.print();
		System.out.println("----------------------------------------");
		System.out.println();
		
		//read this text file
		Scanner fileScanner = new Scanner(new File ("MoreGameScores.txt"));
		
		//store the scanned game name
		GameScore gameScore2 = new GameScore(fileScanner.nextLine());
		
		//store the scores from text file in this array of objects so we can iterate
		GameEntry [] textFileScores = new GameEntry[5];
		
		// counter variable
		int i = 0;
		// check to make sure there is even something to read next
		while(fileScanner.hasNextLine())
		{
			// create new game entry object
			textFileScores[i] = new GameEntry (fileScanner.next(), fileScanner.nextInt(), fileScanner.next());
			// add to top 10 list
			gameScore1.add(textFileScores[i]);
			i++;	
		}
		System.out.println("----[ Added 6 scores from text file ]----");
		// output the old scores along with the new scores from the text file
		gameScore1.print();
		System.out.println("----------------------------------------");
		System.out.println();
		
		//we want to output into the specified text file
		FileOutputStream fos = new FileOutputStream("MoreGameScores.txt", false);
		// we use printwriter to do the file output methods into specified text file
		PrintWriter pw = new PrintWriter(fos);
		
		
		pw.println(gameScore2.getGameName());
		// print out the updated scores back into text file
		for (int j = 0; j < gameScore1.getNumberOfEntries(); j++)
		{
			GameEntry temp = gameScore1.highScoresBoard[j];
			int rank = j + 1;
			pw.println( rank + "----"+ temp.getName() + " ---- " + temp.getScore() + " ---- " + temp.getDate());
		}
		
		pw.close();
		
		//inform user that the text file has been updated
		System.out.println("----[ Updated the text file with new scores ]----");
	
	}
}
