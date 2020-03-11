package Game;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Pintinho {
    int x=450,y=50;
    BufferedImage imgPintinho;

    public Pintinho() {
        imgPintinho();
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
    
    
    public void imgPintinho(){
        URL img = getClass().getResource("/Images\\pintinho batendo asa.png");
        if (img == null) System.out.println("erro na imagem do pintinho");
        else try {
            imgPintinho = ImageIO.read(img);
        } catch (IOException ex) {
            Logger.getLogger(Pintinho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedImage getImgPintinho() {
        return imgPintinho;
    }
    
}
