package src.doodlejump.model;

import java.util.Arrays;

import src.soporte.ObjetoGrafico;
import src.soporte.ObjetoGraficoDeUsuario;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;

public class Personaje extends ObjetoGraficoDeUsuario {
    private static final String PERSONAJE_IMAGE = "./doodle.png";

    private static final double PERSONAJE_WIDTH = 6;

    private static final double PERSONAJE_X = 50;
    private static final double PERSONAJE_Y = 50;
    
    private static final int FLECHA_ARRIBA = 38;
    private static final int FLECHA_ABAJO = 40;
    private static final int FLECHA_DERECHA = 39;
    private static final int FLECHA_IZQUIERDA = 37;
    

    protected Personaje(){
        super(new Poligono(java.awt.Color.DARK_GRAY, new Punto(PERSONAJE_X,PERSONAJE_Y),
            Arrays.asList(
                new Punto(PERSONAJE_X-PERSONAJE_WIDTH,PERSONAJE_Y-PERSONAJE_WIDTH),
                new Punto(PERSONAJE_X-PERSONAJE_WIDTH,PERSONAJE_Y+PERSONAJE_WIDTH),
                new Punto(PERSONAJE_X + PERSONAJE_WIDTH/4, PERSONAJE_Y + PERSONAJE_WIDTH),
                new Punto(PERSONAJE_X + PERSONAJE_WIDTH/4,PERSONAJE_Y+ PERSONAJE_WIDTH/3),
                new Punto(PERSONAJE_X + PERSONAJE_WIDTH, PERSONAJE_Y + PERSONAJE_WIDTH/3),
                new Punto(PERSONAJE_X + PERSONAJE_WIDTH, PERSONAJE_Y-PERSONAJE_WIDTH/5),
                new Punto(PERSONAJE_X + PERSONAJE_WIDTH/4, PERSONAJE_Y-PERSONAJE_WIDTH/5),
                new Punto(PERSONAJE_X + PERSONAJE_WIDTH/4, PERSONAJE_Y-PERSONAJE_WIDTH)
            )), FLECHA_ARRIBA, FLECHA_ABAJO, FLECHA_DERECHA, FLECHA_IZQUIERDA);

        setImage(PERSONAJE_IMAGE);
    }
    
    public void efectuarMovimiento(double vX, double vY){
        this.colocar(vX,vY);
    }
    
    public void recibirImpacto(ObjetoGrafico otrafigura){
    }
}
