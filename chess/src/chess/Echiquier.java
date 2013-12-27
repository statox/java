package chess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import packagePieces.Cavalier;
import packagePieces.Fou;
import packagePieces.Piece;
import packagePieces.Pion;
import packagePieces.Reine;
import packagePieces.Roi;
import packagePieces.Tour;
import packageUtilsPieces.Coordonnees;
import packageUtilsPieces.Couleur;

import com.googlecode.lanterna.terminal.Terminal;


public class Echiquier {

	private ArrayList<Piece> _pieces = new ArrayList<Piece>();
	
	// constructeur: la construction des pieces est temporaire et a finir
	public Echiquier(Couleur noir, Couleur blanc) {
		
		
		Piece p;
		
		// construction des pions
		for (int i=1; i<=8; i++){
//			p = new Pion(new Coordonnees(i, 2), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
//			ajouterPiece(p);
//			p = new Pion(new Coordonnees(i, 7), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
//			ajouterPiece(p);
		}
		
		// construction des tours
		p = new Tour(new Coordonnees(1, 1), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		ajouterPiece(p);
		p = new Tour(new Coordonnees(8, 1), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());		
		ajouterPiece(p);
		p = new Tour(new Coordonnees(1, 8), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		ajouterPiece(p);
		p = new Tour(new Coordonnees(8, 8), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());		
		ajouterPiece(p);
		
		// construction des cavaliers
		p = new Cavalier(new Coordonnees(2, 1), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		ajouterPiece(p);
		p = new Cavalier(new Coordonnees(7, 1), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());		
		ajouterPiece(p);
		p = new Cavalier(new Coordonnees(2, 8), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		ajouterPiece(p);
		p = new Cavalier(new Coordonnees(7, 8), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());		
		ajouterPiece(p);
		
		// construction des fous
		p = new Fou(new Coordonnees(3, 1), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		ajouterPiece(p);
		p = new Fou(new Coordonnees(6, 1), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());		
		ajouterPiece(p);
		p = new Fou(new Coordonnees(3, 8), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		ajouterPiece(p);
		p = new Fou(new Coordonnees(6, 8), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());		
		ajouterPiece(p);
		
		// construction des reines
		p = new Reine(new Coordonnees(4, 1), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		ajouterPiece(p);
		p = new Reine(new Coordonnees(4, 8), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());		
		ajouterPiece(p);	
		
		// construction des rois
		p = new Roi(new Coordonnees(5, 1), blanc, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());
		ajouterPiece(p);
		p = new Roi(new Coordonnees(5, 8), noir, false, new ArrayList<Coordonnees>(), new ArrayList<Coordonnees>());		
		ajouterPiece(p);
		
	}
	
	
	/**
	 * @return the _pieces
	 */
	public ArrayList<Piece> get_pieces() {
		return _pieces;
	}


	/**
	 * @param _pieces the _pieces to set
	 */
	public void set_pieces(ArrayList<Piece> _pieces) {
		this._pieces = _pieces;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String chaine = "";
		Iterator<Piece> it = this.get_pieces().iterator();
		
		while(it.hasNext())
		{
			Piece p = it.next();
			p.deplacementsPossibles(this);
			chaine = chaine + p.toString() + "\n";
		}
	
		return chaine;
	}

	//ajoute une piece dans l'echiquier
	public void ajouterPiece(Piece piece){
		get_pieces().add(piece);
	}
	
	// recherche une piece ayant les coordonnees donnees
	// renvoit la piece en question si elle existe et nul sinon
	public Piece rechercherCoord(Coordonnees rech){
		Iterator<Piece> it = this.get_pieces().iterator();
		
		while(it.hasNext())
		{
			Piece p = it.next();
			if(p.get_coordonnees().equals(rech)){
				return p;
			}
		}
		return null;
	}
	
	// cette methode permet à un joueur de selectionner une piece, de selectionner l'endroit ou il veut la jouer et de l'y deplacer
	public int tour(Couleur couleurJoueur){
		Piece p;
		int x, y;
		boolean selectionOK;
		
		System.out.println("\nAu joueur " + couleurJoueur + " de jouer\n");
		
		// selection d'une piece de la bonne couleur
		do{
			selectionOK=true;
			System.out.println("entrez les coordonnees de la piece a selectionner");
			
			Scanner sc = new Scanner(System.in);
			x = sc.nextInt();
			y = sc.nextInt();
			
			
			System.out.println("coordonnees selectionnees : " + x + ", " + y);
			p = rechercherCoord(new Coordonnees(x, y));
			
			// calcul  des deplacements possibles de la piece selectionnee
			if (p!=null)
				p.deplacementsPossibles(this);
			
			if (p==null){
				System.out.println("\nselectionnez une piece pas une case vide!\n");
				selectionOK=false;
			}else if (!p.get_couleur().equals(couleurJoueur)){
				System.out.println("\nselectionnez une piece de votre couleur: le " + couleurJoueur + "\n");
				selectionOK=false;
			}else if (p.get_casesJouablesPrises().isEmpty() && p.get_casesJouablesVides().isEmpty()){
				System.out.println("\nla piece selectionnee ne peut pas bouger, selectionnez en une autre");
				selectionOK=false;
			}
			
		}while(!selectionOK);
		
		
		System.out.println(p);
		
		// on demande au joueur où il veut se deplacer tant qu'il n'a pas choisi un emplacement valide
		do{
			System.out.println("Selectionnez la coordonnee de destination: ");
			
			Scanner sc = new Scanner(System.in);
			x = sc.nextInt();
			y = sc.nextInt();
	
			System.out.println("coordonnees selectionnees : " + x + ", " + y);
			
			// solution de secours: si le joueur veut changer de piece maintenant
			// il peut rentrer 99 et 99
			if (x==99 && y==99)
				return tour(couleurJoueur);
		}while(p.seDeplacer(new Coordonnees(x, y), this)==0);
		
		return 1;
	}
	
	
	// test de methode d'affichage avec google.lanterna
	public void affichageGraphique(Terminal terminal){
		
		terminal.enterPrivateMode();	// mode d'edition du terminal
		terminal.clearScreen();		// on efface l'ecran
		
		for (Integer i=1; i<=8; i++){
			// affichage des coordonnees au bord de l'ecran
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			terminal.moveCursor(i, 10);
			terminal.putCharacter(i.toString().charAt(0));
			terminal.moveCursor(10, i);
			terminal.putCharacter(i.toString().charAt(0));
			
			// changement de la couleur de fond de maniere alternative
			for(int j=1; j<=8; j++){
				terminal.moveCursor(i, j);
				terminal.applyBackgroundColor(Terminal.Color.BLUE);
				if ((i+j)%2==0)
					terminal.applyBackgroundColor(Terminal.Color.YELLOW);
				
				terminal.putCharacter(' ');
			}
		}
		Iterator<Piece> it = this.get_pieces().iterator();
		
		// affichage de chacune des pieces
		while(it.hasNext())
		{
			Piece p = it.next();
			if (!p.get_estMange()){	// on n'affiche que les pièces qui ne sont pas mangées (i.e encore sur le plateau)
				terminal.moveCursor(p.get_coordonnees().get_x(), p.get_coordonnees().get_y());
				
				terminal.applyBackgroundColor(Terminal.Color.BLUE);
				if ((p.get_coordonnees().get_x()+p.get_coordonnees().get_y())%2==0)
					terminal.applyBackgroundColor(Terminal.Color.YELLOW);
				
				terminal.applyForegroundColor(Terminal.Color.BLACK);
				if (p.get_couleur().get_couleur()=="blanc")
					terminal.applyForegroundColor(Terminal.Color.WHITE);
				
				terminal.putCharacter(p.get_symbole().charAt(0));
			}
		}	
		
		terminal.moveCursor(0, 0);
		
	}
}
