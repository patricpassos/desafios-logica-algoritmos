import java.util.Locale;
import java.util.Scanner;

public class DesafioConcurso {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Entrada de dados com "n" quantidades
		System.out.print("Qual a quantidade de pessoas? ");
		int n = sc.nextInt();

		// Criação dos vetores
		String[] nome = new String[n];
		double[] nota1 = new double[n];
		double[] nota2 = new double[n];
		double[] media = new double[n];

		// Entradas de dados nos vetores
		for (int i = 0; i < n; i++) {
			System.out.printf("Digite os dados da %dª pessoa: \n", i + 1);
			sc.nextLine(); // nextLine() vazio para consumir a quebra de linha (Limpa o buffer de leitura)
			System.out.print("Nome: ");
			nome[i] = sc.nextLine();
			System.out.print("Nota etapa 1: ");
			nota1[i] = sc.nextDouble();
			System.out.print("Nota etapa 2: ");
			nota2[i] = sc.nextDouble();
		}

		// Saida de dados
		// Criação de um vetor media para armazenar a media dos candidatos
		System.out.println("\nTABELA:");
		for (int i = 0; i < n; i++) {
			media[i] = (nota1[i] + nota2[i]) / 2;
			System.out.printf("%s, %.1f, %.1f, MÉDIA = %.2f\n", nome[i], nota1[i], nota2[i], media[i]);
		}

		// Processamento de dados dos candidatos
		System.out.println("\nPESSOAS APROVADAS:");

		int contAprovados = 0;
		double maiorMedia = 0.0;
		double somaAprovados = 0.0;
		String maiorNome = "";
		for (int i = 0; i < n; i++) {
			if (media[i] > maiorMedia) {
				maiorMedia = media[i];
				maiorNome = nome[i];
			}
			if (media[i] >= 70.0) {
				somaAprovados += media[i];
				contAprovados++;
				System.out.println(nome[i]); // saida de dados
			}
		}

		double porcentagemAprovados = (double) contAprovados / n * 100;

		// Saida de dados
		System.out.printf("\nPorcentagem de aprovação: %.1f %%\n", porcentagemAprovados);
		System.out.printf("Maior média: %s\n", maiorNome);

		// Validação de dados para ausência de aprovados
		if (contAprovados == 0) {
			System.out.print("Não há candidatos aprovados");
		} else {
			double mediaAprovados = (double) somaAprovados / contAprovados;
			System.out.printf("Nota média dos aprovados: %.2f", mediaAprovados);
		}

		sc.close();

	}

}
