package fr.mael.showndownAI.pokemonData;

import com.google.gson.annotations.SerializedName;

public class DamageClass {

	@SerializedName("name")
	public DamageType type;

	private enum DamageType {
		PHYSICAL, SPECIAL
	}
}
