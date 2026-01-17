import java.util.Locale;
import java.util.Scanner;

public class DesafioContribuintes {

	/**
	 * Parametros:
	 * @param salario: salario bruto
	 * @return retorna o imposto sobre o salario bruto anual
	 */
	static double impostoSobreSalario(double salario) {
		double impostoSalarial;
		if (salario > 60000) {
			impostoSalarial = salario * 0.20;
		} else if (salario > 36000) {
			impostoSalarial = salario * 0.10;
		} else {
			impostoSalarial = 0.0;
		}
		return impostoSalarial;
	}
	
	/**
	 * Parametro:
	 * @param servico: valor recebido com prestação de serviços
	 * @return: retorna imposto a ser pago sobre a prestação de serviço 15%
	 */
	static double impostoSobreServico(double servico) {
		double impostoServicos = servico * 0.15;
		return impostoServicos;
	}
	
	/**
	 * Parametros:
	 * @param ganhoDeCapital: valor recebido com ganho de capital
	 * @return: retorna o imposto a ser pago sobre os ganhos de capital 20%
	 */
	static double impostoSobreGC(double ganhoDeCapital) {
		double impostoGanhoDeCapital = ganhoDeCapital * 0.20;
		return impostoGanhoDeCapital;
	}
	
	/**
	 * Parametros:
	 * @param salario: valores recebido como salário
	 * @param servico: valores recebido com prestação de serviço
	 * @param ganhoCapital: valores recebidos com ganho de capital
	 * @return: imposto bruto total a ser pago
	 */
	static double impostoBrutoTotal(double salario, double servico, double ganhoCapital) {
		double impostoTotal = impostoSobreSalario(salario) + impostoSobreServico(servico) + impostoSobreGC(ganhoCapital);
		return impostoTotal;
	}
	
	/**
	 * Parametros:
	 * @param salario: valores recebido como salário
	 * @param servico: valores recebido com prestação de serviço
	 * @param ganhoCapital:  valores recebidos com ganho de capital
	 * @param gastoMedico: valores gastos com despesas médicas
	 * @param gastoEducacionais: valores gastos com despesas educacionais
	 * @return: o valor que o contribuinte pode abater no seu imposto
	 */
	static double abatimentoImposto(double salario, double servico, double ganhoCapital, double gastoMedico, double gastoEducacionais) {
		double impostoDedutivel = impostoBrutoTotal(salario, servico, ganhoCapital) * 0.30;
		double gastosDedutiveis = gastoMedico + gastoEducacionais;
		if (gastosDedutiveis > impostoDedutivel) {
			return impostoDedutivel;
		} else {
			return gastosDedutiveis;
		}
	}

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Entrada de dados de n contribuintes
		System.out.print("Quantos contribuintes você irá cadastrar? ");
		int n = sc.nextInt();
		
		// Criação dos vetores
		double[] salario = new double[n];
		double[] prestacaoServico = new double[n];
		double[] ganhoCapital = new double[n];
		double[] gastosMedicos = new double[n];
		double[] gastosEducacionais = new double[n];
		
		//Entrada de dados
		for (int i = 0; i < n; i++) {
			System.out.printf("\nDigite os dados do %d° contribuinte:\n", i + 1);
			System.out.print("Renda anual com salário: ");
			salario[i] = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			prestacaoServico[i] = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			ganhoCapital[i] = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			gastosMedicos[i] = sc.nextDouble();
			System.out.print("Gatos Educacionais: ");
			gastosEducacionais[i] = sc.nextDouble();
		}

		for (int i = 0; i < n; i++) {
			
			//Chamada e processo
			double impostoDevidoSalario = impostoSobreSalario(salario[i]);
			double impostoDevidoServico = impostoSobreServico(prestacaoServico[i]);
			double impostoDevidoGanhoCapital = impostoSobreGC(ganhoCapital[i]);
			double impostoBrutoDevido = impostoBrutoTotal(salario[i], prestacaoServico[i], ganhoCapital[i]);
			double abatimentos = abatimentoImposto(salario[i], prestacaoServico[i], ganhoCapital[i], gastosMedicos[i], gastosEducacionais[i]);
			double impostoDevido = impostoBrutoDevido - abatimentos;
			
			//Saida
			System.out.printf("\nResumo do %d° contribuinte:\n", i + 1);
			System.out.printf("Imposto sobre salário: %.2f\n", impostoDevidoSalario);
			System.out.printf("Imposto sobre serviços: %.2f\n", impostoDevidoServico);
			System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoDevidoGanhoCapital);
			System.out.printf("Imposto bruto total: %.2f\n", impostoBrutoDevido);
			System.out.printf("Abatimento: %.2f\n", abatimentos);
			System.out.printf("Imposto devido: %.2f\n", impostoDevido);
		}

		sc.close();

	}

}
