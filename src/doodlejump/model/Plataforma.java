package src.doodlejump.model;

import java.util.Arrays;

import src.soporte.ObjetoGrafico;
import src.soporte.ObjetoGraficoMovil;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;

public class Plataforma extends ObjetoGraficoMovil {
    private static final double ancho = 12;
    private static final double alto = 3;
    private static final String plataforma = "./plataforma.png";

    protected Plataforma(double x, double y, double incX, double incY){
        super(new Poligono(java.awt.Color.GREEN, new Punto(x, y),
            Arrays.asList(
                new Punto(x - ancho/2, y - alto/2),
                new Punto(x + ancho/2, y - alto/2),
                new Punto(x + ancho/2, y + alto/2),
                new Punto(x - ancho/2, y + alto/2))), 
            2000, incX, incY);
        this.setImage(plataforma);
    }
    
    public void recibirImpacto(ObjetoGrafico f){}

}