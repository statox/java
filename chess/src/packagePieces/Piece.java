/**
 * 
 */
package packagePieces;

import java.util.ArrayList;

import packageUtilsPieces.Coordonnees;
import packageUtilsPieces.Couleur;
import chess.Echiquier;


/**
 * @author Adrien
 *
 */
public abstract class Piece {

	/**
	 * @param args
	 */
	String _nom;
	Coordonnees _coordonnees;
	Couleur _couleur;
	Boolean _estMange;
	ArrayList<Coordonnees> _casesJouablesVides;
	ArrayList<Coordonnees> _casesJouablesPrises;
	String _symbole;
	
	
	
	
	/**
	 * @param _nom
	 * @param _coordonnees
	 * @param _couleur
	 * @param _estMange
	 * @param _casesJouablesVides
	 * @param _casesJouablesPrises
	 * @param _symbole
	 */
	public Piece(String _nom, Coordonnees _coordonnees, Couleur _couleur,
			Boolean _estMange, ArrayList<Coordonnees> _casesJouablesVides,
			ArrayList<Coordonnees> _casesJouablesPrises, String _symbole) {
		super();
		this._nom = _nom;
		this._coordonnees = _coordonnees;
		this._couleur = _couleur;
		this._estMange = _estMange;
		this._casesJouablesVides = _casesJouablesVides;
		this._casesJouablesPrises = _casesJouablesPrises;
		this._symbole = _symbole;
	}

	public Piece(Piece p) {
		super();
		this._nom = p.get_nom();
		this._coordonnees = p.get_coordonnees();
		this._couleur = p.get_couleur();
		this._estMange = p.get_estMange();
		this._casesJouablesVides = p.get_casesJouablesVides();
		this._casesJouablesPrises = p.get_casesJouablesPrises();
		this._symbole = p.get_symbole();
	}
	
	/**
	 * @return the _nom
	 */
	public String get_nom() {
		return _nom;
	}

	/**
	 * @param _nom the _nom to set
	 */
	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	/**
	 * @return the _coordonnees
	 */
	public Coordonnees get_coordonnees() {
		return _coordonnees;
	}

	/**
	 * @param _coordonnees the _coordonnees to set
	 */
	public void set_coordonnees(Coordonnees _coordonnees) {
		this._coordonnees = _coordonnees;
	}

	/**
	 * @return the _couleur
	 */
	public Couleur get_couleur() {
		return _couleur;
	}

	/**
	 * @param _couleur the _couleur to set
	 */
	public void set_couleur(Couleur _couleur) {
		this._couleur = _couleur;
	}

	/**
	 * @return the _estMange
	 */
	public Boolean get_estMange() {
		return _estMange;
	}

	/**
	 * @param _estMange the _estMange to set
	 */
	public void set_estMange(Boolean _estMange) {
		this._estMange = _estMange;
	}

	/**
	 * @return the _casesJouablesVides
	 */
	public ArrayList<Coordonnees> get_casesJouablesVides() {
		return _casesJouablesVides;
	}

	/**
	 * @param _casesJouablesVides the _casesJouablesVides to set
	 */
	public void set_casesJouablesVides(ArrayList<Coordonnees> _casesJouablesVides) {
		this._casesJouablesVides = _casesJouablesVides;
	}

	/**
	 * @return the _casesJouablesPrises
	 */
	public ArrayList<Coordonnees> get_casesJouablesPrises() {
		return _casesJouablesPrises;
	}

	/**
	 * @param _casesJouablesPrises the _casesJouablesPrises to set
	 */
	public void set_casesJouablesPrises(ArrayList<Coordonnees> _casesJouablesPrises) {
		this._casesJouablesPrises = _casesJouablesPrises;
	}

	/**
	 * @return the _symbole
	 */
	public String get_symbole() {
		return _symbole;
	}

	/**
	 * @param _symbole the _symbole to set
	 */
	public void set_symbole(String _symbole) {
		this._symbole = _symbole;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	// methode faite rapidement pour les tests a changer pour la production
	@Override
	public String toString() {

		if (_estMange==false)
		{
			return "" + _nom + " " + _couleur + _coordonnees
					+ ", \t_casesJouablesVides=" + _casesJouablesVides
					+ ", \n\t\t\t_casesJouablesPrises=" + _casesJouablesPrises;
		}
		else{
			return "" + _nom + " " + _couleur + " est mangé";
		}
	}
	
	public void afficher() {
		System.out.println(this.get_symbole());
	}
	
	public abstract void deplacementsPossibles(Echiquier e);
	
	public int seDeplacer(Coordonnees destination, Echiquier e){
		
		// si la case vers laquelle se deplacer est vide on se deplace et on retourne 1
		if(_casesJouablesVides.contains(destination)){
			set_coordonnees(destination);
			return 1;
		}
		// si la case contient une piece a manger on marque la piece comme mangée, on se déplace et on retourne 2
		else if (_casesJouablesPrises.contains(destination)){
			Piece p = e.rechercherCoord(destination);
			p.set_estMange(true);
			set_coordonnees(destination);
			return 2;
		}
		// si la case n'est pas une destination possible on retourne 0
		return 0;
	}

}
