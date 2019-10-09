/* 
 * Copyright (c) 2018, Kayra Urfalı
 * 
 * 
 * 
 * 
 * 
 * 
 */
package nesneler;

import java.awt.Graphics2D;
import java.util.LinkedList;
import kaplama.Kaplamalar;
import pencere.Main;
import yapi.ID;
import yapi.OyunNesnesi;

/**
 *
 * @author kayra
 */
public class Kale extends OyunNesnesi {
    Kaplamalar kaplama = Main.getir();
    
    public Kale(int x, int y, ID id, boolean renk) {
        super(x, y, id);
        this.renk = renk;
    }

    @Override
    public void ciz(Graphics2D g) {
        if(renk){
            g.drawImage(kaplama.taslar[0][2], this.x, this.y, null);
        } //siyah
        else {
            g.drawImage(kaplama.taslar[1][2], this.x, this.y, null);
        } //beyaz
    }

    @Override
    public void guncelle(LinkedList<OyunNesnesi> nesne) {
        
    }
    
    
}
