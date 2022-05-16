public class Hospital {

    //Atributos
    private int idPaciente;
    private String nome;
    private int idade;
    private double peso;
    private double temperatura;
    private String sintomas;
    private String alergiaRemedio;
    private String diagnostico;

    //Construtor
    public Hospital(int idPaciente, String nome, int idade, double peso, double temperatura, String sintomas, String alergiaRemedio, String diagnostico) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.temperatura = temperatura;
        this.sintomas = sintomas;
        this.alergiaRemedio = alergiaRemedio;
        this.diagnostico = diagnostico;
    }

    //toString
    @Override
    public String toString() {
        String texto1 = String.format("%-10s %-14s %11s %6s %6s %15s %20s %20s\n", "IDPACINETE", "NOME", "IDADE", "PESO", "TEMPERATURA", "SINTOMAS", "ALERGIAS", "DIAGNOTISCO");
        String texto2 = String.format("%010d %-14s %11s %6.2f %6.2f %20s %20s %20s\n", idPaciente, nome, idade, peso, temperatura, sintomas, alergiaRemedio, diagnostico);
        return texto1 + texto2;
    }

    //Getters and Setters

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getAlergiaRemedio() {
        return alergiaRemedio;
    }

    public void setAlergiaRemedio(String alergiaRemedio) {
        this.alergiaRemedio = alergiaRemedio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
