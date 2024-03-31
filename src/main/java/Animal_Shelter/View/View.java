package Animal_Shelter.View;

import Animal_Shelter.Controller.*;

import java.util.Scanner;


public class View {

    private final Scanner scanner = new Scanner(System.in);
    private final Controller controller = new Controller();

    public View() {
    }

    private String inputName(){
        System.out.print("\nВведите имя животного: ");
        String value = scanner.nextLine();
        return value;
    }

    private String inputDateOfBirth() {
        System.out.print("\nВведите дату рождения животного: ");
        String value = scanner.nextLine();
        return value;
    }

    private String inputNewCommands(){
        boolean flag = true;
        while (flag) {
            System.out.print("\nВведите новую команду для животного: ");
            String value = scanner.nextLine();
            if (value.isEmpty()) {
                System.out.println("\nВы ничего не ввели\n");
            } else {
                flag = false;
                return value;
            }
        }
        return null;
    }

    private String choosingAnimal(){
        System.out.println("\nВыберите категорию животного из доступных!\n");
        System.out.print("Ваш выбор -> ");
        return scanner.nextLine();
    }

    public void start(){
        boolean flag = true;
        String menu = "\n       ---MENU---\n\n" +                  // Меню
                "1 -> Добавить животного\n" +
                "2 -> Смотреть список всех животных\n" +
                "3 -> Смотреть список команд животного\n" +
                "4 -> Обучить животного новой команде\n" +
                "5 -> Выход\n\n" +
                "Ваш выбор -> ";

        String listAnimals = "\n---Доступные категории---\n\n" +
                "1 -> Dog\n" +
                "2 -> Cat\n" +
                "3 -> Hamster\n" +
                "4 -> Camel\n" +
                "5 -> Donkey\n" +
                "6 -> Horse\n" +
                "7 -> Exit\n\n";

        while (flag) {                                   // Обработка команд меню
            System.out.print(menu);
            String input = scanner.nextLine();
            switch (input){
                case "1":{
                    System.out.println(listAnimals);
                    String result = choosingAnimal();
                    boolean flagIn = result.equals("7");
                    if(flagIn) break;
                    else {
                        try {
                            controller.addAnimals(result,inputName(),inputDateOfBirth());
                        } catch (Exception e) {
                            System.out.println("\nКличка и дата рождения не могут быть пустыми\n");
                        }
                    }
                    break;
                }
                case "2":{
                    controller.printAllAnimals();
                    break;
                }
                case "3":{
                    System.out.println(listAnimals);
                    String result = choosingAnimal();
                    boolean flagIn = result.equals("7");
                    if(flagIn) break;
                    else {
                        controller.printCommands(result,inputName());
                    }
                    break;
                }
                case "4":{
                    System.out.println(listAnimals);
                    String result = choosingAnimal();
                    boolean flagIn = result.equals("7");
                    if(flagIn) break;
                    else {
                        controller.newComand(result,inputName(),inputNewCommands());
                    }
                    break;
                }
                case "5":{
                    flag = false;
                    break;
                }
                default:{
                    System.out.println("\nНекорректно введен номер пункта\n");
                }
            }
        }
    }

}
