package fr.mael.showndownAI.network;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum InMessage {
	CHALLSTR("(?<=challstr\\|).*"),
	REQUEST_DATA("(?<=request\\|).*"),
	BATTLE_ID("^>(battle-[0-9a-z\\-]+)");
	
	private Pattern pattern;
	
	private InMessage(String textPattern) {
		this.pattern = Pattern.compile(textPattern);;
	}

	public boolean matches(String message) {
		Matcher matcher = pattern.matcher(message);
		return matcher.find();
	}
	
	public String get(String message) {
		Matcher matcher = pattern.matcher(message);
		matcher.find();
		return matcher.group().toString().trim();
	}
	
	
	
}
