package folhaDePagamento;

import java.awt.List;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class FolhaDePagamento {
	
static Map<String, Horista> horistas = new HashMap<String, Horista>();
static Map<String, Assalariados> assalariados = new HashMap<String, Assalariados>();
static Map<String, Comissionado> comissionados = new HashMap<String, Comissionado>();
public static LinkedList<Integer> sindicato = new LinkedList<Integer>();

	
public static void emitirFolhaDePagamento() {
		
	Calendar calendar = Calendar.getInstance();
	System.out.println("PAGAMENTOS PARA HOJE\n");
	
	for (String key : horistas.keySet()) {
		Horista h = horistas.get(key); 
		h.salario();
		if(calendar.get(calendar.DAY_OF_WEEK) == 6 && h.getTipoAgenda() == 1)
			System.out.println(key + " " + h.getNome() + " " +h.getSalario());
		else if(calendar.get(calendar.DAY_OF_MONTH) == 1 && h.getTipoAgenda() == 4)
			System.out.println(key + " " + h.getNome() + " " +h.getSalario());
		else if(calendar.get(calendar.DAY_OF_MONTH) == 7 && h.getTipoAgenda() == 5)
			System.out.println(key + " " + h.getNome() + " " +h.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 2 && h.getTipoAgenda() == 7)
			System.out.println(key + " " + h.getNome() + " " +h.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 6 && (h.getTipoAgenda() == 8 || h.getTipoAgenda() == 6))
			System.out.println(key + " " + h.getNome() + " " +h.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 2 && calendar.get(calendar.WEEK_OF_MONTH)%2 == 0 && h.getTipoAgenda() == 9) 
			System.out.println(key + " " + h.getNome() + " " +h.getSalario());
	}
	
	System.out.println("");
	
	for (String key : assalariados.keySet()) {
		Assalariados a = assalariados.get(key);
		a.salario();
		if(calendar.get(calendar.DAY_OF_MONTH) == 28 && a.getTipoAgenda() == 2)
			System.out.println(key + " " + a.getNome() + " " +a.getSalario());
		else if(calendar.get(calendar.DAY_OF_MONTH) == 1 && a.getTipoAgenda() == 4)
			System.out.println(key + " " + a.getNome() + " " +a.getSalario());
		else if(calendar.get(calendar.DAY_OF_MONTH) == 7 && a.getTipoAgenda() == 5)
			System.out.println(key + " " + a.getNome() + " " +a.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 2 && a.getTipoAgenda() == 7)
			System.out.println(key + " " + a.getNome() + " " +a.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 6 && (a.getTipoAgenda() == 8 || a.getTipoAgenda() == 6))
			System.out.println(key + " " + a.getNome() + " " +a.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 2 && calendar.get(calendar.WEEK_OF_MONTH)%2 == 0 && a.getTipoAgenda() == 9) 
			System.out.println(key + " " + a.getNome() + " " +a.getSalario());
	}
	
	System.out.println("");
	
	for (String key : comissionados.keySet()) {
		Comissionado c = comissionados.get(key);
		c.salario();
		if(calendar.get(calendar.WEEK_OF_MONTH)%2 == 0 && c.getTipoAgenda() == 3)
			System.out.println(key + " " + c.getNome() + " " + c.getSalario());
		else if(calendar.get(calendar.DAY_OF_MONTH) == 1 && c.getTipoAgenda() == 4)
			System.out.println(key + " " + c.getNome() + " " + c.getSalario());
		else if(calendar.get(calendar.DAY_OF_MONTH) == 7 && c.getTipoAgenda() == 5)
			System.out.println(key + " " + c.getNome() + " " + c.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 2 && c.getTipoAgenda() == 7)
			System.out.println(key + " " + c.getNome() + " " + c.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 6 && (c.getTipoAgenda() == 8 || c.getTipoAgenda() == 6))
			System.out.println(key + " " + c.getNome() + " " + c.getSalario());
		else if(calendar.get(calendar.DAY_OF_WEEK) == 2 && calendar.get(calendar.WEEK_OF_MONTH)%2 == 0 && c.getTipoAgenda() == 9) 
			System.out.println(key + " " + c.getNome() + " " + c.getSalario());
	}
}

public static void remover() {
	Scanner scanC = new Scanner(System.in);
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
}

public static void alterarAtributos () {
	Scanner scan = new Scanner(System.in);
	Scanner scanC = new Scanner(System.in);
	System.out.println("INSIRA O CODIGO DE EMPREGADO");
	String cod = scanC.nextLine();
	int opcao;
	
	if(cod.startsWith("H", 0)) {
		if(horistas.get(cod)==null) {
			System.out.println("EMPREGADO NÃO CADASTRADO");
		}else {
			Horista h = horistas.get(cod);
			System.out.println("O QUE DESEJA ALTERAR?\n"
					+ "1-Nome\n2-Endereço\n3-Tipo\nAssociação Sindical");
			opcao = scan.nextInt();
			if(opcao == 1) {
				System.out.println("DIGITE O NOVO NOME: ");
				h.setNome(scanC.nextLine());//
			}else if (opcao == 2) {
				System.out.println("DIGITE O NOVO ENDEREÇO: ");
				h.setEndereco(scanC.nextLine());//
			}else if (opcao == 3) {
				System.out.println("ASSOCIAR(1) OU DESASSOCIAR(0)?");
				opcao = scan.nextInt();
				if(opcao == 1)
					h.setSindicato(true);//
				else if(opcao == 0)
					h.setSindicato(false);//
			}
		}
	}else if(cod.startsWith("A", 0)) {
		if(assalariados.get(cod)==null) {
			System.out.println("EMPREGADO NÃO CADASTRADO");
		}else {
			Assalariados a = assalariados.get(cod);
			System.out.println("O QUE DESEJA ALTERAR?\n"
					+ "1-Nome\n2-Endereço\n3-Tipo\nAssociação Sindical");
			opcao = scan.nextInt();
			if(opcao == 1) {
				System.out.println("DIGITE O NOVO NOME: ");
				a.setNome(scanC.nextLine());//
			}else if (opcao == 2) {
				System.out.println("DIGITE O NOVO ENDEREÇO: ");
				a.setEndereco(scanC.nextLine());//
			}else if (opcao == 3) {
				System.out.println("ASSOCIAR(1) OU DESASSOCIAR(0)?");
				opcao = scan.nextInt();
				if(opcao == 1)
					a.setSindicato(true);//
				else if(opcao == 0)
					a.setSindicato(false);//
			}
		}
	}else if(cod.startsWith("C", 0)) {
		if(comissionados.get(cod)==null) {
			System.out.println("EMPREGADO NÃO CADASTRADO");
		}else{
			Comissionado c = comissionados.get(cod);
			System.out.println("O QUE DESEJA ALTERAR?\n"
					+ "1-Nome\n2-Endereço\n3-Tipo\nAssociação Sindical");
			opcao = scan.nextInt();
			if(opcao == 1) {
				System.out.println("DIGITE O NOVO NOME: ");
				c.setNome(scanC.nextLine());//
			}else if (opcao == 2) {
				System.out.println("DIGITE O NOVO ENDEREÇO: ");
				c.setEndereco(scanC.nextLine());//
			}else if (opcao == 3) {
				System.out.println("ASSOCIAR(1) OU DESASSOCIAR(0)?");
				opcao = scan.nextInt();
				if(opcao == 1)
					c.setSindicato(true);//
				else if(opcao == 0)
					c.setSindicato(false);//
			}
		}
	}else {
		System.out.println("CODIGO INVALIDO!");
	}
}

public static void agenda() {
	System.out.println("HORISTAS:");
	for (String key : horistas.keySet()) {
		Horista h = horistas.get(key); 
		System.out.println("COD: " + key + "\n" + h);
		if(h.isSindicato()==true) {
			System.out.println("ASSOCIADO AO SINDICATO - TAXA -> " + h.getTaxaSindical());
		}else {
			System.out.println("SEM ASSOCIAÇÃO COM O SINDICATO");
		}
	}
	System.out.println("\nASSALARIADOS:");
	for (String key : assalariados.keySet()) {
		Assalariados a = assalariados.get(key);
		System.out.println("COD: "+ key + "\n" + a);
		if(a.isSindicato()==true) {
			System.out.println("ASSOCIADO AO SINDICATO - TAXA -> " + a.getTaxaSindical());
		}else {
			System.out.println("SEM ASSOCIAÇÃO COM O SINDICATO");
		}
	}
	System.out.println("\nCOMISSIONADOS:");
	for (String key : comissionados.keySet()) {
		Comissionado c = comissionados.get(key);
		System.out.println("COD: "+ key + "\n" + c);
		if(c.isSindicato()==true) {
			System.out.println("ASSOCIADO AO SINDICATO - TAXA -> " + c.getTaxaSindical());
		}else {
			System.out.println("SEM ASSOCIAÇÃO COM O SINDICATO");
		}
	}
}

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
				remover();				
			}else if(opcao == 3) {
				alterarAtributos();
			}else if(opcao == 4){
				System.out.println("1-Ver agendas\n2-Criar nova agenda");
				opcao = scanI.nextInt();
				if(opcao == 1)
					agenda();
				else if(opcao == 2)
					criarAgenda();
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
