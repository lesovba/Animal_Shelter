package Animal_Shelter.Model;

import java.util.HashSet;

public class Hamsters extends Pets{

    private final String type = "Hamster";
    private String name;
    private String dateOfBirthday;
    private final HashSet<String> commands = new HashSet<>();
    //endregion

    public Hamsters(String name, String dateOfBirthday) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
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

    @Override
    public String toString() {
        return   "----" + type + "-----" +'\n' +
                "Name:"+ ' ' + name +'\n' +
                "Birthday:"+ ' ' + dateOfBirthday + '\n';
    }

}