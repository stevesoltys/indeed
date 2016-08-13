package com.stevesoltys.indeed.net;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Tests {@link RestClient}.
 *
 * @author Steve Soltys
 */
public class RestClientTest {

    /**
     * The resource URL being used in this test.
     */
    private static final String TEST_RESOURCE_URL = "http://google.com";

    /**
     * The REST client.
     */
    private RestClient restClient;

    @Before
    public void initialize() throws Exception {
        this.restClient = new RestClient();
    }

    /**
     * Tests a valid GET request.
     */
    @Test
    public void testValidGet() throws Exception {
        String response = restClient.get(TEST_RESOURCE_URL);

        assertNotEquals(response, "");
        assertNotEquals(response, null);
    }

    /**
     * Tests an invalid GET request.
     */
    @Test(expected = Exception.class)
    public void testInvalidGet() throws Exception {
        restClient.get("");
    }

}