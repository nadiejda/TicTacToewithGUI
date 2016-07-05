import javax.swing.JFrame;

public class Application {
	public static void main(String[] args){
		// Cr�ation de la fen�tre
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Tic Tac Toe");
		fenetre.setSize(168, 190);
		fenetre.setLocationRelativeTo(null);  
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(true);
		// Cr�ation du contenu
		TicTacToeBoardJPanel panel = new TicTacToeBoardJPanel();
		fenetre.setContentPane(panel);
		// Affichage
		fenetre.setVisible(true);
		panel.lancer();
	}

}
