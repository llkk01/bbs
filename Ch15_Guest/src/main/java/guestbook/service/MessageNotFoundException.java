package guestbook.service;
//P.461
public class MessageNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public MessageNotFoundException(String message) {
		super(message);
	}
}