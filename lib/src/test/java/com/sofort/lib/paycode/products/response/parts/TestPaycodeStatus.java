package com.sofort.lib.paycode.products.response.parts;

import com.sofort.lib.paycode.products.common.PaycodeTransactionStatus;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;


public class TestPaycodeStatus {

	@Test
	public void testStatus() {
		assertEquals(3, PaycodeStatus.values().length);
		assertEquals(PaycodeStatus.OPEN, PaycodeStatus.get("open"));
		assertEquals(PaycodeStatus.USED, PaycodeStatus.get("USED"));
		assertEquals(PaycodeStatus.EXPIRED, PaycodeStatus.get("eXpIrEd"));
	}


	@Test
	public void testNull() {
		assertNull(PaycodeTransactionStatus.get(null));
	}


	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Unknown paycode status: xyz")
	public void testFail() {
		PaycodeStatus.get("xyz");
	}

}
