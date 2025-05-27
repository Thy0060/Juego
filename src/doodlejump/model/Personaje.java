package src.doodlejump.model;

import java.util.Arrays;

import src.soporte.ObjetoGrafico;
import src.soporte.ObjetoGraficoDeUsuario;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;

final class Personaje extends ObjetoGraficoDeUsuario {
    private static final double lado = 6;
    private static final double posicionInicial = 50;
    
    private static final int flechaArriba = 38;
    private static final int flechaAbajo = 40;
    private static final int flechaDerecha = 39;
    private static final int flechaIzquierda = 37;
    
    private static final String PERSONAJE_IMAGE = "./doodle.png";

    protected Personaje(){
        super(new Poligono(java.awt.Color.DARK_GRAY, new Punto(posicionInicial,posicionInicial),
            Arrays.asList(
                new Punto(posicionInicial - lado, posicionInicial - lado),
                new Punto(posicionInicial - lado, posicionInicial + lado),
                new Punto(posicionInicial + lado/4, posicionInicial + lado),
                new Punto(posicionInicial + lado/4,posicionInicial + lado/3),
                new Punto(posicionInicial + lado, posicionInicial + lado/3),
                new Punto(posicionInicial + lado, posicionInicial - lado/5),
                new Punto(posicionInicial + lado/4, posicionInicial - lado/5),
                new Punto(posicionInicial + lado/4, posicionInicial - lado))), 
            flechaArriba, flechaAbajo, flechaDerecha, flechaIzquierda);

        setImage(PERSONAJE_IMAGE);
    }
    
    public void efectuarMovimiento(double vX, double vY){
        this.colocar(vX,vY);
    }
    
    public void recibirImpacto(ObjetoGrafico otrafigura){
    }
}
