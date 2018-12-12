package PieceCreator;

import DataStructures.Pieza;
//Patron abstract factory. Esta interfaz tiene dos subclases que crearan las piezas de nuestro juego.
//Segun la implementacion, pueden ser Piezas de tipo normal o piezas de tipo pro. 
//haran override de los metodos de creacion
public abstract interface PjeAbstractFactory {

	public Pieza crearArquero();
	public Pieza crearLycan();
	public Pieza crearMago();
	public Pieza crearNigromante();
	public Pieza crearTanque();
	public Pieza crearVampiro();
	
	
}
