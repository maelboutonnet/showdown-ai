package fr.mael.showndownAI;

import java.io.IOException;
import java.net.URISyntaxException;

import fr.mael.showndownAI.network.WebsocketFacade;

public class BattleThread implements Runnable {
	
	WebsocketFacade facade;
	
	

	public BattleThread() throws URISyntaxException, IOException {
		facade = new WebsocketFacade();
	}

	@Override
	public void run() {
		facade.sendChallenge("[Gen 8] Unrated Random Battle");
		while(true) {}
	}

}
