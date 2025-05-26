package doodlejump.model;

import tads.*;
import stdlib.StdRandom;
public class LdEnemigos {
    protected IList<Enemigo> enemigos = new ArrayList<>();
    private Personaje personajeRef;


    public LdEnemigos(Personaje personajeRef){
        for(int i = 0;i<10;i++){
            enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), (i+1)*300, personajeRef));
        }
    }
    public void comprobarEnemigos(){
        for(int i = 0; i < enemigos.size(); i++){
            if(enemigos.get(i).getFigura().getCentroide().getY() < 0){
                generarNuevoEnemigo();
            }
        }
        
    }
    public void generarNuevoEnemigo(){
        enemigos.remove(0);
        enemigos.add(new Enemigo(StdRandom.uniformDouble(5,95), enemigos.get(enemigos.size()-1).getFigura().getCentroide().getY() + 300, personajeRef));
    }

    public Enemigo get(int i){
        return enemigos.get(i);
    }

    public int size(){
        return enemigos.size();
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