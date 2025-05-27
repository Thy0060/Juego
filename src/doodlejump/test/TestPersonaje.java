package src.doodlejump.test;

import src.doodlejump.model.JuegoPersonaje;
import src.doodlejump.model.LdPlataformas;
import stdlib.StdDraw;

public class TestPersonaje {
 public static void main(String[] args) {
        while (true) {
            JuegoPersonaje juego = new JuegoPersonaje();
            juego.jugar(); 

            StdDraw.text(50, 50, "¡Juego Terminado!");
            StdDraw.text(50, 45, "Puntuación: " + LdPlataformas.getPuntuacion());
            StdDraw.text(50, 40, "Pulsa 'R' para reiniciar");
            StdDraw.show();

            while (!StdDraw.isKeyPressed('R')) {
                StdDraw.pause(50);
            }

            while (StdDraw.isKeyPressed('R')) {
                StdDraw.pause(50);
            }
        }
    }
}