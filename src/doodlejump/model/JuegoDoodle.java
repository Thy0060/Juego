package src.doodlejump.model;

import stdlib.StdDraw;

import src.soporte.Juego2DBase;
import src.soporte.base.Punto;

public class JuegoDoodle extends Juego2DBase {
    protected Personaje jugador;
    protected LdPlataformas plataformas;
    protected LdEnemigos enemigos;
    protected Fondo fondo;
    private double velocidadY = 0;
    private double velocidadX = 0;

    private static final double GRAVEDAD = 0.2;
    private static final double FUERZA_SALTO = 4;
    private static final double VELOCIDAD_MAXIMA = -3;

    public static final int FLECHA_ARRIBA = 38;
    public static final int FLECHA_ABAJO = 40;
    public static final int FLECHA_DERECHA = 39;
    public static final int FLECHA_IZQUIERDA = 37;

    public JuegoDoodle() {
        this.jugador = new Personaje();
        this.plataformas = new LdPlataformas(jugador);
        this.enemigos = new LdEnemigos(jugador);
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
        for(int i = 0; plataformas.size() > i; i ++){
            if(plataformas.get(i) instanceof PlataformaMovil){
                PlataformaMovil movil = (PlataformaMovil) plataformas.get(i); 
                movil.moverHorizontal(); 
            }
        }
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
        if(velocidadY >= VELOCIDAD_MAXIMA)
            velocidadY -= GRAVEDAD;

        jugador.efectuarMovimiento(0,velocidadY);

        if(jugador.getFigura().getCentroide().getY() > 50 && velocidadY > 0){
            plataformas.comprobarPlataformas();
            enemigos.comprobarEnemigos();
            for(int i = 0; i < plataformas.size(); i++)
                plataformas.get(i).mover(0, -velocidadY);
            for(int i = 0; i < enemigos.size(); i++)
                enemigos.get(i).colocar(0,-velocidadY);

            jugador.efectuarMovimiento(0, -velocidadY);
        }
        if(this.hayColision()){       
            velocidadY = FUERZA_SALTO;
        }
    }

        private void manejarMovimientoHorizontal(){
        velocidadX = 0;
        if (StdDraw.isKeyPressed(FLECHA_IZQUIERDA)) 
            velocidadX = -2;
        if (StdDraw.isKeyPressed(FLECHA_DERECHA)) 
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