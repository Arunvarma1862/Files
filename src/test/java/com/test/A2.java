package com.test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class A2 {
	

	@Test(groups = {"smoke","functional"})
	public void B3() {
		System.out.println("b3");
	}
	@Test(groups = {"regression","sanity"})
	public void B4() {
		System.out.println("b4");
	}
	@Test(groups = {"regression"})
	public void B5() {
		System.out.println("b5");
	}


}
