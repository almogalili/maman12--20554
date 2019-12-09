public class Main {

	
	public static void main(String[] args)
	{
		Employee[] employees = new Employee[5];
		
		Employee salariedEmoloyee = new SalariedEmployee("Almog", "Galili", "192321", 2200, new BirthDay(13, 8, 1992));
		
		Employee commissionEmoloyee = new CommissionEmployee("Chen", "Eliezer", "192111", 30, 0.77,  new BirthDay(4, 2, 1992));
		
		Employee hourlyEmoloyee = new HourlyEmployee("Ben", "Eliezer", "192011", 52, 153,  new BirthDay(2, 12, 1992));
		
		Employee basePluscommissionEmployee = new BasePlusCommissionEmployee("Aviv", "Galili", "192222", 26, 0.75, 1300, new BirthDay(3, 12, 1990));
		
		Employee pieceWorker = new PieceWorker("Jojo", "Halastra", "192013", 52, 153,  new BirthDay(2, 12, 1992));
		employees[0] = salariedEmoloyee;
		employees[1] = commissionEmoloyee;
		employees[2] = hourlyEmoloyee;
		employees[3] =  basePluscommissionEmployee;
		employees[4] = pieceWorker;
		
		
		for(int i = 0; i < employees.length; i++)
		{

			System.out.println(employees[i]);
			System.out.println();
		
		}
		
		
		
		
		


		
	}
	
}
