public class Engenheiro extends Funcionario{

   //Atributos
    private Double salario;

    @Override
    public String toString() {
        return "Engenheiro{" +
                "salario=" + salario +
                '}';
    }

    //Construtor
    public Engenheiro(String cpf, String nome, Double salario) {
        super(cpf, nome);
        this.salario = salario;
    }

    @Override
    public Double calcSalario() {
        return salario;
    }


}
