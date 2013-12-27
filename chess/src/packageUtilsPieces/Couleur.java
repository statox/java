/**
 * 
 */
package packageUtilsPieces;

/**
 * @author Adrien
 *
 */
public class Couleur {

	private
	String _couleur;

	/**
	 * @param _couleur
	 */
	public Couleur(String _couleur) {
		super();
		this._couleur = _couleur;
	}

	/**
	 * @return the _couleur
	 */
	public String get_couleur() {
		return _couleur;
	}

	/**
	 * @param _couleur the _couleur to set
	 */
	public void set_couleur(String _couleur) {
		this._couleur = _couleur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return _couleur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_couleur == null) ? 0 : _couleur.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couleur other = (Couleur) obj;
		if (_couleur == null) {
			if (other._couleur != null)
				return false;
		} else if (!_couleur.equals(other._couleur))
			return false;
		return true;
	}
	
	
	
	
}
