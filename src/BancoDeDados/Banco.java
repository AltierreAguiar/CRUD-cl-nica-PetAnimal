package BancoDeDados;

import Animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    //Declaração da lista Animal
    private static List<Animal> listaAnimal = new ArrayList<>();

    //Para adicionar um novo animal
    public static void adicionarAnimal(Animal animal){
        listaAnimal.add(animal);//Vai armazenar a variável local ao Array
        System.out.println("Animal adicionado com sucesso!");
    }

    //Para listar os animais
    public static List<Animal> listarAnimal(){
        return listaAnimal;
    }

    //Para buscar por ID
    public static Animal buscarAnimalPorID(int id){
        //Percorre a lista cadastrada
        for (Animal animal : listaAnimal){
            if(animal.getId() == id){
                // Retorna o animal encontrado
                return animal;
            }
        }
        // Se sair do loop sem encontrar, retorna null
        return null;
    }

    // Para editar um novo animal
    public static boolean editarAnimal(String novoNome, int novaIdade, int idEdicao){
        Animal animalEditado = buscarAnimalPorID(idEdicao);

        if(animalEditado != null){
            animalEditado.setNome(novoNome);
            animalEditado.setIdade(novaIdade);
            System.out.println("Animal editado com sucesso!");
            return true;
        }
        System.out.println("Animal não encontrado para edição!"); // Mensagem mais clara
        return false;
    }

    // Para excluir um animal
    public static boolean excluirAnimal(int id){
        Animal exclusao = buscarAnimalPorID(id);

        if(exclusao != null){
            listaAnimal.remove(exclusao);
            System.out.println("Animal com o ID " + id + " removido com sucesso!");
            return true;
        } else { // Adicione o else aqui para evitar que a mensagem seja mostrada se a busca retornar null
            System.out.println("Animal não encontrado para remoção.");
            return false;
        }
    }


}
