
package com.mycompany.oyun;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;


public class SavasAlani2 {
    public String samurayad;
    public int samurayhp;
    public int samuraydmg;
    public int samurayarmor;
    public int canavarhp;
    public int canavardmg;
    
    SavasAlani2(String samurayad,int samurayhp,int samuraydmg,int samurayarmor,int canavarhp,int canavardmg){
        this.samurayad=samurayad;
        this.samurayhp=samurayhp;
        this.samuraydmg=samuraydmg;
        this.samurayarmor=samurayarmor;
        this.canavarhp=canavarhp;
        this.canavardmg=canavardmg;
    }
    
    public int savas(){
        int canavarhptemp=canavarhp;
        int a=JOptionPane.showConfirmDialog(null, samurayad+" yürürken karşısına bir canavar çıktı!!"
                + "\nSaldıracak mısın?", "Karar Anı", YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION){
            while(canavarhp>0 && samurayhp>0){
                JOptionPane.showMessageDialog(null, "SALDIR!");
                canavarhp-=samuraydmg;
                if(canavarhp<0){
                samurayhp+=(canavarhptemp/10)*3;
            }else if(canavarhp>0){
                samurayhp-=(canavardmg-samurayarmor);
                JOptionPane.showMessageDialog(null, "Sen de canavar da hamlenizi yaptınız\n"+samurayad+" canı: "+samurayhp+"\nCanavarın canı: "+canavarhp);
            }if(samurayhp<0){
                samurayhp=0;
            }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Bir korkak gibi savaşan kaçtın!"
                    + "\nSamuraylığın şanına leke sürme...");
            samurayhp-=250;
        }
        return samurayhp;
    }
}

