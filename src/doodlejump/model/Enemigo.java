package src.doodlejump.model;

import java.util.Arrays;
import stdlib.StdRandom;

import src.soporte.ObjetoGrafico;
import src.soporte.ObjetoGraficoMovil;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;

public class Enemigo extends ObjetoGraficoMovil{
    public static final double Lado = 12;
    public Personaje personajeRef;
    protected String[] fotosEnemigos = {"./enemigo1.png", "./enemigo2.png", "./enemigo3.png"};

    public Enemigo(double x, double y, Personaje personajeRef) {
        super(new Poligono(java.awt.Color.RED, new Punto(x, y),
            Arrays.asList(
                new Punto(x - Lado/2, y - (Lado-4)/2),
                new Punto(x + Lado/2, y - (Lado-4)/2),
                new Punto(x + Lado/2, y + (Lado-4)/2),
                new Punto(x - Lado/2, y + (Lado-4)/2)
            )), 1, StdRandom.uniformDouble(0,2), 0);
        this.personajeRef = personajeRef;
        this.setImage(fotosEnemigos[StdRandom.uniformInt(0,3)]);
    }

    public void mover(){
        if (getFigura().getCentroide().getX()<0 || getFigura().getCentroide().getX()>100)
            setIncX(-getIncX());
        this.avanzar();
    }

    public void recibirImpacto(ObjetoGrafico f){}

}