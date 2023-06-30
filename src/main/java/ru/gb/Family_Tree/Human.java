package ru.gb.Family_Tree;

public class Human {
    private String name;
    private int age;
    private Gender gender;

    public Human(String name, int age,Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public Gender getGender() {
        return gender;
    }
    @Override
    public String toString() {
        return String.format("%s %s %s", name, age, gender);
    }
}
