public class Livro extends Produto{

    //Atributos
    private String autor;
    private String isbn;

    //Construtor
    public Livro(int codigo, String nome, double precoCusto, String autor, String isbn) {
        super(codigo, nome, precoCusto);
        this.autor = autor;
        this.isbn = isbn;
    }

    //Metodos


    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public double getValorVenda() {
        return getPrecoCusto();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
