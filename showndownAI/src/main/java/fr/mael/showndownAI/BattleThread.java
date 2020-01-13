package fr.mael.showndownAI;

import java.io.IOException;
import java.net.URISyntaxException;

import fr.mael.showndownAI.battleData.Battle;
import fr.mael.showndownAI.network.BasicMessageProcessor;
import fr.mael.showndownAI.network.CircularBuffer;
import fr.mael.showndownAI.network.WebsocketFacade;

public class BattleThread implements Runnable {
	
	WebsocketFacade facade;
	CircularBuffer inMessageQueue;
	Battle battle;
	
	private final int BUFFER_SIZE = 20;
	
	public BattleThread() throws URISyntaxException, IOException {
		facade = new WebsocketFacade();
	}

	@Override
	public void run() {
		
		inMessageQueue = new CircularBuffer(BUFFER_SIZE);

		BasicMessageHandler basicMessageHandler = new BasicMessageHandler(inMessageQueue);
		BasicMessageProcessor basicMessageProcessor = new BasicMessageProcessor(inMessageQueue,facade);
		facade.setMessageHandler(basicMessageHandler);
		basicMessageProcessor.start();
		facade.sendChallenge("[Gen 8] Unrated Random Battle");
	}

}
