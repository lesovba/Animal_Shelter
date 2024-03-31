package Animal_Shelter.Controller;

import Animal_Shelter.Model.*;

public class Controller {

    //region fields
    PackAnimals packAnimals = new PackAnimals();
    Pets pets = new Pets();

    public Controller() {
    }

    public void addAnimals(String type, String name, String birth) throws Exception {      /* 1 -> Dog
                                                                            2 -> Cat
                                                                            3 -> Hamster
                                                                            4 -> Camel
                                                                            5 -> Donkey
                                                                            6 -> Horse */
        try(Count count = new Count()){
            switch (type) {
                case "1":
                    pets.addNewPetAnimal(new Dogs(name, birth));
                    break;
                case "2":
                    pets.addNewPetAnimal(new Cats(name, birth));
                    break;
                case "3":
                    pets.addNewPetAnimal(new Hamsters(name, birth));
                    break;
                case "4":
                    packAnimals.addNewPackAnimal(new Camels(name, birth));
                    break;
                case "5":
                    packAnimals.addNewPackAnimal(new Donkeys(name, birth));
                    break;
                case "6":
                    packAnimals.addNewPackAnimal(new Horse(name, birth));
                    break;
                default: {
                    System.out.println();
                    System.out.println(type + " - Такая категория не существует\n");
                    return;
                }
            }
            count.add(name,birth);
            System.out.println();
            System.out.println('\n' + name + " добавлен в ваш питомник!\n" +
                    "Ему присвоен номер -> " + count.getInstanceCount() + '\n');
        }

    }

    public void printAllAnimals() {

        System.out.println("\n----Домашние животные----\n");
        pets.printAll();
        System.out.println("----Вьючные животные----\n");
        packAnimals.printAll();
    }

    public void printCommands(String type, String name) {
        switch (type) {
            case "1": {
                boolean flag = false;
                for (Pets animal : pets.getListAnimal()) {
                    if (animal instanceof Dogs && animal.toString().contains(name)) {
                        Dogs dog = (Dogs) animal;
                        dog.printAllCommands();
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "2": {
                boolean flag = false;
                for (Pets animal : pets.getListAnimal()) {
                    if (animal instanceof Cats && animal.toString().contains(name)) {
                        Cats cat = (Cats) animal;
                        cat.printAllCommands();
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "3": {
                boolean flag = false;
                for (Pets animal : pets.getListAnimal()) {
                    if (animal instanceof Hamsters && animal.toString().contains(name)) {
                        Hamsters hamsters = (Hamsters) animal;
                        hamsters.printAllCommands();
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "4": {
                boolean flag = false;
                for (PackAnimals animal : packAnimals.getListAnimal()) {
                    if (animal instanceof Camels && animal.toString().contains(name)) {
                        Camels camels = (Camels) animal;
                        camels.printAllCommands();
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "5": {
                boolean flag = false;
                for (PackAnimals animal : packAnimals.getListAnimal()) {
                    if (animal instanceof Donkeys && animal.toString().contains(name)) {
                        Donkeys donkeys = (Donkeys) animal;
                        donkeys.printAllCommands();
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "6": {
                boolean flag = false;
                for (PackAnimals animal : packAnimals.getListAnimal()) {
                    if (animal instanceof Horse && animal.toString().contains(name)) {
                        Horse horse = (Horse) animal;
                        horse.printAllCommands();
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }

            default: {
                System.out.println();
                System.out.println(type + " - Такой категории не существует\n");
            }

        }
    }

    public void newComand(String type, String name, String newCommand){
        switch (type) {
            case "1": {
                boolean flag = false;
                for (Pets animal : pets.getListAnimal()) {
                    if (animal instanceof Dogs && animal.toString().contains(name)) {
                        Dogs dog = (Dogs) animal;
                        dog.addCommand(newCommand);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "2": {
                boolean flag = false;
                for (Pets animal : pets.getListAnimal()) {
                    if (animal instanceof Cats && animal.toString().contains(name)) {
                        Cats cat = (Cats) animal;
                        cat.addCommand(newCommand);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "3": {
                boolean flag = false;
                for (Pets animal : pets.getListAnimal()) {
                    if (animal instanceof Hamsters && animal.toString().contains(name)) {
                        Hamsters hamsters = (Hamsters) animal;
                        hamsters.addCommand(newCommand);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "4": {
                boolean flag = false;
                for (PackAnimals animal : packAnimals.getListAnimal()) {
                    if (animal instanceof Camels && animal.toString().contains(name)) {
                        Camels camels = (Camels) animal;
                        camels.addCommand(newCommand);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "5": {
                boolean flag = false;
                for (PackAnimals animal : packAnimals.getListAnimal()) {
                    if (animal instanceof Donkeys && animal.toString().contains(name)) {
                        Donkeys donkeys = (Donkeys) animal;
                        donkeys.addCommand(newCommand);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }
            case "6": {
                boolean flag = false;
                for (PackAnimals animal : packAnimals.getListAnimal()) {
                    if (animal instanceof Horse && animal.toString().contains(name)) {
                        Horse horse = (Horse) animal;
                        horse.addCommand(newCommand);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("\nЖивотное не найдено\n");
                }
                break;
            }

            default: {
                System.out.println();
                System.out.println(type + " - Такой категории не существует\n");
                return;
            }
        }
        System.out.println("\nКоманда " + newCommand + " успешно добавлена\n");
    }
    
}
