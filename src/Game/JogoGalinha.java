package Game;

import Core.GerarLoc;
import Core.FontManager;
import Core.Game;
import Core.Observador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafa_
 */
public class JogoGalinha extends Game implements MouseListener {


    private BufferedImage celeiro;
    private BufferedImage fechar;
    private BufferedImage nuvem;
    private Font alfa;
    Milho m = new Milho();
    Milho m1 = new Milho();
    Milho m2 = new Milho();
    Milho m3 = new Milho();
    Galinha galinha = new Galinha();
    Pintinho p = new Pintinho();
    int Minutos = 0;
    int segundos1 = 0;
    int segundos2 = 0;
    Rectangle rmilho = new Rectangle();
    Rectangle rmilho1 = new Rectangle();
    Rectangle rmilho2 = new Rectangle();
    Rectangle rmilho3 = new Rectangle();
    Rectangle rgalinha = new Rectangle();
    Rectangle rpintinho = new Rectangle();
    private int pontuacao = 0;
    int velocidade = 3;
    int velocidadep = 1;

    public JogoGalinha() {
        getMainWindow().addKeyListener(Observador.getInstancia());
        getMainWindow().addMouseListener(this);
        cronometro();

    }

    public void cronometro() {
        new Thread() {
            public void run() {
                while (active) {
                    if (segundos2 > 9) {
                        segundos2 = 0;
                        segundos1++;
                    }
                    if (segundos1 >= 6 && segundos2 >= 0) {
                        segundos1 = 0;
                        segundos2 = 0;
                        Minutos++;
                    }
                    if (segundos1 == 3 && segundos2 == 0 || Minutos > 0 && segundos1 == 0 && segundos2 == 0) {
                        velocidade += 2;
                        velocidadep += 1;
                    }
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                    }
                    segundos2++;
                }

            }
        }.start();
    }

    public void onRender(Graphics2D g) {

        g.drawImage(celeiro, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(m.getMilho1(), m.getX(), m.getY(), 40, 40, null);
        g.drawImage(m1.getMilho1(), m1.getX(), m1.getY() + 10, 40, 40, null);
        g.drawImage(m2.getMilho1(), m2.getX(), m2.getY(), 40, 40, null);
        g.drawImage(m3.getMilho1(), m2.getX(), m3.getY() + 10, 40, 40, null);
        g.drawImage(galinha.getGalinha(), galinha.getX(), galinha.getY(), 80, 80, null);
        g.drawImage(fechar, 950, 0, 50, 50, null);
        g.drawImage(p.getImgPintinho(), p.getX(), p.getY(), 40, 40, null);
        g.drawImage(nuvem, 415, -10, 170, 110, null);
        alfa = FontManager.getInstance().loadFont("Images/alfabeto1.ttf", 25, FontManager.BOLD);
        g.setFont(alfa);
        g.setColor(Color.white);
        g.drawString("Pontuacao: " + pontuacao, 0, 30);
        g.drawString(Minutos + ":" + segundos1 + segundos2, 470, 55);

    }

    @Override
    public void onLoad() {
        verificacao();
        m2.setX(950);
        m3.setX(950);

        URL imgCeleiro = getClass().getResource("/Images\\celeiro.jpg");
        URL x = getClass().getResource("/Images\\x.png");
        URL imgNuvem = getClass().getResource("/Images\\nuvem.png");
        if (imgCeleiro == null || x == null || imgNuvem == null) {
            throw new RuntimeException("Erro no arquivo de images");
        } else {
            try {
                celeiro = ImageIO.read(imgCeleiro);
                fechar = ImageIO.read(x);
                nuvem = ImageIO.read(imgNuvem);
            } catch (IOException ex) {
                Logger.getLogger(Milho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void onUpdate() {
        Observador.getInstancia().controle(galinha);

        rgalinha.setRect(galinha.getX(), galinha.getY(), 80, 80);
        rpintinho.setRect(p.getX(), p.getY(), 40, 40);
        rmilho.setRect(m.getX(), m.getY(), 40, 40);
        rmilho1.setRect(m1.getX(), m1.getY(), 40, 40);
        rmilho2.setRect(m2.getX(), m2.getY(), 40, 40);
        rmilho3.setRect(m3.getX(), m3.getY(), 40, 40);

        if (rgalinha.intersects(rpintinho)) {
            pontuacao = pontuacao + 5;
            p.setX(GerarLoc.gerarNumeroX());
            p.setY(50);

        }
        if (rgalinha.intersects(rmilho)
                || rgalinha.intersects(rmilho1)
                || rgalinha.intersects(rmilho2)
                || rgalinha.intersects(rmilho3)) {
            gameover();
        }

        m.setX(m.getX() + velocidade);
        m1.setX(m1.getX() + velocidade);
        m2.setX(m2.getX() - velocidade);
        m3.setX(m3.getX() - velocidade);
        p.setY(p.getY() + velocidadep);
        try {

            sleep(10);
        } catch (InterruptedException ex) {
        }

        if (p.getY() >= getHeight()) {
            p.setX(GerarLoc.gerarNumeroX());
            p.setY(50);
            pontuacao -= 10;
            if (pontuacao < 0) {
                gameover();
            }

        }
        if (m.getX() > getWidth()) {
            m.setY(GerarLoc.gerarNumeroY());
            m.setX(0);
        }
        if (m1.getX() > getWidth()) {
            m1.setY(GerarLoc.gerarNumeroY());
            m1.setX(0);
        }

        if (m2.getX() < 0) {
            m2.setY(GerarLoc.gerarNumeroY());
            m2.setX(950);
        }
        if (m3.getX() < 0) {
            m3.setY(GerarLoc.gerarNumeroY());
            m3.setX(950);
        }

        if (galinha.getX() <= 0) {
            galinha.setX(1);
        }
        if (galinha.getX() >= getWidth() - 80) {
            galinha.setX(getWidth() - 80);
        }
        if (galinha.getY() <= 0) {
            galinha.setY(1);
        }
        if (galinha.getY() >= getHeight() - 80) {
            galinha.setY(getHeight() - 80);
        }
    }

    @Override
    public void onUnload() {
        terminate();

    }

    public void gameover() {
        String resp = JOptionPane.showInputDialog("Game Over \n Deseja Continuar ? Sim/Nao");
        if (resp.contentEquals("Sim") || resp.contentEquals("sim") || resp.contentEquals("s")) {
            galinha.setX(460);
            galinha.setY(520);
            m.setX(1);
            m.setY(100);
            m1.setX(1);
            m1.setY(100);
            m2.setX(1);
            m2.setY(100);
            m3.setX(1);
            m3.setY(100);
            Minutos = 0;
            segundos1 = 0;
            segundos2 = 0;
            p.setX(450);
            p.setY(50);
            pontuacao = 0;
        } else {

            onUnload();
        }
    }

    public void verificacao() {
        new Thread() {

            public synchronized void run() {

                if (m.getY() < m1.getY() - 40
                        || m.getY() > m1.getY() + 40) {

                } else {
                    m.setY(GerarLoc.gerarNumeroY());
                }

                if (m2.getY() < m3.getY() - 40
                        || m2.getY() > m3.getY() + 40) {

                } else {
                    m.setY(GerarLoc.gerarNumeroY());

                }

            }
        }.start();

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getX() >= 950 && me.getY() <= 50) {
            terminate();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


