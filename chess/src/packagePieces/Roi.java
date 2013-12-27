package packagePieces;

import java.util.ArrayList;
import java.util.Iterator;

import packageUtilsPieces.Coordonnees;
import packageUtilsPieces.Couleur;
import chess.Echiquier;

public class Roi extends Piece {

	/**
	 * @param _nom
	 * @param _coordonnees
	 * @param _couleur
	 * @param _estMange
	 * @param _casesJouablesVides
	 * @param _casesJouablesPrises
	 * @param _symbole
	 */
	public Roi(Coordonnees _coordonnees, Couleur _couleur,
				Boolean _estMange, ArrayList<Coordonnees> _casesJouablesVides,
				ArrayList<Coordonnees> _casesJouablesPrises) {
		
		super("Roi", _coordonnees, _couleur, _estMange, _casesJouablesVides, _casesJouablesPrises, "R");
	}
	
	public void deplacementsPossibles(Echiquier e){
		Coordonnees coordPiece = new Coordonnees(get_coordonnees());
		
		ArrayList<Coordonnees> cibles = new ArrayList<Coordonnees>();
	
		//purge des anciens deplacements possibles
		_casesJouablesPrises = new ArrayList<Coordonnees>();
		_casesJouablesVides = new ArrayList<Coordonnees>();
		
		// creation de l'ensemble des cases ou peut potentiellement se rendre le roi
		cibles.add(new Coordonnees(coordPiece.get_x()-1, coordPiece.get_y()-1));
		cibles.add(new Coordonnees(coordPiece.get_x()-1, coordPiece.get_y()));
		cibles.add(new Coordonnees(coordPiece.get_x()-1, coordPiece.get_y()+1));
		cibles.add(new Coordonnees(coordPiece.get_x(), coordPiece.get_y()+1));
		cibles.add(new Coordonnees(coordPiece.get_x()+1, coordPiece.get_y()+1));
		cibles.add(new Coordonnees(coordPiece.get_x()+1, coordPiece.get_y()));
		cibles.add(new Coordonnees(coordPiece.get_x()+1, coordPiece.get_y()-1));
		cibles.add(new Coordonnees(coordPiece.get_x(), coordPiece.get_y()-1));
		
		// elimination des cases qui ne sont pas dans l'echiquier
		Iterator<Coordonnees> it = cibles.iterator();

		while(it.hasNext()){
			Coordonnees c = it.next();
			// si la coordonnee ne rentre pas dans l'echiquier on la supprime des cases accessibles
			if (c.get_x()<1 || c.get_x()>8 || c.get_y()<1 || c.get_y()>8){
				it.remove();
			}
		}
		
		//classement des cases dans casesJouablesVides ou casesJouablesPrises
		it = cibles.iterator();
		while (it.hasNext()){
			Coordonnees c = it.next();
			Piece p = e.rechercherCoord(c);
			
			// si sur la case on a une piece d'une autre couleur on l'ajoute a Prises
			if (p!=null && !(p.get_couleur().equals(_couleur))){
				_casesJouablesPrises.add(c);
			}
			else if (p==null){	//sinon si la case ne contient aucune piece
				_casesJouablesVides.add(c);
			}
		}
	}
}
