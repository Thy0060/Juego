package src.doodlejump.model;

import java.util.Arrays;

import src.model.ObjetoGrafico;
import src.model.ObjetoGraficoDeUsuario;
import src.model.base.Poligono;
import src.model.base.Punto;
public class Personaje extends ObjetoGraficoDeUsuario {
    public static final String PERSONAJE_IMAGE = "./doodle.png";

    public static final double PERSONAJE_WIDTH = 6;
    public static final double PERSONAJE_HEIGHT = 8;

    public static final double PERSONAJE_X = 50;
    public static final double PERSONAJE_Y = 50;
    
    public static final int FLECHA_ARRIBA = 38;
    public static final int FLECHA_ABAJO = 40;
    public static final int FLECHA_DERECHA = 39;
    public static final int FLECHA_IZQUIERDA = 37;
    

    public Personaje(){
        super(new Poligono(java.awt.Color.DARK_GRAY,
                    new Punto(PERSONAJE_X,PERSONAJE_Y),
                    Arrays.asList(new Punto[]{new Punto(PERSONAJE_X-PERSONAJE_WIDTH,PERSONAJE_Y-PERSONAJE_WIDTH),
                                new Punto(PERSONAJE_X+PERSONAJE_WIDTH,PERSONAJE_Y-PERSONAJE_WIDTH),
                                new Punto(PERSONAJE_X+PERSONAJE_WIDTH,PERSONAJE_Y+PERSONAJE_WIDTH),
                                new Punto(PERSONAJE_X-PERSONAJE_WIDTH,PERSONAJE_Y+PERSONAJE_WIDTH)}
                )), FLECHA_ARRIBA, FLECHA_ABAJO, FLECHA_DERECHA, FLECHA_IZQUIERDA);

        setImage(PERSONAJE_IMAGE);
    }
    public void efectuarMovimiento(double vX, double vY){
        this.colocar(vX,vY);
    }
    
    public void recibirImpacto(ObjetoGrafico otrafigura){
    }
}
