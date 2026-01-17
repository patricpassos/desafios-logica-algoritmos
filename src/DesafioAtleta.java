import java.util.Locale;
import java.util.Scanner;

public class DesafioAtleta {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// definição das variaveis de entrada
		int quantidadeAtleta;
		String nomeAtleta;
		char sexo;
		double altura, peso;

		System.out.print("Qual a quantidade de atletas? ");
		quantidadeAtleta = sc.nextInt();

		// Definição das variaveis para calculos
		double somaPeso = 0.0;
		double maiorAltura = 0.0;
		String nome = "";
		int contMasculino = 0;
		int contFeminino = 0;
		double totalAlturaFeminino = 0.0;

		// Processamento de dados
		for (int i = 1; i <= quantidadeAtleta; i++) {
			System.out.printf("Digite os dados do atleta número %d: \n", i);
			System.out.print("Nome: ");
			sc.nextLine(); // .nextLine() vazio para consumir a quebra de linha (Limpa o buffer de leitura)
			nomeAtleta = sc.nextLine();

			System.out.print("Sexo: ");
			sexo = sc.next().charAt(0);
			// Validação de dados do sexo
			while (sexo != 'M' && sexo != 'F') {
				System.out.print("Valor inválido! Favor digitar F ou M: ");
				sexo = sc.next().charAt(0);
			}
			// condicional para media do sexo masculino
			if (sexo == 'M') {
				contMasculino++;
			}

			System.out.print("Altura: ");
			altura = sc.nextDouble();
			// Validação de dados da altura dos atletas
			while (altura <= 0.0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}
			// Atleta mais alto
			if (altura > maiorAltura) {
				maiorAltura = altura;
				nome = nomeAtleta;
			}
			// condicional para o calculo da media de altura do sexo feminino
			if (sexo == 'F') {
				totalAlturaFeminino += altura;
				contFeminino++;
			}

			System.out.print("Peso: ");
			peso = sc.nextDouble();
			// Validação de dados do peso
			while (peso <= 0.0) {
				System.out.print("Valor inválido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}
			somaPeso += peso;
		}

		double mediaPeso = somaPeso / quantidadeAtleta;
		double porcentagemMasculino = (double) contMasculino / quantidadeAtleta * 100;

		// Saída de dados
		System.out.println();
		System.out.println("RELATÓRIO:");
		System.out.printf("Peso médio dos atletas: %.2f\n", mediaPeso);
		System.out.println("Atleta mais alto: " + nome);
		System.out.printf("Porcentagem de homens: %.1f %%\n", porcentagemMasculino);

		// Validação na ausencia de sexo feminino
		if (totalAlturaFeminino > 0.0) {
			double mediaAlturaFeminino = (double) totalAlturaFeminino / contFeminino;
			System.out.printf("Altura média das mulheres: %.2f\n", mediaAlturaFeminino);
		} else {
			System.out.println("Não há mulheres cadastradas");
		}

		sc.close();
	}

}
