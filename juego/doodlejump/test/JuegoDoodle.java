package doodlejump.test;
import juego.Juego2DBase;
import model.base.Circulo;
import model.base.Punto;
import pong.model.Pelota;
import doodlejump.model.Personaje;
import stdlib.StdDraw;
import tads.IList;
import tads.LinkedList;
import doodlejump.model.Plataforma;
public class JuegoDoodle extends Juego2DBase{
    static double vx = .8, vy = -.8;     // velocity

    private static int score = 0;
    private Personaje paleta = new Personaje();
    private IList<Plataforma> plataformas = new LinkedList<>();

    public JuegoDoodle(){
      for (int i=0;i<6;i++){
        plataformas.add(new Plataforma(
          new Circulo(StdDraw.BLUE, new Punto(50, 50), 2), 
          1, vx, vy));
      }
    }

    protected void finalizarJuego() {
      StdDraw.text(50, 50, "Juego Terminado");
      StdDraw.text(50, 60, "Puntos : " + score);
      for(int i=0;i<plataformas.size();i++)
        plataformas.get(i).avanzar();
      StdDraw.show();
    }

    protected boolean comprobarCondicionesSeguirJugando() {
      boolean todosFuera = true;
      for(int i=0;i<plataformas.size();i++){
        todosFuera = todosFuera && plataformas.get(i).getFigura().getCentroide().getY()<0;
      }
      return todosFuera;
    }

    protected void pintarObjetos() {
      paleta.pintar();
      for(int i=0;i<plataformas.size();i++){
         plataformas.get(i).pintar();
      }
    }

    protected void comprobarColisiones() {
      for(int i=0;i<plataformas.size();i++){
        if (paleta.hayColision(plataformas.get(i))){
          plataformas.get(i).recibirImpacto(paleta);
          score +=100;
          if (score%200==0)
          plataformas.get(i).incrementarVelocidad();
          
          plataformas.get(i).avanzar();
        }
      }
    }

    protected void moverObjetos() {
      for(int i=0;i<plataformas.size();i++){
        plataformas.get(i).avanzar();
      }
      paleta.eventoUsuarioRatonMover();
    }

}
