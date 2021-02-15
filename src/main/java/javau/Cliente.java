package javau;

public class Cliente {

    private String nome;
    private String cpf;
    private int idade;
    private char sexo;
    private Contato contato = new Contato();
    private Conta conta = new Conta();
    private Endereco endereco = new Endereco();


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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(String email, String telefone, String celular) {
        this.contato.setEmail(email);
        this.contato.setTelefone(telefone);
        this.contato.setCelular(celular);
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(int agencia, int conta, double saldo) {
        this.conta.setAgencia(agencia);
        this.conta.setConta(conta);
        this.conta.setSaldo(saldo);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(String cidade, String bairro, String rua, int numero) {
        this.endereco.setCidade(cidade);
        this.endereco.setBairro(bairro);
        this.endereco.setRua(rua);
        this.endereco.setNumero(numero);
    }

}
