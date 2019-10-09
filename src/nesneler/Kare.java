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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import yapi.OyunNesnesi;

/**
 *
 * @author kayra
 */
@SuppressWarnings("FieldMayBeFinal")
public class Kare{
    
    public int x, y;
    public OyunNesnesi n = null;
    public Color renk;
    public int r;
    
    public Kare(int x, int y, int t, int renk){
        this.x = x;
        this.y = y;
            if(t == 1){
                if(renk == 0){
                    this.renk = Color.white;
                    this.r = 0;
                }else{
                    this.renk = Color.GRAY;
                    this.r = 1;
                }
            }else{
                if(renk == 0){
                    this.renk = Color.GRAY; 
                    this.r = 1;
                }else{
                    this.renk = Color.white;
                    this.r = 0;
                }
            }
    }
    
    public Rectangle sinirlar(){
        return new Rectangle(this.x, this.y, 48, 48);
    }
    
    public void tasEkle(OyunNesnesi n){
        if(this.n == null) {
            this.n = n;
            this.n.setX(this.x);
            this.n.setY(this.y);
        }
    }
    public boolean tasCikar(){
        this.n = null;
        return true;
    }
    
    public void ciz(Graphics2D g){
        g.setColor(renk);
        g.fill(new Rectangle(this.x, this.y, 48, 48));
    }
    
    public void setRenk(Color r){
        this.renk = r;
    }
    
}
