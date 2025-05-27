package src.doodlejump.test;

import src.doodlejump.model.JuegoPersonaje;
import stdlib.StdDraw;

public class TestPersonaje {
 public static void main(String[] args) {
        while(true){
            JuegoPersonaje juego = new JuegoPersonaje();
            juego.jugar(); 

            juego.finalizarJuego();

            while(!StdDraw.isKeyPressed('R')){
                StdDraw.pause(10);
            }

            while(StdDraw.isKeyPressed('R')){
                StdDraw.pause(10);
            }
        }
    }
}