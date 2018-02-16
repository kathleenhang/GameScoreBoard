/*  Java Class: GameScore
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
public class GameScore 
{
	String gameName;
	
	// number of actual entries
	private int numberOfEntries = 0;
	
	// array of game entries (name, score, date)
	public GameEntry [] highScoresBoard = new GameEntry[10];
	
	public GameScore()
	{
		
	}
	public GameScore(String newGameName)
	{
		setGameName(newGameName);
	}
	
	
	private void setGameName(String newGameName)
	{
		gameName = newGameName;
	}
	
	// attempt to add a new score to the scoreboard (if it is high enough)
	public void add(GameEntry newEntry)
	{
		int newScore = newEntry.getScore();
		
		// if the scoreboard is NOT full OR new score is higher than lowest score on board
		if(numberOfEntries < highScoresBoard.length || newScore > highScoresBoard[numberOfEntries-1].getScore())
		{
			// if no score drops from the board...
			if (numberOfEntries < highScoresBoard.length)
			{
				// number of entries increases
				numberOfEntries++;
			}
			
			// j refers to the last score on scoreboard
			int j = numberOfEntries - 1;
			//while there are still scores AND 2nd to last score is less than new game score
			while(j > 0 && highScoresBoard[j-1].getScore() < newScore)
			{
				// shift entries towards the right to make room for new score
				highScoresBoard[j] = highScoresBoard[j-1];
				// decrement j
				j--;
			}
			//when done shifting the scores, add the new entry
			highScoresBoard[j] = newEntry;
			
		}
	}
	
	public void remove(String date)
	{
		// loop through all game entries
		for(int i = numberOfEntries - 1; i >= 0; i--)
        {
			// if current date iteration is farther in history than specified date
        	if(highScoresBoard[i].getDate().compareTo(date) < 0)
        	{
        		// remove score from scoreboard
        		remove(i);
        	}
        }
	}
	// remove and return the score that got removed
	public GameEntry remove(int rank) throws IndexOutOfBoundsException 
	{
		// output error if rank input is invalid (out of array bounds)
		if(rank < 0 || rank >= numberOfEntries)
		{
			throw new IndexOutOfBoundsException("Invalid index: " + rank);
		}
		// save the object to be removed
		GameEntry temp = highScoresBoard[rank];
		// iterate from the rank you want to remove all the way to the last score in array
		for(int j = rank; j < numberOfEntries - 1; j++)
		{
			// shift the scores to the left 
			highScoresBoard[j] = highScoresBoard[j+1];
		}
		// null the last old score that doesn't exist in that slot anymore since we shifted to the left
		highScoresBoard[numberOfEntries - 1] = null;
		// subtract 1 from number of entries
		numberOfEntries--;
		// return the removed object
		return temp;
	}
	
	public void print()
	{
		// iterate through each entry
		for (int i = 0; i < numberOfEntries; i++)
	    {
		  // assign current entry to object temp
	      GameEntry temp = highScoresBoard[i];
	      int rank = i + 1;
	      // get name, score, and date from object temp
	      System.out.println( rank + "----"+ temp.getName() + " ---- " + temp.getScore() + " ---- " + temp.getDate());
	    }
	}
	
	public String getGameName()
	{
		return gameName;
	}
	public int getNumberOfEntries()
	{
		return numberOfEntries;
	}
}
