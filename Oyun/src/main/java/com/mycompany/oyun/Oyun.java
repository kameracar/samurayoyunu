package com.mycompany.oyun;

import static java.lang.Math.random;
import javax.swing.JOptionPane;
import java.util.Random;
import static javax.swing.JOptionPane.YES_NO_OPTION;


public class Oyun {

    
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "OYUNUMUZA HOŞ GELDİNİZ"
                + "\n------------------------------------"
                + "\n-Oyunumuzda size ait 3 samuray bulunmakta. Biri ölmeden diğerine GEÇEMEZSİNİZ. Amacınız en az bir samurayınız hayattayken ormandan sağ çıkabilmek."
                + "\n-Ormanda sayısı belirsiz canavarlar, köpekler, büyücüler ve 3 ejderha bulunmaktadır."
                + "\n-Attığınız her zarda çıkan sayı kadar adım ilerlersiniz. Bulunduğunuz adımda, bir önceki ve bir sonraki adımlarda olmayanlarla karşılaşmazsınız."
                + "\n-Her 50 adımda bir aşama geçersiniz ve her aşama sonunda o aşamanın ejderhasıyla karşılaşırsınız."
                + "\n-Karşınıza gelen canavarlarla savaşmak istemezseniz karşınızdaki canavarın canının %10 kadarı canınızdan eksilecektir."
                + "\n-Canavar kestiğinizde canavarın canının %30'unu sömürerek kendi canına katarsın."
                + "\n-Ejderha kestiğinizde aşama geçtiğiniz için can artışı, hasar artışı ve zırh kazanırsınız."
                + "\nKesemez ve 3 samurayınızı kaybederseniz ormandan çıkmadan ruhları için birer tütsü yakmayı unutmayın!"
                + "\n-Karşınıza çıkan köpekler size zarar veremez... Ama siz o köpeklere kıyar da öldürürseniz köpeğin canının tamamını kazanırsınız."
                + "\n-Rastgele konumlanmış büyücüler var. Büyücüler bazen iyi bazen kötü niyetlidir."
                + "\nİyi niyetliyse ölmüş bir samurayınız varsa onu canlandırır. Kötü niyetliye denk gelirseniz savaşmakta olduğunuz samurayınıza veda edersiniz."
                + "\n--------------------------------------"
                + "\nHAYATTA KALMA KONUSUNDA BAŞARILAR...");
        
        String isim1=JOptionPane.showInputDialog("Lütfen birinci samurayınızın ismini giriniz:");
        String isim2=JOptionPane.showInputDialog("Lütfen ikinci samurayınızın ismini giriniz:");
        String isim3=JOptionPane.showInputDialog("Lütfen üçüncü samurayınızın ismini giriniz:");
        Samuray s1 =new Samuray("samuray1",75,750,0);
        s1.setAd(isim1);
        Samuray s2 =new Samuray("samuray2",75,750,0);
        s2.setAd(isim2);
        Samuray s3 =new Samuray("samuray3",75,750,0);
        s3.setAd(isim3);
        JOptionPane.showMessageDialog(null,"Samuray isimlerinizi sırasıyla "+isim1+" "+isim2+" "+isim3+" olarak seçtiniz.");
        Zar Z1=new Zar();
        int sayac,i,kontrol = 0;
        int adim=0;
        int samuraysayisi=3;
        Canavar c1=new Canavar(30,500);
        Canavar c2=new Canavar(40,750);
        Canavar c3=new Canavar(50,950);
        Ejderha e1=new Ejderha(80,1400);
        Ejderha e2=new Ejderha(85,2500);
        Ejderha e3=new Ejderha(105,4000);
        Kopek k1=new Kopek(150);
        Kopek k2=new Kopek(200);
        Kopek k3=new Kopek(250);
        Buyucu buyucu=new Buyucu();
        int[] kopek1konum=new int[6];
        int[] canavar1konum=new int[6];
        int[] kopek2konum=new int[6];
        int[] canavar2konum=new int[6];
        int[] buyucukonum=new int[4];
        int[] kopek3konum=new int[6];
        int[] canavar3konum=new int[6];
        Random rastgele = new Random();
        
        //ilk 50 adim icin
        for(sayac=0;sayac<kopek1konum.length;sayac++){
            int sayi=rastgele.nextInt(50)+1;
            kopek1konum[sayac]=sayi;
        }
        
        for(sayac=0;sayac<canavar1konum.length;sayac++){
            int sayi=rastgele.nextInt(50)+1;
            canavar1konum[sayac]=sayi;
        }
        
        for(sayac=0;sayac<kopek2konum.length;sayac++){
            int sayi=rastgele.nextInt(50)+51;
            kopek2konum[sayac]=sayi;
        }
        
        for(sayac=0;sayac<canavar2konum.length;sayac++){
            int sayi=rastgele.nextInt(50)+51;
            canavar2konum[sayac]=sayi;
        }
        
        for(sayac=0;sayac<kopek3konum.length;sayac++){
            int sayi=rastgele.nextInt(50)+101;
            kopek3konum[sayac]=sayi;
        }
        
        for(sayac=0;sayac<canavar3konum.length;sayac++){
            int sayi=rastgele.nextInt(50)+101;
            canavar3konum[sayac]=sayi;
        }
        
        for(sayac=0;sayac<buyucukonum.length;sayac++){
            int sayi=rastgele.nextInt(150)+1;
            buyucukonum[sayac]=sayi;
        }
        
        
        while(adim<=50){
            if(samuraysayisi>0){
                JOptionPane.showMessageDialog(null,"Kalan samuraylar: "+samuraysayisi+"\nCan: "+s1.getHp()+"\nAdım: "+adim+"\nLütfen zar atınız.");
                adim+=Z1.Zar();
                kontrol=0;
                for(i=0;i<kopek1konum.length;i++){
                    if(adim==kopek1konum[i]-1 || adim==kopek1konum[i] || adim==kopek1konum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    String samurayad=s1.getAd();
                    int samurayhp=s1.getHp();
                    int samuraydmg=s1.getDamage();
                    int kopekhp=k1.getHp();
                    SavasAlani1 svs1=new SavasAlani1(samurayad,samurayhp,samuraydmg,kopekhp);
                    s1.setHp(svs1.savas());
                }else{
                    continue;
                }
                
                kontrol=0;
                for(i=0;i<canavar1konum.length;i++){
                    if(adim==canavar1konum[i]-1 || adim==canavar1konum[i] || adim==canavar1konum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    String samurayad=s1.getAd();
                    int samurayhp=s1.getHp();
                    int samuraydmg=s1.getDamage();
                    int samurayarmor=s1.getArmor();
                    int canavarhp=c1.getHp();
                    int canavardmg=c1.getDamage();
                    SavasAlani2 svs2=new SavasAlani2(samurayad,samurayhp,samuraydmg,samurayarmor,canavarhp,canavardmg);
                    int donen=svs2.savas();
                    if(donen<=0){
                        JOptionPane.showMessageDialog(null, samurayad+" öldü. Kendisine ruhlar aleminde başarılar.");
                        samuraysayisi--;
                        s1.setAd(s2.getAd());
                        s1.setHp(s2.getHp());
                        s1.setDamage(s2.getDamage());
                        s1.setArmor(s2.getArmor());
                        s2.setAd(s3.getAd());
                        s2.setHp(s3.getHp());
                        s2.setDamage(s3.getDamage());
                        s2.setArmor(s3.getArmor());
                    }else{
                        s1.setHp(donen);
                    }
                }
                kontrol=0;
                for(i=0;i<buyucukonum.length;i++){
                    if(adim==buyucukonum[i]-1||adim==buyucukonum[i]||adim==buyucukonum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    int a=JOptionPane.showConfirmDialog(null, s1.getAd()+" yürürken karşısına büyücü çıktı!"
                            + "\nAnlaşma riskine girecek misin?", "Karar Anı", YES_NO_OPTION);
                    if(a==JOptionPane.YES_OPTION){
                        if(buyucu.Niyet()==0){
                            JOptionPane.showMessageDialog(null, s1.getAd()+" öldü. Kendisine ruhlar aleminde başarılar.");
                            samuraysayisi--;
                            s1.setAd(s2.getAd());
                            s1.setHp(s2.getHp());
                            s1.setDamage(s2.getDamage());
                            s1.setArmor(s2.getArmor());
                            s2.setAd(s3.getAd());
                            s2.setHp(s3.getHp());
                            s2.setDamage(s3.getDamage());
                            s2.setArmor(s3.getArmor());
                        }else{
                        if(samuraysayisi==2){
                            samuraysayisi++;
                            s1.setAd(isim1);
                            s2.setAd(isim2);
                            s3.setAd(isim3);
                            s3.setHp(s2.getHp());
                            s3.setDamage(s2.getDamage());
                            s3.setArmor(s2.getArmor());
                        }else if(samuraysayisi==1){
                            samuraysayisi++;
                            s1.setAd(isim1);
                            s2.setAd(isim2);
                            s2.setHp(750);
                            s2.setDamage(50);
                            s2.setArmor(0);
                        }
                    }
                    }
                }else{
                    continue;
                }
                
                  
            }else{
            JOptionPane.showMessageDialog(null,"3 KAHRAMANI DA KAYBETTİNİZ... OYUNU DA...");
            adim=151;
            }
            
            
                }
                if(samuraysayisi>0){
                JOptionPane.showMessageDialog(null,"Birinci aşamayı geçtin. Tebrikler samuray.");
                JOptionPane.showMessageDialog(null,"Sırada ilk aşamanın ejderhası var. Kılıcın keskin olsun!");
                int samuraycan=s1.getHp();
                int ejdercan=e1.getHp();
                int samurayhasar=s1.getDamage();
                int ejderhasar=e1.getDamage();
                while(samuraycan>0 && ejdercan>0){
                    JOptionPane.showMessageDialog(null, "SALDIR!");
                    ejdercan-=samurayhasar;
                    samuraycan-=ejderhasar;
                    JOptionPane.showMessageDialog(null, s1.getAd()+" canı: "+samuraycan+"\nEjderhanın canı: "+ejdercan);
                }if(samuraycan<=0){
                    samuraysayisi--;
                            if(samuraysayisi==0){
                                JOptionPane.showMessageDialog(null,"Oyunu kaybetttin.\nZaten güven vermemiştin.");
                            }else{
                                JOptionPane.showMessageDialog(null,"Karakterin ejderhaya yem oldu.\nAl bi sıcak çorba iç.");
                                s1.setAd(s2.getAd());
                                s1.setHp(s2.getHp());
                                s1.setDamage(s2.getDamage());
                                s1.setArmor(s2.getArmor());
                                s2.setAd(s3.getAd());
                                s2.setHp(s3.getHp());
                                s2.setDamage(s3.getDamage());
                                s2.setArmor(s3.getArmor());
                            }
                }else{
                    JOptionPane.showMessageDialog(null,"İlk ejderhanı kestin.\nSanırım gerçekten samuray oluyorsun...");
                    }

                }
        
            s1.setArmor(20);
            s1.setHp(s1.getHp()+1200);
            s1.setDamage(95);
            s2.setArmor(20);
            s2.setHp(s2.getHp()+1200);
            s2.setDamage(95);
            s3.setArmor(20);
            s3.setHp(s3.getHp()+1200);
            s3.setDamage(95);
            
        while(adim<=100){
            
            if(samuraysayisi>0){
                JOptionPane.showMessageDialog(null,"Kalan samuraylar: "+samuraysayisi+"\nCan: "+s1.getHp()+"\nAdım: "+adim+"\nLütfen zar atınız.");
                adim+=Z1.Zar();
                
                kontrol=0;
                for(i=0;i<kopek2konum.length;i++){
                    if(adim==kopek2konum[i]-1 || adim==kopek2konum[i] || adim==kopek2konum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    String samurayad=s1.getAd();
                    int samurayhp=s1.getHp();
                    int samuraydmg=s1.getDamage();
                    int kopekhp=k2.getHp();
                    SavasAlani1 svs1=new SavasAlani1(samurayad,samurayhp,samuraydmg,kopekhp);
                    s1.setHp(svs1.savas());
                }
                
                kontrol=0;
                for(i=0;i<canavar2konum.length;i++){
                    if(adim==canavar2konum[i]-1 || adim==canavar2konum[i] || adim==canavar2konum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    String samurayad=s1.getAd();
                    int samurayhp=s1.getHp();
                    int samuraydmg=s1.getDamage();
                    int samurayarmor=s1.getArmor();
                    int canavarhp=c2.getHp();
                    int canavardmg=c2.getDamage();
                    SavasAlani2 svs2=new SavasAlani2(samurayad,samurayhp,samuraydmg,samurayarmor,canavarhp,canavardmg);
                    int donen=svs2.savas();
                    if(donen<=0){
                        JOptionPane.showMessageDialog(null, samurayad+" öldü. Kendisine ruhlar aleminde başarılar.");
                        samuraysayisi--;
                        s1.setAd(s2.getAd());
                        s1.setHp(s2.getHp());
                        s1.setDamage(s2.getDamage());
                        s1.setArmor(s2.getArmor());
                        s2.setAd(s3.getAd());
                        s2.setHp(s3.getHp());
                        s2.setDamage(s3.getDamage());
                        s2.setArmor(s3.getArmor());
                    }else{
                        s1.setHp(svs2.savas());
                    }
                }
                kontrol=0;
                for(i=0;i<buyucukonum.length;i++){
                    if(adim==buyucukonum[i]-1||adim==buyucukonum[i]||adim==buyucukonum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    int a=JOptionPane.showConfirmDialog(null, s1.getAd()+" yürürken karşısına büyücü çıktı!"
                            + "\nAnlaşma riskine girecek misin?", "Karar Anı", YES_NO_OPTION);
                    if(a==JOptionPane.YES_OPTION){
                        if(buyucu.Niyet()==0){
                            JOptionPane.showMessageDialog(null, s1.getAd()+" öldü. Kendisine ruhlar aleminde başarılar.");
                            samuraysayisi--;
                            s1.setAd(s2.getAd());
                            s1.setHp(s2.getHp());
                            s1.setDamage(s2.getDamage());
                            s1.setArmor(s2.getArmor());
                            s2.setAd(s3.getAd());
                            s2.setHp(s3.getHp());
                            s2.setDamage(s3.getDamage());
                            s2.setArmor(s3.getArmor());
                        }else{
                        if(samuraysayisi==2){
                            samuraysayisi++;
                            s1.setAd(isim1);
                            s2.setAd(isim2);
                            s3.setAd(isim3);
                            s3.setHp(s2.getHp());
                            s3.setDamage(s2.getDamage());
                            s3.setArmor(s2.getArmor());
                        }else if(samuraysayisi==1){
                            samuraysayisi++;
                            s1.setAd(isim1);
                            s2.setAd(isim2);
                            s2.setHp(1200);
                            s2.setDamage(95);
                            s2.setArmor(0);
                        }
                    }
                    }
                }
                
            }else{
            JOptionPane.showMessageDialog(null,"3 KAHRAMANI DA KAYBETTİNİZ... OYUNU DA...");
            adim=151;
            }
    }
        
                        if(samuraysayisi>0){
                JOptionPane.showMessageDialog(null,"İkinci aşamayı geçtin. Tebrikler samuray.");
                JOptionPane.showMessageDialog(null,"Sırada ikinci aşamanın ejderhası var. Kılıcın keskin olsun!");
                int samuraycan=s1.getHp();
                int ejdercan=e2.getHp();
                int samurayhasar=s1.getDamage();
                int ejderhasar=e2.getDamage();
                int samurayzirh=s1.getArmor();
                while(samuraycan>0 && ejdercan>0){
                    JOptionPane.showMessageDialog(null, "SALDIR!");
                    ejdercan-=samurayhasar;
                    samuraycan-=(ejderhasar-samurayzirh);
                    JOptionPane.showMessageDialog(null, s1.getAd()+" canı: "+samuraycan+"\nEjderhanın canı: "+ejdercan);
                }if(samuraycan<=0){
                    JOptionPane.showMessageDialog(null,"Karakterin ejderhaya yem oldu.\nAl bi sıcak çorba iç.");
                    samuraysayisi--;
                            if(samuraysayisi==0){
                                JOptionPane.showMessageDialog(null,"Oyunu kaybetttin.\nZaten güven vermemiştin.");
                            }else{
                                s1.setAd(s2.getAd());
                                s1.setHp(s2.getHp());
                                s1.setDamage(s2.getDamage());
                                s1.setArmor(s2.getArmor());
                                s2.setAd(s3.getAd());
                                s2.setHp(s3.getHp());
                                s2.setDamage(s3.getDamage());
                                s2.setArmor(s3.getArmor());
                            }
                }else{
                    JOptionPane.showMessageDialog(null,"İkinci ejderhanı kestin.\nGözlerimi yaşartıyorsun...");
                    }

                }
        
                
                        
                s1.setArmor(35);
                s1.setHp(s1.getHp()+1000);
                s1.setDamage(130);
                s2.setArmor(35);
                s2.setHp(s2.getHp()+1000);
                s2.setDamage(130);
                s3.setArmor(35);
                s3.setHp(s3.getHp()+1000);
                s3.setDamage(130);
                        
        while(adim<=150){
            
            if(samuraysayisi>0){
                JOptionPane.showMessageDialog(null,"Kalan samuraylar: "+samuraysayisi+"\nCan: "+s1.getHp()+"\nAdım: "+adim+"\nLütfen zar atınız.");
                adim+=Z1.Zar();
                
                kontrol=0;
                for(i=0;i<kopek3konum.length;i++){
                    if(adim==kopek3konum[i]-1 || adim==kopek3konum[i] || adim==kopek3konum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    String samurayad=s1.getAd();
                    int samurayhp=s1.getHp();
                    int samuraydmg=s1.getDamage();
                    int kopekhp=k3.getHp();
                    SavasAlani1 svs1=new SavasAlani1(samurayad,samurayhp,samuraydmg,kopekhp);
                    s1.setHp(svs1.savas());
                }
                
                kontrol=0;
                for(i=0;i<canavar3konum.length;i++){
                    if(adim==canavar3konum[i]-1 || adim==canavar3konum[i] || adim==canavar3konum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    String samurayad=s1.getAd();
                    int samurayhp=s1.getHp();
                    int samuraydmg=s1.getDamage();
                    int samurayarmor=s1.getArmor();
                    int canavarhp=c3.getHp();
                    int canavardmg=c3.getDamage();
                    SavasAlani2 svs2=new SavasAlani2(samurayad,samurayhp,samuraydmg,samurayarmor,canavarhp,canavardmg);
                    int donen=svs2.savas();
                    if(donen<=0){
                        JOptionPane.showMessageDialog(null, samurayad+" öldü. Kendisine ruhlar aleminde başarılar.");
                        samuraysayisi--;
                        s1.setAd(s2.getAd());
                        s1.setHp(s2.getHp());
                        s1.setDamage(s2.getDamage());
                        s1.setArmor(s2.getArmor());
                        s2.setAd(s3.getAd());
                        s2.setHp(s3.getHp());
                        s2.setDamage(s3.getDamage());
                        s2.setArmor(s3.getArmor());
                    }
                }
                kontrol=0;
                for(i=0;i<buyucukonum.length;i++){
                    if(adim==buyucukonum[i]-1||adim==buyucukonum[i]||adim==buyucukonum[i]+1){
                        kontrol++;
                    }
                }if(kontrol!=0){
                    int a=JOptionPane.showConfirmDialog(null, s1.getAd()+" yürürken karşısına büyücü çıktı!"
                            + "\nAnlaşma riskine girecek misin?", "Karar Anı", YES_NO_OPTION);
                    if(a==JOptionPane.YES_OPTION){
                        if(buyucu.Niyet()==0){
                            JOptionPane.showMessageDialog(null, s1.getAd()+" öldü. Kendisine ruhlar aleminde başarılar.");
                            samuraysayisi--;
                            s1.setAd(s2.getAd());
                            s1.setHp(s2.getHp());
                            s1.setDamage(s2.getDamage());
                            s1.setArmor(s2.getArmor());
                            s2.setAd(s3.getAd());
                            s2.setHp(s3.getHp());
                            s2.setDamage(s3.getDamage());
                            s2.setArmor(s3.getArmor());
                        }else{
                        if(samuraysayisi==2){
                            samuraysayisi++;
                            s1.setAd(isim1);
                            s2.setAd(isim2);
                            s3.setAd(isim3);
                            s3.setHp(s2.getHp());
                            s3.setDamage(s2.getDamage());
                            s3.setArmor(s2.getArmor());
                        }else if(samuraysayisi==1){
                            samuraysayisi++;
                            s1.setAd(isim1);
                            s2.setAd(isim2);
                            s2.setHp(2000);
                            s2.setDamage(35);
                            s2.setArmor(0);
                        }
                    }
                    }
                }
                
            }else{
            JOptionPane.showMessageDialog(null,"3 KAHRAMANI DA KAYBETTİNİZ... OYUNU DA...");
            adim=151;
            }
    }
        if(samuraysayisi>0){
                JOptionPane.showMessageDialog(null,"Son aşamayı geçtin. Tebrikler samuray.");
                JOptionPane.showMessageDialog(null,"Sırada son ejderha var. Gerçek bir samuray olduğunu göster!");
                int samuraycan=s1.getHp();
                int ejdercan=e3.getHp();
                int samurayhasar=s1.getDamage();
                int ejderhasar=e3.getDamage();
                while(samuraycan>0 && ejdercan>0){
                    JOptionPane.showMessageDialog(null, "SALDIR!");
                    ejdercan-=samurayhasar;
                    samuraycan-=ejderhasar;
                    JOptionPane.showMessageDialog(null, s1.getAd()+" canı: "+samuraycan+"\nEjderhanın canı: "+ejdercan);
                }if(samuraycan<=0){
                    JOptionPane.showMessageDialog(null,"Karakterin ejderhaya yem oldu.\nAl bi sıcak çorba iç.");
                    samuraysayisi--;
                            if(samuraysayisi==0){
                                JOptionPane.showMessageDialog(null,"Oyunu kaybetttin.\nZaten güven vermemiştin.");
                            
                            }else{
                                s1.setAd(s2.getAd());
                                s1.setHp(s2.getHp());
                                s1.setDamage(s2.getDamage());
                                s1.setArmor(s2.getArmor());
                                s2.setAd(s3.getAd());
                                s2.setHp(s3.getHp());
                                s2.setDamage(s3.getDamage());
                                s2.setArmor(s3.getArmor());
                            }
                }else{
                    JOptionPane.showMessageDialog(null,"İşte gerçek samuray.\nKendini kanıtlayıp oyunu kazandın !!!");
                    }

                }
        
}
}
