package src.doodlejump.model;

import stdlib.StdDraw;

public class PlataformaFragil extends Plataforma{
private static final String PLATAFORMA_FRAGIL = "./plataformaFragil.png";

    protected PlataformaFragil(double x, double y, Personaje personajeRef) {
        super(x, y,  0, 0);
        this.getFigura().setColor(StdDraw.LIGHT_GRAY);
        setImage(PLATAFORMA_FRAGIL);
    }
    
}