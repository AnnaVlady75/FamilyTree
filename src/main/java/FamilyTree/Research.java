package FamilyTree;

import java.io.Serializable;

public class Research implements Serializable {
    public static void getRelation(Human person, Relations relation, FamilyTree myTree) {
        for (Link info : myTree.getLinks()) {
            if (info.getHuman().getName().equals(person.getName())
                    && info.getRelationships() == relation) {
                System.out.println(info);
            }
        }
    }
    public static void getRelation(Relations relation, FamilyTree myTree) {
        for (Link info1 :
                myTree.getLinks()) {
            if (info1.getRelationships() == relation) {
                System.out.println(info1);
            }
        }
    }
    public static void getRelation(Human person, FamilyTree myTree) {
        for (Link info2 :
                myTree.getLinks()) {
            if (info2.getHuman().getName().equals(person.getName())) {
                System.out.println(info2);
            }
        }
    }
}