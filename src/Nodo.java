public class Nodo<T> {

	/**
	 * 
	 */
	private T dato;
	/**
	 * 
	 */
	private Nodo<T> siguiente;

	/**
	 * Constructor de la clase
	 */
	public Nodo() {
		this.dato = null;
		this.siguiente = null;
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param dato
	 */
	public Nodo(T dato) {
		this.dato = dato;
		this.siguiente = null;
	}

	/**
	 * Constructor de la clase
	 * 
	 * @param dato
	 * @param siguiente
	 */
	public Nodo(T dato, Nodo<T> siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	/**
	 * Método que obtiene el valor
	 * 
	 * @return dato
	 */
	public T getDato() {
		return dato;
	}

	/**
	 * @param dato
	 *            the dato to set
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Método que obtiene el valor
	 * @return siguiente
	 */
	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * Método para asignar el valor
	 * 
	 * @param siguiente
	 */
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}


}
