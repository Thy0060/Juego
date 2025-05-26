package doodlejump.model;

import stdlib.StdDraw;

public class PlataformaFragil extends Plataforma{
    protected boolean activa = true;

    public PlataformaFragil(double x, double y, Personaje personajeRef) {
        super(x, y, personajeRef, 0, 0);
        this.getFigura().setColor(StdDraw.LIGHT_GRAY);
    }
    
    public void activar(){
        this.activa = true;
    }
    public void desactivar(){
        this.activa = false;
    }
    @Override
    public void pintar() {
        this.getFigura().pintar(); 
    }

    public boolean estaActiva() {
        return activa;
    }

    @Override
    public void mover(double incX, double incY) {
        this.colocar(incX, incY);
    }

}
