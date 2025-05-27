package src.doodlejump.model;

import tads.*;
import stdlib.StdRandom;

public class LdEnemigos {
    protected IList<Enemigo> enemigos = new ArrayList<>();
    private Personaje personajeRef;
    protected String[] fotosEnemigos = {"./enemigo1.png", "./enemigo2.png", "./enemigo3.png"};

    public LdEnemigos(Personaje personajeRef){
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), 300, personajeRef, fotosEnemigos[StdRandom.uniformInt(0,3)]));
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), 500, personajeRef, fotosEnemigos[StdRandom.uniformInt(0,3)]));
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), 700, personajeRef, fotosEnemigos[StdRandom.uniformInt(0,3)]));
    }

    public void comprobarEnemigos(){
        if(enemigos.get(0).getFigura().getCentroide().getY() < 0)
            generarNuevoEnemigo();
    }

    public void generarNuevoEnemigo(){
        enemigos.remove(0);
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), enemigos.get(enemigos.size()-1).getFigura().getCentroide().getY() + StdRandom.uniformDouble(100, 300), personajeRef, fotosEnemigos[StdRandom.uniformInt(0,2)]));
    }

    public Enemigo get(int i){
        return enemigos.get(i);
    }

    public int size(){
        return enemigos.size();
    }

    public void add(int i, Enemigo enemigo){
        this.enemigos.add(i, enemigo);
    }

    public void remove(int i) {
        this.enemigos.remove(i);
    }

    public void pintar(){
        for(int i = 0; i < enemigos.size(); i++){
            enemigos.get(i).pintar();
        }
    }
    
    public void mover(){
        for(int i = 0; i < enemigos.size(); i++){
            if (enemigos.get(i).getFigura().getCentroide().getX()<0 || enemigos.get(i).getFigura().getCentroide().getX()>100 )
                enemigos.get(i).setIncX(-enemigos.get(i).getIncX());
            enemigos.get(i).avanzar();
        }

    }
}