package com.stevesoltys.indeed;

import com.stevesoltys.indeed.model.IndeedSearchResults;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Steve Soltys
 */
public class IndeedIntegrationTest {

    /**
     * The Indeed instance.
     */
    private Indeed indeed;

    @Before
    public void initialize() {
        indeed = new Indeed(System.getenv("INDEED_PUBLISHER_KEY"));
    }

    /**
     * Tests a valid search using a real publisher key.
     */
    @Test
    public void testValidSearch() throws Exception {
        IndeedSearchResults searchResults = indeed.search()
                .query("Java").location("NYC")
                .coordinates(true).filter(false).highlight(true)
                .backlog(30).start(0).limit(100).run();

        assertTrue(!searchResults.getResults().isEmpty());
        assertTrue(searchResults.getTotalResults() > 0);
    }
}
