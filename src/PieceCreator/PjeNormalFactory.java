package PieceCreator;

import DataStructures.Pieza;
import PieceCreator.PieceType.NormalVersion.*;
//Clase que implementa la fabrica abstracta y que crea las piezas normales
public class PjeNormalFactory implements PjeAbstractFactory{

	private int id = 1;
	public Pieza crearArquero() {
		ArqueroN arqueroN=new ArqueroN(this.id);
		this.id++;
		return arqueroN;
	}
	
	public Pieza crearLycan() {
		LycanN lycanN=new LycanN(this.id);
		this.id++;
		return lycanN;
	}

	public Pieza crearMago() {
		MagoN magoN=new MagoN(this.id);
		this.id++;
		return magoN;
		
	}
	
	public Pieza crearNigromante() {
		NigromanteN nigromanteN=new NigromanteN(this.id);
		this.id++;
		return nigromanteN;
	}
	
	public Pieza crearTanque() {
		TanqueN tanqueN=new TanqueN(this.id);
		this.id++;
		return tanqueN;
	}
	
	public Pieza crearVampiro() {
		VampiroN vampiroN=new VampiroN(this.id);
		this.id++;
		return vampiroN;
	}
}
