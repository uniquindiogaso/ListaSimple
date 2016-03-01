import java.util.Iterator;

public class EjemploListaSimple {

	public static void main(String[] args) {
		
	
		ListaSimple<Integer> lista = new ListaSimple<Integer>();
				
		lista.insertarPrimero(5);
		lista.insertarDespuesDe(10, lista.obtenerUltimo());
		lista.insertarDespuesDe(11, lista.obtenerUltimo());
		lista.insertarDespuesDe(12, lista.obtenerUltimo());
		lista.insertarDespuesDe(69, 11);
		lista.insertarUltimo(1111);
		lista.eliminarUltimo();
		
		
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		

		
	}

}
