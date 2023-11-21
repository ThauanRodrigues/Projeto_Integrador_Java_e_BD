package Programa;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String name, String cpf, String email) {
        super(name, email);
        this.cpf = cpf;
    }

    // Métodos getter e setter para o CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getTipoPessoa() {
        return "Pessoa Física";
    }

    @Override
    public String toString() {
        return "PessoaFisica [cpf=" + cpf + "]";
    }
    
}

