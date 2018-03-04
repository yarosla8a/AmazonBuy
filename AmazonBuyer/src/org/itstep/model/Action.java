package org.itstep.model;

public class Action {
	private String id;
	private String asin;
	private String action;
	private String login;
	private String action_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getAction_time() {
		return action_time;
	}
	public void setAction_time(String action_time) {
		this.action_time = action_time;
	}
	public Action(String id, String asin, String action, String login, String action_time) {
		this.id = id;
		this.asin = asin;
		this.action = action;
		this.login = login;
		this.action_time = action_time;
	}
	public Action() {
	}
	
	
}
