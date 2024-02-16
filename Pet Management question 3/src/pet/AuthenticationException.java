package pet;

public class AuthenticationException {
	public AuthenticationException(String message) {
		 super();
}
	
}

class AuthorizationException extends Exception {
	 public AuthorizationException(String message) {
	 super(message);
	 }
	}
	class OutOfStockException extends Exception {
	 public OutOfStockException(String message) {
	 super(message);
	 }
	}
