public class PieceWorker extends Employee {

	private double pieceValue;
	private double pieceAmount;
	
	
	
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber,
			double pieceValue, double pieceAmount, BirthDay birthDay) {
		
		super(firstName, lastName, socialSecurityNumber, birthDay);
		
		if(pieceValue <= 0.0) throw new IllegalArgumentException("Piece Value must be > 0.0");
		
		if(pieceAmount < 0.0) throw new IllegalArgumentException("Piece Amount must be >= 0");
		
		this.pieceValue = pieceValue;
		this.pieceAmount = pieceAmount;
		
		
	}



	public double getPieceValue() {
		return pieceValue;
	}



	public double getPieceAmount() {
		return pieceAmount;
	}



	public void setPieceValue(double pieceValue) {
		
		if(pieceValue <= 0.0) throw new IllegalArgumentException("Piece Value must be > 0.0");
		
		this.pieceValue = pieceValue;
		
	}



	public void setPieceAmount(double pieceAmount) {
		
		if(pieceAmount < 0.0) throw new IllegalArgumentException("Piece Amount must be >= 0");

		this.pieceAmount = pieceAmount;
	}


	public String toString()
	{
	   return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "piece worker", super.toString(), "piece value", getPieceValue(),
                "piece amount", getPieceAmount());
	}

	@Override
	public double earnings() {

		return getPieceAmount() * getPieceValue();
		
	}

}
