import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class TicTacToeBoardJPanel extends JPanel implements Observer,MouseListener{
	TicTacToeBoard jeu;
	String message;

	
	
	public TicTacToeBoardJPanel(){
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
	}

	public void lancer(){
		jeu= new TicTacToeBoard();
		jeu.addObserver(this);
		message = "";
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			int squareX=e.getX()/50;
			int squareY=e.getY()/50;
			String square="";
			switch(squareY){
			case(0):
				square+="A";
				break;
			case(1):
				square+="B";
				break;
			case(2):
				square+="C";
				break;
			}
			switch(squareX){
			case(0):
				square+="1";
				break;
			case(1):
				square+="2";
				break;
			case(2):
				square+="3";
				break;
			}
			//The human player plays first by clicking any of the squares. 
			//The square clicked by the human displays a large X. 
			jeu.playAt(square, 1);
			//After the human plays, 
			//the program determines if the human has won or forced a draw.
			int situation = jeu.isGameOver();
			System.out.println("résultat du jeu "+situation);
			switch(situation){
			case (0):
				//If not, the computer
				// chooses a move and marks its square with a large O.
				try {
					jeu.playAt(jeu.getNextMove(), 2);
				} catch (IllegalArgumentException | GameIsOver e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//The program then determines if the computer has won the game.
				int résultat = jeu.isGameOver();
				switch (résultat){
				case(0):
					break;
				case(2):
					// If so, a message 
					//is displayed, the board is reset, and a new game begins.
					System.out.println("Computer wins !");
					message= "You lose !";
					this.update(this.getGraphics());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					message="";
					jeu.reset();
					break;
				default: break;
				}
			//If so, the program 
			// displays a message, resets the board, and starts a new game. If not, the human 
			// player plays again. This continues until one player wins or all of the squares 
			// are filled.
				break;
			case (1):
				// If so, a message 
				//is displayed, the board is reset, and a new game begins.
				System.out.println("You win !");
				message= "You win ! ";
				this.update(this.getGraphics());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				message="";
				jeu.reset();
				break;
			case (3):
				System.out.println("No winner");
				message= "Draw ! ";
				this.update(this.getGraphics());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
				// 	TODO Auto-generated catch block
					e1.printStackTrace();
				}
				message="";
				jeu.reset();
				break;
			default:
				break;
			}
		}
	}
	
	public void DessinerCase(Graphics g, String mark, int x, int y){
		g.setFont(new Font("TimesRoman", Font.PLAIN, 42));
		if(mark=="X"||mark=="O"){
			g.drawChars(mark.toCharArray(), 0, mark.length(), x, y);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (int i=0; i<3;i++){
			for (int j=0; j<3;j++){
				DessinerCase(g,jeu.jeu[i][j],j*50+11,i*50+39);
			}
		}
		g.setColor(Color.BLACK);
		g.drawLine(50, 0, 50, 150);
		g.drawLine(100, 0, 100, 150);
		g.drawLine(0, 50, 150, 50);
		g.drawLine(0, 100, 150, 100);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
		g.setColor(Color.red);
		g.drawChars(message.toCharArray(), 0, message.length(), 5, 80);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
		
	}
}
