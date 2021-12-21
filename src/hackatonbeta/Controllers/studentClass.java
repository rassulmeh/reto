/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackatonbeta.Controllers;

package PkXC.controllers;

import java.util.ArrayList;

/**
 *
 * @author franciscocasdie
 */
public class studentClass {
    //1 atributos

    private int id;
    private String name;
    private String surname;
    private int age;
    private String course;
    

    //2
    public studentClass() {
        this.setId(1);
        this.setName("-");
        this.setSurname("-");
        this.setAge(20);
        this.setCourse("");
    }

    public studentClass(String barCod, String name, String TypeBookClass, String autor, int any) {
        this.setId(1);
        this.setName("-");
        this.setSurname("-");
        this.setAge(20);
        this.setCourse("");
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
    
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
       
    //4
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bar Code: " + getId() + "\r\n");
        sb.append("Author: " + getName() + "\r\n");
        sb.append("Name: " + getSurname() + "\r\n");
        sb.append("Type: " + getAge() + "\r\n");
        sb.append("Year: " + getCourse() + "\r\n");
        return sb.toString();
    }

}
