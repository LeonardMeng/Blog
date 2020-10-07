package org.mengsoft.webbackend.model;

import java.util.List;

public class MenuItem {
    private Integer id;
    private String path;
    private String title;
    private String father;
    private String level;
    private List<MenuItem> menuItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem(Integer id, String path, String title, String father, String level) {
        this.id = id;
        this.path = path;
        this.title = title;
        this.father = father;
        this.level = level;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", father='" + father + '\'' +
                ", level='" + level + '\'' +
                ", menuItems=" + menuItems +
                '}';
    }
}
