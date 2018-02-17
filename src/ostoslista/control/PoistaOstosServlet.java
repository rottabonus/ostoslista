package ostoslista.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ostoslista.model.dao.OstosDAO;


@WebServlet("/poista-ostos")
public class PoistaOstosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PoistaOstosServlet() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	try {
		String idStr = request.getParameter("poisto");
		int id = new Integer(idStr);
		OstosDAO ostosdao = new OstosDAO();
		ostosdao.poistaOstos(id);
	} catch (SQLException e) {
		System.out.println("Virhe");
	} 
	response.sendRedirect("ostoslista");
	}

	
	

}
