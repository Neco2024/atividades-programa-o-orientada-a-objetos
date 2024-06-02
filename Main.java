import java.util.Scanner;
import java.util.InputMismatchException;

class Funcionario {
    private String nome;
    private String problemasMedicos;
    private String telefone;
    private String email;

    // Construtor
    public Funcionario(String nome, String problemasMedicos, String telefone, String email) {
        this.nome = nome;
        this.problemasMedicos = problemasMedicos;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProblemasMedicos() {
        return problemasMedicos;
    }

    public void setProblemasMedicos(String problemasMedicos) {
        this.problemasMedicos = problemasMedicos;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario[] funcionarios = new Funcionario[100];
        int nFuncionarios = 0;

        int opcao = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Funcionário");
            System.out.println("2. Imprimir Funcionários");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        if (nFuncionarios < funcionarios.length) {
                            funcionarios[nFuncionarios] = criarFuncionario(scanner);
                            nFuncionarios++;
                        } else {
                            System.out.println("Limite de funcionários atingido.");
                        }
                        break;
                    case 2:
                        if (nFuncionarios == 0) {
                            System.out.println("Nenhum funcionário cadastrado.");
                        } else {
                            System.out.println("Lista de Funcionários:");
                            for (int i = 0; i < nFuncionarios; i++) {
                                System.out.println((i + 1) + " - " + funcionarios[i].getNome());
                                imprimirFuncionario(funcionarios[i]);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine(); // Consumir a entrada inválida
                opcao = 0; // Reiniciar a opção para manter o loop
            }
        } while (opcao != 3);

        scanner.close();
    }

    public static Funcionario criarFuncionario(Scanner scanner) {
        System.out.println("Digite as informações do funcionário:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Problemas médicos: ");
        String problemasMedicos = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Funcionario(nome, problemasMedicos, telefone, email);
    }

    public static void imprimirFuncionario(Funcionario funcionario) {
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Problemas médicos: " + funcionario.getProblemasMedicos());
        System.out.println("Telefone: " + funcionario.getTelefone());
        System.out.println("Email: " + funcionario.getEmail());
    }
}
