package fr.formation.proxibanquev3.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Classe permettant de gerer l'affichage de l'ecran d'accueil de l'application.
 * @author Adminl
 *
 */
public class IndexServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexServlet.class.getName());

	/**
	 * Methode permettant d'acceder a� index.jsp.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}