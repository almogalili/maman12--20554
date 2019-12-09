public class HourlyEmployee extends Employee {

	private double wage;
	private double hours;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours, BirthDay birthDay) {

		super(firstName, lastName, socialSecurityNumber, birthDay);

		if (wage < 0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");

		if (hours < 0.0 || hours > 168.0)
			throw new IllegalArgumentException("Hours worked must be >= 0 and <= 168.0");

		this.wage = wage;
		this.hours = hours;

	}

	public double getWage() {
		return this.wage;
	}

	public double getHours() {
		return this.hours;
	}

	public void setHours(double hours) {
		if (hours < 0.0 || hours > 168.0)
			throw new IllegalArgumentException("Hours worked must be >= 0 and <= 168.0");

		this.hours = hours;
	}

	public void setWage(double wage) {
		if (wage < 0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");

		this.wage = wage;

	}

	@Override
	public double earnings() {

		if (getHours() <= 40)
			return getWage() * getHours();

		return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;

	}

	public String toString() {
		
		return String.format("hourly emoloyee: %s%n%s: $%,.2f %s: %,.2f", super.toString(), "hourly wage", getWage(),
				"hours worked", getHours());
		
	}

}
