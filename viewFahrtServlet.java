package de.unidue.inf.is;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.fahrt;
import de.unidue.inf.is.stores.FahrtStore;

public class viewFahrtServlet extends HttpServlet {
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	try {
    	    	 fahrt fahrt = new fahrt();
    	    	request.setAttribute("start", fahrt.getStart());
    	    	request.setAttribute("ziel", fahrt.getZiel());
    	    	request.setAttribute("max", fahrt.getMaxPlaetze());
    	    	request.setAttribute("kosten", fahrt.getFahrKosten());
    	    	request.setAttribute("anbieter", fahrt.getAnbieter());
    	    	request.setAttribute("mittle", fahrt.getMittle());
    	    	request.setAttribute("beschreibung", fahrt.getBeschreibung());

    	      request.getRequestDispatcher("viewFahrt.ftl").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
       


} 

}
