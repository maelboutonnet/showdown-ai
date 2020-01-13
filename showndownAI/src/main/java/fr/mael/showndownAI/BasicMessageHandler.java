package fr.mael.showndownAI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.mael.showndownAI.network.CircularBuffer;
import fr.mael.showndownAI.network.WebsocketClient;
import fr.mael.showndownAI.network.WebsocketClient.MessageHandler;

public class BasicMessageHandler implements WebsocketClient.MessageHandler {
	private final Logger LOGGER = LogManager.getLogger(getClass());
	
	CircularBuffer buffer;
	
	public BasicMessageHandler(CircularBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void handleMessage(String message) {
		try {
			buffer.offer(message);
		} catch (InterruptedException e) {
			LOGGER.error("Couldn't register message " + message);
		}
	}

}
