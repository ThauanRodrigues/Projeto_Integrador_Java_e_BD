package Programa;

public class Pessoa{
  // Contador
  private static int contador = 1;
  // Atributos
  private String nome;
  private String cpf;
  private String email;
  // Construtor
  public Pessoa(String nome, String cpf, String email) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    contador+=1;
  }
  // Gets e Sets
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  // ToString
  public String toString() {
    return "\nNome: " + this.getNome() + 
            "\nCPF: " + this.getCpf() + 
            "\nE-mail: " + this.getEmail();
  }

}