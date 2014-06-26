package net.civilis.playground.jaas;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.civilis.playground.configuration.Config;
import net.civilis.playground.persistence.dao.AuthenticationDao;
import net.civilis.playground.persistence.entity.AppUser;
import net.civilis.playground.web.ServletBase;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns = { "/page/getDisplayName" })
public class AuthDataServlet extends ServletBase {

	private static final long	serialVersionUID	= 1L;
	private static Logger logger = Logger.getLogger(AuthDataServlet.class.getName());

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String displayname = getDisplayName(request.getUserPrincipal().getName());
		logger.debug("username: " + request.getUserPrincipal().getName());
		
		String testProperty = Config.getString("digid.simulator.mda_name");
		logger.debug(testProperty);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(displayname);
	}

	private String getDisplayName(String username) {
		String result = null;
		AppUser appUser = AuthenticationDao.getAppUser(username);
		result = appUser.getUserDetail().getDisplayName();
		return result;
	}

}
