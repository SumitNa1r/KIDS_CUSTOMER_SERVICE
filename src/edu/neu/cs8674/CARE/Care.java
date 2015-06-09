package edu.neu.cs8674.CARE;

import java.util.ArrayList;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class Care {
	public void issue_Identification(RDFNode x, RDFNode y) {
		System.out.println("Identification phase..");
		Loop_elements e = new Issue_indetification();
		e.directive(x,y);
		/*
		 * e.fact(); e.perception(); e.hypothesis();
		 */

	}

	public void issue_verification(RDFNode x, RDFNode y) {
		System.out.println("Verification phase..");
		Loop_elements e = new Issue_verification();
		e.directive(x,y);
		/*
		 * e.fact(); e.perception(); e.hypothesis();
		 */

	}

	public void issue_cause_determination(RDFNode x, RDFNode y) {
		System.out.println("Cause determination phase..");
		Loop_elements e = new Cause_determination();
		e.directive(x,y);
		/*
		 * e.fact(); e.perception(); e.hypothesis();
		 */

	}

	public void issue_solution_plan(RDFNode x, RDFNode y) {
		System.out.println("Issue solution phase..");
		Loop_elements e = new Solution_plan();
		e.directive(x,y);
		/*
		 * e.fact(); e.perception(); e.hypothesis();
		 */

	}

	public void directive() {
		System.out.println("Find directive");
	}

	public void fact() {
		System.out.println("Find Facts");
	}

	public void perception() {
		System.out.println("Find perception");
	}

	public void hypothesis() {
		System.out.println("Find hypothesis");
	}

	private boolean isVerifiedSolution() {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean isCauseDeterminedWithhighConfidence() {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean isIssueVerified() {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean isCauseDetermined() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void main(String[] args) {
		RandomData rd = new RandomData();
		ArrayList<Model> Models = (ArrayList<Model>) rd.createRandomData();
		Model product_model = Models.get(0);
		Model user_model = Models.get(1);
		Model sub_cat1_model = Models.get(2);
		Model sub_cat2_model = Models.get(3);
		Model feature_model = Models.get(4);
		Model status_model = Models.get(5);
		Model issue_model = Models.get(6);

		Care loop = new Care();
		String queryString = "SELECT ?node ?feature WHERE {?node <http://cs8764/neu/edu/Issue/feature> ?feature}";

		Query query = QueryFactory.create(queryString);

		QueryExecution qexec = QueryExecutionFactory.create(query, issue_model);

		try {
			ResultSet rs = qexec.execSelect();
			while (rs.hasNext()) {
				QuerySolution rb = rs.nextSolution();
				RDFNode x = rb.get("feature");
				RDFNode y = rb.get("node");
				
				while (true) {
					loop.issue_Identification(x,y);
					loop.issue_verification(x,y);
					if (loop.isIssueVerified()) {
						break;
					}
				}

				boolean completed = false;
				while (!completed) {
					for (;;) {
						loop.issue_cause_determination(x,y);
						if (loop.isCauseDeterminedWithhighConfidence()) {
							break;
						}
					}
					for (;;) {
						loop.issue_solution_plan(x,y);
						if (loop.isVerifiedSolution()) {
							completed = true;
							break;
						}
						if (!loop.isCauseDetermined()) {
							completed = false;
							break;
						}
					}
				}
			}
		} finally {
			qexec.close();
		}



	}
}
