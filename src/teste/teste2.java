/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.sun.javafx.geom.AreaOp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rafa_
 */
public class teste2 extends teste {
    public static void main(String[] args) {
        teste t = new teste2();
        t.run();
    }
    
    JPanel painel = new JPanel();
    JLabel l = new JLabel();
    
    
   
     
    
    
    
    
    @Override
    public void update() {
        painel.setSize(400, 400);
        l.setBounds(100,100, 800, 800);
        l.setForeground(Color.yellow);
        l.setFont(new Font("arial", Font.ITALIC, 55));
        l.setText("aslkddfjfd");
        
        
        painel.add(l);
        getWindows().add(painel);
    }

    @Override
    public void onRender(Graphics2D g) {
      
    }

    @Override
    public void UnLoad() {
    }

    @Override
    public void onUnload() {
    }

    @Override
    public void onLoad() {
    }

    
}
