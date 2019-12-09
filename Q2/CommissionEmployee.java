public class CommissionEmployee extends Employee {

	
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, BirthDay birthDay) {
		
		super(firstName, lastName, socialSecurityNumber, birthDay);
		
		if(grossSales < 0.0) throw new IllegalArgumentException("grossSales must be >= 0");
		
		if(commissionRate <= 0.0 || commissionRate >= 1.0) throw new IllegalArgumentException("commissionRate must be > 0.0 and < 1.0");
		
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		
	}
	
	public void setGrossSales(double grossSales)
	{
		if(grossSales < 0.0) throw new IllegalArgumentException("grossSales must be >= 0");
		
		this.grossSales = grossSales;


	}
	public void setCommissionRate(double commissionRate)
	{
		if(commissionRate <= 0.0 || commissionRate >= 1.0) throw new IllegalArgumentException("commissionRate must be > 0.0 and < 1.0");

		this.commissionRate = commissionRate;

	}
	
	public double getGrossSales() {
		
		return this.grossSales;
	}

	public double getCommissionRate() {
		
		return this.commissionRate;
	}

	@Override
	public double earnings() {

		return getCommissionRate() * getGrossSales();

	}
	@Override
	public String toString()
	{
		return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commision employee", super.toString(), "gross sales", getGrossSales(),
				                                            "commission rate", getCommissionRate());
	}



	

}
