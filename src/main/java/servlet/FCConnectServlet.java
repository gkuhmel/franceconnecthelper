package eu.ooffee.fcconnect.servlet;
 
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.StdErrLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.ooffee.fcconnect.FcConnectException;
import eu.ooffee.fcconnect.FcConnection;
import eu.ooffee.fcconnect.FcParamConfig;


public class FCConnectServlet extends HttpServlet
{ 
	private static final long serialVersionUID = 1L;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		Log.setLog(new StdErrLog());	
		 
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);        
		    

		String filename = "config.properties";
		Properties prop = new Properties();
		prop.load(getClass().getClassLoader().getResourceAsStream(filename));
        
		FcParamConfig fpc = new FcParamConfig(prop);	
		FcConnection fcc = new FcConnection(fpc);
		
		Log.info("FC - Servlet Connect");		
		
		try {
			//Generation of the FC Url to call.
			Log.info("FC - redirect URi Generation");
			URI redirect = fcc.getRedirectUri();					
			request.setAttribute("redirect", redirect.toString());
			Log.info("FC - redirect URI : " + redirect);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/connect.jsp");
	        requestDispatcher.forward(request, response);            
	        
		} catch (FcConnectException e) {
			Log.warn(e.getMessage());
			e.printStackTrace();
		} 
			        
    }
}