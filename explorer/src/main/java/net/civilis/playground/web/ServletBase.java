package net.civilis.playground.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public abstract class ServletBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String LOG4J_PROPERTY_FILENAME = "log4j.config.file";

    public void init(ServletConfig config) throws ServletException {
        initLog4J();
        super.init(config);
    }

    private void initLog4J() {
        String path = System.getProperty(LOG4J_PROPERTY_FILENAME);

        if (path != null) {
            PropertyConfigurator.configureAndWatch(path, 10000);
        } else {
            System.err.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
            BasicConfigurator.configure();
        }
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	protected abstract void processRequest(HttpServletRequest request,
			HttpServletResponse response)  throws IOException;


}
