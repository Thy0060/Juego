package src.doodlejump.model;

import java.util.Arrays;

import src.soporte.ObjetoGrafico;
import src.soporte.ObjetoGraficoMovil;
import src.soporte.base.IFigura;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;

public class Plataforma extends ObjetoGraficoMovil {
    public static final double ANCHO = 12;
    public static final double ALTO = 3;
    public Personaje personajeRef;
    public static final String plataforma = "./plataforma.png";

    public Plataforma(double x, double y, Personaje personajeRef, double incX, double incY){
        super(crearFigura(x, y), 1, incX, incY);
        this.personajeRef = personajeRef;
        this.setImage(plataforma);
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
    
    public void recibirImpacto(ObjetoGrafico f){}

}