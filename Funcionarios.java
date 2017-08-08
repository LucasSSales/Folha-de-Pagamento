package folhaDePagamento;

import java.awt.List;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class Funcionarios<T> {
	
	LinkedList<T> list = new LinkedList<T>();

	public void adicionar (T func) {
		list.add(func);
	}
	
	public void remover (int cod) {
		int i = verificarCod(cod);
		if(i != -1)
			list.remove(i);
		else
			System.out.println("EMPREGADO NÃO CADASTRADO");
	}
	
	public int verificarCod (int cod) {
		int index = -1;
		int conf = 0;
		for (T i : list) {
			Empregado e = (Empregado) i;
			++index;
			if(e.getCodigo() == cod) {
				conf = 1;
				break;
			}
		}
		
		if(conf == 1)
			return index;
		else
			return -1;
	}
	
	public void alterarAtributos (int cod) {
		
		int i = verificarCod(cod);
		int opcao;
		Scanner scan = new Scanner(System.in);
		Scanner scanC = new Scanner(System.in);
		
		if(i == -1)
			System.out.println("EMPREGADO NÃO CADASTRADO");
		else {
			Empregado e = (Empregado) list.get(i);
			System.out.println("O QUE DESEJA ALTERAR?\n"
					+ "1-Nome\n2-Endereço\n3-Tipo\nAssociação Sindical");
			opcao = scan.nextInt();
			if(opcao == 1) {
				System.out.println("DIGITE O NOVO NOME: ");
				e.setNome(scanC.nextLine());
			}else if (opcao == 2) {
				System.out.println("DIGITE O NOVO ENDEREÇO: ");
				e.setEndereco(scanC.nextLine());
			}else if (opcao == 3) {
				System.out.println("ASSOCIAR(1) OU DESASSOCIAR(0)?");
				opcao = scan.nextInt();
				if(opcao == 1)
					e.setSindicato(true);
				else if(opcao == 0)
					e.setSindicato(false);
			}
		}
	}

	public void agenda() {
		for (T i : list) {
			System.out.println(i);
		}
	}
	
	public void emitirFolhaDePagamento () {
		Calendar calendar = Calendar.getInstance();
		
		for (T i : list) {
			Empregado e = (Empregado) i; 
			e.salario();
			System.out.println(e.getCodigo() + " " + e.getNome() + " " +e.getSalario());
			/*
			if(calendar.get(calendar.DAY_OF_WEEK) == 6 && e.getTipoAgenda() == 1)
				System.out.println(e.getCodigo() + " " + e.getNome() + " " +e.getSalario());
			else if(calendar.get(calendar.DAY_OF_MONTH) == 1 && e.getTipoAgenda() == 4)
				System.out.println(e.getCodigo() + " " + e.getNome() + " " +e.getSalario());
			else if(calendar.get(calendar.DAY_OF_MONTH) == 7 && e.getTipoAgenda() == 5)
				System.out.println(e.getCodigo() + " " + e.getNome() + " " +e.getSalario());
			else if(calendar.get(calendar.DAY_OF_WEEK) == 2 && e.getTipoAgenda() == 7)
				System.out.println(e.getCodigo() + " " + e.getNome() + " " +e.getSalario());
			else if(calendar.get(calendar.DAY_OF_WEEK) == 6 && (e.getTipoAgenda() == 8 || e.getTipoAgenda() == 6))
				System.out.println(e.getCodigo() + " " + e.getNome() + " " +e.getSalario());
			else if(calendar.get(calendar.DAY_OF_WEEK) == 2 && calendar.get(calendar.WEEK_OF_MONTH)%2 == 0 && e.getTipoAgenda() == 9) 
				System.out.println(e.getCodigo() + " " + e.getNome() + " " +e.getSalario());
				*/
		}
		
		System.out.println("");
	}
}
