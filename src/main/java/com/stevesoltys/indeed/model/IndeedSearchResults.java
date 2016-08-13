package com.stevesoltys.indeed.model;

import java.util.List;

/**
 * Wrapper for an Indeed API search response.
 *
 * @author Steve Soltys
 */
public class IndeedSearchResults {

    /**
     * The results.
     */
    private final List<IndeedResult> results;

    /**
     * The total number of results. Note that this is not the number of results in this list alone. It is the total
     * number of results given for this particular search.
     */
    private final int totalResults;

    public IndeedSearchResults(List<IndeedResult> results, int totalResults) {
        this.results = results;
        this.totalResults = totalResults;
    }

    /**
     * Gets the result list.
     *
     * @return The result list.
     */
    public List<IndeedResult> getResults() {
        return results;
    }

    /**
     * Gets total number of results. Note that this is not the number of results in this list alone. It is the total
     * number of results given for this particular search.
     *
     * @return The total number of results.
     */
    public int getTotalResults() {
        return totalResults;
    }
}
