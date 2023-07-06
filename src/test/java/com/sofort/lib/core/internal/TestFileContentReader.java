package com.sofort.lib.core.internal;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class TestFileContentReader {

	@Test
	public void testSuccess() {
		String content = new ResourceContentReader("/xml/core/dummy.xml").getContent();
		assertEquals("<dummy/>", content);
	}


	@Test(expectedExceptions = NullPointerException.class)
	public void testFail() {
		new ResourceContentReader("/not-existed-file").getContent();
	}

}
