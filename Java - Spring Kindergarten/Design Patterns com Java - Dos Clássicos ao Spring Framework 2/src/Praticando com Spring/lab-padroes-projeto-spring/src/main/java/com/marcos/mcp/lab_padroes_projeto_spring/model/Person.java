package com.marcos.mcp.lab_padroes_projeto_spring.model;


public class Person {
    private String name;
    private int age;
    private Endereco endereco;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Endereco endereco) {
        this.name = name;
        this.age = age;
        this.endereco = endereco;
    }

    public Person(String name) {
        this.name = name;
    }   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdult(){
        return this.age >= 18;
    }

    public Endereco getEndereco() {
        return endereco;
    }   

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    


    
}
