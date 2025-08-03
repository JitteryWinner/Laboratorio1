import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Habilidad llamaFinal = new Habilidad("Llama Final", "ataque", 15, 70);
        Habilidad escudoAgua = new Habilidad("Escudo de Agua", "defensa", 20, 60);
        Habilidad impactoRelampago = new Habilidad("Impacto Relampago", "dañoDirecto", 10, 80);
        Habilidad raices = new Habilidad("Raices Curativas", "defensa", 15, 65);

        Pokemones[] pokemon = {
            new Pokemones("Charmander", "Fuego", 50, 30, llamaFinal),
            new Pokemones("Squirtle", "Agua", 45, 35, escudoAgua),
            new Pokemones("Bulbasaur", "Planta", 40, 40, raices),
            new Pokemones("Pikachu", "Electrico", 55, 25, impactoRelampago),
            new Pokemones("Vulpix", "Fuego", 48, 28, llamaFinal),
            new Pokemones("Caterpie", "Planta", 30, 45, raices),
            new Pokemones("Voltorb", "Electrico", 50, 30, impactoRelampago),
            new Pokemones("Cloyster", "Agua", 42, 50, escudoAgua)
        };

        List<Integer> disponibles = new ArrayList<>();
        for (int i = 0; i < pokemon.length; i++) {
            disponibles.add(i);
        }

        System.out.println("Batalla Pokemon");
        System.out.println("Jugador 1, elige a tus 4 Pokemon:");

        while (jugador1.getEquipo().size() < 4) {
            System.out.println("\nPokemones disponibles:");

            
            for (int i = 0; i < disponibles.size(); i++) {
                int indice = disponibles.get(i);
                Pokemones p = pokemon[indice];
                System.out.println((i + 1) + ". " + p.getNombre() + " (" + p.getTipo() + ")");
            }

            System.out.println("Elige un numero (1-" + disponibles.size() + ") ");
            int opcion = sc.nextInt();

            if (opcion < 1 || opcion > disponibles.size()) {
                System.out.println("Opcion invalida.");
            } else {
                int elegido = disponibles.get(opcion - 1);
                jugador1.agregarPokemon(pokemon[elegido]);
                disponibles.remove(opcion - 1);
                System.out.println("Elegiste: " + pokemon[elegido].getNombre());
            }
        }
        for (int i : disponibles) {
            jugador2.agregarPokemon(pokemon[i]);
        }

        Combate combate = new Combate(jugador1, jugador2);

        for (int ronda = 0; ronda < 4; ronda++) {
            Pokemones p1 = jugador1.getPokemon(ronda);
            Pokemones p2 = jugador2.getPokemon(ronda);

            System.out.println("\nRonda" + (ronda + 1));
            System.out.println(jugador1.getNombre() + " usa " + p1.getNombre());
            System.out.println(jugador2.getNombre() + " usa " + p2.getNombre());

            System.out.println("\nJugador 1: Que quieres hacer?");
            System.out.println("1. Ataque normal");
            System.out.println("2. Habilidad especial (" + p1.getHabilidad().getNombre() + ")");
            int decision = sc.nextInt();

            boolean habilidad1Activa = false;
            if (decision == 2 && p1.getHabilidad().activar()) {
                System.out.println(p1.getNombre() + " activo " + p1.getHabilidad().getNombre() + "!");
                p1.getHabilidad().aplicar(p1, p2);
                habilidad1Activa = true;
            }

            boolean habilidad2Activa = false;
            if (random.nextBoolean() && p2.getHabilidad().activar()) {
                System.out.println(p2.getNombre() + " activo " + p2.getHabilidad().getNombre() + "!");
                p2.getHabilidad().aplicar(p2, p1);
                habilidad2Activa = true;
            }

            int resultado = combate.pelear(p1, p2);

            if (resultado == 1) {
                System.out.println("Jugador 1 gana la ronda");
            } else if (resultado == 2) {
                System.out.println("Jugador 2 gana la ronda");
            } else {
                System.out.println("Empate!");
            }

            if (!habilidad1Activa) p1.resetBonus();
            if (!habilidad2Activa) p2.resetBonus();
        }

        System.out.println("\nGanador:");
        if (jugador1.getWins() > jugador2.getWins()) {
            System.out.println("Jugador 1 gana la batalla");
        } else if (jugador2.getWins() > jugador1.getWins()) {
            System.out.println("Jugador 2 gana la batalla");
        } else {
            System.out.println("La batalla termino en empate");
        }
    }
}
