package src.doodlejump.model;

import stdlib.StdDraw;
import stdlib.StdRandom;

public class PlataformaMovil extends Plataforma{

    public PlataformaMovil(double x, double y, Personaje personajeRef, String imagenPlataforma) {
        super(x, y, personajeRef, StdRandom.uniformDouble(1,3), 0, imagenPlataforma);
        this.getFigura().setColor(StdDraw.BLUE);
    }

    public void moverHorizontal(){
        if(this.getFigura().getCentroide().getX() < 0)
            this.colocar(99, 0);
        
        if(this.getFigura().getCentroide().getX() > 100)
            this.colocar(-99, 0);
        
        this.avanzar();
    }

}