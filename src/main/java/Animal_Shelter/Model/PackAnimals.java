package Animal_Shelter.Model;

import java.util.ArrayList;

public class PackAnimals extends Animals{

    private final ArrayList<PackAnimals> listAnimal = new ArrayList<>();

    public ArrayList<PackAnimals> getListAnimal() {
        return listAnimal;
    }

    public PackAnimals() {
    }

    public void addNewPackAnimal(PackAnimals animal) {
        listAnimal.add(animal);
    }

    public void printAll(){
        if(this.listAnimal.isEmpty()){
            System.out.println("      Список пуст \n");
        }else{
            for (PackAnimals var : this.listAnimal) {
                System.out.println(var.toString());
            }
        }
    }
}
