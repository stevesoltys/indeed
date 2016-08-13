package com.stevesoltys.indeed.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * A mock XML response builder.
 *
 * @author Steve Soltys
 */
public class MockResponseBuilder {

    /**
     * A mock number of total results.
     */
    public static final int MOCK_TOTAL_RESULTS = 12345;

    /**
     * A mock company name.
     */
    public static final String MOCK_COMPANY = "DuckDuckGo";

    /**
     * A mock job key.
     */
    public static final String MOCK_JOB_KEY = "1a2b3c4d5e6f7g8h9";

    /**
     * Builds a document, given the XML input.
     *
     * @param input The XML input.
     * @return The parsed document.
     * @throws Exception If there is an error while building the document.
     */
    Document buildDocument(String input) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource documentSource = new InputSource(new StringReader(input));

        return documentBuilder.parse(documentSource);
    }

    /**
     * Builds a mocked search response.
     *
     * @return The search response.
     */
    public String buildSearchResponse() {
        StringBuilder response = new StringBuilder();

        response.append("<response version=\"2\">");
        response.append("<totalresults>" + MOCK_TOTAL_RESULTS + "</totalresults>");
        response.append("<results>");

        response.append("<result>");
        response.append("<company>" + MOCK_COMPANY + "</company>");
        response.append("<jobkey>" + MOCK_JOB_KEY + "</jobkey>");
        response.append("</result>");

        response.append("</results>");
        response.append("</response>");

        return response.toString();
    }

    /**
     * Builds a mocked job response.
     *
     * @return The job response.
     */
    public String buildJobResponse() {
        StringBuilder response = new StringBuilder();

        response.append("<response version=\"2\">");
        response.append("<results>");

        response.append("<result>");
        response.append("<company>" + MOCK_COMPANY + "</company>");
        response.append("</result>");

        response.append("</results>");
        response.append("</response>");

        return response.toString();
    }

}
