package Game;


import Core.Game;
import Game.JogoGalinha;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
/**
 *
 * @author rafa_
 */
public class Main {
    public static void main(String[] args) {
  //      TelaInicio t = new TelaInicio();
   //     t.setVisible(true);
        Game a = new JogoGalinha();
        a.run();       
    }
    public Main(Game a){
       a.run();
    }
}
