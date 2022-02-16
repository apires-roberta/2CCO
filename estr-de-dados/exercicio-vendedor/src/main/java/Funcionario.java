abstract class Funcionario {

    //Atributos
    private String cpf ;
    private String nome ;

    //toString
    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    //Constutor
    public Funcionario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    //Metodos
    public abstract Double calcSalario();


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
