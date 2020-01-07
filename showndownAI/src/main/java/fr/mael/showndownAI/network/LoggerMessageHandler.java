package fr.mael.showndownAI.network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerMessageHandler implements WebsocketClient.MessageHandler {
	private final Logger LOGGER = LogManager.getLogger(getClass());
	
	public String[] challStrMsg;
	
	@Override
	public void handleMessage(String message) {
		String[] splitMessage = message.split("\\|");
		LOGGER.info("Message received : ");
		LOGGER.info(message);
		LOGGER.info("End of message");
		
		if ("challstr".contentEquals(splitMessage[1])) {
			challStrMsg = splitMessage;
		}
		
		
		
	}

}
