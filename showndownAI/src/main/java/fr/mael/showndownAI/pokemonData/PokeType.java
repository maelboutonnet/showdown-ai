package fr.mael.showndownAI.pokemonData;

public enum PokeType {

	BUG("bug"), DARK("dark"), DRAGON("dragon"), ELECTRIC("electric"), FAIRY("fairy"), FIGHTING("fighting"),
	FIRE("fire"), FLYING("flying"), GHOST("ghost"), GRASS("grass"), GROUND("ground"), ICE("ice"), NORMAL("normal"),
	POISON("poison"), PSYCHIC("psychic"), ROCK("rock"), STEEL("steel"), WATER("water");

	String text;

	private PokeType(String text) {
		this.text = text;
	}

}
