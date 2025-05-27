package src.doodlejump.model;

import java.util.Arrays;

import src.soporte.ObjetoGrafico;
import src.soporte.ObjetoGraficoMovil;
import src.soporte.base.IFigura;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;

public class Plataforma extends ObjetoGraficoMovil {
    private static final double ANCHO = 12;
    private static final double ALTO = 3;
    private static final String PLATAFORMA = "./plataforma.png";

    protected Plataforma(double x, double y, double incX, double incY){
        super(crearFigura(x, y), 1, incX, incY);
        this.setImage(PLATAFORMA);
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