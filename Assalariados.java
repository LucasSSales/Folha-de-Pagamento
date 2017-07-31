package folhaDePagamento;

public class Assalariados extends Empregado {
	
	public Assalariados() {
		super();
		setAgenda("Mensalmente");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "TIPO: Assalariado\n";
	}
	
	@Override
	public void salario() {
		super.salario();
		System.out.println(getSalario());
	}
}
