package folhaDePagamento;
import java.util.Map;
import java.util.Scanner;

public class Empregado {
	
	private String nome = new String();
	private String endereco = new String();
	private String Agenda;
	private boolean sindicato;
	
	private final double salarioPorMes = 2000;
	private double salario;

	public Empregado () {
		Scanner scan = new Scanner(System.in);
		System.out.println("NOME: ");
		setNome(scan.nextLine());
		System.out.println("ENDEREÇO: ");
		setEndereco(scan.nextLine());
		System.out.println("ASSOCIAR AO SINDICATO?\n1-SIM    0-NÃO");
		if(scan.nextInt() == 1)
			setSindicato(true);
		else
			setSindicato(false);
			
	}
	
	public void salario() {
		
	}
	
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

	public String getAgenda() {
		return Agenda;
	}

	public void setAgenda(String agenda) {
		Agenda = agenda;
	}
	
	public double getSalarioPorMes() {
		return salarioPorMes;
	}
	
	

	public boolean isSindicato() {
		return sindicato;
	}

	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NOME: " + this.nome + "\nENDERECO: " + this.endereco + "\n";
	}
	
	
	
	
}
