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

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author kayra
 */
public class Pencere {
    
    public Pencere(int g, int y, String baslik, Main m){
        m.setPreferredSize(new Dimension(g,y));
        m.setMinimumSize(new Dimension(g,y));
        m.setMaximumSize(new Dimension(g,y));
        
        JFrame f = new JFrame(baslik);
        f.add(m);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setTitle(baslik);
        f.setVisible(true);
        
        m.start();
    }
    
}
