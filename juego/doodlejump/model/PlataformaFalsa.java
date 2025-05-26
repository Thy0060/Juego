package doodlejump.model;

import stdlib.StdDraw;
import model.ObjetoGrafico;
public class PlataformaFalsa extends Plataforma{
    public PlataformaFalsa(double x, double y, Personaje personajeRef) {
        super(x, y, personajeRef);
        getFigura().setColor(StdDraw.LIGHT_GRAY);
    }

    @Override
    public void recibirImpacto(ObjetoGrafico otraFigura) {
        if(activa && otraFigura instanceof Personaje) {
            activa = false;
            getFigura().setColor(new Color(0,0,0,0)); // Hacer transparente
        }
    }
}
