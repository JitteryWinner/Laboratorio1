import java.util.Random;

public class Habilidad {
    private String nombre;
    private String tipoEfecto;
    private int valor;
    private int probabilidad;

    public Habilidad(String nombre, String tipoEfecto, int valor, int probabilidad) {
        this.nombre = nombre;
        this.tipoEfecto = tipoEfecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }

    public String getNombre() { return nombre; }
    public String getTipoEfecto() { return tipoEfecto; }
    public int getValor() { return valor; }

    public boolean activar() {
        Random r = new Random();
        int numero = r.nextInt(101);
        return numero <= probabilidad;
    }

    public void aplicar(Pokemones propio, Pokemones rival) {
        if (tipoEfecto.equals("ataque")) propio.aplicarBonusAtaque(valor);
        if (tipoEfecto.equals("defensa")) propio.aplicarBonusDefensa(valor);
        if (tipoEfecto.equals("dañoDirecto")) rival.reducirAtaque(valor);
    }
}
