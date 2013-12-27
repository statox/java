package packagePieces;
import java.util.ArrayList;

import packageUtilsPieces.Coordonnees;
import packageUtilsPieces.Couleur;
import chess.Echiquier;

public class Tour extends Piece {
	
	/**
	 * @param _nom
	 * @param _coordonnees
	 * @param _couleur
	 * @param _estMange
	 * @param _casesJouablesVides
	 * @param _casesJouablesPrises
	 * @param _symbole
	 */
	public Tour(Coordonnees _coordonnees, Couleur _couleur,
			Boolean _estMange, ArrayList<Coordonnees> _casesJouablesVides,
			ArrayList<Coordonnees> _casesJouablesPrises) {
		super("Tour", _coordonnees, _couleur, _estMange, _casesJouablesVides, _casesJouablesPrises, "T");
	}

	@Override
	public void deplacementsPossibles(Echiquier e) {
		Coordonnees coordPiece = new Coordonnees(get_coordonnees());
		int x, y;
		
		//purge des anciens deplacements possibles
		_casesJouablesPrises = new ArrayList<Coordonnees>();
		_casesJouablesVides = new ArrayList<Coordonnees>();
		
		// parcours de l'ensemble des cases où peut se rendre la tour et classement dans les cases jouables
		//cases à gauche de la tour
		int continuer=1;
		x=coordPiece.get_x();
		while(x>1 && continuer!=0){	// tant qu'il existe des cases à gauche de la tour
			x--;
			Coordonnees c = new Coordonnees(x, coordPiece.get_y());	 
			Piece p = e.rechercherCoord(c);
			if(p==null){	// si on ne rencontre pas de piece on ajoute au cases vides
				_casesJouablesVides.add(c);
			}
			else{	// si on rencontre une piece
				if (!p.get_couleur().equals(_couleur)){	// si elle est pas de la meme couleur on l'ajoute au cases mangeables
					_casesJouablesPrises.add(c);
				}
				continuer=0;	// on arrete la recherce dans ce sens
			}
		}
		
		// cases à droite de la tour
		continuer=1;
		x=coordPiece.get_x();
		while(x<8 && continuer!=0){	// tant qu'il existe des cases à droite de la tour
			x++;
			Coordonnees c = new Coordonnees(x, coordPiece.get_y());	 
			Piece p = e.rechercherCoord(c);
			if(p==null){	// si on ne rencontre pas de piece on ajoute au cases vides
				_casesJouablesVides.add(c);
			}
			else{	// si on rencontre une piece
				if (!p.get_couleur().equals(_couleur)){	// si elle est pas de la meme couleur on l'ajoute au cases mangeables
					_casesJouablesPrises.add(c);
				}
				continuer=0;	// on arrete la recherce dans ce sens
			}
		}
		
		// cases au dessus de la tour
		continuer=1;
		y=coordPiece.get_y();
		while(y<8 && continuer!=0){	// tant qu'il existe des cases au dessus de la tour
			y++;
			Coordonnees c = new Coordonnees(coordPiece.get_x(), y);	 
			Piece p = e.rechercherCoord(c);
			if(p==null){	// si on ne rencontre pas de piece on ajoute au cases vides
				_casesJouablesVides.add(c);
			}
			else{	// si on rencontre une piece
				if (!p.get_couleur().equals(_couleur)){	// si elle est pas de la meme couleur on l'ajoute au cases mangeables
					_casesJouablesPrises.add(c);
				}
				continuer=0;	// on arrete la recherce dans ce sens
			}
		}
		
		// cases en dessous de la tour
		continuer=1;
		y=coordPiece.get_y();
		while(y>1 && continuer!=0){	// tant qu'il existe des cases au dessus de la tour
			y--;
			Coordonnees c = new Coordonnees(coordPiece.get_x(), y);	 
			Piece p = e.rechercherCoord(c);
			if(p==null){	// si on ne rencontre pas de piece on ajoute au cases vides
				_casesJouablesVides.add(c);
			}
			else{	// si on rencontre une piece
				if (!p.get_couleur().equals(_couleur)){	// si elle est pas de la meme couleur on l'ajoute au cases mangeables
					_casesJouablesPrises.add(c);
				}
				continuer=0;	// on arrete la recherce dans ce sens
			}
		}
	}
}
