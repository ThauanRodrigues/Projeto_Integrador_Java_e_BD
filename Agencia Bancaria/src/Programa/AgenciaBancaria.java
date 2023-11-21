package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    // Menu
    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");
         System.out.print("\nDigite a Opção: ");

        int operacao = sc.nextInt();
        sc.nextLine();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por usar a nossa Agência");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;

        }
    }

    // Método criar conta
    public static void criarConta() {

        System.out.print("\nTipo de Pessoa:" +
        "\n |   Opção 1 - Pessoa Fisica   |" +
        "\n |   Opção 2 - Pessoa Juridica |" +
        "\n\n Digite: ");
        int tipoPessoa = sc.nextInt();
        sc.nextLine();

        Pessoa cliente;
        if (tipoPessoa == 1) {
            System.out.print("\nNome: ");
            String nome = sc.nextLine();
            System.out.print("\nCPF: ");
            String cpf = sc.nextLine();
            System.out.print("\nemail: ");
            String email = sc.nextLine();

            cliente = new PessoaFisica(nome, cpf,email);
        } else if (tipoPessoa == 2) {
          System.out.print("\nNome da empresa: ");
          String nome = sc.nextLine();
            System.out.print("\nCNPJ: ");
            String cnpj = sc.nextLine();
            System.out.print("\nemail: ");
            String email = sc.nextLine();
            cliente = new PessoaJuridica(nome, cnpj, email);
        } else {
            System.out.println("Tipo de pessoa inválido.");
            operacoes();
            return;
        }

        Conta conta = new Conta(cliente);
        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");
        operacoes();
    }

    // Método encontrar conta
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta contaa : contasBancarias) {
                if (contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }

    // Método depositar
    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = sc.nextDouble();

            ((OperacoesBancarias) conta).depositar(valorDeposito);
        } else {
            System.out.println("--- Conta não encontrada ---");
        }
        operacoes();
    }

    // Método sacar
    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = sc.nextDouble();

            ((OperacoesBancarias) conta).sacar(valorSaque);
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();
    }

    // Método transferir
    public static void transferir() {
        System.out.println("Informe o número da conta do remetente: ");
        int numeroContaRemetente = sc.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        // validação
        if (contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = sc.nextInt();
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Quantia a ser transferida: ");
                double valor = sc.nextDouble();
                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                System.out.println("A conta para depósito não foi encontrada");
            }
        } else {
            System.out.println("Conta para transferir não encontrada");
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            // percorrendo a lista
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Sem contas cadastradas");
        }
        operacoes();
    }
}
