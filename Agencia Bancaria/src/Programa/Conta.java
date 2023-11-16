package Programa;

import Utilitarios.Utils;

public class Conta {
  // Contador de contas
  public static int contadorDeContas = 1;
  // Atributos
  private int numeroConta;
  private Pessoa pessoa;
  private double saldo = 0.0;
  // Construtor da Classe
  public Conta(Pessoa pessoa) {
    this.numeroConta = contadorDeContas;
    this.pessoa = pessoa;
    contadorDeContas += 1;
  }
  // Gets e Sets
  public int getNumeroConta() {
    return numeroConta;
  }
  public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
  }
  public Pessoa getPessoa() {
    return pessoa;
  }
  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }
  public double getSaldo() {
    return saldo;
  }
  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  // ToString
  public String toString(){
  return "\nNúmero da conta: " + this.getNumeroConta() +
          "\nNome: " + this.pessoa.getNome() +
          "\nCPF: " + this.pessoa.getCpf() +
          "\nE_mail: " + this.pessoa.getEmail() +
          "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
          "\n";
  }

  // Mêtodo de Depositar
  public void depositar(double valor){
    if(valor > 0){
      setSaldo(getSaldo() + valor);
      System.out.println("Depósito realizado com sucesso!");
    }else{
      System.out.println("Não foi possível realizar o depósito!");
    }
  }

  // Mêtodo Sacar
  public void sacar (double valor){
    if(valor > 0 && this.getSaldo() >= valor){
      setSaldo(getSaldo() - valor);
      System.out.println("Saque realizado com sucesso!");
    }else{
      System.out.println("Não foi possível realizar o saque!");
    }
  }

  // Mêtodo Transferir
  public void transferir ( Conta contaParaDeposito, double valor){
    if(valor > 0 && this.getSaldo() >= valor){
      setSaldo(getSaldo() - valor);

      contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
      System.out.println("Transferência realizada com sucesso!");
    }else{
      System.out.println("Não foi possível realizar a transferência!");
    }
  }
}
