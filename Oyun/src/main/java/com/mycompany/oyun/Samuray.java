/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oyun;

/**
 *
 * @author Kmr
 */
public class Samuray {
    public String ad;
    public int damage;
    public int hp;
    public int armor;
    
    Samuray(String ad,int damage,int hp,int armor){
        this.ad=ad;
        this.damage=damage;
        this.hp=hp;
    }
    
    public String getAd(){
        return ad;
    }
    public void setAd(String ad){
        this.ad=ad;
    }
    
    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    
    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp=hp;
    }
    
    public int getArmor(){
        return armor;
    }
    public void setArmor(int armor){
        this.armor=armor;
    }
}
