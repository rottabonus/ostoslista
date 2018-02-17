package ostoslista.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ostoslista.model.Ostos;
import ostoslista.model.dao.OstosDAO;


@WebServlet("/lisaa-ostos")
public class LisaaUusiOstosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LisaaUusiOstosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/uusiOstos.jsp";
		RequestDispatcher dissaaja = getServletContext().getRequestDispatcher(jsp);
		dissaaja.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String nimi = request.getParameter("nimi");
			String strMaara = request.getParameter("maara");
			int maara = new Integer(strMaara);
			String kuvaus = request.getParameter("kuvaus");
			String strHinta = request.getParameter("hinta");
			double hinta = new Double(strHinta);
			
			Ostos ostos = new Ostos(0, nimi, maara, kuvaus, hinta);
			
			OstosDAO ostosdao = new OstosDAO();
			
			ostosdao.lisaaOstos(ostos);
		} catch (SQLException e) {
			System.out.println("Virhe: "+ e.getMessage());
		}
		response.sendRedirect("ostoslista");
	}

}
