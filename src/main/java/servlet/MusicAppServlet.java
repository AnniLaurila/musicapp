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

		try {
			req.setAttribute("artists", artistDao.getAllArtists());
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Artistien haku ei onnistunut");
			req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		try {
			String name = req.getParameter("name");
			artistDao.addArtist(new Artist(name));
			resp.sendRedirect("/");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Artistin lis‰‰minen ei onnistunut");
			req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
		}

	}
}
