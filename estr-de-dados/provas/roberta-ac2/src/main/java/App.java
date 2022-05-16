import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    public static void gravaArquivoCSV(ListaObj<Hospital> lista, String nomeArq) {
        FileWriter arq = null; // Objeto que representa o arquivo que será usado para escrita/gravação
        Formatter saida = null; // Objeto que será usado para escrever o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv"; // Acrescenta a extensão do arquivo .csv

        // Bloco trt-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Hospital hospital = lista.getElemento(i);
                saida.format("%d;%s;%d;%.2f;%.2f;%s;%s;%s\n",
                        hospital.getIdPaciente(),
                        hospital.getNome(),
                        hospital.getIdade(),
                        hospital.getPeso(),
                        hospital.getTemperatura(),
                        hospital.getSintomas(),
                        hospital.getAlergiaRemedio(),
                        hospital.getDiagnostico());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo!");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void lerArquivoCSV(String nomeArq) {
        FileReader arq = null; // Objeto que representa o arquivo que será aberto para leitura
        Scanner entrada = null; // Objeto que será usado para ler o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler o arquivo
        try {
            System.out.printf("%-10s %-14s %11s %6s %6s %15s %20s %20s\n", "IDPACIENTE", "NOME", "IDADE", "PESO", "TEMPERATURA", "SINTOMAS", "ALERGIAS", "DIAGNOTISCO");
            while (entrada.hasNext()) {
                int idPaciente = entrada.nextInt();
                String nome = entrada.next();
                int idade = entrada.nextInt();
                double peso = entrada.nextDouble();
                double temperatura = entrada.nextDouble();
                String sintomas = entrada.next();
                String alergiaRemedio = entrada.next();
                String diagnostico = entrada.next();
                System.out.printf("%010d %-14s %11s %6.2f %6.2f %20s %20s %20s\n",
                        idPaciente,
                        nome,
                        idade,
                        peso,
                        temperatura,
                        sintomas,
                        alergiaRemedio,
                        diagnostico);
            }
        } catch (NoSuchElementException erro) {
            System.out.printf("Arquivo com problema");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        ListaObj<Hospital> listaHosp = new ListaObj<>(10);

        // Variáveis
        boolean continua = true;

        int idPaciente;
        String nome;
        int idade;
        double peso;
        double temperatura;
        String sintomas;
        String alergiaRemedio;
        String diagnostico;

        int opcao;
        String nomeArquivo;
        int idadePacientes;
        String novoDiagnostico;

        Scanner leitor = new Scanner(System.in);
        Scanner leitorN = new Scanner(System.in);


        do {
            System.out.println("1. Adicionar um paciente\n" +
                    "2. Exibir a lista\n" +
                    "3. Gravar a lista em arquivo CSV\n" +
                    "4. Ler e exibir um arquivo CSV\n" +
                    "5. Atualizar o diagnotico dos pacientes.\n" +
                    "6. Sair\n");

            opcao = leitorN.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o id do Paciente: ");
                    idPaciente = leitorN.nextInt();

                    System.out.println("Digite o nome: ");
                    nome = leitor.next();

                    System.out.println("Digite a idade do paciente: ");
                    idade = leitorN.nextInt();

                    System.out.println("Digite o peso do paciente: ");
                    peso = leitorN.nextDouble();

                    System.out.println("Digite a temperatura do paciente: ");
                    temperatura = leitorN.nextDouble();

                    System.out.println("Digite os sintomas do paciente: ");
                    sintomas = leitor.next();

                    System.out.println("Digite a alergia a algum medicamento (Caso não tenha informe 'null'): ");
                    alergiaRemedio = leitor.next();

                    System.out.println("Digite o diagnostico do paciente: ");
                    diagnostico = leitor.next();

                    listaHosp.adiciona(new Hospital(idPaciente, nome, idade, peso, temperatura, sintomas, alergiaRemedio, diagnostico));
                    break;
                case 2:
                    listaHosp.exibe();
                    break;
                case 3:
                    if (listaHosp.getTamanho() == 0) {
                        System.out.println("Lista está vazia. Não há nada a gravar.");
                    } else {
                        gravaArquivoCSV(listaHosp, "Hospital");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do arquivo que deve ser lido: ");
                    nomeArquivo = leitor.next();
                    lerArquivoCSV(nomeArquivo);
                    break;
                case 5:
                    System.out.println("Digite a idade dos pacientes que deseja alterar o diagnostico: ");
                    idadePacientes = leitor.nextInt();

                    System.out.println("Digite o novo diagnostico: ");
                    novoDiagnostico = leitor.next();

                    for (int i = 0; i < listaHosp.getTamanho(); i++) {
                        if (listaHosp.getElemento(i).getIdade() == idadePacientes) {
                            listaHosp.getElemento(i).setDiagnostico(novoDiagnostico);
                            System.out.println("Diagnostico atualizado!");
                        }
                    }
                    if (listaHosp.getTamanho() == 0) {
                        System.out.println("Lista está vazia.");
                    }
                    break;
                case 6:
                    continua = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (continua);
    }
}
