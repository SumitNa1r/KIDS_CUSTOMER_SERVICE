package edu.neu.cs8674.CARE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

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
		e.fact(x,y); 
		e.perception(x,y); 
		e.hypothesis(x,y);
		 

	}

	public void issue_verification(RDFNode x, RDFNode y) {
		System.out.println("Verification phase..");
		Loop_elements e = new Issue_verification();
		e.directive(x, y);
		e.fact(x,y);
		e.perception(x,y);
		e.hypothesis(x,y);
		 

	}

	public void issue_cause_determination(RDFNode x, RDFNode y) {
		System.out.println("Cause determination phase..");
		Loop_elements e = new Cause_determination();
		e.directive(x,y);
		
		e.fact(x,y); 
		e.perception(x,y); 
		e.hypothesis(x,y);
		 

	}

	public void issue_solution_plan(RDFNode x, RDFNode y) {
		System.out.println("Issue solution phase..");
		Loop_elements e = new Solution_plan();
		e.directive(x,y);
		
		e.fact(x,y); 
		e.perception(x,y); 
		e.hypothesis(x,y);
		 

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
		String response = "";
		System.out.println("Is solution Verified?");
		System.out.println("Press Y to accept and N to reject");
		
		InputStreamReader ins = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(ins);
		try {
			response = stdin.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("y".equals(response))
			return true;
		else
			return false;
	}

	private boolean isCauseDeterminedWithhighConfidence() {
		String response = "";
		int i = get_random_number(100);
		System.out.println("Root cause has been determined with " + i
				+ " % confidence");
		System.out.println("Press Y to accept and N to reject");

		InputStreamReader ins = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(ins);
		try {
			response = stdin.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if ("y".equals(response))
			return true;
		else
			return false;
	}

	public int get_random_number(int n) {
		Random random = new Random();
		return random.nextInt(n);
	}
	
	private boolean isIssueVerified() {
		String response = "";
		System.out.println("Is issue verified?");
		System.out.println("Press Y to accept and N to reject");
		
		InputStreamReader ins = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(ins);
		try {
			response = stdin.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("y".equals(response))
			return true;
		else
			return false;
	}

	private boolean isCauseDetermined() {
		String response = "";
		System.out.println("Is cause determined?");
		System.out.println("Press Y to accept and N to reject");
		
		InputStreamReader ins = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(ins);
		try {
			response = stdin.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("y".equals(response))
			return true;
		else
			return false;
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
