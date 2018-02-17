package ostoslista.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ostoslista.model.Ostos;
import ostoslista.model.dao.OstosDAO;



@WebServlet("/ostoslista")
public class ListaaOstosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListaaOstosServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OstosDAO ostosdao = new OstosDAO();
		ArrayList<Ostos> ostoslista = ostosdao.haeOstokset();
		
		
		request.setAttribute("ostoslista", ostoslista);
		
		String jsp ="/view/ostoslista.jsp";
		RequestDispatcher dissaaja = getServletContext().getRequestDispatcher(jsp);
		dissaaja.forward(request, response);
	}
}

	
	