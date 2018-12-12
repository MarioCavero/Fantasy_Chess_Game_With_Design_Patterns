package DataStructures;

import Comunication.Observador;
import Comunication.Sujeto;
import Movement.*;
import PieceCreator.PjeAbstractFactory;
import States.Furious;
import States.Normal;
import States.State;
import States.immobilized;
import pieceActions.Actions;

public abstract class Pieza implements Observador, Sujeto {

	protected int vida;
	protected int vidaActual;
	protected int defensa;
	protected int ataque;
	protected String nombre;
	protected int x;
	protected int y;
	protected int id;

	protected Movement movement;
	protected Actions AttackAct;

	public State _NORMAL = new Normal();
	public State _PARALIZADO = new immobilized();
	public State _FURIOSO = new Furious();
	protected State state = _NORMAL;

	public void ataque(Pieza enemigo)
	{
		this.state.attack(enemigo, AttackAct, this);
	}
	public void moverse(int x, int y)
	{
		if(movement.canMoveTo(x,y, this))
			this.state.move(this,x,y);
		else System.out.println("Error en coordenadas: no es posible el movimiento");
	}
	public void cambiarMovimiento(Movement newMovement)
	{
		movement = this.state.changeMovement(newMovement);
	}
	public Pieza combinarse(Pieza aliado)
	{
		return state.combine(aliado, this);
	}
	public void curar(Pieza aliado)
	{
		state.heal(aliado);
	}
	public Pieza reproducirse(PjeAbstractFactory Fabric) {
		System.out.println("Esta pieza no puede reproducirse porque no es Pro. ");
		return null;
	}

	@Override
	final public void registerObserver(Observador newObservador) {
		observadores.add(newObservador);
	}

	@Override
	final public void removeObserver(Observador deleteObservador) {

		int i = -1;
		i = observadores.indexOf(deleteObservador);
		if(i >= 0)
			observadores.remove(i);
	}

	@Override
	final public void notifyObservers() {
		for(int i = 0; i < observadores.size(); i++)
		{
			System.out.println(i);
			observadores.get(i).update();
		}
		System.out.println("Se ha recuperado parte de la vida de todos los aliados de la pieza que ha muerto");
	}

	@Override
	final public void update() {

		int nuevaVida = (this.getVidaActual() + this.getVida() / 10);
		if (nuevaVida < this.getVida()) {
			this.setVidaActual(nuevaVida);
		} else {
			this.setVidaActual(this.getVida());
		}
		if (nuevaVida < this.getVida() / 2) {
			this.setState(this._FURIOSO);
		} else {
			this.setState(this._NORMAL);
		}
	}

	public void setState(State newState){
		this.state = newState;
	}
	public int getVida() {
		return vida;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getAtaque() {
		return ataque;
	}

	public String getNombre() { return nombre; }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getId() {
		return id;
	}

	public Movement getMovement() { return movement; }

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}