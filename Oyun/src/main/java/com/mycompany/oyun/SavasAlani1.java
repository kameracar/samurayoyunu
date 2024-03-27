
package com.mycompany.oyun;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;


public class SavasAlani1 {
    public String samurayad;
    public int samurayhp;
    public int samuraydmg;
    public int kopekhp;
    SavasAlani1(String samurayad,int samurayhp,int samuraydmg,int kopekhp){
        this.samurayad=samurayad;
        this.samurayhp=samurayhp;
        this.samuraydmg=samuraydmg;
        this.kopekhp=kopekhp;
    }
    
    public int savas(){
        int kopekhptemp=kopekhp;
        int a=JOptionPane.showConfirmDialog(null, samurayad+" yürürken karşısına çok sevimli bir köpek çıktı!"
                + "\nSaldıracak mısın?", "Karar Anı", YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION){
            while(kopekhp>0){
                JOptionPane.showMessageDialog(null, "SALDIR!");
                kopekhp-=samuraydmg;
                if(kopekhp<=0){
                    samurayhp+=kopekhptemp;
                }else{
                JOptionPane.showMessageDialog(null, samurayad+" canı: "+samurayhp+"\nKöpeğin canı: "+kopekhp);
            }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Eforsuz can kazanma hakkını kaçırdın!"
                    + "\nUmarım köpeği kurtarmana değmiştir...");
        }return samurayhp;
    }
}
