package pontuacao;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int compras, inadimplencia;
		int scoreCompra, scoreInadimplencia, scoreFormaPgto;
		double ticketMedio, volumeCompras;
		char formaPgto;
		scoreCompra = scoreInadimplencia = scoreFormaPgto = 0;
		
		System.out.println("SISTEMA DE PERFIL DE CLIENTE");
		System.out.println("--------------------------------");
		System.out.println("INFORME OS DADOS DO ÚLTIMO ANO");
		System.out.println("");
		
		System.out.print("Quantas compras o cliente fez no último ano? ");
		compras = sc.nextInt();
		System.out.print("Qual o ticket médio? ");
		ticketMedio = sc.nextDouble();
		
		System.out.println("");
		System.out.print("Quantas vezes o cliente atrasou o pagamento? ");
		inadimplencia = sc.nextInt();
		System.out.print("A maioria das compras foi em dinheiro, cartão, ou boleto (D/C/B)? ");
		formaPgto = sc.next().charAt(0);
		
		volumeCompras = compras * ticketMedio;
		
		if (compras <= 0) {
			scoreCompra = 0;
		} else if (volumeCompras <= 3000 && compras < 2) {
			scoreCompra = 20;
		} else if (volumeCompras <= 3000 && compras >= 2) {
			scoreCompra = 40;
		} else if (volumeCompras > 3000) {
			scoreCompra = 60;
		}
		
		System.out.println("");
		System.out.printf("Score de volume de compras = %d pontos%n", scoreCompra);
		
		if (inadimplencia > 1 || compras == 0) {
			scoreInadimplencia = 0;
		} else if (compras > 0 && inadimplencia == 1) {
			scoreInadimplencia = 15;
		} else if (compras > 0 && inadimplencia == 0) {
			scoreInadimplencia = 30;
		}
		
		if (compras > 0 && formaPgto == 'D') {
			scoreFormaPgto = 5;
		} else if (compras > 0 && (formaPgto == 'C' || formaPgto == 'B')) {
			scoreFormaPgto = 10;
		}
		
		System.out.println("");
		System.out.printf("Score de inadimplência = %d pontos%n", scoreInadimplencia);
		System.out.printf("Score de forma de pagamento = %d pontos%n", scoreFormaPgto);
		sc.close();
	}

}
