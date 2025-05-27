package src.doodlejump.model;

import src.soporte.Juego2DBase;
import src.soporte.base.Punto;
import stdlib.StdDraw;
public class JuegoPersonaje extends Juego2DBase {
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

    public JuegoPersonaje() {
        this.jugador = new Personaje();
        this.plataformas = new LdPlataformas(jugador);
        this.enemigos = new LdEnemigos(jugador);
        this.fondo = new Fondo();
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
            plataformas.comprobarPlataformasFragiles();     
            velocidadY = FUERZA_SALTO;
        }
    }

    private boolean hayColision(){
        boolean colision = false;

        for(int i = 0; i < 5 && !colision && jugador.getFigura().getCentroide().getY() >= plataformas.get(i).getFigura().getCentroide().getY() && velocidadY < 0.5; i++){
            colision = plataformas.get(i).hayColision(jugador);
            
            if(colision && plataformas.get(i) instanceof PlataformaFragil){
                plataformas.comprobarPlataformasFragiles();
            }
        }
        return colision;
    }

    private boolean hayColisionEnemigo(){
        return enemigos.get(0).hayColision(jugador);
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
    protected void finalizarJuego() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(50, 60, "¡Juego Terminado!");
        StdDraw.text(50, 50, "Puntuación: " + LdPlataformas.puntuacion);
        StdDraw.text(50, 40, "Pulsa 'R' para reiniciar");
        StdDraw.show();

        while (!StdDraw.isKeyPressed('R') && !StdDraw.isKeyPressed('r')) {
            StdDraw.pause(50);
        }

        while (StdDraw.isKeyPressed('R') || StdDraw.isKeyPressed('r')) {
            StdDraw.pause(50);
        }

        reiniciar();
        jugar();    
    }

    @Override
    protected boolean comprobarCondicionesSeguirJugando() {
        return !(jugador.getFigura().getCentroide().getY() < 0 || hayColisionEnemigo());
    }
    

    @Override
    protected void pintarObjetos() {
        fondo.pintar();
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
        enemigos.mover();
        for(int i = 0; plataformas.size() > i; i ++){
            if(plataformas.get(i) instanceof PlataformaMovil){
                PlataformaMovil movil = (PlataformaMovil) plataformas.get(i); 
                movil.moverHorizontal(); 
            }
        }
    }

    public void reiniciar() {
        this.jugador = new Personaje();
        this.velocidadX = 0;
        this.velocidadY = 0;

        this.plataformas = new LdPlataformas(jugador);
        this.enemigos = new LdEnemigos(jugador);
        this.fondo = new Fondo();

        LdPlataformas.puntuacion = 0;
    }
}