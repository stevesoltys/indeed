package com.stevesoltys.indeed.model;

import lombok.Data;

import java.util.List;

/**
 * Wrapper for an Indeed API search response.
 *
 * @author Steve Soltys
 */
@Data
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
}
