public class Produto {

    //Atributos
    private int codProduto;
    private String nome;
    private double preco;
    private String avaliacao;
    private int quantidadeVendida;

    //Construtor
    public Produto(int codProduto, String nome, double preco, String avaliacao) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.quantidadeVendida = 0;
    }

    public void compra(int qtdVendida){
        this.quantidadeVendida += qtdVendida;
    }

    public double calcularFaturamento(){
        double valorCalculado = this.quantidadeVendida * this.preco;
        return valorCalculado;
    }

    @Override
    public String toString() {
       String texto1 = String.format("%-6s %-14s %6s %7s %14s\n", "CODIGO", "NOME", "PREÇO", "NOTA", "FATURAMENTO");
       String texto2 = String.format("%06d %-14s %6.2f %7s %14.3f\n", codProduto, nome, preco, avaliacao, calcularFaturamento());
        return texto1 + texto2;
    }

    //Getter and Setters
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
}
