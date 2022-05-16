import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void gravaArqTxt(List<Aluno> lista, String nomeArq){
        int contaRegistroCorpo = 0;
        String header = "00NOTA20221";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        gravaRegistro(header, nomeArq);

        for(Aluno a : lista){
            String corpo = "02";
            corpo += String.format("%-5.5s", a.getCurso());
            corpo += String.format("%-8.8s", a.getRa());
            corpo += String.format("%-50.50s", a.getNome());
            corpo += String.format("%-40.40s", a.getDisciplina());
            corpo += String.format("%05.2f", a.getMedia());
            corpo += String.format("%03d", a.getQtdFalta());
            gravaRegistro(corpo, nomeArq);
            contaRegistroCorpo++;
        }

        String trailer = "01";
        trailer += String.format("%010d", contaRegistroCorpo);
        gravaRegistro(trailer, nomeArq);
    }

    public static void gravaRegistro(String registro, String nomeArq){
        BufferedWriter saida = null;

        try{
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }
        try{
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro){
            System.out.println("Erro ao gravar o arquivo: " + erro);
        }
    }

    public static void leArquivoTxt(String nomeArq){
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String curso, ra, nome, disciplina;
        Double media;
        Integer qtdFalta;
        int contaRegDadoLido = 0;
        int qtdRegGravado;

        List<Aluno> listaLida = new ArrayList<>();

        try{
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        try{
            registro = entrada.readLine();
            while (registro != null){ // enquanto não é final do arquivo

                //Obtem os 2 primerios caracteres do registro
                //012345
                //00NOTA20221
                tipoRegistro = registro.substring(0,2);
                if(tipoRegistro.equals("00")){
                    System.out.println("É um registro de header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2,6));
                    System.out.println("Ano/Semestre: " + registro.substring(6,11));
                    System.out.println("Data e hora de gravação do arquivo: " + registro.substring(11,30));
                    System.out.println("Versão do documento de layout: " + registro.substring(30,32));
                }else if(tipoRegistro.equals("01")){
                    System.out.println("É um registro de trailer");
                    qtdRegGravado = Integer.parseInt(registro.substring(2,12));
                    if(contaRegDadoLido == qtdRegGravado){
                        System.out.println("Quantidade de registro lidos compatível com a quantidade de registros gravados");
                    }else{
                        System.out.println("Quantidade de registro lidos incompatível com a quantidade de registros gravados");
                    }
                }else if(tipoRegistro.equals("02")){
                    System.out.println("É um registro de corpo");
                    curso = registro.substring(2,7).trim();
                    ra = registro.substring(7,15).trim();
                    nome = registro.substring(15,65).trim();
                    disciplina = registro.substring(65,105).trim();
                    media = Double.valueOf(registro.substring(105,110).replace(',','.'));
                    qtdFalta = Integer.parseInt(registro.substring(110,113));
                    contaRegDadoLido++;


                    Aluno a = new Aluno(ra,nome,curso,disciplina,media,qtdFalta);

                    listaLida.add(a);

                    //para importar no banco de dados pode-se fazer
                    //repository.save(a);

                    //vamos add o obj a na listaLida
                }else{
                    System.out.println("Tipo de arquivo inválido");
                }
                registro = entrada.readLine();

            }
            entrada.close();
        }
        catch (IOException erro){
            System.out.println("Erro na leitura do arquivo: " + erro);
        }
        //Exibe o conteúdo da listaLida
        //resposity.saveAll(listaLida);

        //Vamos exibir o conteúdo da listaLida]
        System.out.println("\nConteúdo da lista lida: ");
        for (Aluno a : listaLida){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        List<Aluno> lista = new ArrayList<>();

        lista.add(new Aluno("02211000","Abner Nunes", "CCO","Cáculo Computacional",9.5,5));
        lista.add(new Aluno("02211001","Roberta Pires", "REDES","Cloud",9.5,5));
        lista.add(new Aluno("02211002","Paula Pires", "CCO","Programação Java",10.5,2));
        lista.add(new Aluno("02211003","João Nunes", "CCO","Design de Interação",2.5,4));
        lista.add(new Aluno("02211004","Maria Aparecida", "ADS","Programação App",8.5,5));
        lista.add(new Aluno("02211005","Clodoaldo Pires", "ADS","Sistemas Operacionais",9.5,5));

        for(Aluno a : lista){
            System.out.println(a);
        }

        //gravaArqTxt(lista, "aluno.txt");
        leArquivoTxt("aluno.txt");
    }
}
