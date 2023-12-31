package FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {
    private String name;
    private LocalDate birthDay;
    private Gender gender;

    public Human(String name, LocalDate birthDay, Gender gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Gender getGender() {
        return gender;
    }
    @Override
    public String toString() {
        return String.format("%s %s %s", name, birthDay , gender);
    }

}
