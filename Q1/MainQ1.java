
import java.util.ArrayList;
import java.util.Scanner;

public class MainQ1 {

	private static Scanner scan = new Scanner(System.in);
	private static final String STOP = "stop";
	private static Polynom polynom;
	private static final boolean IS_PlUS = true;

	public static void main(String[] args) {

		menu();

	}

	public static void menu() {

		System.out.println("Lets create new Polynom");

		createNewPolynom(0);

		
		
		while(true)
		{
			System.out.println("What do you want do now?\n" + 
					"1. Create new polynom and summarize them\n"+ 
					"2. Create new polynom and get the differnce\n" + 
					"3. Derive this polynom\n" + 
					"4. Print polynom\n"+ 
					"5. exit"
					);

		int choice = scan.nextInt();

		switch (choice) {

		case 1:
			//take the enter
			scan.nextLine();
			createNewPolynom(1);
			break;
			
		case 2:
			//take the enter
			scan.nextLine();
			createNewPolynom(2);
			break;
			
		case 3:
			System.out.println(polynom.derivative());
			break;
		
		case 4:
			System.out.println(polynom);
			break;
		
		case 5:
			System.exit(1);

		}
		}

	}

	public static void createNewPolynom(int choice) {

		ArrayList<Integer> exp = new ArrayList<>();
		ArrayList<Double> coe = new ArrayList<>();

		System.out.println("Start with the coefficients");

		while (true) {
			
			System.out.println("Please enter an number, if you want to stop the process write stop");
			String input = scan.nextLine();

			if (input.equals(STOP))
				break;

			coe.add(Double.parseDouble(input));

		}

		System.out.println("Lets move to the exponents");

		while (true) {
			
			System.out.println("Please enter an number, if you want to stop the process write stop");
			String input = scan.nextLine();

			if (input.equals(STOP))
				break;

			exp.add(Integer.parseInt(input));

		}
		
		double[] coefficients  = new double[coe.size()];
		int [] exponents = new int[exp.size()];
		
		for(int i = 0; i < coe.size(); i++)
			coefficients[i] = coe.get(i);
		
		for(int j = 0; j < exp.size(); j++)
			exponents[j] = exp.get(j);
			
		
		if(choice == 0)
		{
			polynom = new Polynom(coefficients, exponents);
		} 
		else if(choice == 1)
		{
			System.out.println(polynom.plusOrMinus(new Polynom(coefficients, exponents), IS_PlUS));
		}
		else if(choice == 2)
		{
			System.out.println(polynom.plusOrMinus(new Polynom(coefficients, exponents), !IS_PlUS));
		}
		

	}

}
