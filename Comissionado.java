package folhaDePagamento;
import java.util.Scanner;
public class Comissionado extends Empregado {

	private double comissao;
	private int vendas;
	
	public Comissionado() {
		super();
		setSalario(getSalarioPorMes()/2);
		setAgenda("Bi-semanalmente");
		setTipoAgenda(3);
		Scanner scan = new Scanner(System.in);
		System.out.println("INSIRA A COMISS�O: ");
		setComissao(scan.nextDouble());
	}
	
	public void vendas () {
		Scanner scan = new Scanner(System.in);
		System.out.println("N�MERO DE VENDAS: ");
		setVendas(scan.nextInt());
		setSalario(getVendas() * (getComissao()/100));
	}
	
	@Override
	public void salario() {
		super.salario();
		setSalario(getSalario() * getComissao());
	}
	
	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public int getVendas() {
		return vendas;
	}

	public void setVendas(int vendas) {
		this.vendas = vendas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "TIPO: Comisionado\nCOMISS�O: " + this.comissao + "\nAGENDA: " + getAgenda() + "\n";
	}

}
