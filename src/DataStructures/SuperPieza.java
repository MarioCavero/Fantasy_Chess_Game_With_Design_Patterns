package DataStructures;

import Movement.Movement;
import PieceCreator.PjeAbstractFactory;
import States.State;
//Patron decorator para crear la super pieza, que es la combinacion de dos piezas. 
//mediante returns de los atributos y asignaciones a una super pieza en otros metodos fuera
public class SuperPieza extends Pieza {

	
	Pieza pieza1;
	Pieza pieza2;
	public SuperPieza(Pieza pieza1, Pieza pieza2){
		this.pieza1=pieza1;
		this.pieza2=pieza2;
	}

	@Override
	public void ataque(Pieza enemigo) {
		this.pieza1.ataque(enemigo);
	}

	@Override
	public void moverse(int x, int y) {
		this.pieza1.moverse(x, y);
	}

	@Override
	public void cambiarMovimiento(Movement newMovement) {
		this.pieza1.cambiarMovimiento(newMovement);
	}

	@Override
	public Pieza combinarse(Pieza aliado) {
		System.out.println("Esta pieza no puede combinarse, debes combinar otra con esta para unirlas");
        return aliado;
    }

	@Override
	public void curar(Pieza aliado) {
		this.pieza1.curar(aliado);
	}

	@Override
	public Pieza reproducirse(PjeAbstractFactory Fabric) {
		System.out.println("Al estar combinado no puedes reproducirte... tus hijos serian monstruosos!");
		return null;
	}

	@Override
	public void setState(State newState) {
		this.pieza1.setState(newState);
	}

	@Override
	public int getVida() {
		return this.pieza1.getVida() + this.pieza2.getVida();
	}

	@Override
	public int getVidaActual() {
		return this.pieza1.getVidaActual() + this.pieza2.getVidaActual();
	}

	@Override
	public int getDefensa() {
		return this.pieza1.getDefensa()+this.pieza2.getDefensa();
	}

	@Override
	public int getAtaque() {
		return this.pieza1.getAtaque()+this.pieza2.getAtaque();
	}

	@Override
	public String getNombre() {
		return this.pieza1.getNombre() + ", " + this.pieza2.getNombre();
	}

	@Override
	public int getX() {
		return this.pieza1.getX();
	}

	@Override
	public int getY() {
		return this.pieza1.getY();
	}

	@Override
	public int getId() {
		return Integer.valueOf(String.valueOf(this.pieza1.getId())+ String.valueOf(this.pieza2.getId()));
	}

	@Override
	public void setVidaActual(int vidaActual) {
		int tempHealth = vidaActual - this.getVidaActual();
		int curarPieza1 = this.pieza1.getVida() - this.pieza1.getVidaActual();
		int curarPieza2 = this.pieza2.getVida() - this.pieza2.getVidaActual();
		if(curarPieza1 > 0 && tempHealth > 0)
		{
			if(curarPieza1 - tempHealth >= 0)
			{
				this.pieza1.setVidaActual(this.pieza1.getVidaActual()+ tempHealth);
			}
			else {
				this.pieza1.setVidaActual(this.pieza1.getVida());
				tempHealth -= curarPieza1;
			}
		}
		if(curarPieza2 > 0 && tempHealth > 0)
		{
			if(curarPieza2 - tempHealth >= 0)
			{
				this.pieza2.setVidaActual(this.pieza2.getVidaActual() + tempHealth);
			}
			else {
				this.pieza2.setVidaActual(this.pieza2.getVida());
			}
		}
	}

	@Override
	public void setX(int x) {
		this.pieza1.setX(x);
	}

	@Override
	public void setY(int y) {
		this.pieza1.setY(y);
	}
}
