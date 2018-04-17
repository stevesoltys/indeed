package com.stevesoltys.indeed.util;

import com.stevesoltys.indeed.model.IndeedResult;
import com.stevesoltys.indeed.model.IndeedSearchResults;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ResponseParser}.
 *
 * @author Steve Soltys
 */
public class ResponseParserTest {

    /**
     * The response parser.
     */
    private ResponseParser responseParser;

    /**
     * The mocked search response XML.
     */
    private String searchResponse;

    /**
     * The mocked job response XML.
     */
    private String jobResponse;

    @Before
    public void initialize() {
        this.responseParser = new ResponseParser(new ResultParser());

        this.searchResponse = new MockResponseBuilder().buildSearchResponse();
        this.jobResponse = new MockResponseBuilder().buildJobResponse();
    }

    /**
     * Tests parsing of a valid search response.
     */
    @Test
    public void testParseSearch() throws Exception {

        IndeedSearchResults resultSet = responseParser.parseSearch(searchResponse);
        assertEquals(resultSet.getTotalResults(), MockResponseBuilder.MOCK_TOTAL_RESULTS);

        IndeedResult result = resultSet.getResults().get(0);
        assertEquals(result.getCompany(), MockResponseBuilder.MOCK_COMPANY);
        assertEquals(result.getJobKey(), MockResponseBuilder.MOCK_JOB_KEY);
    }

    /**
     * Tests parsing of an invalid search.
     */
    @Test(expected = Exception.class)
    public void testInvalidSearchResponse() throws Exception {
        responseParser.parseSearch("");
    }

    /**
     * Tests parsing of a valid job response.
     */
    @Test
    public void testParseJob() throws Exception {
        IndeedResult result = responseParser.parseJob(jobResponse);

        assertEquals(result.getCompany(), MockResponseBuilder.MOCK_COMPANY);
    }

    /**
     * Tests parsing of an invalid job response.
     */
    @Test(expected = Exception.class)
    public void testInvalidJobResponse() throws Exception {
        responseParser.parseSearch("");
    }

}