package src.doodlejump.model;

import stdlib.StdDraw;

public class PlataformaFragil extends Plataforma{
public static final String plataformaFragil = "./plataformaFragil.png";

    public PlataformaFragil(double x, double y, Personaje personajeRef) {
        super(x, y, personajeRef, 0, 0);
        this.getFigura().setColor(StdDraw.LIGHT_GRAY);
        setImage(plataformaFragil);
    }
    
    @Override
    public void mover(double incX, double incY) {
        this.colocar(incX, incY);
    }

}