package folhaDePagamento;

public class Assalariados extends Empregado {
	
	public Assalariados() {
		super();
		setAgenda("Mensalmente");
		setTipoAgenda(2);
		setSalario(getSalarioPorMes());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "TIPO: Assalariado\nAGENDA: " + getAgenda() + "\n";
	}
}
