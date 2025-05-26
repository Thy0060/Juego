package doodlejump.model;

public class PlataformaMovil extends Plataforma {
    private double direccion = 1.5;
    private final double LIMITE_IZQ = 20;
    private final double LIMITE_DER = 80;

    public PlataformaMovil(double x, double y) {
        super(x, y);
        getFigura().setColor(java.awt.Color.ORANGE);
        setIncX(direccion);
    }

    @Override
    public void actualizar(double deltaTime) {
        super.actualizar(deltaTime);
        
        // Cambiar dirección al llegar a los límites
        if(getFigura().getCentroide().getX() > LIMITE_DER || 
           getFigura().getCentroide().getX() < LIMITE_IZQ) {
            setIncX(-getIncX());
        }
    }
}
