package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Date;

import javax.security.auth.callback.LanguageCallback;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;
import org.omg.CosNaming.IstringHelper;

import de.unidue.inf.is.domain.fahrt;
import de.unidue.inf.is.stores.FahrtStore;

public final class FahrtErstellenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("deprecation")
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
    	 /*
         fahrt newFahrt = new fahrt();
         FahrtStore store = new FahrtStore();
         String message = "" ;
         if (Integer.parseInt(request.getParameter("max"))>10) { 
        	 message+= "max Plaetze ist 10 ";
        	 request.setAttribute("message", message);
        	 request.getRequestDispatcher("ErstellenSuccess.ftl").forward(request, response);
         }
         if (Integer.parseInt(request.getParameter("kosten"))<=0) {
			message+= "bitte geben Sie eine Positive Nummer" ;
			request.setAttribute("message", message);
			request.getRequestDispatcher("ErstellenSuccess.ftl").forward(request, response);
		}
      //   if (Date.parse(request.getParameter("datum"))< null) { }
         if (request.getParameter("beschreibung").length() > 50) {
        	 message+= "Ihre Beschreibung Ist zu LanguageCallback ! ";
        	 request.setAttribute("message", message);
        	 request.getRequestDispatcher("ErstellenSuccess.ftl").forward(request, response);
         }
         
         else
         try {
         newFahrt.setStart(request.getParameter("von"));
         newFahrt.setZiel(request.getParameter("bis"));
         newFahrt.setZeit(Date.parse(request.getParameter("datum")));
         newFahrt.setMax(Integer.parseInt(request.getParameter("max")));
         newFahrt.setFahrkosten(Integer.parseInt(request.getParameter("kosten")));
         newFahrt.setAnbieter(request.getParameter("anbieter"));
         newFahrt.setTransportmittle(request.getParameter("mittle"));
         newFahrt.setBeschreibung(request.getParameter("beschreibung")); 
         store.addFahrt(newFahrt);
         store.close();
         }
         catch (Exception e) {
			// TODO: handle exception
		*/
        request.getRequestDispatcher("FahrtErstellen.ftl").forward(request, response);
    }    

}