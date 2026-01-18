
public class Polimorfismo {

	public static void main(String[] args) {
		
		mamifero mamifero1 = new Elefante();
		System.out.println("Cota diária de leite de um Elefante :" + mamifero1.cotaDiariaLeite());
		mamifero mamifero2 = new Rato();
		System.out.println("Cota diária de leite de um Rato :" + mamifero2.cotaDiariaLeite());
	}

}
