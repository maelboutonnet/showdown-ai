package fr.mael.showndownAI.battleData;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	
	SmogonBattle smogonBattle;
	
	
	
	public String getNextMove() {
		if (forceSwitch) {
			pkmIdx++;
			return (Action.SWITCH + " " + String.valueOf(pkmIdx)).toLowerCase();
		} else {
			return (Action.MOVE + " " + smogonBattle.active.get(0).moves.get(0).id).toLowerCase();
		}
	}

	public void init(String string) {
		Gson gson = new GsonBuilder().create();
		if (string.indexOf("\"wait\":true") == -1) {
			smogonBattle = gson.fromJson(string, SmogonBattle.class);
		}
		/*String move = string.substring(string.indexOf("\"id\":")+6, string.indexOf("\",", string.indexOf("\"id\":")));
		nextMove = move; */
		forceSwitch = string.indexOf("\"forceSwitch\":[true]") > -1;
	}
	
}
