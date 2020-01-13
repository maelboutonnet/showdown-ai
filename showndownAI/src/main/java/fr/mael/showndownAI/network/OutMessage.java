package fr.mael.showndownAI.network;

public enum OutMessage {
	CHALLENGE("|/challenge %s,%s"),
	CONFIRM_LOGIN("|/trn %s,0,%s"),
	CHOOSE_ACTION("%s|/choose %s"),
	EMPTY("%s");
	
	
	String preformattedMessage;

	private OutMessage(String preformattedMessage) {
		this.preformattedMessage = preformattedMessage;
	}
	
}
