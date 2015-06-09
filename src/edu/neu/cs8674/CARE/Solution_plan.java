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
	public void fact(RDFNode x, RDFNode y) {
		System.out.println("Solution Plan: FACT");
		fact f = new fact(0, y.toString(), x.toString(), "Solution Plan", get_date());
		factDAO fct = new factDAO();
		fct.create_fact(f);
		
	}

	@Override
	public void perception(RDFNode x, RDFNode y) {
		System.out.println("Solution Plan: perception");
		perception p = new perception(0, y.toString(), x.toString(), "Solution Plan", get_date());
		perceptionDAO pd = new perceptionDAO();
		pd.create_perception(p);
		
	}

	@Override
	public void hypothesis(RDFNode x, RDFNode y) {
		System.out.println("Solution Plan: hypothesis");
		hypothesis h = new hypothesis(0, y.toString(), x.toString(), "Solution Plan", get_date());
		hypothesisDAO hd = new hypothesisDAO();
		hd.create_hypothesis(h);
		
	}
	
	public String get_date(){
		DateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dat = new Date();
		return date.format(dat);		
	}

}
