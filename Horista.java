package folhaDePagamento;
import java.util.Scanner;
public class Horista extends Empregado{
	
	private int horas;
	private int extra;
	private final double salarioPorHora = 10;
	
	public void cartaoDePonto() {
		Scanner scan = new Scanner(System.in);
		System.out.println("NUMERO DE HORAS TRABALHADAS: ");
		setHoras(scan.nextInt());
		
		if(horas > 8)
			setExtra(8-getHoras());		
		else
			setExtra(0);
		
		setSalario((salarioPorHora*getHoras()) + (1.5 * getExtra()));
	}
	
	public Horista() {
		super();
		setAgenda("Semanalmente");
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getExtra() {
		return extra;
	}

	public void setExtra(int extra) {
		this.extra = extra;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nTIPO: Horista\n";
	}
	
}
