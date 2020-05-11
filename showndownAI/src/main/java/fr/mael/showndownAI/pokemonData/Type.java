package fr.mael.showndownAI.pokemonData;

import com.google.gson.annotations.SerializedName;

public class Type {

	@SerializedName("name")
	public PokeType type;

	private enum PokeType {

		bug, dark, dragon, electric, fairy, fighting, fire, flying, ghost, grass, ground, ice, normal, poison, psychic,
		rock, steel, water;

	}
}
