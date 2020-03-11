/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import Game.Galinha;
import Game.JogoGalinha;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rafa_
 */
public class Observador implements KeyListener {
    
    
    
    
    protected int KEY_RELEASED=0;
    protected int KEY_JUST_PRESSED=-1;
    private int KEY_PRESSED=2;
    static private Observador instancia;
    HashMap<Integer, Boolean> tecla;
    
    
    public Observador(){
        tecla = new HashMap<Integer, Boolean>();
        
        
    }  
   
    
    static public Observador getInstancia(){
        if (instancia == null){
            instancia = new Observador();
        }
        return instancia;
    }
    
    
   
    
    public void controle(Galinha g){
        if (tecla.get(KeyEvent.VK_W) != null){
            g.setY(g.getY()-5);
            
        }
        if (tecla.get(KeyEvent.VK_S)!= null){
            g.setY(g.getY()+5);
            
        }
        if (tecla.get(KeyEvent.VK_D)!= null){
            g.setX(g.getX()+5);
        }
        if (tecla.get(KeyEvent.VK_A)!= null){
            g.setX(g.getX()-5);
            
        }
        if (tecla.get(KeyEvent.VK_ESCAPE) != null){
            System.exit(0);
        }
        try{
            Thread.sleep(20);
        }catch(InterruptedException e){
            Logger.getLogger(JogoGalinha.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    /**
     * Observador do teclado
     * @param ke 
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       tecla.put(ke.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        tecla.remove(ke.getKeyCode());
    } 
    
}  
    
 /**
  * Observador do mouse
  * @param me 
  */
    
    

