package com.yinhai.webframework.session;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.session.SessionRegistryImpl;

import com.yinhai.webframework.security.model.AppUser;

public class SessionManager extends SessionRegistryImpl {
	private final Map<String, UserSession> userSessions = Collections.synchronizedMap(new HashMap());

	@Override
	public void removeSessionInformation(String paramString) {
		super.removeSessionInformation(paramString);
		UserSession localUserSession = this.userSessions.get(paramString);
		if (localUserSession != null) {
			localUserSession.invalidateUserSession();
			this.userSessions.remove(paramString);
		}
	}

	public void registerUserSession(String paramString, UserSession paramUserSession, AppUser myAppUser) {
		this.userSessions.put(paramString, paramUserSession);
		super.registerNewSession(paramString, myAppUser);
	}

	public void registerUserSession(String paramString, UserSession paramUserSession) {
		this.userSessions.put(paramString, paramUserSession);
	}

	public UserSession[] getSessions() {
		return this.userSessions.values().toArray(new UserSession[0]);
	}

	public UserSession getUserSession(String paramString) {
		return this.userSessions.get(paramString);
	}

	public int getSessionSize() {
		return this.userSessions.size();
	}
}