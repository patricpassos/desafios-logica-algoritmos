import java.util.Locale;
import java.util.Scanner;

public class DesafioTelefone {

public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Entrada de definição das matrizes
		System.out.print("Informe a quantidade de clientes: ");
		int n = sc.nextInt();

		// Criação dos vetores
		String[] nome = new String[n];
		String[] telefone = new String[n];
		int[] tipoConta = new int[n];
		int[] minutos = new int[n];
		double[] precoConta = new double[n];
		double[][] precos = new double[3][2];

		// Entrada de dados para os vetores
		for (int i = 0; i < n; i++) {
			System.out.printf("Dados do %d° cliente: \n", i + 1);
			System.out.print("Nome: ");
			sc.nextLine();
			nome[i] = sc.nextLine();

			System.out.print("Telefone: ");
			telefone[i] = sc.next();

			System.out.print("Tipo: ");
			tipoConta[i] = sc.nextInt();

			System.out.print("Minutos: ");
			minutos[i] = sc.nextInt();
			System.out.println();
		}

		// Entrada de dados para o preço dos planos/excedentes
		System.out.println("Informe o preço básico e excedente de cada tipo de conta: ");
		for (int i = 0; i < 3; i++) {
			System.out.printf("Tipo %d:\n", i);
			for (int j = 0; j < 2; j++) {
				precos[i][j] = sc.nextDouble();
			}
		}

		// Processamento dos dados do total a pagar de cada usuário
		for (int i = 0; i < n; i++) {
			precoConta[i] = precos[tipoConta[i]][0];
			if (minutos[i] > 90) { 
				precoConta[i] = precoConta[i] + (minutos[i] - 90) * precos[tipoConta[i]][1];
			}
		}

		// Saída de dados com o relatório de todas as contas
		System.out.println("\nRELATÓRIO DE CLIENTES: \n");
		for (int i = 0; i < n; i++) {
			System.out.printf("%s, %s, tipo %d, Minutos: %d, conta = R$ %.2f\n", nome[i], telefone[i], tipoConta[i], minutos[i], precoConta[i]);
		}

		sc.close();

	}

}
