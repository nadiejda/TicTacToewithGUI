import javax.swing.JFrame;

public class Application {
	public static void main(String[] args){
		// Création de la fenêtre
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Tic Tac Toe");
		fenetre.setSize(168, 190);
		fenetre.setLocationRelativeTo(null);  
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(true);
		// Création du contenu
		TicTacToeBoardJPanel panel = new TicTacToeBoardJPanel();
		fenetre.setContentPane(panel);
		// Affichage
		fenetre.setVisible(true);
		panel.lancer();
	}

}
