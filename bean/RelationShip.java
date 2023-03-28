package edu.imu.display.bean;

import java.util.ArrayList;

public class RelationShip {
    private ArrayList<Category> categories;
    private String type = "force";
    private ArrayList<Node> nodes;
    private ArrayList<Link> links;
    private ArrayList<String> legends;

    public ArrayList<String> getLegends() {
        return legends;
    }

    public void setLegends(ArrayList<String> legends) {
        this.legends = legends;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Link> links) {
        this.links = links;
    }
}
