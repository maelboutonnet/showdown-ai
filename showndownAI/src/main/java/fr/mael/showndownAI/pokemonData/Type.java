package fr.mael.showndownAI.pokemonData;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Type {

	@SerializedName("name")
	public PokeType type;

	public static Map<PokeType, Map<PokeType, Integer>> attackEfficencyTable = new HashMap<>();

	static {

	}

}
