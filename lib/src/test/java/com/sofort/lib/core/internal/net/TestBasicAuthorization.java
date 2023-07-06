package com.sofort.lib.core.internal.net;

import com.sofort.lib.core.internal.net.http.BasicHttpAuthorization;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


/**
 * Tests the basic authorization.
 */
public class TestBasicAuthorization {

	@Test
	public void testBasicAuthorization() {
		assertEquals("Basic MTIzNDU6", new BasicHttpAuthorization(12345, "").getValue());
		assertEquals("Basic MTIzNDU6MTIzNDU=", new BasicHttpAuthorization(12345, "12345").getValue());
	}

}
