package Animal_Shelter.Model;

import java.util.HashSet;

public class Horse extends PackAnimals {

    private final String type = "Horse";
    private String name;
    private String dateOfBirthday;
    private final HashSet<String> commands = new HashSet<>();

    public Horse(String name, String dateOfBirthday) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    public void printAllCommands(){
        if(!this.commands.isEmpty()){
            System.out.print("\n Животное знает следующие команды: ");
            for (String com:this.commands) {
                System.out.print(com +' ');
            }
            System.out.println();
        }else{
            System.out.println("\nСписок команд пуст\n");
        }
    }

    public String toString() {
        return   "----" + type + "-----" +'\n' +
                "Name:"+ ' ' + name +'\n' +
                "Birthday:"+ ' ' + dateOfBirthday + '\n';
    }

}
