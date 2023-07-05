package FamilyTree;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        //сохранение
        String filePath = "src/main/java/FamilyTree/tree.out";

        FindHandler findHandler = new FindHandler();
        FamilyTree tree = testTree();
        System.out.println(tree);

        findHandler.saveInfo(tree,filePath);

        //возврат
//        FindHandler findHandler = new FindHandler();
//        FamilyTree tree = (FamilyTree) findHandler.readInfo("src/main/java/FamilyTree/tree.out");
//        System.out.println(tree);

    }

    static FamilyTree testTree() {
        FamilyTree familyTree = new FamilyTree();

        Human mother = new Human("Anna", LocalDate.of(1973, 2, 21), Gender.Female);
        Human father = new Human("Alex", LocalDate.of(1978, 5, 12), Gender.Male);
        Human son = new Human("Kirill", LocalDate.of(1992, 12, 11), Gender.Male);
        Human daughter = new Human("Veronika", LocalDate.of(2000, 3, 30), Gender.Female);
        Human granddad = new Human("Vladimir", LocalDate.of(1955, 5, 12), Gender.Male);
        Human grandma = new Human("Ludmila", LocalDate.of(1957, 8, 25), Gender.Female);

        familyTree.addLink(father, mother, Relations.Husband, Relations.Wife);
        familyTree.addLink(father, son, Relations.Father, Relations.Son);
        familyTree.addLink(father, daughter, Relations.Father, Relations.Daughter);
        familyTree.addLink(mother, son, Relations.Mother, Relations.Son);
        familyTree.addLink(mother, daughter, Relations.Mother, Relations.Daughter);

        familyTree.addLink(granddad, son, Relations.Granddad, Relations.Grandson);
        familyTree.addLink(grandma, son, Relations.Grandma, Relations.Grandson);
        familyTree.addLink(granddad, daughter, Relations.Granddad, Relations.Granddaughter);
        familyTree.addLink(grandma, daughter, Relations.Grandma, Relations.Granddaughter);

        familyTree.addLink(grandma, mother, Relations.Mother, Relations.Daughter);
        familyTree.addLink(granddad, mother, Relations.Father, Relations.Daughter);
        familyTree.addLink(son, daughter, Relations.Brother, Relations.Sister);
//        System.out.println(" \n");
//        Research.getRelation(son, familyTree);
        return familyTree;
    }
}




