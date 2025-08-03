public class Pokemones {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private Habilidad habilidad;
    private int bonusAtaque = 0;
    private int bonusDefensa = 0;

    public Pokemones(String nombre, String tipo, int ataque, int defensa, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public Habilidad getHabilidad() { return habilidad; }

    public int getAtaque() {
        return ataque + bonusAtaque;
    }

    public int getDefensa() {
        return defensa + bonusDefensa;
    }

    public void resetBonus() {
        bonusAtaque = 0;
        bonusDefensa = 0;
    }

    public void aplicarBonusAtaque(int valor) {
        bonusAtaque += valor;
    }

    public void aplicarBonusDefensa(int valor) {
        bonusDefensa += valor;
    }

    public void reducirAtaque(int valor) {
        bonusAtaque -= valor;
    }
}
