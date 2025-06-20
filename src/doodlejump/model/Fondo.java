package src.doodlejump.model;

import java.util.Arrays;

import src.soporte.ObjetoGrafico;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;

final class Fondo extends ObjetoGrafico {
    private static final String fondo = "./fondo.png";

    protected Fondo(){
        super(new Poligono(java.awt.Color.GREEN, new Punto(50,50), 
            Arrays.asList(new Punto(0,0),
                new Punto(100,0), 
                new Punto(100,100), 
                new Punto(0,100))), 
            5000);

        setImage(fondo);
    }

    public void recibirImpacto(ObjetoGrafico otrafigura){}
}