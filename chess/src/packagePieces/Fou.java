package packagePieces;

import java.util.ArrayList;

import packageUtilsPieces.Coordonnees;
import packageUtilsPieces.Couleur;
import chess.Echiquier;

public class Fou extends Piece {

	public Fou(Coordonnees _coordonnees, Couleur _couleur,
			Boolean _estMange, ArrayList<Coordonnees> _casesJouablesVides,
			ArrayList<Coordonnees> _casesJouablesPrises) {
		
		super("Fou", _coordonnees, _couleur, _estMange, _casesJouablesVides, _casesJouablesPrises, "F");
	}

	@Override
	public void deplacementsPossibles(Echiquier e) {
		Coordonnees coordPiece = new Coordonnees(get_coordonnees());
		int x, y;
		
		//purge des anciens deplacements possibles
		_casesJouablesPrises = new ArrayList<Coordonnees>();
		_casesJouablesVides = new ArrayList<Coordonnees>();
		
		// parcours de l'ensemble des cases où peut se rendre le fou et classement dans les cases jouables
		//cases en haut à gauche du fou
		int continuer=1;
		x=coordPiece.get_x();
		y=coordPiece.get_y();
		
		while(x>1 && y<8 && continuer!=0){	// tant qu'il existe des cases en haut à gauche du fou
			x--;
			y++;
			Coordonnees c = new Coordonnees(x, y);	 
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

		//cases en haut à droite du fou
		continuer=1;
		x=coordPiece.get_x();
		y=coordPiece.get_y();
		
		while(x<8 && y<8 && continuer!=0){	// tant qu'il existe des cases en haut à droite du fou
			x++;
			y++;
			Coordonnees c = new Coordonnees(x, y);	 
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

		//cases en bas à gauche du fou
		continuer=1;
		x=coordPiece.get_x();
		y=coordPiece.get_y();
		
		while(x>1 && y>1 && continuer!=0){	// tant qu'il existe des cases en bas à gauche du fou
			x--;
			y--;
			Coordonnees c = new Coordonnees(x, y);	 
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
		//cases en bas à droite du fou
		continuer=1;
		x=coordPiece.get_x();
		y=coordPiece.get_y();
		
		while(x<8 && y>1 && continuer!=0){	// tant qu'il existe des cases en bas à droite du fou
			x++;
			y--;
			Coordonnees c = new Coordonnees(x, y);	 
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
