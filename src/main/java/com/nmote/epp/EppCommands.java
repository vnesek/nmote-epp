package com.nmote.epp;

public class EppCommands {

	public static CheckDomainCommand checkDomain() {
		return new CheckDomainCommand();
	}

	public static CheckDomainCommand checkDomain(String... domains) {
		return new CheckDomainCommand().domain(domains);
	}

	public static InfoDomainCommand infoDomain() {
		return new InfoDomainCommand();
	}

	public static InfoDomainCommand infoDomain(String name) {
		return new InfoDomainCommand().name(name);
	}

	public static LoginCommand login() {
		return new LoginCommand();
	}

	public static LoginCommand login(String clientID, String password) {
		return new LoginCommand().clientID(clientID).password(password);
	}

	public static LogoutCommand logout() {
		return new LogoutCommand();
	}
}
