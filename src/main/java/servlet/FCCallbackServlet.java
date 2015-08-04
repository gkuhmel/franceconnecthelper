package eu.ooffee.fcconnect.servlet;
 
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.StdErrLog;

import eu.ooffee.fcconnect.FcConnectException;
import eu.ooffee.fcconnect.FcConnection;
import eu.ooffee.fcconnect.FcParamConfig;
 
public class FCCallbackServlet extends HttpServlet
{
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
			
		Log.info("FC - Servlet Callback");		
        String accessToken;
		try {
			
			Log.info("FC - access token retrieving ... ");
			accessToken = fcc.getAccessToken(request);
			request.setAttribute("accessToken", accessToken);
			Log.info("FC - access token retrieved. ");
			Log.info("FC - user infos retriving");
			String userInfo = fcc.getUserInfo(accessToken);
			Log.info("FC - user infos retrieved");
			Log.info(userInfo);
			request.setAttribute("userInfo", userInfo);					
			
		} catch (FcConnectException e) {
			Log.warn(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Log.warn(e.getMessage());
		}		 
		 
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/infos.jsp");
        requestDispatcher.forward(request, response);  
        
    }
}