import java.util.Observable;

public class TicTacToeBoard extends Observable {
	protected String[][] jeu;
	public TicTacToeBoard(){
		//Creates a new TicTacToeBoard with all squares empty.
		jeu = new String[3][3] ;
	}
	void reset(){
		//Resets the status of each square to empty.
		System.out.println("RaZ");
		jeu = new String [3][3];
		setChanged();
		notifyObservers();
		
	}
	
	void playAt(String square, int player) throws IllegalArgumentException {
		//Marks the specified square (A1, A2, A3, B1, B2, B3, C1, C2, or C3) 
		// for the specified player (1 for X, 2 for O). Throws IllegalArgumentException
		// if square is not one of the allowable values, player is not 1 or 2, or the 
		// specified square is not empty.
		String mark ;
		System.out.println("square is " + square + "; player is" + player);
		switch (player) {
		case 1 :
			mark = "X";
			break;
		case 2 :
			mark = "O";
			break;
		default : 
			throw new IllegalArgumentException() ; 
		}
		switch (square) {
		case "A1" :
			if (jeu[0][0]!=null) 
				throw new IllegalArgumentException();
			else 
				{ 
				jeu[0][0]=mark;
				setChanged();
				notifyObservers();
				}
			break;
		case "A2" :
			if (jeu[0][1]!=null) 
				throw new IllegalArgumentException();
			else {
				jeu[0][1]=mark;
				setChanged();
				notifyObservers();
			}
			break;
		
		case "A3" :
			if (jeu[0][2]!=null) 
				throw new IllegalArgumentException();
			else {
				jeu[0][2]=mark;
				setChanged();
				notifyObservers();
			}
			break;
		
		case "B1" :
			if (jeu[1][0]!=null) 
				throw new IllegalArgumentException();
			else  {
				jeu[1][0]=mark;
				setChanged();
				notifyObservers();
			}
			break;

		case "B2" :
			if (jeu[1][1]!=null) 
				throw new IllegalArgumentException();
			else {
				jeu[1][1]=mark;
				setChanged();
				notifyObservers();
			}
			break;
			
		case "B3" :
			if (jeu[1][2]!=null) 
				throw new IllegalArgumentException();
			else {
				jeu[1][2]=mark;
				setChanged();
				notifyObservers();
			}
			break;
		case "C1" :
			if (jeu[2][0]!=null) 
				throw new IllegalArgumentException();
			else {
				jeu[2][0]=mark;
				setChanged();
				notifyObservers();
			}
			break;
			
		case "C2" :
			if (jeu[2][1]!=null) 
				throw new IllegalArgumentException();
			else {
				jeu[2][1]=mark;
				setChanged();
				notifyObservers();
			}
			break;
			
		case "C3" :
			if (jeu[2][2]!=null) 
				throw new IllegalArgumentException();
			else {
				jeu[2][2]=mark;
				setChanged();
				notifyObservers();
			}
			break;

		default : 
			throw new IllegalArgumentException() ; 
		}		
		System.out.println("Game is \n" +this.toString());
	}
	
	int isGameOver(){
		// Determines whether the game is over. Returns 0 if the game is not over, 
		// 1 if X has won the game, 2 if O has won the game, and 3 if the game is a draw. 
		// The game ending conditions are as follows:
		// 1: If any row, column, or diagonal contains all X's.
		// 2: If any row, column, or diagonal contains all O's.
		// 3: If there are no empty squares and neither X nor O has won.
		// parcours lignes
		int [] colonnes = {1,2};
		for (int i=0; i<3; i++){
			String mark = jeu[i][0];
			if (mark != null){
				for (int j : colonnes){
					if (jeu[i][j]!=mark){break;}
					else if (j==2){
						if (mark=="X") return 1; else if (mark=="O") return 2;
					}
				}
			}
		}
		// parcours colonnes
		int [] lignes = {1,2};
		for (int j=0; j<3; j++){
			String mark = jeu[0][j];
			if (mark != null){
				for (int i : lignes){
					if (jeu[i][j]!=mark){
						break;
					}
					else if (i==2){
						if (mark =="X") return 1; else if (mark=="O") return 2;
					}
				}
			}
		}
		// parcours diagonales
		String mark = jeu[0][0];
		if (jeu[1][1]== mark && mark != null) 
			if (jeu[2][2]==mark) {
			if (mark =="X") return 1; else if (mark=="O") return 2;
		}
		mark = jeu[2][0];
		if (jeu[1][1]== mark && mark != null) 
			if (jeu[0][2]==mark) {
			if (mark =="X") return 1; else if (mark=="O")  return 2;
		}
		boolean partieNulle = true;
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				if (jeu[i][j]==null){
					partieNulle=false;
					break;	
				}
			}
			if (!partieNulle) break;
		}
		if (partieNulle) return 3;
		return 0;
	}
	
	String getNextMove() throws GameIsOver{
		// Returns a string representing the next move for the computer opponent. 
		// This method should make a rudimentary effort to select a good move, 
		// according to the following strategy:

		//* If the center (square B2) is empty, play the center square.
		if (jeu[1][1]==null)
			return "B2";
		//* If the center is not empty but any of the four corners (squares A1, A3, C1, 
		// or C3) are empty, play one of the corners (it doesn't matter which).
		if (jeu[0][0]==null)
			return "A1";
		else if (jeu[0][2]==null)
			return "A3";
		else if (jeu[2][0]==null)
			return "C1";
		else if (jeu[0][2]==null)
			return "C3";
		//* If the center is not empty and no corners are empty, play one of the edges 
		// (squares A2, B1, B3, or C2).
		if (jeu[0][1]=="")
			return "A2";
		else if (jeu[1][0]==null)
			return "B1";
		else if (jeu[1][2]==null)
			return "B3";
		else if (jeu[2][1]==null)
			return "C2";
		
		throw new GameIsOver();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString(){
		// Returns a string that represents the current status of the board. The 
		// string includes new-line characters to display the rows as well as 
		//separator lines on separate console lines, as in this example:
		//O | | O
		//---|---|---
		//| X |
		//---|---|---
		//| X |
		String jeu2String = "";
		for (int i = 0; i<3; i++){
			for (int j=0; j<3 ; j++){
				jeu2String+=jeu[i][j];
				if (j!=2) 
					jeu2String+="|";
			}
			if (i!=2)
				jeu2String+="\n---|---|---\n";
		}
		return jeu2String;
	}	
}
