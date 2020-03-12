package org.cloud.funcDemo;

public class Artist {
    private int id;
    private String name;
    private String from;
    public Artist() {
        // TODO Auto-generated constructor stub
    }
    public Artist(int id, String name, String from) {
        super();
        this.id = id;
        this.name = name;
        this.from = from;
    }
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
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public boolean isFrom(String from) {
        return from.equals(this.from);
    }
}
