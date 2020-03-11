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
public class Milho {
    
    private int x=1,y=100,sx,sy;
    private BufferedImage Milho1;

    public Milho() {
        ImgMilho();
    }

    public BufferedImage getMilho1() {
        return Milho1;
    }

    public int getX() {
        return x+sx;
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

    public int getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }

    public int getSy() {
        return sy;
    }

    public void setSy(int sy) {
        this.sy = sy;
    }

  

    
    private void ImgMilho(){
        URL imgMilho = getClass().getResource("/Images\\milho.png");
        if (imgMilho == null){
            throw new RuntimeException("Erro no arquivo de imagem milho");
        }else{
            try {
                Milho1 = ImageIO.read(imgMilho);
            } catch (IOException ex) {
                Logger.getLogger(Milho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
