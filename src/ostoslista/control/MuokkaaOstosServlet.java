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


@WebServlet("/muokkaa-ostos")
public class MuokkaaOstosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MuokkaaOstosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/muokkaaOstos.jsp";
		
		
	try {
		String idStr = request.getParameter("muokkaus");
		int id = new Integer(idStr);
		
			//hae "ostos" db
		
		OstosDAO ostosdao = new OstosDAO();
		Ostos ostos = ostosdao.haeOstosId(id);
			
			//setattribute -> ostos
			request.setAttribute("ostos", ostos);
			
	} catch (SQLException e) {
		System.out.println("Virhe: "+ e.getMessage());
	}
		

		RequestDispatcher dissaaja = getServletContext().getRequestDispatcher(jsp);
		dissaaja.forward(request, response);
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String idStr = request.getParameter("muokkaus");
			int id = new Integer(idStr);
			String nimi = request.getParameter("nimi");
			String strMaara = request.getParameter("maara");
			int maara = new Integer(strMaara);
			String kuvaus = request.getParameter("kuvaus");
			String strHinta = request.getParameter("hinta");
			double hinta = new Double(strHinta);
			
			Ostos ostos = new Ostos(id, nimi, maara, kuvaus, hinta);
			
			OstosDAO ostosdao = new OstosDAO();
			
			ostosdao.muutaOstos(ostos);
		}  catch (SQLException e) {
			System.out.println("Virhe: "+ e.getMessage());
		}
		response.sendRedirect("ostoslista");
	}

}
