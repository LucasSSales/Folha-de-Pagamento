package folhaDePagamento;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FolhaDePagamento {
	public static void main (String[] args) {
		
		Scanner scanI = new Scanner(System.in);
		Scanner scanC = new Scanner(System.in);
		int opcao;
		int codigo = 0;
		
		Map<Integer, Empregado> empregados= new HashMap<Integer, Empregado>();
			
		
		do {
			System.out.println("SELECIONE A OPERAÇÃO\n");
			System.out.println("1- Adicionar empregado\n"
					+ "2- Remover Empregado\n"
					+ "3- Alterar Atributos\n"
					+ "4- Agenda\n"
					+ "5- Folha de Pagamento\n"
					+ "0- Sair");
			
			opcao = scanI.nextInt();
			
			if(opcao == 1) {
				Empregado emp = null;
				System.out.println("SELECIONE O TIPO\n"
						+ "1- Horista\n"
						+ "2- Assalariado\n"
						+ "3- Comissionado");
				
				opcao = scanI.nextInt();
				if(opcao == 1) {
					emp = new Horista();
				}else if (opcao == 2)
					emp = new Assalariados();
				else if(opcao == 3)
					emp = new Comissionado();
					
				empregados.put(++codigo, emp);
				
			}else if(opcao == 2) {
				System.out.println("DIGITE O CODIGO DO EMPREGADO: ");
				int cod = scanI.nextInt();
				empregados.remove(cod);
				
				
			}else if(opcao == 3) {
				System.out.println("INSIRA O CODIGO: ");
				System.out.println("O QUE DESEJA ALTERAR?");
			}else if(opcao == 4){
				System.out.println("1-Ver agendas\n2-Criar nova agenda");
			}else if (opcao == 5){
				
			}else if (opcao == 0)
				break;
			
			System.out.println("DESEJA REALIZAR OUTRA OPERAÇÃO?\n1-Sim           0-Não");
			opcao = scanI.nextInt();
			
		}while(opcao!=0);
		System.out.println("PROCESSO ENCERRADO");
	}
}
