package Core;



public class GerarLoc {
    
    public static int gerarNumeroX() {
        int x = ((int)(Math.random() * 970)+1);
        return x;
    }
    
    public static int gerarNumeroY() {
        int y = ((int)(Math.random() * 560)+50);
        return y;
    }

}
