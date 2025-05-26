package doodlejump.model;

import java.util.Arrays;

import model.ObjetoGrafico;
import model.base.IFigura;
import model.base.Poligono;
import model.base.Punto;
import stdlib.StdDraw;

public class PlataformaMovil extends Plataforma{
    public static final double ANCHO = 12;
    public static final double ALTO = 3;
    public Personaje personajeRef = null;
    protected boolean activa = true;
    protected boolean colision = false;

    public PlataformaMovil(double x, double y, Personaje personajeRef) {
        super(x, y, personajeRef, 2, 0);
        this.getFigura().setColor(StdDraw.BLUE);
    }

    private static IFigura crearFigura(double x, double y) {
        return new Poligono(java.awt.Color.BLUE, new Punto(x, y),
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

    public void mover(){
        this.avanzar();
    }

}