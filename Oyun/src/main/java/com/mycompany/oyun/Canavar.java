package com.mycompany.oyun;


public class Canavar {
    public int damage;
    public int hp;
    
    Canavar(int damage,int hp){
        this.hp=hp;
        this.damage=damage;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public int getHp(){
        return hp;
    }
}
