package servlet;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCArtistDao;
import model.Artist;

@WebServlet("")
public class MusicAppServlet extends HttpServlet {
	
	private final JDBCArtistDao artistDao = new JDBCArtistDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("artists", artistDao.getAllArtists());

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
    	String name = req.getParameter("name");
    	
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Check name-parameter");
        }
        
        if(artistDao.addArtist(new Artist(name))) {
        	resp.sendRedirect("/");
        } else {
        	req.setAttribute("error", "Artistin lis‰‰minen ei onnistunut");
        	req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
    	
	}
}


