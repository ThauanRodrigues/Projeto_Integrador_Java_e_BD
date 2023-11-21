package Programa;
import Utilitarios.Utils;
import java.util.Date;

class Conta implements OperacoesBancarias {
    private static int proximoNumeroConta = 1;

    private int numeroConta;
    private Pessoa cliente;
    private double saldo;
    private Date dataCriacaoConta;

    // Construtor
    public Conta(Pessoa cliente) {
        this.numeroConta = proximoNumeroConta++;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.dataCriacaoConta = new Date();
    }

    // Getters
    public int getNumeroConta() {
        return numeroConta;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
    public Date getAccountCreationDate() {
        return dataCriacaoConta;
    }
    //ToString
    @Override
    public String toString() {
        return "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nTipo de conta: " + this.cliente.getTipoPessoa() +
                "\nCliente/Empresa: " + this.cliente.getName() +
                (this.cliente instanceof PessoaFisica ? "\nCPF: " + ((PessoaFisica) this.cliente).getCpf() : "") +
                (this.cliente instanceof PessoaJuridica ? "\nCNPJ: " + ((PessoaJuridica) this.cliente).getCnpj() : "") +
                "\nEmail: " + this.cliente.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\nData de criação de Conta: " + Utils.dateToString(this.getAccountCreationDate()) +
                "\n";
    }
    

    // Implementação dos métodos da interface
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso. \nNovo saldo: R$" + Utils.doubleToString(this.getSaldo()));
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.\nNovo saldo: R$" + Utils.doubleToString(this.getSaldo()));
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " para a conta " + destino.getNumeroConta() + " realizada com sucesso.");
        } else {
            System.out.println("Valor de transferência inválido ou saldo insuficiente.");
        }
    }
}
