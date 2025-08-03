import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Pokemones> equipo;
    private int wins;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        this.wins = 0;
    }

    public void agregarPokemon(Pokemones p) {
        equipo.add(p);
    }

    public Pokemones getPokemon(int index) {
        return equipo.get(index);
    }

    public List<Pokemones> getEquipo() {
        return equipo;
    }

    public void ganarRonda() {
        wins++;
    }

    public int getWins() {
        return wins;
    }

    public String getNombre() {
        return nombre;
    }
}
