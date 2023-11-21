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
  public static void operacoes(){
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

    int operacao = sc.nextInt();
    sc.nextLine();

    switch (operacao){
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
  // Mêtodo criar conta
  public static void criarConta(){
    System.out.println("\nNome: ");
    String nome = sc.nextLine();
    sc.nextLine();
   
    System.out.println("\nCPF: ");
    String cpf = sc.nextLine();
  
    System.out.println("\nE_mail: ");
    String email = sc.nextLine();
  

    Pessoa cliente = new Pessoa(nome, cpf, email);
    Conta conta = new Conta(cliente);
    contasBancarias.add(conta);
    System.out.println("Sua conta foi criada com sucesso!");
    operacoes();
  }

  // Mêtodo encontrar conta
  private static Conta encontrarConta(int numeroConta) {
    Conta conta = null;
    if(contasBancarias.size() > 0) {
        for(Conta contaa : contasBancarias) {
            if(contaa.getNumeroConta() == numeroConta) {
                conta = contaa;
            }
        }
    }
    return conta;
}
  // Mêtodo depositar
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
    // Mêtodo sacar
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
    // Mêtodo transferir
    public static void transferir(){
      System.out.println("Informe o número da conta do remetente: ");
      int numeroContaRemetente = sc.nextInt();
      Conta contaRemetente = encontrarConta(numeroContaRemetente);
      
      // validação
      if(contaRemetente != null){
        System.out.println("Número da conta do destinatário: ");
        int numeroContaDestinatario = sc.nextInt();
        Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

        if (contaDestinatario != null) {
          System.out.println("Quantia a ser transferida: ");
          double valor = sc.nextDouble();
          contaRemetente.transferir(contaDestinatario, valor);
        }else{
          System.out.println("Aconta para depósito não foi encontrada");
        } 
      }else{
        System.out.println("Conta para transferir não encontrada");
      }
      operacoes();
    }
  
  public static void listarContas(){
    if (contasBancarias.size() > 0) {
      // pecorrendo a lista
      for(Conta conta : contasBancarias){
        System.out.println(conta);
      }
    }else{
      System.out.println("Sem contas cadastradas");
    }
    operacoes();
  }
}
