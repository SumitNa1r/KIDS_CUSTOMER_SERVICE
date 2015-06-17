package edu.neu.cs8674.CARE;

import com.hp.hpl.jena.rdf.model.RDFNode;

/**
 * @author SUMIT
 *
 */
public interface Loop_elements {

	/**
	 * @param x Issue ID ticket URI
	 * @param y Issue feature URI
	 */
	public void fact(String x, String y);
	
	
	/**
	 * @param x Issue ID ticket URI
	 * @param y Issue feature URI
	 */
	public void perception(String x, String y);
	
	
	/**
	 * @param x Issue ID ticket URI
	 * @param y Issue feature URI
	 */
	public void hypothesis(String x, String y);
	
	
	/**
	 * @param x Issue ID ticket URI
	 * @param y Issue feature URI
	 */
	public void directive(String x, String y);
	
}
