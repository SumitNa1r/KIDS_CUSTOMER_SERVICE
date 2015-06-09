package edu.neu.cs8674.CARE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hp.hpl.jena.rdf.model.RDFNode;

public class Solution_plan implements Loop_elements {

	@Override
	public void directive(RDFNode x, RDFNode y) {
		System.out.println("Solution Plan: Directive");	
		directive d = new directive(0, y.toString(), x.toString(), "Solution Plan", get_date());
		directiveDAO dir = new directiveDAO();		
		dir.create_directive(d);
		
	}

	@Override
	public void fact() {
		System.out.println("Solution Plan: FACT");
		
	}

	@Override
	public void perception() {
		System.out.println("Solution Plan: perception");
		
	}

	@Override
	public void hypothesis() {
		System.out.println("Solution Plan: hypothesis");
		
	}
	
	public String get_date(){
		DateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dat = new Date();
		return date.format(dat);		
	}

}
