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
public class Piyon extends OyunNesnesi {
    Kaplamalar kaplama = Main.getir();
    
    public boolean renk = false; // false = beyaz, true = siyah
    
    public Piyon(int x, int y, ID id, boolean renk) {
        super(x, y, id);
        this.renk = renk;
    }

    @Override
    public void ciz(Graphics2D g) {
        if(renk)g.drawImage(kaplama.taslar[0][0], this.x, this.y, null); //siyah
        else g.drawImage(kaplama.taslar[1][0], this.x, this.y, null); //beyaz
    }

    @Override
    public void guncelle(LinkedList<OyunNesnesi> nesne) {
        
    }
    
    
}
