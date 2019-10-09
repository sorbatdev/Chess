/* 
 * Copyright (c) 2018, Kayra Urfalı
 * 
 * 
 * 
 * 
 * 
 * 
 */
package pencere;

import nesneler.Kare;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import kaplama.Kaplamalar;
import yapi.ID;
import yapi.Isleyici;
import yapi.MouseGirdisi;
import nesneler.*;


/**
 *
 * @author kayra
 */
@SuppressWarnings("FieldMayBeFinal")
public class Main extends Canvas implements Runnable{

    public static short GENISLIK, YUKSEKLIK;

    
    private boolean running = false;
    private Thread thread;
    public static Kare[][] kare = new Kare[8][8];
    
    Isleyici isleyici;
    static Kaplamalar k;
    
    @Override
    public void run() {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;        
        while(running){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while(delta >= 1){
                        guncelle();
                        delta--;
                }
                ciz();
//                frames++;
//
//                if(System.currentTimeMillis() - timer > 1000){
//                        timer += 1000;
//                        System.out.println("FPS: " + frames + " TICKS: " + updates);
//                        frames = 0;
//                        updates = 0;
//                }
        }
    }
    public synchronized void start(){
        if(running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void init() {
        GENISLIK = (short)getWidth();
        YUKSEKLIK = (short)getHeight();
                      
        k = new Kaplamalar();
        isleyici = new Isleyici();
        
        int t;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(i%2 == 0) t = 1;
                else t = -1;
                kare[i][j] = new Kare(j*48, i*48, t, j%2);
            }
        }
        
        taslariYukle();
            
        this.addMouseListener(new MouseGirdisi(isleyici));
    }

    public void guncelle() {
        isleyici.guncelle();
    }

    public void ciz() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.black);
        g2.fillRect(0, 0, GENISLIK, YUKSEKLIK);
        
        //g2.drawImage(k.tahta, 0, 0, null);
        isleyici.ciz(g2);
        
        
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args) {
         new Pencere(374, 374, "Satranç", new Main());
    }
    
    private void taslariYukle(){
        kare[0][0].n = new Kale(kare[0][0].x, kare[0][0].y, ID.Kale, false);
        kare[0][1].n = new At(kare[0][1].x, kare[0][1].y, ID.At, false);
        kare[0][2].n = new Fil(kare[0][2].x, kare[0][2].y, ID.Fil, false);
        kare[0][3].n = new Vezir(kare[0][3].x, kare[0][3].y, ID.Vezir, false);
        kare[0][4].n = new Sah(kare[0][4].x, kare[0][4].y, ID.Sah, false);
        kare[0][5].n = new Fil(kare[0][5].x, kare[0][5].y, ID.Fil, false);
        kare[0][6].n = new At(kare[0][6].x, kare[0][6].y, ID.At, false);
        kare[0][7].n = new Kale(kare[0][7].x, kare[0][7].y, ID.Kale, false);
        
        for(int i = 0; i < 8; i++){
            kare[1][i].n = new Piyon(kare[1][i].x, kare[1][i].y, ID.Piyon, false);
        }
        
        kare[7][0].n = new Kale(kare[7][0].x, kare[7][0].y, ID.Kale, true);
        kare[7][1].n = new At(kare[7][1].x, kare[7][1].y, ID.At, true);
        kare[7][2].n = new Fil(kare[7][2].x, kare[7][2].y, ID.Fil, true);
        kare[7][3].n = new Vezir(kare[7][3].x, kare[7][3].y, ID.Vezir, true);
        kare[7][4].n = new Sah(kare[7][4].x, kare[7][4].y, ID.Sah, true);
        kare[7][5].n = new Fil(kare[7][5].x, kare[7][5].y, ID.Fil, true);
        kare[7][6].n = new At(kare[7][6].x, kare[7][6].y, ID.At, true);
        kare[7][7].n = new Kale(kare[7][7].x, kare[7][7].y, ID.Kale, true);
        
        for(int i = 0; i < 8; i++){
            kare[6][i].n = new Piyon(kare[6][i].x, kare[6][i].y, ID.Piyon, true);
        }
                
        for(int i = 0; i < 8; i++){
            isleyici.nesneler.add(kare[0][i].n);
        }
        for(int i = 0; i < 8; i++){
            isleyici.nesneler.add(kare[1][i].n);
        }
        for(int i = 0; i < 8; i++){
            isleyici.nesneler.add(kare[7][i].n);
        }
        for(int i = 0; i < 8; i++){
            isleyici.nesneler.add(kare[6][i].n);
        }
        
    }
    
    public static Kaplamalar getir(){
        return k;
    }
}
