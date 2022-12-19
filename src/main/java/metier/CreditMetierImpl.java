package metier;

public class CreditMetierImpl implements ICreditMetier
{

	@Override
	public double calculerMasualiteCredit(double capitale, double taux, int duree) {
		double tauxFilnal=taux/100;
		double term1=capitale*tauxFilnal/12;
		double term2=1-Math.pow(1+tauxFilnal/12, -duree);
		return term1/term2;
	}

}
