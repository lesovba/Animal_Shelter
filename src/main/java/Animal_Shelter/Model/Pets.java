package Animal_Shelter.Model;

import java.util.ArrayList;


public class Pets extends Animals {

    private final ArrayList<Pets> listAnimal = new ArrayList<>();

    public Pets() {
    }

    public ArrayList <Pets> getListAnimal() {
        return listAnimal;
    }

    public void addNewPetAnimal(Pets animal) {
        listAnimal.add(animal);
    }

    public void printAll(){
        if(this.listAnimal.isEmpty()){
            System.out.println("      Список пуст\n");
        }else{
            for (Pets var : this.listAnimal) {
                System.out.println(var.toString());
            }
        }
    }
}