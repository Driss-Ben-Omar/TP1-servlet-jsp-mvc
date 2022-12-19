package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;
@WebServlet(name="controllerServlet",urlPatterns = "*.do")
public class ControllerServlet extends HttpServlet
{
	ICreditMetier metier;
	@Override
	public void init() throws ServletException 
	{
		metier=new CreditMetierImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("vue/creditBanque.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		double montant=Double.parseDouble(request.getParameter("montant"));
		double taux=Double.parseDouble(request.getParameter("taux"));
		int duree=Integer.parseInt(request.getParameter("duree"));
		
		CreditModel model=new CreditModel();
		model.setMontant(montant);
		model.setDuree(duree);
		model.setTaux(taux);

		double result=metier.calculerMasualiteCredit(montant, taux, duree);
		model.setMensualite(result);
		
		request.setAttribute("creditModel", model);
		
		request.getRequestDispatcher("vue/creditBanque.jsp").forward(request, response);
	}
}
