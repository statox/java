/**
 * 
 */
package packagePieces;
import java.util.ArrayList;

import packageUtilsPieces.Coordonnees;
import packageUtilsPieces.Couleur;
import chess.Echiquier;

public class Pion extends Piece {

	/**
	 * @param _nom
	 * @param _coordonnees
	 * @param _couleur
	 * @param _estMange
	 * @param _casesJouablesVides
	 * @param _casesJouablesPrises
	 * @param _symbole
	 */
	public Pion(Coordonnees _coordonnees, Couleur _couleur,
				Boolean _estMange, ArrayList<Coordonnees> _casesJouablesVides,
				ArrayList<Coordonnees> _casesJouablesPrises) {
		
		super("Pion", _coordonnees, _couleur, _estMange, _casesJouablesVides, _casesJouablesPrises, "p");
	}
	
	public void deplacementsPossibles(Echiquier e){
		Coordonnees cible = new Coordonnees(get_coordonnees());
		Piece p;
		int sens = 1;
		
		// la variable sens sert a indiquer le sens de deplacement du pion
		// si le pion est blanc on augmente ses y s'il est noir on les décrémente
		
		// deplacement des pions blancs
		if (get_couleur().get_couleur()=="blanc"){
			sens = 1;
		}else{
			sens = -1;
		}
			
		//purge des anciens deplacements possibles
		_casesJouablesPrises = new ArrayList<Coordonnees>();
		_casesJouablesVides = new ArrayList<Coordonnees>();
		
		// test de la case devant le pion
		if(cible.get_y()<8 && cible.get_y()>1){
			cible.set_y(cible.get_y()+sens);			
			if (e.rechercherCoord(cible)==null){
				get_casesJouablesVides().add(cible);
			}
		}
		// test de deux cases devant le pion s'il n'a jamais bougé
		Coordonnees cible3 = new Coordonnees(get_coordonnees());
		cible3.set_y(cible3.get_y()+2*sens);			
		if (((get_coordonnees().get_y()==2 && sens==1) || (get_coordonnees().get_y()==7 && sens==-1))  && e.rechercherCoord(cible)==null && e.rechercherCoord(cible3)==null){
			get_casesJouablesVides().add(cible3);
		}

		// test de la case de gauche
		Coordonnees cible1 = new Coordonnees(get_coordonnees());
		if (cible1.get_x()>1 && cible1.get_y()<8 && cible1.get_y()>1){
			cible1.set_x(cible1.get_x()-1);
			cible1.set_y(cible1.get_y()+sens);
			p = e.rechercherCoord(cible1);

			if (p!=null && !p.get_couleur().equals(_couleur)){
				get_casesJouablesPrises().add(cible1);				
			}
		}
		// test de la case de droite
		Coordonnees cible2 = new Coordonnees(get_coordonnees());
		if(cible2.get_x()<8 && cible2.get_y()<8 && cible1.get_y()>1){
			cible2.set_x(cible2.get_x()+1);
			cible2.set_y(cible2.get_y()+sens);
			p = e.rechercherCoord(cible2);

//			if (p!=null && p.get_couleur().get_couleur()!=get_couleur().get_couleur() && p.get_nom()!="Roi" ){
			if (p!=null && !p.get_couleur().equals(_couleur)){
				get_casesJouablesPrises().add(cible2);				
			}
		}
	}
}
