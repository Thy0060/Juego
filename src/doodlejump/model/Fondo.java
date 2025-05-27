package src.doodlejump.model;
import src.soporte.ObjetoGrafico;
import src.soporte.base.Poligono;
import src.soporte.base.Punto;
import java.util.Arrays;
public class Fondo extends ObjetoGrafico {
    public static final String FONDO_IMAGE = "./fondo.png";
    public Fondo(){
        super(new Poligono(java.awt.Color.GREEN, new Punto(50,50), 
        Arrays.asList(new Punto(0,0),
         new Punto(100,0), 
         new Punto(100,100), 
         new Punto(0,100))), 5000);
        setImage(FONDO_IMAGE);
    }
    public void recibirImpacto(ObjetoGrafico otrafigura){}
}
