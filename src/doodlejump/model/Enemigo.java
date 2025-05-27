package src.doodlejump.model;
import java.util.Arrays;

import src.soporte.ObjetoGrafico;
import src.soporte.ObjetoGraficoMovil;
import src.soporte.base.IFigura;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;
import stdlib.StdRandom;

public class Enemigo extends ObjetoGraficoMovil{
    public static final double Lado = 6;
    public static final String enemigoFoto = "./enemigo.png";
    public Personaje personajeRef = null;

    public Enemigo(double x, double y, Personaje personajeRef) {
        super(crearFigura(x, y), 1, StdRandom.uniformDouble(0,2), 0);
        this.personajeRef = personajeRef;
        setImage(enemigoFoto);
    }
    private static IFigura crearFigura(double x, double y) {
        return new Poligono(java.awt.Color.RED, new Punto(x, y),
            Arrays.asList(
                new Punto(x - Lado/2, y - Lado/2),
                new Punto(x + Lado/2, y - Lado/2),
                new Punto(x + Lado/2, y + Lado/2),
                new Punto(x - Lado/2, y + Lado/2)
            ));
    }

    public void mover(){
        if (getFigura().getCentroide().getX()<0 || getFigura().getCentroide().getX()>100 )
            setIncX(-getIncX());
        this.avanzar();
    }

    public void recibirImpacto(ObjetoGrafico f){}

}