package doodlejump.model;
import tads.*;
import stdlib.StdRandom;
public class LdPlataformas {
    protected IList<Plataforma> plataformas = new ArrayList<>();
    private Personaje personajeRef;
    protected static int puntuacion = 0;

    public LdPlataformas(Personaje personajeRef){
        this.personajeRef = personajeRef;
        for(int i = 0;i<4;i++){
            plataformas.add(new Plataforma(StdRandom.uniformDouble(5,95), (i+1)*30, personajeRef, 0, 0));
            if(i==0)
                plataformas.set(i, new Plataforma(50, 30, personajeRef, 0, 0));
        }
    }

    public void comprobarPlataformas(){
        if(plataformas.get(0).getFigura().getCentroide().getY()<0){
            generarNuevaPlataforma();
        }
    }
    public void comprobarPlataformasFragiles(){
        PlataformaFragil actual = null;
        for(int i = 0; i < plataformas.size(); i++){
            if(plataformas.get(i) instanceof PlataformaFragil){
                actual = (PlataformaFragil) plataformas.get(i);
                if(actual.hayColision(this.personajeRef) && (this.personajeRef.getFigura().getCentroide().getY() - 6 >= actual.getFigura().getCentroide().getY()))
                    this.plataformas.remove(i);
            }
        }
    }

    public void generarNuevaPlataforma(){
        plataformas.remove(0);
        LdPlataformas.puntuacion += 10;
        int tipo = StdRandom.uniformInt(0, 6);
        if(tipo < 4){
            plataformas.add(new Plataforma(StdRandom.uniformDouble(5,95), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(20, 30), personajeRef, 0,0 ));
            LdPlataformas.puntuacion += 25;
        }
        if(tipo == 5 || tipo == 4){
            plataformas.add(new PlataformaMovil(StdRandom.uniformDouble(5,95), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(10, 30), personajeRef));
            LdPlataformas.puntuacion += 75;
        }
        else{
            plataformas.add(new PlataformaFragil(StdRandom.uniformDouble(5,95), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(10, 30), personajeRef));
            LdPlataformas.puntuacion += 50;
        }
    }
    
    public Plataforma get(int i){
        return plataformas.get(i);
    }
    
    public int size(){
        return plataformas.size();
    }

    public void pintar() {
        for (int i = 0; i < plataformas.size(); i++) {
            plataformas.get(i).pintar();
        }
    }

}

