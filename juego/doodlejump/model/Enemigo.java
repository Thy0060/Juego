package doodlejump.model;
import java.util.Arrays;

import model.ObjetoGrafico;
import model.ObjetoGraficoMovil;
import model.base.IFigura;
import model.base.Poligono;
import model.base.Punto;
public class Enemigo extends ObjetoGraficoMovil{
    public static final double ANCHO = 8;
    public static final double ALTO = 8;
    public static final double VELOCIDAD = 2;
    public Personaje personajeRef = null;

    public Enemigo(double x, double y, Personaje personajeRef) {
        super(crearFigura(x, y), 1, VELOCIDAD, 0);
        this.personajeRef = personajeRef;
    }
    private static IFigura crearFigura(double x, double y) {
        return new Poligono(java.awt.Color.GREEN, new Punto(x, y),
            Arrays.asList(
                new Punto(x - ANCHO/2, y - ALTO/2),
                new Punto(x + ANCHO/2, y - ALTO/2),
                new Punto(x + ANCHO/2, y + ALTO/2),
                new Punto(x - ANCHO/2, y + ALTO/2)
            ));
    }
}
