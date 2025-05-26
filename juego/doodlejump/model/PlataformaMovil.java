package doodlejump.model;

import java.util.Arrays;
import java.util.Random;

import model.ObjetoGrafico;
import model.base.IFigura;
import model.base.Poligono;
import model.base.Punto;
import stdlib.StdDraw;
import stdlib.StdRandom;

public class PlataformaMovil extends Plataforma{
    public static final double ANCHO = 12;
    public static final double ALTO = 3;
    public Personaje personajeRef = null;
    protected boolean activa = true;
    protected boolean colision = false;

    public PlataformaMovil(double x, double y, Personaje personajeRef) {
        super(x, y, personajeRef, StdRandom.uniformDouble(1,3), 0);
        this.getFigura().setColor(StdDraw.BLUE);
    }

    public boolean estaActiva() {
        return activa;
    }

    public void mover(double incX, double incY){
        this.colocar(incX, incY);
    }

    public void recibirImpacto(ObjetoGrafico f){}

    public void mover(){
        if(this.getFigura().getCentroide().getX() < 0)
            this.colocar(99, 0);
        
        if(this.getFigura().getCentroide().getX() > 100)
            this.colocar(-99, 0);
        
        this.avanzar();
    }

}