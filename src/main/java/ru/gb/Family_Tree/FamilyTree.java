package ru.gb.Family_Tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Link> connections = new ArrayList<>();

    public List<Link> getLinks() {
        return connections;
    }

    public void setLinks(List<Link> links) {
        this.connections.addAll(links);
    }
    public void addLink(Human human1, Human human2, Relations con1, Relations con2) {
        this.connections.add(new Link(human1, human2, con1));
        this.connections.add(new Link(human2, human1, con2));
    }
    @Override
    public String toString() {
        String result = new String();
        for (Link data : connections) {
            result += data + "\n";
        }
        return result;
    }
}

