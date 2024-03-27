
package com.mycompany.oyun;

import java.util.Random;


public class Zar {
    public int Zar(){
        Random rastgele = new Random();
        int zaryuzu=rastgele.nextInt(6);
        return zaryuzu+1;
    }
}
