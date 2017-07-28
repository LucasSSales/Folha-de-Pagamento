package folhaDePagamento;
import java.util.Map;
import java.util.Scanner;

public class Empregado {
	
	private String nome = new String();
	private String endereco = new String();
	private int tipo;
	private int atributo;
	private int[] tipos = new int[3];
	private int[] atributos = new int[3];
	
	private final double salarioPorMes = 2000;
	private double salario;
	

	public Empregado () {
		Scanner scan = new Scanner(System.in);
		System.out.println("NOME: ");
		setNome(scan.nextLine());
		System.out.println("ENDEREÇO: ");
		setEndereco(scan.nextLine());
	}
	
/*	public void remove (Integer key, Map<Integer, Empregado> empregados) {
	
		empregados.remove(key);
		
	}*/
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
