package br.jus.tjce.dispatcher.service;

public class RestBase {
	
	private final String URI_BASE = "https://<host>:<port>";

	private final String URI_DOCUMENTS = "/documents";

	public String getUri() {
		return URI_BASE.concat(URI_DOCUMENTS);
				
	}
	

}
