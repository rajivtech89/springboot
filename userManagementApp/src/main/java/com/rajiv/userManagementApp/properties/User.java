package com.rajiv.userManagementApp.properties;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class User {

	@Value("${user.fb.name}")
	private String fbUser;
	@Value("${user.fb.password}")
	private String fbPassword;
	@Value("${user.gmail.name}")
	private String gmailUser;
	@Value("${user.gmail.password}")
	private String gmailPassword;

	@Value("${country.list}")
	private List<String> countryList;
	
	@Value("#{'${country.list}'.split(',')}")
	private List<String> countryList1;

	@Value("#{${country.capital.map}}")
	private Map<String, String> map;
	
	@Autowired
	private DBSettings dbSetting;

	public String getFbUser() {
		return fbUser;
	}

	public void setFbUser(String fbUser) {
		this.fbUser = fbUser;
	}

	public String getFbPassword() {
		return fbPassword;
	}

	public void setFbPassword(String fbPassword) {
		this.fbPassword = fbPassword;
	}

	public String getGmailUser() {
		return gmailUser;
	}

	public void setGmailUser(String gmailUser) {
		this.gmailUser = gmailUser;
	}

	public String getGmailPassword() {
		return gmailPassword;
	}

	public void setGmailPassword(String gmailPassword) {
		this.gmailPassword = gmailPassword;
	}

	public List<String> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}

	public List<String> getCountryList1() {
		return countryList1;
	}

	public void setCountryList1(List<String> countryList1) {
		this.countryList1 = countryList1;
	}

	public Map<String, String> getMap() {
		return map;
	}

	
	public DBSettings getDbSetting() {
		return dbSetting;
	}

	public void setDbSetting(DBSettings dbSetting) {
		this.dbSetting = dbSetting;
	}



	@Override
	public String toString() {
		return "User [fbUser=" + fbUser + ", fbPassword=" + fbPassword + ", gmailUser=" + gmailUser + ", gmailPassword="
				+ gmailPassword + ", countryList=" + countryList + ", countryList1=" + countryList1 + ", map=" + map
				+ ", dbSetting=" + dbSetting.toString() + "]";
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	
	
}
