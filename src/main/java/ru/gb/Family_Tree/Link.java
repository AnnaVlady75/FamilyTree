package ru.gb.Family_Tree;

public class Link {
    private Human hum1;
    private Human hum2;
    private Relations relationships;

    public Link(Human person1, Human person2, Relations relation) {
        this.hum1 = person1;
        this.hum2 = person2;
        this.relationships = relation;
    }
    public Human getPeople() {
        return this.hum1;
    }
    public Human getRelationPeople() {
        return this.hum2;
    }
    public Relations getRelationships() {
        return relationships;
    }
    @Override
    public String toString() {
        return new String(hum1 +
                " " + "for  " + hum2 + " " +
                "is " + relationships);
    }
}