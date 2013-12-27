package chess;

import packageUtilsPieces.Couleur;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

public class Partie {

	private
		Echiquier _echiquier;
		Couleur _noir, _blanc;
		int _tour;
	
	public Partie() {
		super();
		_noir = new Couleur("noir");
		_blanc = new Couleur("blanc");
		_echiquier = new Echiquier(_noir, _blanc);
		_tour = 0;
	}
	
	// la methode de jeu qui permet d'enchainer les tours jusqu'a ce que la methode finPartie décrète que la partie est finie
	void jouer(){
		int k=0;
		Terminal terminal = TerminalFacade.createTerminal();
		// affichage initial
		_echiquier.affichageGraphique(terminal);
		
//		while (finPartie()==0){
		while (_tour<50){
			_tour++;
			
			if (_tour%2==0)
				_echiquier.tour(_noir);
			else
				_echiquier.tour(_blanc);
			
			_echiquier.affichageGraphique(terminal);
			
		}
		terminal.exitPrivateMode();
	}
	
	// la methode qui permet de detecter les différents cas de fin de partie
	int finPartie(){
		return 0;
	}

}
