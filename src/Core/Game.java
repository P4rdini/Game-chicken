package Core;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;



abstract public class Game  {

    private JFrame mainWindow;
    public  boolean active;
    private BufferStrategy bufferStrategy;
    JPanel titulo = new JPanel();
     JLabel l = new JLabel("lkdsfsjlk");
    

    public Game() {
        mainWindow = new JFrame("Abrindo o Jogo - Desenvolvimento de Jogos Digitais em Java");
        mainWindow.setSize(1000, 600);
      
        
        active = false;
        
        
        
        
    }

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public  void terminate() {
        active = false;
    }

    public void run() {
        active = true;
        load();
        while (active) {
            update();
            
            render(); 
        }
        unload();
    }

    public void load() {
        mainWindow.setUndecorated(true);
        mainWindow.setIgnoreRepaint(true);
        mainWindow.setLocation(100, 100);
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.createBufferStrategy(2);
        bufferStrategy = mainWindow.getBufferStrategy();
        
        onLoad();
    }

    public void unload() {
        onUnload();
        bufferStrategy.dispose();
        mainWindow.dispose();
    }

    public void update() {
        
        onUpdate();
        Thread.yield();
    }

    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(), getHeight());
        
        onRender(g);
        g.dispose();
        bufferStrategy.show();
    }

    abstract public void onLoad();

    abstract public void onUnload();

    abstract public void onUpdate();

    abstract public void onRender(Graphics2D g);

    public int getWidth() {
        return mainWindow.getWidth();
    }

    public int getHeight() {
        return mainWindow.getHeight();
    }

}
