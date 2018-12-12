package PieceCreator;

import DataStructures.Pieza;
import PieceCreator.PieceType.ProVersion.*;
//Clase que implementa la fabrica abstracta y que crea las piezas pro
public class PjeProFactory implements PjeAbstractFactory{

	int id = 1;
	public Pieza crearArquero() {
		ArqueroP arqueroP=new ArqueroP(this.id);
		this.id++;
		return arqueroP;
	}
	
	public Pieza crearLycan() {
		LycanP lycanP=new LycanP(this.id);
		this.id++;
		return lycanP;
	}

	public Pieza crearMago() {
		MagoP magoP=new MagoP(this.id);
		this.id++;
		return magoP;
		
	}
	
	public Pieza crearNigromante() {
		NigromanteP nigromanteP=new NigromanteP(this.id);
		this.id++;
		return nigromanteP;
	}
	
	public Pieza crearTanque() {
		TanqueP tanqueP=new TanqueP(this.id);
		this.id++;
		return tanqueP;
	}
	
	public Pieza crearVampiro() {
		VampiroP vampiroP=new VampiroP(this.id);
		this.id++;
		return vampiroP;
	}
}
