import java.util.Iterator;

public class ListaSimple<T> implements Iterable<T> {

	private Nodo<T> cabeza;
	private Nodo<T> cola;

	private int tamano;

	public ListaSimple() {
		this.cabeza = null;
		this.cola = null;
		this.tamano = 0;
	}

	public boolean estaVacia() {
		return this.cabeza == null;
	}

	public void insertarPrimero(T dato) {
		Nodo<T> nuevoNodo;
		if (estaVacia()) {
			nuevoNodo = new Nodo<T>(dato);
			cabeza = cola = nuevoNodo;
		} else {
			nuevoNodo = new Nodo<T>(dato, cabeza);
			cabeza = nuevoNodo;
		}
		tamano++;
	}

	public void insertarUltimo(T dato) {
		Nodo<T> nuevoNodo = new Nodo<T>(dato);
		if (estaVacia()) {
			cabeza = cola = nuevoNodo;
		} else {
			Nodo<T> nodoTemporal = cabeza;

			while (nodoTemporal.getSiguiente() != null) {
				nodoTemporal = nodoTemporal.getSiguiente();
			}

			nodoTemporal.setSiguiente(nuevoNodo);
			cola = nuevoNodo;
		}
		tamano++;
	}

	/**
	 * Método que sirve para insertar un nuevo valor después de un valor dado de
	 * algún elemento que contenga la lista
	 * 
	 * @param dato
	 *            , nuevo dato a insertar
	 * @param datoSiguiente
	 *            , dato que se busca para insertar luego de este.
	 */
	public void insertarDespuesDe(T dato, T datoSiguiente) {
		Nodo<T> nodoBase = buscar(datoSiguiente);

		if (nodoBase != null) {
			Nodo<T> nuevoNodo = new Nodo<T>(dato, nodoBase.getSiguiente());

			Nodo<T> nodoTemporal = cabeza;
			while (nodoTemporal != null) {
				if (nodoTemporal == nodoBase) {
					nodoTemporal.setSiguiente(nuevoNodo);
					break;
				}
				nodoTemporal = nodoTemporal.getSiguiente();
			}

			if (nuevoNodo.getSiguiente() == null) {
				cola = nuevoNodo;
			}
			tamano++;
		}
	}

	public void eliminarTodo() {
		cabeza = cola = null;
		tamano = 0;
	}

	public void eliminarPrimero() {
		if (!estaVacia()) {
			Nodo<T> nodoTemporal = cabeza.getSiguiente();

			if (cabeza == cola) {
				cabeza = cola = nodoTemporal;
			} else {
				cabeza = nodoTemporal;
			}

			tamano--;
		}

	}

	public void eliminarUltimo() {
		if (!estaVacia()) {
			if (cabeza == cola){
				cabeza = cola = null;
			}else{
				Nodo<T> nodoTemporal = cabeza;
				while(nodoTemporal.getSiguiente() != cola){
					nodoTemporal = nodoTemporal.getSiguiente();
				}
				nodoTemporal.setSiguiente(null);
				cola = nodoTemporal;
				
			}
			
			tamano--;
		}
	}

	public Nodo<T> buscar(T dato) {
		Nodo<T> nodoEncontrado = null;

		if (!estaVacia()) {
			Nodo<T> nodoTemporal = cabeza;

			while (nodoTemporal != null) {
				if (nodoTemporal.getDato() == dato) {
					nodoEncontrado = nodoTemporal;
					break;
				}
				nodoTemporal = nodoTemporal.getSiguiente();
			}
		}
		return nodoEncontrado;
	}

	public void buscarPosicion(T dato) {

	}

	public boolean existe(T dato) {
		boolean nodoEncontrado = false;

		if (!estaVacia()) {
			Nodo<T> nodoTemporal = cabeza;

			while (nodoTemporal != null) {
				if (nodoTemporal.getDato() == dato) {
					nodoEncontrado = true;
					break;
				}
			}
		}
		return nodoEncontrado;
	}

	public T obtenerPrimero() {
		return cabeza.getDato();
	}

	public T obtenerUltimo() {
		return cola.getDato();
	}

	/**
	 * Método que obtiene el valor
	 * 
	 * @return tamano
	 */
	public int getTamano() {
		return tamano;
	}

	
	@Override
	public Iterator<T> iterator() {
		return new IteradorLista(cabeza);
	}
	
	class IteradorLista implements Iterator<T>{
		
		protected Nodo cabeza;
		protected Nodo actual;
		protected int posicion;
		
		public IteradorLista(Nodo cabeza){
			this.cabeza = this.actual = cabeza;
			this.posicion = 0;
		}

		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public T next() {
			T dato = (T) actual.getDato();
			actual = actual.getSiguiente();
			posicion++;
			return dato;
		}
		
		public int getPosicion(){
			return posicion;
		}
		
	}

}
