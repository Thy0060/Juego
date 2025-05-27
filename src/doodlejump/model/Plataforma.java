package src.doodlejump.model;
import java.util.Arrays;

import src.model.ObjetoGrafico;
import src.model.ObjetoGraficoMovil;
import src.model.base.IFigura;
import src.model.base.Poligono;
import src.model.base.Punto;

public class Plataforma extends ObjetoGraficoMovil {
    public static final double ANCHO = 12;
    public static final double ALTO = 3;
    public Personaje personajeRef = null;
    protected boolean colision = false;

    public Plataforma(double x, double y, Personaje personajeRef, double incX, double incY){
        super(crearFigura(x, y), 1, incX, incY);
        this.personajeRef = personajeRef;
    }

    private static IFigura crearFigura(double x, double y){
        return new Poligono(java.awt.Color.GREEN, new Punto(x, y),
            Arrays.asList(
                new Punto(x - ANCHO/2, y - ALTO/2),
                new Punto(x + ANCHO/2, y - ALTO/2),
                new Punto(x + ANCHO/2, y + ALTO/2),
                new Punto(x - ANCHO/2, y + ALTO/2)
            ));
    }

    public void mover(double incX, double incY){
        this.colocar(incX, incY);
    }
    
    public void recibirImpacto(ObjetoGrafico f){}

}
