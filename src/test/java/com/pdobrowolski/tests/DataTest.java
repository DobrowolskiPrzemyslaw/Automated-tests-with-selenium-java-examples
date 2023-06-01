package com.pdobrowolski.tests;

import org.testng.annotations.DataProvider;

public class DataTest extends BaseTest {
	
	@DataProvider(name="files")
	protected static Object[][] files() {
		return new Object[][] {
			{1,"index.html"},
			{2,"logo.png"},
			{3,"text.txt"}
		};
	}

	@DataProvider(name = "urls")
	public Object[][] dataProvider(){
		return new Object[][] {
			{"https://simpletheme.myshopify.com/"},
			{"https://simpletheme.myshopify.com/"},
			{"https://simpletheme.myshopify.com/"}};
	}
}
