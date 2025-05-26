package doodlejump.model;

import stdlib.StdDraw;

import java.util.Arrays;

import model.ObjetoGrafico;
import model.ObjetoGraficoMovil;
import model.base.IFigura;
import model.base.Poligono;
import model.base.Punto;

public class PlataformaFalsa extends Plataforma{
    protected boolean activa = true;
   // protected boolean colision = false;

    public PlataformaFalsa(double x, double y, Personaje personajeRef) {
        super(x, y, personajeRef, 0, 0);
        this.getFigura().setColor(StdDraw.LIGHT_GRAY);
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
/*
    public void verificarColision() {
        if (activa && !colision && colisionaCon(personajeRef)) {  
            colision =  true;
            activa = false;   
        }
    }
 */
    public void activar(){
        this.activa = true;
    }
    public void desactivar(){
        this.activa = false;
    }
    @Override
    public void pintar() {
    if (activa) {
        getFigura().pintar(); // pinta solo si está activa
    }
}

    public boolean estaActiva() {
        return activa;
    }
/* 
    private boolean colisionaCon(Personaje pj) {
    if (!activa) return false; // ya no colisiona

    Punto centroPlataforma = ((Poligono) this.getFigura()).getCentroide();
    Punto centroPersonaje = ((Poligono) pj.getFigura()).getCentroide();

    double x = centroPlataforma.getX();
    double y = centroPlataforma.getY();

    double px = centroPersonaje.getX();
    double py = centroPersonaje.getY();

    double izquierda = x - Plataforma.ANCHO / 2;
    double derecha = x + Plataforma.ANCHO / 2;
    double abajo = y - Plataforma.ALTO / 2;
    double arriba = y + Plataforma.ALTO / 2;

    return (px >= izquierda && px <= derecha && py >= abajo && py <= arriba);
    }
*/
    @Override
    public void mover(double incX, double incY) {
       // verificarColision();
        this.colocar(incX, incY);
    }

    @Override
    public boolean noHay() {
    return !activa;
    }

}
