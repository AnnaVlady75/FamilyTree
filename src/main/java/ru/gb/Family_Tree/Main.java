package ru.gb.Family_Tree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human mother = new Human("Anna",41,Gender.Female);
        Human father = new Human("Alex",42,Gender.Male);
        Human son = new Human("Kirill",12,Gender.Male);
        Human daughter = new Human("Veronika",3,Gender.Female);
        Human granddad = new Human("Vladimir",77,Gender.Male);
        Human grandma = new Human("Ludmila",75,Gender.Female);

        familyTree.addLink(father,mother,Relations.Husband,Relations.Wife);
        familyTree.addLink(father,son,Relations.Father,Relations.Son);
        familyTree.addLink(father,daughter,Relations.Father,Relations.Daughter);
        familyTree.addLink(mother,son,Relations.Mother,Relations.Son);
        familyTree.addLink(mother,daughter,Relations.Mother,Relations.Daughter);

        familyTree.addLink(granddad,son,Relations.Granddad,Relations.Grandson);
        familyTree.addLink(grandma,son,Relations.Grandma,Relations.Grandson);
        familyTree.addLink(granddad,daughter,Relations.Granddad,Relations.Granddaughter);
        familyTree.addLink(grandma,daughter,Relations.Grandma,Relations.Granddaughter);

        familyTree.addLink(grandma,mother,Relations.Mother,Relations.Daughter);
        familyTree.addLink(granddad,mother,Relations.Father,Relations.Daughter);
        familyTree.addLink(son,daughter,Relations.Brother,Relations.Sister);

        System.out.println(" \n");
        Research.getRelation(son,familyTree);

//        File myFile = new File("text.txt");
//        try {
//            BufferedWriter writer = new BufferedWriter(myFile,true);
//            String lineSeparator = System.getProperty("line.separator");
//            writer.write("For example"+lineSeparator);
//            writer.flush();
//            writer.close();
//        }   catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
