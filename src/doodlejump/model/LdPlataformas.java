package src.doodlejump.model;

import tads.*;
import stdlib.StdRandom;

final class LdPlataformas {
    protected final IList<Plataforma> plataformas = new ArrayList<>();
    private static int puntuacion = 0;
    
    protected static int getPuntuacion() {
        return puntuacion;
    }

    protected LdPlataformas(){
        for(int i = 0; i <= 4; i++){
            if(i==0){
                plataformas.add(new Plataforma(50, 30, 0, 0));
                plataformas.add(new Plataforma(StdRandom.uniformDouble(5,45), 50, 0, 0));
                plataformas.add(new Plataforma(StdRandom.uniformDouble(55,95), 50, 0, 0));
            }
            else{
                plataformas.add(new Plataforma(StdRandom.uniformDouble(5,45), (i+3)*20, 0, 0));
                plataformas.add(new Plataforma(StdRandom.uniformDouble(55,95), (i+3)*20, 0, 0));
            }
        }
        LdPlataformas.puntuacion = 0;
    }

    protected final void comprobarPlataformas(){
        if(plataformas.get(0).getFigura().getCentroide().getY()<0)
            generarNuevaPlataforma();
    }

    protected final void generarNuevaPlataforma(){
        plataformas.remove(0);

        int tipo = StdRandom.uniformInt(0, 4);
        if(tipo < 2){
            plataformas.add(new Plataforma(StdRandom.uniformDouble(5,45), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(10, 15), 0,0 ));
            plataformas.add(new Plataforma(StdRandom.uniformDouble(55,95), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(10, 15), 0,0));
            LdPlataformas.puntuacion += 5;
        }
        if(tipo == 2){
            plataformas.add(new PlataformaMovil(StdRandom.uniformDouble(5,95), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(10, 15)));
            plataformas.add(new Plataforma(StdRandom.uniformDouble(5,95), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(10, 15), 0,0));
            LdPlataformas.puntuacion += 10;
        }
        else{
            plataformas.add(new PlataformaFragil(StdRandom.uniformDouble(5,95), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(10, 15)));
            plataformas.add(new Plataforma(StdRandom.uniformDouble(5,95), plataformas.get(plataformas.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(10, 15), 0,0));
            LdPlataformas.puntuacion += 10;
        }
    }
    
    protected final Plataforma get(int i){
        return plataformas.get(i);
    }
    
    protected final int size(){
        return plataformas.size();
    }

    protected final void pintar() {
        for (int i = 0; i < plataformas.size(); i++) {
            plataformas.get(i).pintar();
        }
    }

    protected final void add(int i, Plataforma plataforma){
        this.plataformas.add(i, plataforma);
    }

    protected final void remove(int i) {
        this.plataformas.remove(i);
    }

    protected final void mover(){
    for(int i = 0; plataformas.size() > i; i ++){
            if(plataformas.get(i) instanceof PlataformaMovil){
                PlataformaMovil movil = (PlataformaMovil) plataformas.get(i); 
                movil.mover(); 
            }
        }
    }

}