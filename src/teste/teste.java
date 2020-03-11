/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author rafa_
 */
public abstract class teste implements WindowListener {
    JFrame tela = new JFrame();
    boolean active = true;
    private BufferStrategy bufferStrategy;
    
    public void teste(){
    tela.setTitle("teste");
    tela.setSize(400, 400);
    tela.addWindowListener(this);
    
        run();
    
}
            
    public JFrame getWindows(){
        return this.tela;
    }
    
    public int getWidth(){
        return tela.getWidth();
    }
    public int getHeight(){
        return tela.getHeight();
    }
    public void run(){
         active = true;
        load();
        while (active) {
            update();
            render(); 
        }
        Unload();
    }
    
    
    private void load() {
        tela.setVisible(true);
        tela.setSize(1000, 600);
        
        onLoad();
    }

    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(), getHeight());
   
        onRender(g);
        g.dispose();
        bufferStrategy.show();
    }

    private void Unload() {
        onUnload();
        bufferStrategy.dispose();
        tela.dispose();
    }

    
    
    
    
    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
            active = false;
    }

    @Override
    public void windowClosed(WindowEvent we) {
         
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    abstract public void update() ;

    abstract public void onRender(Graphics2D g);
    abstract public void UnLoad();

    abstract public void onUnload();

    abstract public void onLoad();
    
}
