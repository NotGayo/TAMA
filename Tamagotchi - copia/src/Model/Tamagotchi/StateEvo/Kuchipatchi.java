package Model.Tamagotchi.StateEvo;

public class Kuchipatchi implements State{

	public int getDecrementoVida() {
		return -2;
	}
	public int getDecrementoComida() {
		return -5;
	}
	public String getNombreEvo() {
		return "Kuchipatchi";
	}

}
