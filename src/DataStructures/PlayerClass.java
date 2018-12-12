package DataStructures;

import java.util.ArrayList;

import java.util.Random;

import PieceCreator.*;



public class PlayerClass {

	ArrayList<Boolean> usados = new ArrayList<>();
	ArrayList<Pieza> piesas = new ArrayList<>();
	PjeAbstractFactory Fabric = new PjeProFactory();
	private int nPlayer;

	public PlayerClass(int nPlayer){
		
		this.nPlayer = nPlayer;
    	Pieza Pro;
    	//creacion de pieza pro de manera random. 
    	Random random = new Random();
    	int proType = random.nextInt(6);

		switch (proType)
		{
			case 0:
				Pro = Fabric.crearArquero();
				break;
			case 1:
				Pro = Fabric.crearLycan();
				break;
			case 2:
				Pro = Fabric.crearMago();
				break;
			case 3:
				Pro = Fabric.crearNigromante();
				break;
			case 4:
				Pro = Fabric.crearTanque();
				break;
			case  5:
				Pro = Fabric.crearVampiro();
				break;
			default:
				System.out.println("Error en el Random al crear las piezas");
				Pro = null;
		}
		setFabric(new PjeNormalFactory());

		piesas.add(Fabric.crearArquero());
		piesas.add(Fabric.crearLycan());
		piesas.add(Fabric.crearMago());
		piesas.add(Fabric.crearNigromante());
		piesas.add(Fabric.crearTanque());
		piesas.add(Fabric.crearVampiro());

		if(Pro != null) {
			piesas.remove(proType);
			piesas.add(proType, Pro);
		}

    	for(int i=0;i<6;i++) {
    		usados.add(false);
    		
    	}

    	for(int i = 0; i < piesas.size(); i++)
		{
			for(int j = 0; j < piesas.size(); j++)
			{
				if(i != j)
					piesas.get(i).registerObserver(piesas.get(j));
			}

		}
    }

    private void setFabric(PjeAbstractFactory newFabric)
	{
		this.Fabric = newFabric;
	}

    public ArrayList<Pieza> getPiecesToUse()
    {
		ArrayList<Pieza> usablePieces = new ArrayList<Pieza>();
    	for(int i=0;i<this.piesas.size() ;i++) {
			if (!this.usados.get(i)) {
				usablePieces.add(piesas.get(i));
			}
		}
		return usablePieces;
    }

    public void resetRound()
    {
    	for(int i=0;i<this.piesas.size();i++) {
    		this.usados.remove(0);
    		this.usados.add(false);
    	}
        
    }

    public void addPiece(Pieza piezaNueva)
    {
        //aniade una pieza a este jugador
    	this.piesas.add(piezaNueva);
    	this.usados.add(false);
    }

    public void removePiece(int id)
    {
    	boolean flag = true;
    	for(int i = 0; i < piesas.size(); i++)
		{
			if(piesas.get(i).getId() == id)
			{
				for(int j = 0; j < piesas.size(); j++)
				{
					if(i != j)
						piesas.get(j).removeObserver(piesas.get(i));
				}
				piesas.remove(i);
				usados.remove(i);
				flag = false;
				break;
			}
		}
    	if(flag) System.out.println("Error al eliminar: id no encontrado");
    	
    }



	public void usePiece(Pieza used)
	{
		for(int i = 0; i < piesas.size(); i++)
		{
			if(piesas.get(i).getId() == used.getId())
			{
				usados.remove(i);
				usados.add(i, true);
			}
		}
	}

	public PjeAbstractFactory getFabric() {
		return Fabric;
	}

	public int getnPlayer() {
		return nPlayer;
	}

	public ArrayList<Pieza> getPiesas() {
		return piesas;
	}
}
