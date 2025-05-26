package doodlejump.model;

import stdlib.StdDraw;
import juego.Juego2DBase;
import model.base.Punto;
public class JuegoPersonaje extends Juego2DBase {
    protected Personaje jugador;
    protected LdPlataformas plataformas = null;
    protected LdEnemigos enemigos = null;
    private double velocidadY = 0;
    private double velocidadX = 0;
    private static final double GRAVEDAD = 0.3;
    private static final double FUERZA_SALTO = 5;
    private static final double VELOCIDAD_MAXIMA = -4;

    public static final int FLECHA_ARRIBA = 38;
    public static final int FLECHA_ABAJO = 40;
    public static final int FLECHA_DERECHA = 39;
    public static final int FLECHA_IZQUIERDA = 37;

    public JuegoPersonaje() {
        this.jugador = new Personaje();
        this.plataformas = new LdPlataformas(jugador);
        this.enemigos = new LdEnemigos(jugador);
        jugador.setImage("./doodle.png");
    }

    private void manejarMovimientoVertical(){
        if(velocidadY > VELOCIDAD_MAXIMA)
            velocidadY -= GRAVEDAD;

        jugador.efectuarMovimiento(0,velocidadY);

        if(jugador.getFigura().getCentroide().getY() > 50 && velocidadY > 0){
            plataformas.comprobarPlataformas();
            for(int i = 0; i < plataformas.size(); i++){
                plataformas.get(i).mover(0, -velocidadY);
            }
            jugador.efectuarMovimiento(0, -velocidadY);
        }
        if (hayColision()) {   
            velocidadY = FUERZA_SALTO;     
        }

    }
    private boolean hayColision(){
        boolean colision = false;

        for(int i = 0; 
        i < plataformas.size() 
        && !colision
        && jugador.getFigura().getCentroide().getY() >= plataformas.get(i).getFigura().getCentroide().getY()
        && velocidadY<0; i++){
            colision = plataformas.get(i).hayColision(jugador);
        }
        return colision;
    }
    private boolean hayColisionEnemigo(){
        return enemigos.get(0).hayColision(jugador);
    }

    private void manejarMovimientoHorizontal(){
        velocidadX = 0;
        if (StdDraw.isKeyPressed(FLECHA_IZQUIERDA)) 
            velocidadX = -3;
        if (StdDraw.isKeyPressed(FLECHA_DERECHA)) 
            velocidadX = 3; 
        jugador.efectuarMovimiento(velocidadX, 0);
    }
    private void moverEnemigos(){
        boolean derecha = true;
        for(int i = 0; i < enemigos.size(); i++){
            if(derecha && enemigos.get(i).getFigura().getCentroide().getX() > 100){
                derecha = false;
            }
            if(!derecha && enemigos.get(i).getFigura().getCentroide().getX() < 0){
                derecha = true;
            }
            if(derecha)
                enemigos.get(i).mover(2, 0);
            else
                enemigos.get(i).mover(-2, 0);
        }
    }
    @Override
    protected void finalizarJuego() {
        StdDraw.text(50, 50, "¡Juego Terminado!");
        StdDraw.text(50, 40, "Puntuacion: " + LdPlataformas.puntuacion);
        StdDraw.show();
    }

    @Override
    protected boolean comprobarCondicionesSeguirJugando() {
        return jugador.getFigura().getCentroide().getY() < 0 || hayColisionEnemigo();
    }

    @Override
    protected void pintarObjetos() {
        jugador.pintar();
        plataformas.pintar();
        enemigos.pintar();
    }

    @Override
    protected void comprobarColisiones() {
        Punto centro = jugador.getFigura().getCentroide();
        if (centro.getX() < 0)
            jugador.efectuarMovimiento(99, 0);
        if(centro.getX() > 100)
            jugador.efectuarMovimiento(-99, 0);
    }
    @Override
    protected void moverObjetos() {
        manejarMovimientoVertical();
        manejarMovimientoHorizontal();
        plataformas.comprobarPlataformas();
        enemigos.comprobarEnemigos();
        moverEnemigos();
        
        for(int i = 0; plataformas.size() > i; i ++){
            if(plataformas.get(i) instanceof PlataformaMovil){
                PlataformaMovil movil = (PlataformaMovil) plataformas.get(i); 
                movil.mover(); 
            }
        }
    }
}