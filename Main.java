package folhaDePagamento;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
/*
	public static int opcoesAgenda() {
		
		System.out.println("SELECIONE AS OPÇÕES:\n"
				+ "1- Mensal 1\n"
				+ "2- Mensal 7\n"
				+ "3- Mensal $\n"
				+ "4- Semanal 1 segunda\n"
				+ "5- Semanal 1 sexta\n"
				+ "6- Semanal 2 segunda\n");
		
		Scanner scan = new Scanner(System.in);
		int opcao = scan.nextInt();
		return opcao-1;
	}

	public static void criarAgenda () {
		
		String[] novaAgenda = new String[6];
		
		novaAgenda[0] = "Dia 1 de todo mês";
		novaAgenda[1] = "Dia 7 de todo mês";
		novaAgenda[2] = "Último dia útil de todo mês";
		novaAgenda[3] = "Toda semana às segundas-feiras";
		novaAgenda[4] = "Toda semana às sextas-feiras";
		novaAgenda[5] = "A cada 2 semanas às segundas-feiras" ;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("INSIRA O CODIGO DO EMPREGADO");
		String cod = scan.nextLine();
		int op;
		
		if(cod.startsWith("H", 0)) {
			if(horistas.get(cod)==null) {
				System.out.println("EMPREGADO NÃO CADASTRADO");
			}else {
				Horista h = horistas.get(cod);
				op = opcoesAgenda();
				h.setAgenda(novaAgenda[op]);
				h.setTipoAgenda(op+4);
			}
		}else if(cod.startsWith("A", 0)) {
			if(assalariados.get(cod)==null) {
				System.out.println("EMPREGADO NÃO CADASTRADO");
			}else {
				Assalariados a = assalariados.get(cod);
				op = opcoesAgenda();
				a.setAgenda(novaAgenda[op]);
				a.setTipoAgenda(op+4);
			}
		}else if(cod.startsWith("C", 0)) {
			if(comissionados.get(cod)==null) {
				System.out.println("EMPREGADO NÃO CADASTRADO");
			}else{
				Comissionado c = comissionados.get(cod);
				op = opcoesAgenda();
				c.setAgenda(novaAgenda[op]);
				c.setTipoAgenda(op+4);
			}
		}else {
			System.out.println("CODIGO INVALIDO!");
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
		}else if (opcao == 3) {
			System.out.println("INSIRA O CODIGO DE EMPREGADO");
			String cod = scanC.nextLine();
			
			if(cod.startsWith("H", 0)) {
				if(horistas.get(cod)==null) {
					System.out.println("EMPREGADO NÃO CADASTRADO");
				}else {
					Horista h = horistas.get(cod);
					System.out.println("DIGITE O SERVIÇO: ");
					h.setServicos(scanC.nextLine());
					System.out.println("INSIRA A TAXA: ");
					h.setTaxaServico(scan.nextInt());
				}
			}else if(cod.startsWith("A", 0)) {
				if(assalariados.get(cod)==null) {
					System.out.println("EMPREGADO NÃO CADASTRADO");
				}else {
					Assalariados a = assalariados.get(cod);
					System.out.println("DIGITE O SERVIÇO: ");
					a.setServicos(scanC.nextLine());
					System.out.println("INSIRA A TAXA: ");
					a.setTaxaServico(scan.nextInt());
				}
			}else if(cod.startsWith("C", 0)) {
				if(comissionados.get(cod)==null) {
					System.out.println("EMPREGADO NÃO CADASTRADO");
				}else{
					Comissionado c = comissionados.get(cod);
					System.out.println("DIGITE O SERVIÇO: ");
					c.setServicos(scanC.nextLine());
					System.out.println("INSIRA A TAXA: ");
					c.setTaxaServico(scan.nextInt());
				}
			}else {
				System.out.println("CODIGO INVALIDO!");
			}
			
			
			
		}
	}
	*/
	public static void main (String[] args) {
							
		Funcionarios<Horista> h = new Funcionarios<Horista>();
		Funcionarios<Assalariados> a = new Funcionarios<Assalariados>();
		Funcionarios<Comissionado> c = new Funcionarios<Comissionado>();
		
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
						h.adicionar(new Horista(++codigo));
					}else if (opcao == 2) {
						a.adicionar(new Assalariados(++codigo));
					}else if(opcao == 3) {
						c.adicionar(new Comissionado(++codigo));
					}
				}else if(opcao == 2) {
					System.out.println("INSIRA O CODIGO:");
					int cod = scanI.nextInt();
					h.remover(cod);
					a.remover(cod);
					c.remover(cod);
				}else if(opcao == 3) {
					
					scanC = new Scanner(System.in);
					System.out.println("INSIRA O CODIGO DE EMPREGADO");
					String cod = scanC.nextLine();
					
					if(cod.startsWith("H", 0)) {
				//		h.alterarAtributos(cod.substring(1, 3).parseInt());
					}else if(cod.startsWith("A", 0)) {

					}else if(cod.startsWith("C", 0)) {

					}else {
						System.out.println("CODIGO INVALIDO!");
					}
					
				}else if(opcao == 4){
					System.out.println("1-Ver agendas\n2-Criar nova agenda");
					opcao = scanI.nextInt();
					if(opcao == 1) {
						System.out.println("HORISTAS:");
						h.agenda();
						System.out.println("ASSALARIADOS:");
						a.agenda();
						System.out.println("COMISSIONADOS:");
						c.agenda();
					}
					//else if(opcao == 2)
					//	criarAgenda();
				}else if (opcao == 5){
					System.out.println("PAGAMENTOS PARA HOJE:");
					h.emitirFolhaDePagamento();
					a.emitirFolhaDePagamento();
					c.emitirFolhaDePagamento();
				}/*else if(opcao == 6){
					outrasOps();
				}*/else if (opcao == 0)
					break;
				
				
				System.out.println("DESEJA REALIZAR OUTRA OPERAÇÃO?\n1-Sim           0-Não");
				opcao = scanI.nextInt();
				
			}while(opcao!=0);
			System.out.println("PROCESSO ENCERRADO");
		}

}
