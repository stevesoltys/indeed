package com.stevesoltys.indeed.util;

import com.stevesoltys.indeed.model.IndeedResult;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ResultParser}.
 *
 * @author Steve Soltys
 */
public class ResultParserTest {

    /**
     * The result parser.
     */
    private ResultParser resultParser;

    /**
     * The mocked response node.
     */
    private Node node;

    @Before
    public void initialize() throws Exception {
        MockResponseBuilder responseBuilder = new MockResponseBuilder();

        Document mockResponse = responseBuilder.buildDocument(responseBuilder.buildJobResponse());
        this.node = mockResponse.getFirstChild().getFirstChild().getFirstChild();

        this.resultParser = new ResultParser();
    }

    /**
     * Tests a valid {@link ResultParser#parseResult(Node)} call.
     */
    @Test
    public void testValidNode() throws Exception {
        IndeedResult result = resultParser.parseResult(node);

        assertEquals(MockResponseBuilder.MOCK_COMPANY, result.getCompany());
    }

    /**
     * Tests an invalid {@link ResultParser#parseResult(Node)} call.
     */
    @Test(expected = Exception.class)
    public void testNullNode() throws Exception {
        resultParser.parseResult(null);
    }

}