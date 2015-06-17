package edu.neu.cs8674.CARE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hp.hpl.jena.rdf.model.RDFNode;

/**
 * @author SUMIT
 *
 */
public class Cause_determination implements Loop_elements {

	@Override
	public void directive(String x, String y) {
		System.out.println("Cause Determination: Directive");

		directive d = new directive(0, y.toString(), x.toString(), "Cause Determination", get_date());
		directiveDAO dir = new directiveDAO();		
		dir.create_directive(d);
		
	}

	@Override
	public void fact(String x, String y) {
		System.out.println("Cause Determination: FACT");
		fact f = new fact(0, y.toString(), x.toString(), "Cause Determination", get_date());
		factDAO fct = new factDAO();
		fct.create_fact(f);
		
	}

	@Override
	public void perception(String x, String y) {
		System.out.println("Cause Determination: perception");
		perception p = new perception(0, y.toString(), x.toString(), "Cause Determination", get_date());
		perceptionDAO pd = new perceptionDAO();
		pd.create_perception(p);
		
	}

	@Override
	public void hypothesis(String x, String y) {
		System.out.println("Cause Determination: hypothesis");
		hypothesis h = new hypothesis(0, y.toString(), x.toString(), "Cause Determination", get_date());
		hypothesisDAO hd = new hypothesisDAO();
		hd.create_hypothesis(h);
		
	}
	
	public String get_date(){
		DateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dat = new Date();
		return date.format(dat);		
	}

}
