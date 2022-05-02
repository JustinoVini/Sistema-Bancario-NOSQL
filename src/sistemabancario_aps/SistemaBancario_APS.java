package sistemabancario_aps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaBancario_APS {
	private static int numeroConta = 1;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String aux;
        int opcao;
        double valor;
        Conta c1 = new Conta();
        List<Conta> listaDeContas = new ArrayList<>();

        do {

            System.out.println("--- Menu ---");
            System.out.println("1) Abrir Conta");
            System.out.println("2) Acessar Conta");
            System.out.println("0) Sair");

            System.out.print("Opção: ");
            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    Conta contaNova = Abrir_Conta();
                    contaNova.DadosBancario();
                    listaDeContas.add(contaNova);
                    break;

                case 2:
                    if (listaDeContas.isEmpty()) {
                        System.out.println("nehuma conta cadastrada");
                        break;
                    } else {
                        Conta conta = buscarConta(listaDeContas);
                        if (conta == null) {
                            System.out.println("Conta não encontrada!");
                        } else {
                            System.out.println("Bem vindo, " + conta.getTitular());
                            MetodosDaConta(conta);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o Valor do depósito: ");
                    valor = in.nextDouble();
                    c1.Depositar(valor);
                    break;

                case 4:
                    System.out.println("Digite o Valor do Saque: ");
                    valor = in.nextDouble();
                    c1.Sacar(valor);

                default:
                    break;

            }

        } while (opcao != 0);
    }

    private static Conta Abrir_Conta() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o Titular da conta: ");
        String aux = in.nextLine();
        System.out.println("");
        System.out.println("Qual conta você gostaria de abrir?:");
        System.out.println("1) Conta Normal: ");
        System.out.println("2) Conta Poupança: ");
        System.out.println("3) Conta cinco estrelas: ");
        System.out.println("0) opcao");
        System.out.println("--- Fim do Menu ---");

        int opcao = in.nextInt();

        switch (opcao) {
            case 1:
                return new Conta(aux, 100, numeroConta++);

            case 2:
                return new Conta(aux, 0, numeroConta++);

            case 3:
                return new Conta(aux, 500, numeroConta++);
            default:
                return null;
        }

    }

    private static void MetodosDaConta(Conta conta) {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("1) Extrato ");
        System.out.println("2) Depósito ");
        System.out.println("3) Saque ");

        System.out.println("opcao ");

        int var1 = in.nextInt();

        switch (var1) {
            case 1:
                conta.DadosBancario();
                break;
            case 2: {
                Scanner in2 = new Scanner(System.in);
                System.out.println("Que valor deseja depositar?: ");
                double valor = Double.valueOf(in2.nextLine());
                conta.Depositar(valor);
                break;
            }
            case 3: {
                Scanner in2 = new Scanner(System.in);
                System.out.println("Que valor deseja sacar?: ");
                double valor = Double.valueOf(in2.nextLine());
                conta.Sacar(valor);
                break;
            }
            default:
                break;
        }
    }

    private static Conta buscarConta(List<Conta> contas1) {
        Scanner in3 = new Scanner(System.in);
        System.out.println("Digite o numero da conta: ");
        System.out.println("");
        int numeroConta = in3.nextInt();

        for (Conta conta1 : contas1) {
            if (conta1.getNumero() == numeroConta) {
                return conta1;
            }
        }
        return null;
    }
}
