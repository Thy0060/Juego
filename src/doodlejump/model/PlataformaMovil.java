package src.doodlejump.model;

import stdlib.StdDraw;
import stdlib.StdRandom;

public class PlataformaMovil extends Plataforma{
public static final String PLATAFORMA_MOVIL = "./plataformaMovil.png";

    public PlataformaMovil(double x, double y, Personaje personajeRef) {
        super(x, y, personajeRef, StdRandom.uniformDouble(1,3), 0);
        this.getFigura().setColor(StdDraw.BLUE);
        this.setImage(PLATAFORMA_MOVIL);
    }

    public void mover(){
        if(this.getFigura().getCentroide().getX() < 0)
            this.colocar(99, 0);
        
        if(this.getFigura().getCentroide().getX() > 100)
            this.colocar(-99, 0);
        
        this.avanzar();
    }

}