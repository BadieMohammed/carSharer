package de.unidue.inf.is;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.stores.UserStore;

public final class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User a = new User() ;
	UserStore store = new UserStore();
    //   a.setName("badie");
      // a.setEmail("mmm");
        a = store.showUser(0);
		request.setAttribute("name",a.getName());
		//request.setAttribute("email",a.getEmail());
        request.getRequestDispatcher("FahrtErstellen.ftl").forward(request, response);
    }

/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                    IOException {

        doGet(request, response);
    }
    */
}
