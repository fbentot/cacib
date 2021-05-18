package cacib.snake.objects;

public class InvalidMoveException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8742900785942188464L;
	
	public InvalidMoveException(String errorMessage) {
	        super(errorMessage);
	}
	
}
