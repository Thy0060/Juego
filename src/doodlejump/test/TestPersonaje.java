package src.doodlejump.test;

import stdlib.StdDraw;

import src.doodlejump.model.JuegoDoodle;

public class TestPersonaje {
public static void main(String[] args) {
        while(true){
            JuegoDoodle juego = new JuegoDoodle();
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