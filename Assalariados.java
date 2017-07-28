package folhaDePagamento;

public class Assalariados extends Empregado {
	
	public Assalariados() {
		super();
		setTipo(2);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nTIPO: Assalariado\n";
	}
}
