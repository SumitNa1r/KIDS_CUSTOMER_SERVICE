package edu.neu.cs8674.CARE;

import com.hp.hpl.jena.rdf.model.RDFNode;

public interface Loop_elements {

	//public void directive();
	public void fact();
	public void perception();
	public void hypothesis();
	public void directive(RDFNode x, RDFNode y);
	
}
