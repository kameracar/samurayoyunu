package com.mycompany.oyun;
import java.util.Random;

public class Buyucu {
    public int Niyet(){
        Random rastgele = new Random();
        int niyet=rastgele.nextInt(2);
        return niyet;
    }
}
