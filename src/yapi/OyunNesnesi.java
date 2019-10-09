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

/**
 *
 * @author kayra
 */
public abstract class OyunNesnesi {
    
    protected int x, y;
    protected ID id;
    protected boolean renk;
    
    public OyunNesnesi(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public abstract void ciz(Graphics2D g);
    public abstract void guncelle(LinkedList<OyunNesnesi> nesne);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OyunNesnesi{" + "sutun=" + ((this.x/48)+1) + ", satır=" + (this.y/48+1) + ", id=" + this.id + '}';
        
    }
    
    
}
