

public abstract class Employee {

	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final BirthDay birthDay;
	
	
	private static double birthDayBonus = 200.0;
	

	public Employee(String firstName, String lastName, String socialSecurityNumber, BirthDay birthDay) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDay = birthDay;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public BirthDay getBirthDay() {
		return birthDay;
	}

	public String toString()
	{
	//i do not know if its correct to call earnings from this class,
	//But only from concrete class we can call to earnings, so maybe its a good idea.
		
		if(getBirthDay().isBirthDayThisMonth())
			return String.format("%s %s%nsocial security number: %s Birth Day: %s\n"
					+ "You have birth day this month, you got bonus of: $%.2f\nearnings: $%.2f"
					, getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDay(),
					birthDayBonus, earnings() + birthDayBonus);

		return String.format("%s %s%nsocial security number: %s Birth Day: %s, earnings: $%.2f",
				getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDay(), earnings());
	}

	public abstract double earnings();

}
