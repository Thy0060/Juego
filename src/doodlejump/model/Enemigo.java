package src.doodlejump.model;

import java.util.Arrays;
import stdlib.StdRandom;

import src.soporte.ObjetoGrafico;
import src.soporte.ObjetoGraficoMovil;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;

final class Enemigo extends ObjetoGraficoMovil{
    private static final double lado = 12;
    private static final String[] fotosEnemigos = {"./enemigo1.png", "./enemigo2.png", "./enemigo3.png"};

    protected Enemigo(double x, double y) {
        super(new Poligono(java.awt.Color.RED, new Punto(x, y),
            Arrays.asList(
                new Punto(x - lado/2, y - (lado-4)/2),
                new Punto(x + lado/2, y - (lado-4)/2),
                new Punto(x + lado/2, y + (lado-4)/2),
                new Punto(x - lado/2, y + (lado-4)/2))), 
            1, StdRandom.uniformDouble(0,2), 0);
        this.setImage(fotosEnemigos[StdRandom.uniformInt(0,3)]);
    }

    protected final void mover(){
        if (getFigura().getCentroide().getX()<0 || getFigura().getCentroide().getX()>100)
            setIncX(-getIncX());
        this.avanzar();
    }

    public void recibirImpacto(ObjetoGrafico f){}

}