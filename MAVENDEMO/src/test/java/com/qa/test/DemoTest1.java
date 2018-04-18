package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest1 {
	@Test
	public void div()
	{
		System.out.println("DIVISION");
		int a =10;
		int b =20;
		Assert.assertEquals(2,(b/a));
		
	}
	
	@Test
	public void reminder()
	{
		System.out.println("REMINDER");
		int a =10;
		int b =20;
		Assert.assertEquals(0,b%a);
		
	}
	
	@Test
	public void square()
	{
		System.out.println("SQUARE");
		int a =10;
		
		Assert.assertEquals(100,(a*a));
		
	}
}
