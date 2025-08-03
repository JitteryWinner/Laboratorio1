public class Combate {
    private Jugador jugador1;
    private Jugador jugador2;

    public Combate(Jugador j1, Jugador j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
    }

    public int calcularEfectoTipo(String atacante, String defensor) {
        if (atacante.equals("Fuego") && defensor.equals("Planta")) return 20;
        if (atacante.equals("Planta") && defensor.equals("Agua")) return 20;
        if (atacante.equals("Agua") && defensor.equals("Fuego")) return 20;
        if (atacante.equals("Electrico") && defensor.equals("Agua")) return 20;

        if (atacante.equals("Fuego") && defensor.equals("Agua")) return -10;
        if (atacante.equals("Agua") && defensor.equals("Planta")) return -10;
        if (atacante.equals("Planta") && defensor.equals("Fuego")) return -10;
        if (atacante.equals("Agua") && defensor.equals("Electrico")) return -10;

        return 0;
    }

    public int pelear(Pokemones p1, Pokemones p2) {
        int efecto1 = calcularEfectoTipo(p1.getTipo(), p2.getTipo());
        int efecto2 = calcularEfectoTipo(p2.getTipo(), p1.getTipo());

        int ataqueTotal1 = p1.getAtaque() - p2.getDefensa() + efecto1;
        int ataqueTotal2 = p2.getAtaque() - p1.getDefensa() + efecto2;

        // Mostrar el daño causado por cada Pokemon
        System.out.println(p1.getNombre() + " hizo " + ataqueTotal1 + " de dano " + p2.getNombre());
        System.out.println(p2.getNombre() + " hizo " + ataqueTotal2 + " de dano " + p1.getNombre());

        if (ataqueTotal1 > ataqueTotal2) {
            jugador1.ganarRonda();
            return 1;
        } else if (ataqueTotal2 > ataqueTotal1) {
            jugador2.ganarRonda();
            return 2;
        } else {
            return 0;
        }
    }
}
