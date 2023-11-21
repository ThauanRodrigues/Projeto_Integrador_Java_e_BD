package Programa;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String name, String cnpj, String email) {
        super(name, email);
        this.cnpj = cnpj;
    }

    // Métodos getter e setter para o CNPJ
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getTipoPessoa() {
        return "Pessoa Jurídica";
    }

    @Override
    public String toString() {
        return "PessoaJuridica [cnpj=" + cnpj + "]";
    }
    
}
