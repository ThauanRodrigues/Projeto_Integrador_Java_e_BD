package Programa;

import Utilitarios.Utils;

public class Conta {
// contador
  private static int accountCounter = 1;
// Atributos
  private int numeroConta;
  private Pessoa pessoa;
  private Double saldo = 0.0;

// Construtor
  public Conta(Pessoa pessoa) {
      this.numeroConta = Conta.accountCounter;
      this.pessoa = pessoa;
      this.updateSaldo();
      Conta.accountCounter += 1;
  }

// Gets e Sets
  public int getNumeroConta() {
      return numeroConta;
  }
  public Pessoa getClient() {
      return pessoa;
  }
  public void setClient(Pessoa pessoa) {
      this.pessoa = pessoa;
  }
  public Double getSaldo() {
      return saldo;
  }
  public void setSaldo(Double saldo) {
      this.saldo = saldo;
  }

  private void updateSaldo() {
      this.saldo = this.getSaldo();
  }
// ToString
  public String toString() {

      return "\nBank account: " + this.getNumeroConta() +
              "\nCliente: " + this.pessoa.getName() +
              "\nCPF: " + this.pessoa.getCpf() +
              "\nEmail: " + this.pessoa.getEmail() +
              "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
              "\n" ;
  }
// Mêtodo depositar
  public void depositar(Double valor) {
      if(valor > 0) {
          setSaldo(getSaldo() + valor);
          //this.saldo = this.getSaldo() + valor;
          System.out.println("Seu depósito foi realizado com sucesso!");
      }else {
          System.out.println("Não foi possível realizar o depósito!");
      }
  }
  // Mêtodo sacar
  public void sacar(Double valor) {
      if(valor > 0 && this.getSaldo() >= valor) {
          setSaldo(getSaldo() - valor);
          System.out.println("Saque realizado com sucesso!");
      }else {
          System.out.println("Não foi possível realizar o saque!");
      }
  }
  // Mêtodo transferir
  public void transferir(Conta contaParaDeposito, Double valor) {
      if(valor > 0 && this.getSaldo() >= valor) {
          setSaldo(getSaldo() - valor);
          //this.saldo = this.getSaldo() - valor;
          contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
          System.out.println("Transferência realizada com sucesso!");
      }else {
          System.out.println("Não foi possível realizar a tranferência");
      }

  }

}
