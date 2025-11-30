package ClinicaPetMain;

import Animal.Animal;
import BancoDeDados.Banco;
import CachorroEGato.Cachorro;
import CachorroEGato.Gato;
import Consulta.Consulta;
import Veterinario.Veterinario;
import java.util.Scanner;
import java.util.List;

public class Main {
    // Declaração do Scanner como static para ser usado em toda a classe
    private static final Scanner scanner = new Scanner(System.in);

    // Lista de Veterinários para simular um cadastro fixo
    private static final Veterinario vet1 = new Veterinario("Dr. Ricardo Santos",
                                                            "1234", "Clínico Geral");

    private static final Veterinario vet2 = new Veterinario("Dra. Ana Maria",
                                                            "5678", "Cirurgiã");

    public static void main(String[] args) {
        int opcao = -1;
        // Loop principal do menu
        do {
            exibirMenuPrincipal();
            try {
                // Tenta ler a opção, garantindo que seja um número inteiro
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarAnimal();
                        break;
                    case 2:
                        listarAnimais();
                        break;
                    case 3:
                        buscarAnimalPorId();
                        break;
                    case 4:
                        editarAnimal();
                        break;
                    case 5:
                        excluirAnimal();
                        break;
                    case 6:
                        agendarConsulta();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida! Digite uma opção entre 0 e 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                opcao = -1; // Mantém o loop
            }
            pausarExecucao(); // Adiciona pausa para leitura
        } while (opcao != 0);

        scanner.close(); // Fecha o scanner ao sair do programa
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n---  Clínica Pet Animal - Menu Principal  ---");
        System.out.println("1. Cadastrar Novo Animal (Create)");
        System.out.println("2. Listar Todos os Animais (Read)");
        System.out.println("3. Buscar Animal por ID");
        System.out.println("4. Editar Animal (Update)");
        System.out.println("5. Excluir Animal (Delete)");
        System.out.println("6. Agendar Nova Consulta");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // --- Métodos de Interação (CRUD) ---

    private static void cadastrarAnimal() {
        System.out.println("\n--- Cadastro de Animal ---");
        System.out.print("Nome do Animal: ");
        String nome = scanner.nextLine();

        int idade = -1;
        while (idade < 0) {
            try {
                System.out.print("Idade do Animal: ");
                idade = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida. Por favor, digite um número inteiro.");
            }
        }

        System.out.println("Tipo de Animal:");
        System.out.println("1. Cachorro");
        System.out.println("2. Gato");
        System.out.print("Escolha (1 ou 2): ");
        String tipoStr = scanner.nextLine();

        Animal novoAnimal = null;
        if (tipoStr.equals("1")) {
            novoAnimal = new Cachorro(nome, idade);
        } else if (tipoStr.equals("2")) {
            novoAnimal = new Gato(nome, idade);
        } else {
            System.out.println("Tipo de animal inválido. Cadastro cancelado.");
            return;
        }

        Banco.adicionarAnimal(novoAnimal);
        System.out.println("Animal cadastrado! ID: " + novoAnimal.getId());
    }

    private static void listarAnimais() {
        System.out.println("\n--- Lista de Animais Cadastrados ---");
        List<Animal> animais = Banco.listarAnimal();
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }
        //For-each para passar pela lista cadrastrada
        for (Animal a : animais) {
            // Chama o toString correto de Cachorro ou Gato
            System.out.println("ID: " + a.getId() + " | " + a.toString());
        }
    }

    private static void buscarAnimalPorId() {
        System.out.println("\n--- Buscar Animal ---");
        System.out.print("Digite o ID do animal para buscar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Animal animal = Banco.buscarAnimalPorID(id);

            if (animal != null) {
                System.out.println("\nAnimal Encontrado:");
                System.out.println("ID: " + animal.getId() + " | " + animal.toString());
                animal.emitirSom();
            } else {
                System.out.println("Animal com ID " + id + " não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Por favor, digite um número inteiro.");
        }
    }

    private static void editarAnimal() {
        System.out.println("\n--- Editar Animal ---");
        System.out.print("Digite o ID do animal para editar: ");
        try {
            int idEdicao = Integer.parseInt(scanner.nextLine());

            // Verifica se o animal existe usando o método ajustado

            Animal animalParaEditar = Banco.buscarAnimalPorID(idEdicao);//vai pegar o método lá classe banco

            if (animalParaEditar == null) {
                System.out.println("Animal com ID " + idEdicao + " não encontrado para edição.");
                return;
            }

            System.out.println("Animal atual: " + animalParaEditar.toString());

            System.out.print("Novo Nome: ");
            String novoNome = scanner.nextLine();

            int novaIdade = -1;
            while (novaIdade < 0) {
                try {
                    System.out.print("Nova Idade: ");
                    novaIdade = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Idade inválida. Por favor, digite um número inteiro.");
                }
            }

            // O método editarAnimal já imprime a mensagem de sucesso/falha
            Banco.editarAnimal(novoNome, novaIdade, idEdicao);

        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Por favor, digite um número inteiro.");
        }
    }

    private static void excluirAnimal() {
        System.out.println("\n--- Excluir Animal ---");
        System.out.print("Digite o ID do animal para excluir: ");
        try {
            int idExclusao = Integer.parseInt(scanner.nextLine());

            // O método excluirAnimal já imprime a mensagem de sucesso/falha
            Banco.excluirAnimal(idExclusao);

        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Por favor, digite um número inteiro.");
        }
    }

    private static void agendarConsulta() {
        System.out.println("\n--- Agendar Consulta ---");

        System.out.print("Digite o ID do Pet a ser atendido: ");
        int petId;
        try {
            petId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID de Pet inválido.");
            return;
        }

        Animal pet = Banco.buscarAnimalPorID(petId);
        if (pet == null) {
            System.out.println("Pet com ID " + petId + " não encontrado. Agendamento cancelado.");
            return;
        }

        System.out.print("Nome do Tutor: ");
        String nomeTutor = scanner.nextLine();

        System.out.print("Tipo de Consulta (Ex: Vacina, Check-up): ");
        String tipoConsulta = scanner.nextLine();

        System.out.print("Data da Consulta (Ex: 01/01/2026): ");
        String dataConsulta = scanner.nextLine();

        System.out.println("\nVeterinários disponíveis:");
        System.out.println("1. " + vet1.toString());
        System.out.println("2. " + vet2.toString());
        System.out.print("Escolha o número do Veterinário (1 ou 2): ");
        String vetEscolha = scanner.nextLine();

        Veterinario vetEscolhido;
        if (vetEscolha.equals("1")) {
            vetEscolhido = vet1;
        } else if (vetEscolha.equals("2")) {
            vetEscolhido = vet2;
        } else {
            System.out.println("Opção de Veterinário inválida. Agendamento cancelado.");
            return;
        }

        Consulta novaConsulta = new Consulta(pet, tipoConsulta, dataConsulta, vetEscolhido, nomeTutor);

        System.out.println("\n--- Consulta Agendada com Sucesso! ---");
        System.out.println(novaConsulta.toString());
    }

    // Método auxiliar para pausar a execução após cada ação
    private static void pausarExecucao() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}