package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest2 {

	
	@Test
	public void add()
	{
		System.out.println("SUM");
		int a =10;
		int b =20;
		Assert.assertEquals(30,(a+b));
		
	}
	
	@Test
	public void SUB()
	{
		System.out.println("Subtraction");
		int a =10;
		int b =20;
		Assert.assertEquals(10,(b-a));
		
	}
	
	@Test
	public void MUL()
	{
		System.out.println("MUL");
		int a =10;
		int b =20;
		Assert.assertEquals(200,(a*b));
		
	}
}
