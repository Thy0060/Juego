package src.doodlejump.model;

import tads.*;
import stdlib.StdRandom;

final class LdEnemigos {
    protected final IList<Enemigo> enemigos = new ArrayList<>();

    protected LdEnemigos(){
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), 300));
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), 500));
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), 700));
    }

    protected final void comprobarEnemigos(){
        if(enemigos.get(0).getFigura().getCentroide().getY() < 0)
            generarNuevoEnemigo();
    }

    protected final void generarNuevoEnemigo(){
        enemigos.remove(0);
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), enemigos.get(enemigos.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(100, 300)));
    }

    protected final Enemigo get(int i){
        return enemigos.get(i);
    }

    protected final int size(){
        return enemigos.size();
    }

    protected final void add(int i, Enemigo enemigo){
        this.enemigos.add(i, enemigo);
    }

    protected final void remove(int i) {
        this.enemigos.remove(i);
    }

    protected final void pintar(){
        for(int i = 0; i < enemigos.size(); i++){
            enemigos.get(i).pintar();
        }
    }
    
    protected final void mover(){
        for(int i = 0; i < enemigos.size(); i++){
            if (enemigos.get(i).getFigura().getCentroide().getX()<0 || enemigos.get(i).getFigura().getCentroide().getX()>100 )
                enemigos.get(i).setIncX(-enemigos.get(i).getIncX());
            enemigos.get(i).avanzar();
        }
    }
}