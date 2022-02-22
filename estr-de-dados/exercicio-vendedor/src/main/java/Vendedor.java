public class Vendedor extends Funcionario{

    //Atributos
    private Double vendas;
    private Double taxa;

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendas=" + vendas +
                ", taxa=" + taxa +
                '}';
    }

    public Vendedor(String cpf, String nome, Double vendas, Double taxa) {
        super(cpf, nome);

        this.vendas = vendas;
        this.taxa = taxa;
    }

    @Override
    public Double calcSalario() {
       Double salarioVendedor = getVendas() * getTaxa();
        return salarioVendedor;
    }

    public Double getVendas() {
        return vendas;
    }

    public void setVendas(Double vendas) {
        this.vendas = vendas;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }
}
