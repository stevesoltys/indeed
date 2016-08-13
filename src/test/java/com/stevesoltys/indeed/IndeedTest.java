package com.stevesoltys.indeed;

import com.stevesoltys.indeed.model.IndeedResult;
import com.stevesoltys.indeed.model.IndeedSearchResults;
import com.stevesoltys.indeed.net.RestClient;
import com.stevesoltys.indeed.util.MockResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Indeed}.
 *
 * @author Steve Soltys
 */
public class IndeedTest {

    /**
     * The mocked API key (publisher key).
     */
    private static final String MOCK_API_KEY = "1a2b3c4d5e6f7g8h9";

    /**
     * A mocked REST client.
     */
    private class MockRestClient extends RestClient {

        @Override
        public String get(String url) {

            if (url.startsWith(RestClient.SEARCH_RESOURCE_URL)) {
                return new MockResponseBuilder().buildSearchResponse();

            } else if (url.startsWith(RestClient.JOB_RESOURCE_URL)) {
                return new MockResponseBuilder().buildJobResponse();

            } else {
                return null;
            }
        }

    }

    /**
     * The Indeed instance.
     */
    private Indeed indeed;

    @Before
    public void initialize() {
        this.indeed = new Indeed(MOCK_API_KEY, new MockRestClient());
    }

    /**
     * Tests a valid search.
     */
    @Test
    public void testValidSearch() throws Exception {
        IndeedSearchResults searchResults = indeed.search()
                .query("Java").location("NYC")
                .coordinates(true).filter(false).highlight(true)
                .backlog(30).start(50).limit(100).run();

        IndeedResult result = searchResults.getResults().get(0);

        assertEquals(MockResponseBuilder.MOCK_COMPANY, result.getCompany());
        assertEquals(MockResponseBuilder.MOCK_JOB_KEY, result.getJobKey());
    }

    /**
     * Tests a search without the 'location' parameter.
     */
    @Test(expected = Exception.class)
    public void testNoLocationSearch() throws Exception {
        indeed.search().query("Java").run();
    }

    /**
     * Tests a search without the 'query' parameter.
     */
    @Test(expected = Exception.class)
    public void testNoQuerySearch() throws Exception {
        indeed.search().location("Java").run();
    }

}
