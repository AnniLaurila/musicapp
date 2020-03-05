package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCAlbumDao;
import database.JDBCArtistDao;

@WebServlet("/albums")
public class AlbumServlet extends HttpServlet {

	private final JDBCAlbumDao albumDao = new JDBCAlbumDao();
	private final JDBCArtistDao artistDao = new JDBCArtistDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		try {
			long artistId = Long.parseLong(req.getParameter("artistId"));
			req.setAttribute("artist", artistDao.getArtist(artistId));
			req.setAttribute("albums", albumDao.getAlbumsByArtist(artistId));
			req.getRequestDispatcher("/WEB-INF/albums.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
        	req.setAttribute("error", "Albumien haku ei onnistunut");
        	req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
		}


	}

}
