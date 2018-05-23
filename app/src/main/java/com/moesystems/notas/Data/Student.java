package com.moesystems.notas.Data;

public class Student {

    private String name;
    private String carne;
    private String nota;

    public Student() {
    }

    public Student(String name, String carne, String nota) {
        this.name = name;
        this.carne = carne;
        this.nota = nota;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }
}
