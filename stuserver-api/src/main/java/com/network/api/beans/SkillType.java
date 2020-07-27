package com.network.api.beans;

public class SkillType {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SkillType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
