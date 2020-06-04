import java.util.Scanner;

// REFERENCES TICTACTOE
// Starter class and main method: http://programmingbydoing.com/a/tic-tac-toe-oop.html
// Roottech (https://www.youtube.com/watch?v=aSQgCtHBr8U)
// 
//REFERENCES JAVA CONCEPTS
// Nested For Loop: GeeksforGeeks (https://www.geeksforgeeks.org/java-nested-loops-with-examples/)
// 
// KEY
// p = player (x or y)
// r = row
// c = column

public class TicTacToeRunner
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		char p = 'X';
		TicTacToe ttt = new TicTacToe();
		int r, c;

		while ( ! ( ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull() ) ) {
			ttt.displayBoard();
			System.out.print( "'" + p + "', choose your location (row, column): " );
			r = keyboard.nextInt();
			c = keyboard.nextInt();

			while ( ttt.isValid(r,c) == false || ttt.playerAt(r,c) != ' ' )	{
				if ( ttt.isValid(r,c) == false )
					System.out.println("That is not a valid location. Try again.");
				else if ( ttt.playerAt(r,c) != ' ' )
					System.out.println("That location is already full. Try again.");

				System.out.print( "Choose your location (row, column): " );
				r = keyboard.nextInt();
				c = keyboard.nextInt();
			}

			ttt.playMove( p, r, c );

			if ( p == 'X' )
				p = 'O';
			else
				p = 'X';

		}

		ttt.displayBoard();

		if ( ttt.isWinner('X') )
			System.out.println("X is the winner!");
		if ( ttt.isWinner('O') )
			System.out.println("O is the winner!");
		if ( ttt.isCat() )
			System.out.println("The game is a tie.");

	keyboard.close();	
	}
}
