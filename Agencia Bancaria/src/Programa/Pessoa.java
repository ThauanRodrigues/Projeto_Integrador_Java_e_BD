package Programa;

import java.util.Date;

import Utilitarios.Utils;

public abstract class Pessoa {

    private static int counter = 1;

    private int numeroPessoa;
    private String name;
    private String email;
    private Date accountCreationDate;

    public Pessoa() { }

    public Pessoa(String name, String email) {
        this.numeroPessoa = Pessoa.counter;
        this.name = name;
        this.email = email;
        this.accountCreationDate = new Date();
        Pessoa.counter += 1;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    public abstract String getTipoPessoa();

    @Override
    public String toString() {
        return  "\nTipo de Pessoa: " + getTipoPessoa() +
                "\nName: " + this.getName() +
                "\nEmail: " + this.getEmail() +
                "\nAccount Creation Date: " + Utils.dateToString(this.getAccountCreationDate());
    }
}
