/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armes;

import Armes.Arme;

/**
 *
 * @author Ammi
 */

    public class Baton extends Arme {
    private int age;
    public Baton(String nom, int niveauAttaque, int age) {
        super(nom, niveauAttaque);
        if(age < 0) age = 0;
        if(age > 100) age = 100;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return getNom() + " (attaque=" + getNiveauAttaque() + ", age=" + age + ")";
    }
    }


