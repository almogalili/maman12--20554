

public class IllegalLengthException  extends IllegalArgumentException {

	private static final String ERROR_MESSAGE = "The Lengths Not Mathcing";

	
	public IllegalLengthException()
	{
		super(ERROR_MESSAGE);
	}

	
}
