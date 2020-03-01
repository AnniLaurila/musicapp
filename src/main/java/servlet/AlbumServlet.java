package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCAlbumDao;

@WebServlet("/albums")
public class AlbumServlet extends HttpServlet {

		
		private final JDBCAlbumDao albumDao = new JDBCAlbumDao();

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        
	    	try {
				System.out.println("HALOOOO HALOOOOO HALOOOOOO");
	    	} finally {
	    		
			}

	    }
	    
}
