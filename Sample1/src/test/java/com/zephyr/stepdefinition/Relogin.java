package com.zephyr.stepdefinition;

public class Relogin 
{
public void reLogin() throws Throwable
{
	Login l=new Login();
	l.user_Selects_the_Browser_Launches_it_and_Maximises_it();
	l.user_Navigates_to_the_URL_provided();
	l.user_Enters_Username_Password_and_clicks_on_login();
}
}
