package src.doodlejump.model;

import stdlib.StdDraw;

import src.soporte.Juego2DBase;
import src.soporte.base.Punto;

public class JuegoDoodle extends Juego2DBase {
    private final Personaje jugador;
    private final LdPlataformas plataformas;
    private final LdEnemigos enemigos;
    private final Fondo fondo;
    private double velocidadY = 0;
    private double velocidadX = 0;

    private static final double gravedad = 0.2;
    private static final double fuerzaSalto = 4;
    private static final double velocidadMax = -3;

    protected static final int flechaArriba = 38;
    protected static final int flechaAbajo = 40;
    protected static final int flechaDerecha = 39;
    protected static final int flechaIzquierda = 37;

    public JuegoDoodle(){
        this.jugador = new Personaje();
        this.plataformas = new LdPlataformas();
        this.enemigos = new LdEnemigos();
        this.fondo = new Fondo();
    }

    @Override
    protected void comprobarColisiones(){
        Punto centro = jugador.getFigura().getCentroide();
        if (centro.getX() < 0)
            jugador.efectuarMovimiento(99, 0);
        if(centro.getX() > 100)
            jugador.efectuarMovimiento(-99, 0);
    }

    @Override
    protected void moverObjetos(){
        manejarMovimientoVertical();
        manejarMovimientoHorizontal();
        plataformas.comprobarPlataformas();
        enemigos.comprobarEnemigos();
        enemigos.mover();
        plataformas.mover();
    }

    private boolean hayColision(){
        boolean colision = false;

        for(int i = 0; i < 5 && !colision && jugador.getFigura().getCentroide().getY() >= plataformas.get(i).getFigura().getCentroide().getY() && velocidadY < 0.5; i++){
            colision = plataformas.get(i).hayColision(jugador);
            
            if(colision && plataformas.get(i) instanceof PlataformaFragil){
                this.plataformas.remove(i);
            }
        }
        return colision;
    }

    private void manejarMovimientoVertical(){
        if(velocidadY >= velocidadMax)
            velocidadY -= gravedad;

        jugador.efectuarMovimiento(0,velocidadY);

        if(jugador.getFigura().getCentroide().getY() > 50 && velocidadY > 0){
            for(int i = 0; i < plataformas.size(); i++)
                plataformas.get(i).colocar(0, -velocidadY);
            for(int i = 0; i < enemigos.size(); i++)
                enemigos.get(i).colocar(0,-velocidadY);

            jugador.efectuarMovimiento(0, -velocidadY);
        }
        if(this.hayColision()){       
            velocidadY = fuerzaSalto;
        }
    }

    private void manejarMovimientoHorizontal(){
        velocidadX = 0;
        if (StdDraw.isKeyPressed(flechaIzquierda)) 
            velocidadX = -2;
        if (StdDraw.isKeyPressed(flechaDerecha)) 
            velocidadX = 2; 
        jugador.efectuarMovimiento(velocidadX, 0);
    }

    @Override
    protected void pintarObjetos(){
        fondo.pintar();
        jugador.pintar();
        plataformas.pintar();
        enemigos.pintar();
    }

    @Override
    protected boolean comprobarCondicionesSeguirJugando(){
        return jugador.getFigura().getCentroide().getY() < 0 || enemigos.get(0).hayColision(jugador);
    }

    public void finalizarJuego(){
        StdDraw.text(50, 50, "¡Juego Terminado!");
        StdDraw.text(50, 45, "Puntuación: " + LdPlataformas.getPuntuacion());
        StdDraw.text(50, 40, "Pulsa 'R' para reiniciar");
        StdDraw.show();
    }
    
}