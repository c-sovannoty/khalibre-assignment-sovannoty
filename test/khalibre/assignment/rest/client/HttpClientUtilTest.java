package khalibre.assignment.rest.client;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.khalibre.assignment.utils.HttpClientUtil;

public class HttpClientUtilTest {

	@Test
	public void sendGetTest() throws Exception {
		String result = HttpClientUtil.sendGet("?q=liferay-portal+language:JavaScript&page=1&per_page=1");
		// assert statements
		assertTrue(result.contains("\"language\":\"JavaScript\""));
	}
}