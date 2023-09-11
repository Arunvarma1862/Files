package com.test;

import org.testng.annotations.Test;

public class A1 {
	@Test(groups = {"smoke","sanity"})
	public void B1() {
		System.out.println("b1");
	}
	@Test(groups = {"functional","sanity"})
	public void B2() {
		System.out.println("b2");
	}
	@Test
	public void B2A() {
		System.out.println("b2A");
	}
	
	

}
