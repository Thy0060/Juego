package src.doodlejump.model;

import stdlib.StdDraw;
import stdlib.StdRandom;

final class PlataformaMovil extends Plataforma{
private static final String plataformaMovil = "./plataformaMovil.png";

    protected PlataformaMovil(double x, double y) {
        super(x, y, StdRandom.uniformDouble(1,3), 0);
        this.getFigura().setColor(StdDraw.BLUE);
        this.setImage(plataformaMovil);
    }

    protected final void mover(){
        if(this.getFigura().getCentroide().getX() < 0)
            this.colocar(99, 0);
        
        if(this.getFigura().getCentroide().getX() > 100)
            this.colocar(-99, 0);
        
        this.avanzar();
    }

}