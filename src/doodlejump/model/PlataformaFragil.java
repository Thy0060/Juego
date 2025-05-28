package src.doodlejump.model;

import stdlib.StdDraw;

final class PlataformaFragil extends Plataforma{
    private static final String PLATAFORMA_FRAGIL = "./plataformaFragil.png";

    protected PlataformaFragil(double x, double y) {
        super(x, y,  0, 0);
        this.getFigura().setColor(StdDraw.LIGHT_GRAY);
        setImage(PLATAFORMA_FRAGIL);
    }
    
}