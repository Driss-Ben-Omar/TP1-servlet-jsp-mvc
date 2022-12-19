package metier;

public class Main {

	public static void main(String[] args) 
	{
		CreditMetierImpl credit=new CreditMetierImpl();
		System.out.println(credit.calculerMasualiteCredit(200000, 4.5 , 240));
	}

}
