package fr.mael.showndownAI.pokemonData;

import java.util.HashMap;
import java.util.Map;


public class Pokedex {

	private Map<PokeType, Map<PokeType, Integer>> attackEfficencyTable;
	
	private Pokedex() {
		attackEfficencyTable = new HashMap<>();
		
	}
	/*
	
	NORMAL => Rock 1/2, Ghost 0, Steel 1/2
	FIRE => Fire 1/2, Water 1/2, Grass 2, Ice 2, Bug 2, Rock 1/2, Dragon 1/2, Steel 2
	WATER => Fire 2, Water 1/2, Grass 1/2, Ground 2, Rock 2, Dragon 1/2, 
	ELECTRIC => Water 2, Electric 1/2, Grass 1/2, Ground 0, Flying 2, Dragon 1/2
	GRASS => Fire 1/2, Water 2, Grass 1/2, Poison 1/2, Ground 2, Flying 1/2, Bug 1/2, Rock 2, Dragon 1/2, Steel 1/2
	ICE => Fire 1/2, Water 1/2, Grass 2, Ice 1/2, Ground 2, Flying 2, Dragon 2, Steel 1/2
	FIGHT => Normal 2, Ice 2, Poison 1/2, Flying 1/2, Psychic 1/2, Bug 1/2, Rock 2, Ghost 0, Dark 2, Steel 2, Fairy 1/2
	POISON => Grass 2, Poison 1/2, Ground 1/2, Rock 1/2, Ghost 1/2, Steel 0, Fairy 2
	GROUND => Fire 2, Electric 2, Grass 1/2, Poison 2, Flying 0, Bug 1/2, Rock 2, Steel 2
	FLYING => Electric 1/2, Grass 2, Fight 2, Bug 2, Rock 1/2, Steel 1/2
	PSYCHIC => Fight 2, Poison 2, Psychic 1/2, Dark 0, Steel 1/2
	BUG => Fire 1/2, grass 2, fight 1/2, poison 1/2, flying 1/2, psychic 2, ghost 1/2, dark 2, steel 1/2, fairy 1/2
	ROCK => Water 2, Ice 2, Fight 1/2, Ground 1/2, Flying 2, Bug 2, Steel 1/2, 
	GHOST => Normal 0, Psychic 2, Ghost 2, Dark 1/2, 
	DRAGON => Dragon 2, Steel 1/2, Fairy 0
	DARK => Fight 1/2, Psychic 2, Ghost 2, Dark 1/2, Fairy 1/2
	STEEL => Fire 1/2, Water 1/2, Electric 1/2, Ice 2, Rock 2, Steel 1/2, Fairy 2
	FAIRY => Fire 1/2, Fight 2, Poison 1/2, Dragon 2, Dark 2, Steel 1/2
	
	*/
	
	/*	BUG("bug"), DARK("dark"), DRAGON("dragon"), ELECTRIC("electric"), FAIRY("fairy"), FIGHTING("fighting"),
	FIRE("fire"), FLYING("flying"), GHOST("ghost"), GRASS("grass"), GROUND("ground"), ICE("ice"), NORMAL("normal"),
	POISON("poison"), PSYCHIC("psychic"), ROCK("rock"), STEEL("steel"), WATER("water"); */

	/** Holder */
	private static class PokedexHolder {
		private final static Pokedex instance = new Pokedex();
	}

	/** Access Point */
	public static Pokedex getInstance() {
		return PokedexHolder.instance;
	}
	
	
}
