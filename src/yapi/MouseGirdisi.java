/* 
 * Copyright (c) 2018, Kayra Urfalı
 * 
 * 
 * 
 * 
 * 
 * 
 */
package yapi;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import pencere.Main;
import nesneler.Kare;

/**
 *
 * @author kayra
 */
public class MouseGirdisi extends MouseAdapter{
    
    Isleyici isleyici;
    
    private Kare tiklanan, istenen;
    OyunNesnesi tas = null;
    int i = 0;
    boolean sil = false;
    int tiklananX, tiklananY;
    private ID id;
    private boolean renk;
    
    public MouseGirdisi(Isleyici isleyici){
        this.isleyici = isleyici;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        for (int i = 0; i < Main.kare.length; i++) {
            for (int j = 0; j < Main.kare[0].length; j++) {
                Kare k = Main.kare[i][j];
                sil = false;
                if (k.n != null && k.sinirlar().contains(e.getX(), e.getY()) && k.renk != Color.cyan) {
                    if(k.n.id == ID.At){
                        tiklanan = k;
                        tas = k.n;
                        id = tas.id;
                        renk = k.n.renk;
                        k.setRenk(Color.cyan);
                        tiklananX = j;
                        tiklananY = i;
                        sil = k.tasCikar();
                    }
                }
                if(id == ID.At && ((tiklananY-2 == i && tiklananX-1 == j) || (tiklananY-2 == i && tiklananX+1 == j) || (tiklananY-1 == i && tiklananX+2 == j) || (tiklananY-1 == i && tiklananX-2 == j) ||
                                   (tiklananY+1 == i && tiklananX-2 == j) || (tiklananY+1 == i && tiklananX+2 == j) || (tiklananY+2 == i && tiklananX-1 == j) || (tiklananY+2 == i && tiklananX+1 == j))){//hareket                        
                    if (k.n == null && tiklanan != null && tas != null && k.sinirlar().contains(e.getX(), e.getY()) && !sil) {                    
                        k.tasEkle(tas);
                        if(tiklanan.r == 0) tiklanan.setRenk(Color.white);
                        else tiklanan.setRenk(Color.gray);
                        tas = null;
                    }if (k.n != null && tiklanan != null && tas != null && k.sinirlar().contains(e.getX(), e.getY()) && !sil && renk != k.n.renk){
                        System.out.println("renk = " + renk + "k.n.renk = " + k.n.renk);
                        k.tasCikar();
                        k.tasEkle(tas);
                        if(tiklanan.r == 0) tiklanan.setRenk(Color.white);
                        else tiklanan.setRenk(Color.gray);
                        tas = null;
                    }
                }            
            }
        }
    }
}
