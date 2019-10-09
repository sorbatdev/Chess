/* 
 * Copyright (c) 2018, Kayra Urfalı
 * 
 * 
 * 
 * 
 * 
 * 
 */
package kaplama;

import java.awt.image.BufferedImage;
import yapi.ResimYukleyici;
import yapi.SheetYukleyici;
/**
 *
 * @author kayra
 */
@SuppressWarnings("FieldMayBeFinal")
public class Kaplamalar {
    SheetYukleyici beyaz, siyah;
    ResimYukleyici yukleyici = new ResimYukleyici();
    
    public BufferedImage[][] taslar = new BufferedImage[2][6];
    
    private BufferedImage taslarB, taslarS; 
    //public BufferedImage tahta;
    
    public Kaplamalar() {
        //tahta = yukleyici.yukle("/res/tahta.png");
        taslarB = yukleyici.yukle("/res/beyaz.png");
        taslarS = yukleyici.yukle("/res/siyah.png");
        
        beyaz = new SheetYukleyici(taslarB);
        siyah = new SheetYukleyici(taslarS);
        
        //System.out.println(taslar.length);
        
        dokuGetir();
        
    }
    
    private void dokuGetir(){
        for(int i = 0; i < taslar.length; i++){
            for(int j = 0; j < taslar[0].length; j++){
                if(i == 0) {
                    taslar[0][j] = siyah.resimYakala(j+1, 1, 48, 48);
                }
                if(i == 1) {
                    taslar[1][j] = beyaz.resimYakala(j+1, 1, 48, 48);
                }
            }
        }
    }
}
