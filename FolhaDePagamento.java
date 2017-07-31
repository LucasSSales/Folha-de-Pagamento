package folhaDePagamento;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FolhaDePagamento {
	
static Map<String, Horista> horistas = new HashMap<String, Horista>();
static Map<String, Assalariados> assalariados = new HashMap<String, Assalariados>();
static Map<String, Comissionado> comissionados = new HashMap<String, Comissionado>();
	
public static void emitirFolhaDePagamento() {
		
	System.out.println("PAGAMENTOS PARA HOJE");
		Calendar calendar = Calendar.getInstance();
			
		if(calendar.DAY_OF_WEEK == 6) {
			for (String key : horistas.keySet()) {
				Horista h = horistas.get(key); 
				System.out.println(key + " " + h.getNome() + " " +h.getSalario());
			}
		}
				
		if(calendar.get(calendar.DAY_OF_MONTH) == 28) {
			for (String key : assalariados.keySet()) {
				Assalariados a = assalariados.get(key);
				System.out.println(key + " " + a.getNome() + " " + a.getSalario());
			}
		}
		
		if(calendar.get(calendar.WEEK_OF_MONTH)%2 == 0) {
			for (String key : comissionados.keySet()) {
				Comissionado c = comissionados.get(key);
				System.out.println(key + " " + c.getNome() + " " + c.getSalario());
			}
		}
				
	}

/*public static void alterarAtributos (int opcao, String cod) {
	
	if(opcao == 1)
	
}*/

public static void agenda() {
	System.out.println("HORISTAS:");
	for (String key : horistas.keySet()) {
		Horista h = horistas.get(key); 
		System.out.println("COD: " + key + " NOME: " + h.getNome() + " AGENDA: " + h.getAgenda());
	}
	System.out.println("\nASSALARIADOS:");
	for (String key : assalariados.keySet()) {
		Assalariados a = assalariados.get(key);
		System.out.println("COD: "+ key + " NOME: " + a.getNome() + " AGENDA: " + a.getAgenda());
	}
	System.out.println("\nCOMISSIONADOS:");
	for (String key : comissionados.keySet()) {
		Comissionado c = comissionados.get(key);
		System.out.println("COD: "+ key + " NOME: " + c.getNome() + " AGENDA: " + c.getAgenda());
	}
}
	
public static void outrasOps() {
	System.out.println("MAIS OPERAÇÕES\n"
			+ "1- Lançar Cartão de ponto\n"
			+ "2- Lançar relatorio de venda\n"
			+ "3- Lançar taxa de serviço");
	Scanner scan = new Scanner(System.in);
	Scanner scanC = new Scanner(System.in);
	int opcao = scan.nextInt();
	if(opcao == 1) {
		System.out.println("INSIRA CODIGO DE EMPREGADO");
		String cod = scanC.nextLine();
		Horista h = horistas.get(cod);
		h.cartaoDePonto();
	}else if (opcao == 2) {
		System.out.println("INSIRA CODIGO DE EMPREGADO");
		String cod = scanC.nextLine();
		Comissionado c = comissionados.get(cod);
		c.vendas();
	}
}

public static void main (String[] args) {
				
		
		Scanner scanI = new Scanner(System.in);
		Scanner scanC = new Scanner(System.in);
		int opcao;
		int codigo = 0;		
		
		do {
			System.out.println("SELECIONE A OPERAÇÃO\n");
			System.out.println("1- Adicionar empregado\n"
					+ "2- Remover Empregado\n"
					+ "3- Alterar Atributos\n"
					+ "4- Agenda\n"
					+ "5- Folha de Pagamento\n"
					+ "6- Outras\n"
					+ "0- Sair");
			
			opcao = scanI.nextInt();
			
			if(opcao == 1) {
				System.out.println("SELECIONE O TIPO\n"
						+ "1- Horista\n"
						+ "2- Assalariado\n"
						+ "3- Comissionado");
				
				opcao = scanI.nextInt();
				if(opcao == 1) {
					horistas.put("H" + (++codigo), new Horista());
				}else if (opcao == 2) {
					assalariados.put("A" + (++codigo),  new Assalariados());
				}else if(opcao == 3) {
					comissionados.put("C" + (++codigo), new Comissionado());
				}
			}else if(opcao == 2) {
				System.out.println("DIGITE O CODIGO DO EMPREGADO: ");
				String cod = scanC.nextLine();
				if(cod.startsWith("H", 0)) {
					if(horistas.remove(cod) == null) {
						System.out.println("EMPREGADO NÃO CADASTRADO");
					}else {
						System.out.println("REMOVIDO COM SUCESSO!");
					}
				}else if(cod.startsWith("A", 0)) {
					if(assalariados.remove(cod) == null) {
						System.out.println("EMPREGADO NÃO CADASTRADO");
					}else {
						System.out.println("REMOVIDO COM SUCESSO!");
					}
				}else if(cod.startsWith("C", 0)) {
					if(comissionados.remove(cod) == null) {
						System.out.println("EMPREGADO NÃO CADASTRADO");
					}else {
						System.out.println("REMOVIDO COM SUCESSO!");
					}
				}else {
					System.out.println("CODIGO INVALIDO!");
				}
				
				
			}else if(opcao == 3) {
				System.out.println("INSIRA O CODIGO: ");
				String cod = scanC.nextLine();
				System.out.println("O QUE DESEJA ALTERAR?\n"
						+ "1-Nome\n2-Endereço\n3-Tipo\nAssociação Sindical");
			}else if(opcao == 4){
				System.out.println("1-Ver agendas\n2-Criar nova agenda");
				opcao = scanI.nextInt();
				if(opcao == 1)
					agenda();
				else if(opcao == 2)
					System.out.println("criar");
			}else if (opcao == 5){
				emitirFolhaDePagamento();
			}else if(opcao == 6){
				outrasOps();
			}else if (opcao == 0)
				break;
			
			System.out.println("DESEJA REALIZAR OUTRA OPERAÇÃO?\n1-Sim           0-Não");
			opcao = scanI.nextInt();
			
		}while(opcao!=0);
		System.out.println("PROCESSO ENCERRADO");
	}
}
