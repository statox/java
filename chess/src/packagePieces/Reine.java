package packagePieces;

import java.util.ArrayList;

import packageUtilsPieces.Coordonnees;
import packageUtilsPieces.Couleur;
import chess.Echiquier;

public class Reine extends Piece {
	/**
	 * @param _nom
	 * @param _coordonnees
	 * @param _couleur
	 * @param _estMange
	 * @param _casesJouablesVides
	 * @param _casesJouablesPrises
	 * @param _symbole
	 */
	public Reine(Coordonnees _coordonnees, Couleur _couleur,
			Boolean _estMange, ArrayList<Coordonnees> _casesJouablesVides,
			ArrayList<Coordonnees> _casesJouablesPrises) {
		
		super("Reine", _coordonnees, _couleur, _estMange, _casesJouablesVides, _casesJouablesPrises, "r");
	}

	@Override
	public void deplacementsPossibles(Echiquier e) {
		
		//purge des anciens deplacements possibles
		_casesJouablesPrises = new ArrayList<Coordonnees>();
		_casesJouablesVides = new ArrayList<Coordonnees>();
		
		// Ici c'est long de refaire tous les cas et la reine se déplace comme une tour et un fou réunis
		// donc on crée un fou et une tour, on calcule leurs déplacements, on les concatène et on obtient ceux de la reine
		// c'est peut etre un chouilla plus lourd en mémoire mais c'est beaucoup plus clair comme code
		
		Piece f = new Fou(get_coordonnees(), get_couleur(), get_estMange(), new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		f.deplacementsPossibles(e);

		Piece t = new Tour(get_coordonnees(), get_couleur(), get_estMange(), f.get_casesJouablesVides(), f.get_casesJouablesPrises());
		t.deplacementsPossibles(e);

		t.get_casesJouablesPrises().addAll(f.get_casesJouablesPrises());
		t.get_casesJouablesVides().addAll(f.get_casesJouablesVides());
		
		this.set_casesJouablesPrises(t.get_casesJouablesPrises());
		this.set_casesJouablesVides(t.get_casesJouablesVides());
		
	}
}
