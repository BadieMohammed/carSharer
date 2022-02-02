package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.bewertung;
import de.unidue.inf.is.stores.BewertungStore;

public class fahrtBewertenServlet extends HttpServlet {
    @SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    bewertung newBewertung = new bewertung();
    BewertungStore store = new BewertungStore() ;
    try {
    	newBewertung.setDatum(Date.parse(request.getParameter(null)));
    	newBewertung.setRate(Integer.parseInt(request.getParameter("rate")));
    	newBewertung.setText(request.getParameter("Bewrtung"));
    	store.addBewertung(newBewertung);
    	store.close();
	} catch (Exception e) {
		// TODO: handle exception
	}

 

   request.getRequestDispatcher("fahrtBewerten.ftl").forward(request, response);
  } 

}


