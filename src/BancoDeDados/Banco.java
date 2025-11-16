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
    //Tem que ser um metodo static referenciando animal
    public static Animal buscarAnimalPorID(int id){
        //Primeiro tem que passar pela lista cadastrada
        for (Animal animal : listaAnimal){
            if(animal.getId() == id){
                System.out.println(animal);
            } else {
                System.out.println("Animal não encontrado!");
            }
        }
        return null;
    }

    //Para editar um novo animal
    public static boolean editarAnimal(String novoNome, int novaIdade, int idEdicao){
        /*Tem-se que criar uma "instanciação local" que se referencia ao
        metodo buscarAnimalPorID*/

        Animal animalEditado = buscarAnimalPorID(idEdicao);//Ele pega como parâmetro a variável local idEdicao


        if(animalEditado != null){
            animalEditado.setNome(novoNome);
            animalEditado.setIdade(novaIdade);
            System.out.println("Animal editado com sucesso!");
            return true;
        }
        System.out.println("Animal não encontrado!");
        return false;
    }

    public static boolean excluirAnimal(int id){
        //Basicamente o mesmo do de cima
        Animal exclusao = buscarAnimalPorID(id);

        if(exclusao != null){
            //Aqui vai remover da lista
            listaAnimal.remove(exclusao);
            System.out.println("Animal com o ID " + id + " removido com sucesso!");
            return true;
        }else {
            System.out.println("Erro na remoção");
            return false;
        }
    }






}
