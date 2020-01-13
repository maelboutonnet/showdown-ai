package fr.mael.showndownAI.network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginMessageHandler implements WebsocketClient.MessageHandler {
	
	private final Logger LOGGER = LogManager.getLogger(getClass());
	
	public String challStrMsg;
	
	@Override
	public void handleMessage(String message) {
		LOGGER.info("Message received : ");
		LOGGER.info(message);
		LOGGER.info("End of message");
		if (InMessage.CHALLSTR.matches(message)) {
			String tmp = InMessage.CHALLSTR.get(message);
			challStrMsg = tmp;
			LOGGER.info("challSTR Updated");
		}
	}
}
