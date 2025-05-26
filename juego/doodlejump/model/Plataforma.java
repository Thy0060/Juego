package doodlejump.model;
import java.util.Arrays;

import model.ObjetoGrafico;
import model.ObjetoGraficoMovil;
import model.base.IFigura;
import model.base.Poligono;
import model.base.Punto;
public class Plataforma extends ObjetoGraficoMovil {
    public static final double ANCHO = 12;
    public static final double ALTO = 3;
    public Personaje personajeRef = null;
    protected boolean activa = true;
    protected boolean colision = false;

    public Plataforma(double x, double y, Personaje personajeRef) {
        super(crearFigura(x, y), 1, 0, 0);
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

    public boolean estaActiva() {
        return activa;
    }
    public void mover(double incX, double incY){
        this.colocar(incX, incY);
    }
    public void recibirImpacto(ObjetoGrafico f){}
}
