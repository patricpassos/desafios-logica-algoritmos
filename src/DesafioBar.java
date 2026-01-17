import java.util.Locale;
import java.util.Scanner;

public class DesafioBar {
	
		/**
		 * 
		 * @param quantidadeCerveja: consumo de cervejas na comanda
		 * @param quantidadeRefrigerante: consumo de refrigerante na comanda
		 * @param quantidadeEspeto: consumo de espetos na comanda
		 * @return: calcula o total dos itens consumidos pelo cliente
		 */
		static double consumoTotal(double quantidadeCerveja, double quantidadeRefrigerante, double quantidadeEspeto) {
			double total = quantidadeCerveja * 5.0 + quantidadeRefrigerante * 3.0 + quantidadeEspeto * 7.0;
			return total;
		}

		/**
		 * verificar se o cliente está deve ou não pagar o couvert
		 * @return: Retornar a taxa de couvert
		 */
		static double taxaCouvert(double quantidadeCerveja, double quantidadeRefrigerante, double quantidadeEspeto) {
			double totalConsumo = consumoTotal(quantidadeCerveja, quantidadeRefrigerante, quantidadeEspeto);
			double couvert;
			if (totalConsumo < 30.0) {
				couvert = 4.0;
			} else {
				couvert = 0.0;
			}
			return couvert;
		}

		/**
		 * define o quanto deve cobrar pelo ingresso conforme o sexo
		 * @param sexo: definição do sexo
		 * @return: o preço do ingresso conforme o sexo
		 */
		static double ingresso(char sexo) {
			double precoIngresso;
			if (sexo == 'F') {
				precoIngresso = 8.0;
			} else {
				precoIngresso = 10.0;
			}
			return precoIngresso;
		}

		public static void main(String[] args) {

			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);

			char sexo;
			int qtdCerveja, qtdRefrigerante, qtdEspeto;

			System.out.print("Sexo: ");
			sexo = sc.next().charAt(0);
			System.out.print("Quantidade de cervejas: ");
			qtdCerveja = sc.nextInt();
			System.out.print("Quantidade de refrigerante: ");
			qtdRefrigerante = sc.nextInt();
			System.out.print("Quantidade de espetinho: ");
			qtdEspeto = sc.nextInt();

			System.out.println("\nRELATÓRIO:");

			double totalConsumido = consumoTotal(qtdCerveja, qtdRefrigerante, qtdEspeto);
			double precoCouvert = taxaCouvert(qtdCerveja, qtdRefrigerante, qtdEspeto);
			double pagamentoIngresso = ingresso(sexo);
			double totalGeral = totalConsumido + precoCouvert + pagamentoIngresso;

			System.out.printf("Consumo = R$ %.2f\n", totalConsumido);
			System.out.println(totalConsumido < 30.0 ? "Couvert = R$ 4.00" : "Isento de Couvert"); // Ternario dentro do print (Livro Deital)
			System.out.printf("Ingresso = R$ %.2f\n", pagamentoIngresso);
			System.out.printf("\nvalor a pagar = R$ %.2f", totalGeral);

			sc.close();

	}

}
