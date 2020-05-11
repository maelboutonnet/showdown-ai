package fr.mael.showndownAI.pokemonData;

import com.google.gson.annotations.SerializedName;

public class Ailment {

	@SerializedName("name")
	AilmentType ailment;

	private enum AilmentType {
		poison, paralysis, burn, freeze, sleep;
	}
}
