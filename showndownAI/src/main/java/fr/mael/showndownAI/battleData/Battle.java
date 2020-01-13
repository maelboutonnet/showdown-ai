package fr.mael.showndownAI.battleData;

import java.util.List;

public class Battle {
	
	public String id;
	List<Pokemon> myPokes;
	List<Pokemon> opPokes;
	Pokemon myActivePokemon;
	Pokemon opActivePokemon;
	String status;
	public boolean requestReceived;
	public boolean initDone = false;
	boolean forceSwitch = false;
	int pkmIdx = 1;
	private String nextMove;
	
	public String getNextMove() {
		if (forceSwitch) {
			pkmIdx++;
			return (Action.SWITCH + " " + String.valueOf(pkmIdx)).toLowerCase();
		} else {
			return (Action.MOVE + " " + nextMove).toLowerCase();
		}
	}

	public void init(String string) {
		String move = string.substring(string.indexOf("\"id\":")+6, string.indexOf("\",", string.indexOf("\"id\":")));
		nextMove = move;
		forceSwitch = string.indexOf("\"forceSwitch\":[true]") > -1;
	}
	
}
