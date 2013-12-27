/**
 * 
 */
package packageUtilsPieces;

/**
 * @author Adrien
 *
 */
public class Coordonnees {

	private
		int _x;
		int _y;
		
	/** 
	 * @param _x
	 * @param _y
	 */
	public Coordonnees(int _x, int _y) {
		super();
		this._x = _x;
		this._y = _y;
	}
	/** constructeur par recopie 
	 * @param _x
	 * @param _y
	 */	
	public Coordonnees(Coordonnees c) {
		super();
		this._x = c.get_x();
		this._y = c.get_y();
	}

	/**
	 * @return the _x
	 */
	public int get_x() {
		return _x;
	}

	/**
	 * @param _x the _x to set
	 */
	public void set_x(int _x) {
		this._x = _x;
	}

	/**
	 * @return the _y
	 */
	public int get_y() {
		return _y;
	}

	/**
	 * @param _y the _y to set
	 */
	public void set_y(int _y) {
		this._y = _y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "( " + _x + " , " + _y + " )";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _x;
		result = prime * result + _y;
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
		Coordonnees other = (Coordonnees) obj;
		if (_x != other._x)
			return false;
		if (_y != other._y)
			return false;
		return true;
	}	
		
}
