package edu.neu.cs8674.CARE;

import com.hp.hpl.jena.rdf.model.RDFNode;

public interface Loop_elements {

	//public void directive();
	public void fact(RDFNode x, RDFNode y);
	public void perception(RDFNode x, RDFNode y);
	public void hypothesis(RDFNode x, RDFNode y);
	public void directive(RDFNode x, RDFNode y);
	
}
