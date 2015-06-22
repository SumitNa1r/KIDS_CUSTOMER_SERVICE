package edu.neu.cs8674.CARE;

import com.hp.hpl.jena.rdf.model.RDFNode;

/**
 * @author SUMIT
 *
 */
public interface Loop_elements {

	/**
	 * Initial data. The initial data is stored as facts in database
	 * 
	 * @param x
	 *            Issue ID ticket URI
	 * @param y
	 *            Issue feature URI
	 */
	public void fact(String x, String y);
	
	
	/**
	 * Uses classification to convert initial data into perception. This new
	 * converted data is then stored into database.
	 * 
	 * @param x
	 *            Issue ID ticket URI
	 * @param y
	 *            Issue feature URI
	 */
	public void perception(String x, String y);
	
	
	/**
	 * Uses Assessment to convert perception into hypothesis. This new converted
	 * data is then stored into database.
	 * 
	 * @param x
	 *            Issue ID ticket URI
	 * @param y
	 *            Issue feature URI
	 */
	public void hypothesis(String x, String y);
	
	
	/**
	 * Uses Resolution to convert hypothesis into directive. This new converted
	 * data is then stored into database.
	 * 
	 * @param x
	 *            Issue ID ticket URI
	 * @param y
	 *            Issue feature URI
	 */
	public void directive(String x, String y);
	
}
