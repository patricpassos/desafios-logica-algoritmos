import java.util.Locale;
import java.util.Scanner;

public class DesafioImposto {

	/**
	 * Condicional sobre o imposto devido sobre o salario anual
	 * @param salario: salario bruto anual
	 * @return: calcula o imposto sobre o salario bruto
	 */
	static double impostoSobreSalario(double salario) {
		double salarioMensal = salario / 12;
		if (salarioMensal < 3000.0) {
			return 0.0;
		} else if (salarioMensal < 5000.0) {
			return salario * 0.10;
		} else {
			return salario * 0.20;
		}
	}
	
	/**
	 * Imposto cobrado sobre prestação de serviços
	 * @param prestacaoServico: renda anual com prestação de serviço
	 * @return: calcula o imposto devio sobre prestações de serviço 15%
	 */
	static double impostoSobreServico(double prestacaoServico) {
		double impostoServicos = prestacaoServico * 0.15;
		return impostoServicos;
	}
	
	/**
	 * Imposto cobrado sobre ganho de capital
	 * @param ganhoCapital: renda com ganho de capital
	 * @return: calcula o imposto devido sobre ganho de capital 20%
	 */
	static double impostoSobreCapital(double ganhoCapital) {
		double impostoGanhoDeCapital = ganhoCapital * 0.20;
		return impostoGanhoDeCapital;
	}
	
	/**
	 * Gastos educacionais e medicos
	 * @param gastoMedico: despesas médicas 
	 * @param GastoEducacional: despesas educacionais
	 * @return: Soma os gastos educacionais e médicos dedutiveis
	 */
	static double gastoDeducoes (double gastoMedico, double GastoEducacional) {
		double gastosDedutivel = gastoMedico + GastoEducacional;
		return gastosDedutivel;
	}
	
	/**
	 * Retorna o abatimento de 30% do imposto bruto devido com gastos médicos ou educacionais.
	 * @param salario: salario bruto anual
	 * @param prestacaoServico: renda anual com prestação de serviço
	 * @param ganhoCapital: renda com ganho de capital
	 * @param gastoMedico: valores gastos com despesas médicas
	 * @param GastoEducacional: valores gastos com despesas educacionais
	 * @return: calcula o abatimento dos impostos devidos
	 */
	static double abatimentoImposto(double salario, double prestacaoServico, double ganhoCapital, double gastoMedico, double GastoEducacional) {
		double impostoDedutivel = impostoSobreSalario(salario) + impostoSobreServico(prestacaoServico) + impostoSobreCapital(ganhoCapital);
		double gastosMedicosEducacionais = gastoDeducoes(gastoMedico, GastoEducacional);
		if (gastosMedicosEducacionais > impostoDedutivel) {
			return impostoDedutivel * 0.30;
		} else {
			return gastosMedicosEducacionais;
		}
	}

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Renda anual com salário: ");
		double salario = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: ");
		double prestacaoServico = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		double ganhoCapital = sc.nextDouble();
		System.out.print("Gastos médicos: ");
		double gastoMedico = sc.nextDouble();
		System.out.print("Gasto educacionais: ");
		double gastoEducacional = sc.nextDouble();
		
		System.out.println("\nRELATÓRIO DE IMPOSTO DE RENDA\n");
		
		System.out.println("CONSOLIDADO DE RENDA:");
		
		double impostoSalarial = impostoSobreSalario(salario);
		double impostoServico = impostoSobreServico(prestacaoServico);
		double impostoCapital = impostoSobreCapital(ganhoCapital);
		
		System.out.printf("Imposto sobre salário: %.2f\n", impostoSalarial);
		System.out.printf("Imposto sobre serviços: %.2f\n", impostoServico);
		System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoCapital);
		
		System.out.println("\nDEDUÇÕES:");
		
		double maximoDedutivel = (impostoSalarial + impostoServico + impostoCapital) * 0.30;
		double gastosDedutivel = gastoDeducoes(gastoMedico, gastoEducacional);
		
		System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutivel);
		
		System.out.println("\nRESUMO:");
		
		double impostoBrutoTotal = impostoSalarial + impostoServico + impostoCapital;
		double abatimentos = abatimentoImposto(salario, prestacaoServico, ganhoCapital, gastoMedico, gastoEducacional);
		double impostoDevido = impostoBrutoTotal - abatimentos;
		
		System.out.printf("Imposto bruto total: %.2f\n", impostoBrutoTotal);
		System.out.printf("Abatimento: %.2f\n", abatimentos);
		System.out.printf("Imposto devido: %.2f\n", impostoDevido);

		sc.close();

	}

}
