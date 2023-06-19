package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu 
{
	
	public static void main(String[] args) 
	{
		String titular;	
		float saldo, limite, valor; 
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		ContaController contas = new ContaController();
		Scanner ler = new Scanner(System.in);
		
		
		while (true) 
		{
			//Informações para o Usuário
			System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO);
			System.out.println("________________________________________\n");
			System.out.println("               BANCO DO BRAZIL COM Z");
			System.out.println("________________________________________\n");
			System.out.println("     1 - Criar Conta");
			System.out.println("     2 - Listar todas as Contas");
			System.out.println("     3 - Buscar Conta por Numero");
			System.out.println("     4 - Atualizar Dados da Conta");
			System.out.println("     5 - Apagar Conta");
			System.out.println("     6 - Sacar");
			System.out.println("     7 - Depositar");
			System.out.println("     8 - Transferir valores entre Contas");
			System.out.println("     9 - Sair");
			System.out.println("________________________________________\n" + Cores.RESETAR_CORES);
			
			System.out.print(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "Entre com a opção desejada: ");
			try 
			{
				opcao = ler.nextInt();
			}catch(InputMismatchException erroString) 
			{
				System.out.println("Digite valores inteiros!");
				ler.nextLine();
				opcao = 0;
			}

			switch (opcao) 
			{
			case 1:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n");
				System.out.println("             Criar Conta");
				System.out.println("________________________________________\n");
				
				System.out.print("Digite o numero da Agência: ");
				agencia = ler.nextInt();
				System.out.print("Digite o nome do titular: ");
				ler.skip("\\R?");
				titular = ler.nextLine();
				
				do 
				{
					System.out.print("Digite o tipo da conta (1- Conta Corrente ou 2 - Conta Poupança): ");
					tipo = ler.nextInt();
				}while (tipo < 1 && tipo > 2);
				
				System.out.print("Digite o saldo da conta (R$): ");
				saldo = ler.nextFloat();
				
				switch(tipo) 
				{
					case 1 ->
					{
						System.out.print("Digite o limite de crédito (R$): ");
						limite = ler.nextFloat();
						contas.cadastrar(new ContaCorrente(titular, contas.gerarNumero(), agencia, tipo, saldo, limite));
			
					}
					case 2 -> 
					{ 
						System.out.print("Digite o dia do aniversário da conta: ");
						aniversario = ler.nextInt();
						contas.cadastrar(new ContaPoupanca(titular, contas.gerarNumero(), agencia, tipo, saldo, aniversario));
					}
				}
					
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n");
				System.out.println("         Listar todas as contas");
				System.out.println("________________________________________\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n");
				System.out.println("        Consultar dados da conta");
				System.out.println("________________________________________\n");
				
				System.out.print("Digite o número da conta: ");
				numero = ler.nextInt();
				contas.procurarPorNumeros(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n");
				System.out.println("         Atualizar dados da conta");
				System.out.println("________________________________________\n");
				
				System.out.print("Digite o número da conta: ");
				numero = ler.nextInt();
				
				if (contas.buscarNaCollection(numero) != null) {
					
					System.out.print("Digite o numero da Agência: ");
					agencia = ler.nextInt();
					System.out.print("Digite o nome do titular: ");
					ler.skip("\\R?");
					titular = ler.nextLine();
					System.out.print("Digite o saldo da conta (R$): ");
					saldo = ler.nextFloat();
					
					tipo = contas.retornaTipo(numero);
					
					switch (tipo) 
					{
						case 1:
							System.out.print("Digite o limite de crédito (R$): ");
							limite = ler.nextFloat();
							contas.atualizar(new ContaCorrente(titular, numero, agencia, tipo, saldo, limite));
						break;
						case 2:
							System.out.print("Digite o dia do aniversario da conta: ");
							aniversario = ler.nextInt();
							contas.atualizar(new ContaCorrente(titular, numero, agencia, tipo, saldo, aniversario));
						break;	
						default:
							System.out.println("Tipo de conta inválido!");
						break;
					}
				}else 
				{
					System.out.println("Conta não Encontrada");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n");
				System.out.println("             Apagar a conta");
				System.out.println("________________________________________\n");
				
				System.out.print("Digite o número da conta ");
				numero = ler.nextInt();	
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n");
				System.out.println("                Saque");
				System.out.println("________________________________________\n");
				
				System.out.print("Digite o número da conta: ");
				numero = ler.nextInt();
				
				do {
					System.out.print("Digite o valor de saque (R$): ");
					valor = ler.nextFloat();
				}while(valor <= 0);
				
				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n");
				System.out.println("               Depósito");
				System.out.println("________________________________________\n");

				System.out.print("Digite o número da conta: ");
				numero = ler.nextInt();
				
				do {
					System.out.print("Digite o valor de depósito (R$): ");
					valor = ler.nextFloat();
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n");
				System.out.println("     Transferência entre as contas");
				System.out.println("________________________________________\n");
				
				System.out.print("Digite o número da conta de origem: ");
				numero = ler.nextInt();
				System.out.print("Digite o número da conta de destino: ");
				numeroDestino = ler.nextInt();	
				
				do {
					System.out.print("Digite o valor de transferência (R$): ");
					valor = ler.nextFloat();
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "________________________________________\n" + Cores.RESETAR_CORES);
				System.out.println(Cores.TEXTO_VERMELHO_NEGRITO_INTENSO + "            Opção Inválida" + Cores.RESETAR_CORES);
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO+ "________________________________________\n");
				
				keyPress();
				break;
			}
			
			if (opcao == 9) 
			{
				System.out.println(Cores.TEXTO_BRANCO_NEGRITO_INTENSO + "Banco do Brazil com Z - O seu Futuro começa aqui!");
				ler.close();
				System.exit(0);
			}
			
		}

	}
	
	public static void keyPress()
	{
		try 
		{
			System.out.println(Cores.RESETAR_CORES+ "Pressione enter para continuar...");
			System.in.read();
		}catch (IOException erroEntradaSaida) 
		{
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}