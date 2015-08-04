package eu.ooffee.fcconnect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.jetty.util.log.Log;

public class FcParamConfig {
	
	private String tokenUri;
	private String authorizationUri;
	private String userInfoUri;
	private String clientId;
	private String clientSecret;
	private String redirectUri;
	private String scope;
	private String state;
	private String verifParameterId;
	private String verifParameterValue;

	
	public FcParamConfig(String tokenUri, String authorizationUri,
			String userInfoUri, String clientId, String clientSecret,
			String redirectUri, String scope, String state,
			String verifParameterId, String verifParameterValue) {
		super();
		this.tokenUri = tokenUri;
		this.authorizationUri = authorizationUri;
		this.userInfoUri = userInfoUri;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.redirectUri = redirectUri;
		this.scope = scope;
		this.state = state;
		this.verifParameterId = verifParameterId;
		this.verifParameterValue = verifParameterValue;
	}

	public FcParamConfig(Properties prop) throws IOException {
		super();					
		
		this.tokenUri = prop.getProperty("tokenUri");
		this.authorizationUri = prop.getProperty("authorizationUri");
		this.redirectUri = prop.getProperty("redirectUri");
		this.userInfoUri = prop.getProperty("userInfoUri");
		this.clientId = prop.getProperty("clientId");
		this.clientSecret = prop.getProperty("clientSecret");
		this.scope = prop.getProperty("scope");
		this.state = prop.getProperty("state");
		this.verifParameterId = prop.getProperty("verifParameterId");
		this.verifParameterValue = prop.getProperty("verifParameterValue");    		
	}

	public String getTokenUri() {
		return tokenUri;
	}

	public void setTokenUri(String tokenUri) {
		this.tokenUri = tokenUri;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getAuthorizationUri() {
		return authorizationUri;
	}

	public void setAuthorizationUri(String authorizationUri) {
		this.authorizationUri = authorizationUri;
	}

	public String getUserInfoUri() {
		return userInfoUri;
	}

	public void setUserInfoUri(String userInfoUri) {
		this.userInfoUri = userInfoUri;
	}
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getVerifParameterId() {
		return verifParameterId;
	}

	public void setVerifParameterId(String verifParameterId) {
		this.verifParameterId = verifParameterId;
	}

	public String getVerifParameterValue() {
		return verifParameterValue;
	}

	public void setVerifParameterValue(String verifParameterValue) {
		this.verifParameterValue = verifParameterValue;
	}
	
	
	
}
