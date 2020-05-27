package fr.mael.showndownAI.pokemonData;

import java.util.HashMap;
import java.util.Map;

public class Pokedex {

	private Map<PokeType, Double[]> attackEfficencyTable;

	private Pokedex() {
		attackEfficencyTable = new HashMap<>();
		attackEfficencyTable.put(PokeType.BUG,
				new Double[] { 1d, 2d, 1d, 1d, 0.5, 0.5, 0.5, 0.5, 0.5, 2d, 1d, 1d, 1d, 0.5, 2d, 1d, 0.5, 1d });
		attackEfficencyTable.put(PokeType.DARK,
				new Double[] { 1d, 0.5, 1d, 1d, 0.5, 0.5, 1d, 1d, 2d, 1d, 1d, 1d, 1d, 1d, 2d, 1d, 1d, 1d });
		attackEfficencyTable.put(PokeType.DRAGON,
				new Double[] { 1d, 1d, 2d, 1d, 0d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 0.5, 1d });
		attackEfficencyTable.put(PokeType.ELECTRIC,
				new Double[] { 1d, 1d, 0.5, 0.5, 1d, 1d, 1d, 2d, 1d, 0.5, 0d, 1d, 1d, 1d, 1d, 1d, 1d, 2d });
		attackEfficencyTable.put(PokeType.FAIRY,
				new Double[] { 1d, 2d, 2d, 1d, 1d, 2d, 0.5, 1d, 1d, 1d, 1d, 1d, 1d, 0.5, 1d, 1d, 0.5, 1d });
		attackEfficencyTable.put(PokeType.FIGHTING,
				new Double[] { 0.5, 2d, 1d, 1d, 1d, 0.5, 1d, 0.5, 0d, 1d, 1d, 2d, 2d, 0.5, 0.5, 2d, 2d, 1d });
		attackEfficencyTable.put(PokeType.FIRE,
				new Double[] { 2d, 1d, 0.5, 1d, 1d, 1d, 0.5, 1d, 2d, 1d, 2d, 1d, 1d, 1d, 1d, 0.5, 2d, 0.5 });
		attackEfficencyTable.put(PokeType.FLYING,
				new Double[] { 2d, 1d, 1d, 0.5, 1d, 2d, 1d, 1d, 1d, 2d, 1d, 1d, 1d, 1d, 1d, 0.5, 0.5, 1d });
		attackEfficencyTable.put(PokeType.GHOST,
				new Double[] { 1d, 0.5, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 2d, 1d, 0d, 1d, 2d, 1d, 1d, 1d });
		attackEfficencyTable.put(PokeType.GRASS,
				new Double[] { 0.5, 1d, 0.5, 1d, 1d, 1d, 0.5, 0.5, 1d, 0.5, 2d, 1d, 1d, 0.5, 1d, 2d, 0.5, 2d });
		attackEfficencyTable.put(PokeType.GROUND,
				new Double[] { 0.5, 1d, 1d, 2d, 1d, 2d, 1d, 0d, 1d, 0.5, 1d, 1d, 1d, 2d, 1d, 2d, 2d, 1d });
		attackEfficencyTable.put(PokeType.ICE,
				new Double[] { 1d, 1d, 2d, 1d, 1d, 1d, 0.5, 2d, 1d, 2d, 2d, 0.5, 1d, 1d, 1d, 1d, 0.5, 0.5 });
		attackEfficencyTable.put(PokeType.NORMAL,
				new Double[] { 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 0d, 1d, 1d, 1d, 1d, 1d, 1d, 0.5, 0.5, 1d });
		attackEfficencyTable.put(PokeType.POISON,
				new Double[] { 1d, 1d, 1d, 1d, 2d, 1d, 1d, 1d, 0.5, 2d, 0.5, 1d, 1d, 0.5, 1d, 0.5, 0d, 1d });
		attackEfficencyTable.put(PokeType.PSYCHIC,
				new Double[] { 1d, 0d, 1d, 1d, 1d, 2d, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 2d, 0.5, 1d, 0.5, 1d });
		attackEfficencyTable.put(PokeType.ROCK,
				new Double[] { 2d, 1d, 1d, 1d, 1d, 0.5, 2d, 2d, 1d, 1d, 0.5, 2d, 1d, 1d, 1d, 1d, 0.5, 1d });
		attackEfficencyTable.put(PokeType.STEEL,
				new Double[] { 1d, 1d, 1d, 0.5, 2d, 1d, 0.5, 1d, 1d, 1d, 1d, 2d, 1d, 1d, 1d, 2d, 0.5, 0.5 });
		attackEfficencyTable.put(PokeType.WATER,
				new Double[] { 1d, 1d, 0.5, 1d, 1d, 2d, 1d, 1d, 1d, 0.5, 2d, 1d, 1d, 1d, 1d, 2d, 1d, 0.5 });

	}

	/** Holder */
	private static class PokedexHolder {
		private final static Pokedex instance = new Pokedex();
	}

	/** Access Point */
	public static Pokedex getInstance() {
		return PokedexHolder.instance;
	}

}
