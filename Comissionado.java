package folhaDePagamento;
import java.util.Scanner;
public class Comissionado extends Empregado {

	private double comissao;
	private int vendas;
	
	public void vendas () {
		Scanner scan = new Scanner(System.in);
		System.out.println("N�MERO DE VENDAS: ");
		setVendas(scan.nextInt());
	}
	
	
	public Comissionado() {
		super();
		Scanner scan = new Scanner(System.in);
		System.out.println("INSIRA A COMISS�O: ");
		setComissao(scan.nextDouble());
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

}
