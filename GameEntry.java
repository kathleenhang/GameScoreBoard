/*  Java Class: GameEntry
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
public class GameEntry
{
	String playerName;
	int score;
	String date;
	
	public GameEntry()
	{
		
	}
	public GameEntry(String newPlayerName, int newScore, String newDate)
	{
		setPlayerName(newPlayerName);
		setScore(newScore);
		setDate(newDate);
	}
	
	private void setPlayerName(String newPlayerName)
	{
		playerName = newPlayerName;
	}
	private void setScore(int newScore)
	{
		score = newScore;
	}
	private void setDate(String newDate)
	{
		date = newDate;
	}
	public String getName()
	{
		return playerName;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String getDate()
	{
		return date;
	}
	public String toString()
	{
		return "(" + playerName + ", " + score + ", " + date + ")";
	}
}
