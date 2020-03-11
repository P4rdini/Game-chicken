package Game;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafa_
 */
public class Galinha {
    
    private int x=460,y=520;
    private BufferedImage galinha;
    
    private void imgGalinha(){
        URL imgGalinha = getClass().getResource("/Images\\GalinhaNomeJogo.png");
        try {
            galinha = ImageIO.read(imgGalinha);
        } catch (IOException ex) {
            throw new RuntimeException("erro na imagem da Galinha");
        }
    }
       public Galinha(){
           imgGalinha();
          
       }
    public BufferedImage getGalinha() {
        return galinha;
    }

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
    
    
    
    
}
