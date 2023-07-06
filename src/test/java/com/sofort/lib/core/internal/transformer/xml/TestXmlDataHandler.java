package com.sofort.lib.core.internal.transformer.xml;

import com.sofort.lib.core.internal.transformer.DataHandlerException;
import com.sofort.lib.core.internal.transformer.RawResponse;
import com.sofort.lib.core.internal.transformer.RawResponse.Status;
import com.sofort.lib.core.products.response.SofortLibResponse;
import org.testng.annotations.Test;


public class TestXmlDataHandler {

	@Test(expectedExceptions = DataHandlerException.class, expectedExceptionsMessageRegExp = "Could not parse the respone XML: xml")
	public void testFail() {

		new XmlDataHandler(new XmlConfig() {

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

		}).parse(new RawResponse(Status.OK, "xml"), SofortLibResponse.class);
	}

}
