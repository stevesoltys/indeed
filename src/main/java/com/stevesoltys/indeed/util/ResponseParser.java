package com.stevesoltys.indeed.util;

import com.stevesoltys.indeed.exception.IndeedParseException;
import com.stevesoltys.indeed.model.IndeedSearchResults;
import com.stevesoltys.indeed.model.IndeedResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Parses XML responses that are received from the Indeed API.
 *
 * @author Steve Soltys
 */
public class ResponseParser {

    /**
     * The XML tag for an {@link IndeedResult}.
     */
    private static final String RESULT_TAG = "result";

    /**
     * The XML tag for the total number of search results.
     */
    private static final String TOTAL_RESULTS_TAG = "totalresults";

    /**
     * The result parser.
     */
    private final ResultParser resultParser;

    public ResponseParser(ResultParser resultParser) {
        this.resultParser = resultParser;
    }

    /**
     * Parses an XML search response and returns the results.
     *
     * @param response The XML response.
     * @return The search results.
     * @throws IndeedParseException If there is an error while parsing the XML response.
     */
    public IndeedSearchResults parseSearch(String response) throws IndeedParseException {
        Document document = createDocument(response);

        List<IndeedResult> results = parseSearchResults(document);
        int totalResults = parseTotalResults(document);

        return new IndeedSearchResults(results, totalResults);
    }

    /**
     * Parses an XML job response and returns the result.
     *
     * @param response The XML response.
     * @return The result.
     * @throws IndeedParseException If there is an error while parsing the XML response.
     */
    public IndeedResult parseJob(String response) throws IndeedParseException {

        Document document = createDocument(response);
        NodeList nodeList = document.getElementsByTagName(RESULT_TAG);

        if(nodeList.getLength() == 0) {
            throw new IndeedParseException("Could not find tag '" + RESULT_TAG + "'");
        }

        Node node = nodeList.item(0);
        return resultParser.parseResult(node);
    }

    /**
     * Creates a document, given the XML response.
     *
     * @param response The XML response.
     * @return The parsed document.
     * @throws IndeedParseException If there is an error while parsing the XML response.
     */
    private Document createDocument(String response) throws IndeedParseException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(response)));

        } catch (Exception e) {
            e.printStackTrace();
            throw new IndeedParseException("Could not parse response");
        }

    }

    /**
     * Parses search results, given the document.
     *
     * @param document The document.
     * @return The search results.
     * @throws IndeedParseException If there is an error while parsing the document.
     */
    private List<IndeedResult> parseSearchResults(Document document) throws IndeedParseException {
        List<IndeedResult> results = new LinkedList<>();

        NodeList resultNodes = document.getElementsByTagName(RESULT_TAG);

        for (int i = 0; i < resultNodes.getLength(); i++) {
            Node node = resultNodes.item(i);

            results.add(resultParser.parseResult(node));
        }

        return results;
    }

    /**
     * Gets the total number of results for a search, given the document.
     *
     * @param document The document.
     * @return The total number of search results.
     * @throws IndeedParseException If there is an error while parsing the document.
     */
    private int parseTotalResults(Document document) throws IndeedParseException {

        NodeList list = document.getElementsByTagName(TOTAL_RESULTS_TAG);

        if (list.getLength() == 0) {
            throw new IndeedParseException("Could not find tag '" + TOTAL_RESULTS_TAG + "'");
        }

        Node totalResultsNode = list.item(0);

        return Integer.parseInt(totalResultsNode.getTextContent());
    }

}
