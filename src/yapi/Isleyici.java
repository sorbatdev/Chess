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

import java.awt.Graphics2D;
import java.util.LinkedList;
import nesneler.Kare;
import pencere.Main;

/**
 *
 * @author kayra
 */
public class Isleyici {
    
    public LinkedList<OyunNesnesi> nesneler = new LinkedList<>();
    
    private OyunNesnesi geciciNesne;
    
    public void guncelle(){
        for(int i = 0; i < nesneler.size(); i++){
            geciciNesne = nesneler.get(i);
            
            geciciNesne.guncelle(nesneler);
        }
    }
    
    public void ciz(Graphics2D g){
        
        for(Kare[] k: Main.kare){
            for(Kare kare: k){
                kare.ciz(g);
            }
        }
        
        for(int i = 0; i < nesneler.size(); i++){
            geciciNesne = nesneler.get(i);
            geciciNesne.ciz(g);
            //System.out.println("geciciNesne = " + geciciNesne);
        }
    }
    
    public void nesneEkle(OyunNesnesi nesne){
        nesneler.add(nesne);
    }
    
    public void nesneSil(OyunNesnesi nesne){
        nesneler.remove(nesne);
    }
    
}
