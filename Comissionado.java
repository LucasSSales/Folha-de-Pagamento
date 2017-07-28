package folhaDePagamento;
import java.util.Scanner;
public class Comissionado extends Empregado {

	private double comissao;
	private int vendas;
	
	public void vendas () {
		Scanner scan = new Scanner(System.in);
		System.out.println("NÚMERO DE VENDAS: ");
		setVendas(scan.nextInt());
	}
	
	
	public Comissionado() {
		super();
		setTipo(3);
		Scanner scan = new Scanner(System.in);
		System.out.println("INSIRA A COMISSÃO: ");
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nTIPO: Comisionado\nCOMISSÃO: " + this.comissao;
	}

}
