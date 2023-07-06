package com.sofort.lib.core;

import com.sofort.lib.core.internal.ResourceContentReader;
import com.sofort.lib.core.internal.transformer.DataHandler;
import com.sofort.lib.core.internal.transformer.RawResponse;
import com.sofort.lib.core.internal.transformer.xml.XmlConfig;
import com.sofort.lib.core.internal.transformer.xml.XmlDataHandler;
import com.sofort.lib.core.internal.utils.xml.XmlFormatter;
import com.sofort.lib.core.products.response.SofortTransactionStatusNotification;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;


public class TestSofortLibCommon {

	@Test
	public void testTransactionNotification() {
		String content = new ResourceContentReader("/xml/core/TransactionStatusNotification.xml").getContent();

		/* parse the received notification response */
		DataHandler dataHandler = new XmlDataHandler(new XmlConfig() {

			@Override
			protected void initRootEntryMapping() {
				/* NoOp */
			}


			@Override
			protected void initRendererMapping() {
				/* NoOp */
			}


			@Override
			protected void initParserMapping() {
				/* NoOp */
			}
		});

		SofortLibCommon sofortLib = new SofortLibCommon(null, dataHandler, LogFactory.getLog(getClass()));
		SofortTransactionStatusNotification response = sofortLib.parseStatusNotificationResponse(new RawResponse(RawResponse.Status.OK, content));

		/* test the received notification response */
		assertNotNull(response);
		assertEquals("00002-20000-A1B2C3D4-E5F6", response.getTransId());
		assertEquals("2013-04-11T15:24:14+0200", new SimpleDateFormat(XmlFormatter.DATE_FORMAT, XmlFormatter.DATE_LOCALE).format(response.getTime()));
	}

}
