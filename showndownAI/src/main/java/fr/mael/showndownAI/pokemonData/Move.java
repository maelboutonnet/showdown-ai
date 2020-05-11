package fr.mael.showndownAI.pokemonData;

import com.google.gson.annotations.SerializedName;

public class Move {

	String name;

	int accuracy;

	@SerializedName("effect_chance")
	int effectChance;

	int pp;

	int priority;

	int power;

	@SerializedName("damage_class")
	DamageClass damageClass;

	Meta meta;

	Type type;

}
