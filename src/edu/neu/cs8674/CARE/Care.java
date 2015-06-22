package edu.neu.cs8674.CARE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * @author SUMIT
 *
 */
public class Care {
	/**
	 * Identify the issue. This function converts the facts into perception
	 * using classification, perception is then converted into hypothesis using
	 * Assessment, hypothesis is converted into directive using resolution,
	 * resolution is converted into fact using enactment.
	 * 
	 * @param x
	 *            Issue Ticket id URI
	 * @param y
	 *            Feature URI
	 */
	public void issue_Identification(String x, String y) {
		System.out.println("Identification phase..");
		Loop_elements e = new Issue_indetification();
		e.directive(x, y); 
		e.fact(x, y);
		e.perception(x, y);
		e.hypothesis(x, y);

	}

	
	/**
	 * Verify the issue. This function converts the facts into perception using
	 * classification, perception is then converted into hypothesis using
	 * Assessment, hypothesis is converted into directive using resolution,
	 * resolution is converted into fact using enactment.
	 * 
	 * @param x
	 *            Issue Ticket id URI
	 * @param y
	 *            Feature URI
	 */
	public void issue_verification(String x, String y) {
		System.out.println("Verification phase..");
		Loop_elements e = new Issue_verification();
		e.directive(x, y);
		e.fact(x, y);
		e.perception(x, y);
		e.hypothesis(x, y);

	}

	/**
	 * Determine the cause of the issue. This function converts the facts into
	 * perception using classification, perception is then converted into
	 * hypothesis using Assessment, hypothesis is converted into directive using
	 * resolution, resolution is converted into fact using enactment.
	 * 
	 * @param x
	 *            Issue Ticket id URI
	 * @param y
	 *            Feature URI
	 */
	public void issue_cause_determination(String x, String y) {
		System.out.println("Cause determination phase..");
		Loop_elements e = new Cause_determination();
		e.directive(x, y);

		e.fact(x, y);
		e.perception(x, y);
		e.hypothesis(x, y);

	}

	/**
	 * Give a solution to issue. This function converts the facts into
	 * perception using classification, perception is then converted into
	 * hypothesis using Assessment, hypothesis is converted into directive using
	 * resolution, resolution is converted into fact using enactment.
	 * 
	 * @param x
	 *            Issue Ticket id URI
	 * @param y
	 *            Feature URI
	 */
	public void issue_solution_plan(String x, String y) {
		System.out.println("Issue solution phase..");
		Loop_elements e = new Solution_plan();
		e.directive(x, y);

		e.fact(x, y);
		e.perception(x, y);
		e.hypothesis(x, y);

	}

	
	/**
	 * Verify the solution by contacting user
	 * @return The boolean response from the user.
	 */
	public boolean isVerifiedSolution() {
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

		if ("y".equals(response))
			return true;
		else
			return false;
	}

	/**
	 * Check with user if he/she accepts the cause for failure detected.
	 * @return The boolean response from the user.
	 */
	public boolean isCauseDeterminedWithhighConfidence() {
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

	/**
	 * Generates a random number.
	 * 
	 * @param n
	 *            Any integer
	 * @return Any random number between (0,n)
	 */
	public int get_random_number(int n) {
		Random random = new Random();
		return random.nextInt(n);
	}

	/**
	 * Check with user if issue has been resolved
	 * 
	 * @return The boolean response from the user.
	 */
	public boolean isIssueVerified() {
		String response = "";
		System.out.println("Is issue verified?");
		System.out.println("Press Y to accept and N to reject");

		InputStreamReader ins = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(ins);
		try {
			response = stdin.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if ("y".equals(response))
			return true;
		else
			return false;
	}

	/**
	 * Check with user if he/she accepts the cause for failure detected.
	 * @return The boolean response from the user.
	 */
	public boolean isCauseDetermined() {
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

		if ("y".equals(response))
			return true;
		else
			return false;
	}

	

	/**
	 * Checks if there is already a known issue to the incident ticket.
	 * 
	 * @param m
	 *            Known issue model
	 * @param p
	 *            Product which has issue (Ms Office)
	 * @param c1
	 *            Sub category1 (Ms Word)
	 * @param c2
	 *            Sub category2 (ctrl+v, ctrl+c does not work)
	 * @return The issue which has attributes product p, sub cat1 c1, sub cat2
	 *         c2
	 */
	public static String if_exist_KI(Model m, String p,
			String c1, String c2) {
		String response = "";
		String queryString = "SELECT ?node ?is_valid ?issue WHERE {?node <http://cs8764/neu/edu/KI/product> "
				+"\""
				+ p.toString()
				+"\""
				+ "."
				+ "?node <http://cs8764/neu/edu/KI/sub_cat1> "
				+"\""
				+ c1.toString()
				+"\""
				+ "."
				+ "?node <http://cs8764/neu/edu/KI/is_valid> "
				+ "?is_valid"
				+ "."
				+ "?node <http://cs8764/neu/edu/KI/Issue> "
				+ "?issue"
				+ "."
				+ "?node <http://cs8764/neu/edu/KI/sub_cat2> "
				+"\""
				+ c2.toString() + "\"}";
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query,m);
		try {
			ResultSet rs = qexec.execSelect();
			while (rs.hasNext()) {

				QuerySolution rb = rs.nextSolution();
				//RDFNode KI = rb.get("node");
				RDFNode is_valid = rb.get("is_valid");
				RDFNode issue = rb.get("issue");
				
				if ("y".equals(is_valid.toString()))
					response = issue.toString();
				else if("n".equals(is_valid.toString()))
				{
					response = "";
					break;
				}
			}
		} finally {
			qexec.close();
		}
		return response;
	}

	/**
	 * For each problem ticket it tries to find a solution.
	 * 
	 * @param problem_model
	 *            Problem Model
	 * @param user_model
	 *            User Model
	 * @param known_issue_model
	 *            Known Issue Model
	 */
	public static void solve_problem_tickets(Model problem_model, Model user_model, Model known_issue_model) {
		System.out.println("Solving problem tickets");
		RandomData rd = new RandomData();
		ArrayList<String> res = new ArrayList<String>();
		String queryString = "SELECT ?node ?product ?cat1 ?cat2 "
				+ "WHERE {?node <http://cs8764/neu/edu/Problem/product> ?product. "
				+ "?node <http://cs8764/neu/edu/Problem/sub_cat1> ?cat1. "
				+ "?node <http://cs8764/neu/edu/Problem/sub_cat2> ?cat2 }";
		Query query = QueryFactory.create(queryString);

		QueryExecution qexec = QueryExecutionFactory.create(query, problem_model);
		
		//from problem model fetch all problem tickets and store it as a string
		try {
			ResultSet rs = qexec.execSelect();
			while (rs.hasNext()) {
				QuerySolution rb = rs.nextSolution();
				RDFNode x = rb.get("node");
				RDFNode p = rb.get("product");
				RDFNode c1 = rb.get("cat1");
				RDFNode c2 = rb.get("cat2");
				
				String s = x.toString()+",,"+p.toString()+",,"+c1.toString()+",,"+c2.toString();
				res.add(s);
			}

		} finally {
			qexec.close();
		}
		
		//For each problem string try to find solution
		for(String s : res){
			String param[] = s.split(",,");
			String r = param[0];
/*			String p = param[1];
			String c1 = param[2];
			String c2 = param[3];*/
			
			String user = "http://cs8764/neu/edu/User#"+rd.get_random_number(10);
			System.out.println("User "+user+" has been assigned the problem ticket");
			
			while(true){
				//Determine the change required to solve the problem
				//and the cost to implement the change.
				String change = "change"+rd.get_random_number(10);
				String cost = "$"+rd.get_random_number(1000);
				if(is_change_acceptable(change, cost)){
					rd.add_details(problem_model, r, user, change, cost);
					
					//If the problem ticket is resolved then the known issue
					//associated with it is also resolved.
					remove_KI(r,problem_model,known_issue_model);
					break;
				}
			}
		}
	}

	/**
	 * Set the is_valid attribute of known issue to "n".
	 * 
	 * @param r
	 *            Problem ticket
	 * @param problem_model
	 *            Problem Model
	 * @param KI_model
	 *            Known issue Model
	 */
	public static void remove_KI(String r, Model problem_model, Model KI_model) {
		Resource p = problem_model.getResource(r);
		String known_issue = "http://cs8764/neu/edu/Problem/KI";
		Property KI_property = problem_model.getProperty(known_issue);
		System.out.println(p.getProperty(KI_property).getObject());
		
		Resource k = KI_model.getResource(p.getProperty(KI_property).getObject().toString());
		String is_valid = "http://cs8764/neu/edu/KI/is_valid";
		Property is_valid_property = KI_model.getProperty(is_valid);
		
		k.addProperty(is_valid_property, "n");		
		System.out.println(k.getProperty(is_valid_property).getObject());		
	}

	/**
	 * Check with the user if change and cost associated with it is acceptable.
	 * 
	 * @param change
	 *            Change that needs to be done
	 * @param cost
	 *            Cost for implementing that change
	 * @return Boolean response from the user
	 */
	public static boolean is_change_acceptable(String change, String cost) {
		String response = "";
		System.out.println("Change " + change +" need to be implemented to resolve the problem");
		System.out.println("It would cost " + cost);
		System.out.println("Is acceptable");
		System.out.println("Press Y to accept and N to find different solution");

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

	/**
	 * Change the status of an Incident ticket
	 * 
	 * @param issue_model
	 *            Issue Model
	 * @param y
	 *            Issue ticket URI
	 * @param n
	 *            Status number
	 */
	public static void change_status(Model issue_model,
			String y, int n) {
		Resource r = issue_model.getResource(y.toString());
		String Status = "http://cs8764/neu/edu/Status";
		String status = "http://cs8764/neu/edu/Issue/status";
		Property status_property = issue_model.getProperty(status);
		r.addProperty(status_property, Status + "#" + n );		
	}

	/**
	 * Given product and it sub categorizations it returns true if there exit a
	 * problem ticket with same attributes, else returns false.
	 * 
	 * @param m
	 *            Problem Model
	 * @param p
	 *            Product
	 * @param c1
	 *            sub category 1
	 * @param c2
	 *            sub category 2
	 * @param issue
	 *            Issue ticket URI
	 * @return True if product already exists, else returns False
	 */
	public static boolean check_is_problem_ticket_present(Model m,String p,
			String c1, String c2, String issue) {
		
		String queryString = "SELECT ?node WHERE {?node <http://cs8764/neu/edu/Problem/product> "
				+"\""
				+ p.toString()
				+"\""
				+ "."
				+ "?node <http://cs8764/neu/edu/Problem/sub_cat1> "
				+"\""
				+ c1.toString()
				+"\""
				+ "."
				+ "?node <http://cs8764/neu/edu/Problem/sub_cat2> "
				+"\""
				+ c2.toString() + "\"}";
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query,m);
		try {
			ResultSet rs = qexec.execSelect();
			while (rs.hasNext()) {

				QuerySolution rb = rs.nextSolution();
				RDFNode problem_ticket = rb.get("node");
				
				add_issue_to_problem_ticket(issue, problem_ticket,m);
				return true;
			}
		} finally {
			qexec.close();
		}
		return false;
	}

	/**
	 * Add a new incident to problem ticket if its attributes match.
	 * 
	 * @param issue
	 *            Issue URI
	 * @param problem_ticket
	 *            Problem Ticket
	 * @param m
	 *            Issue Model
	 */
	public static void add_issue_to_problem_ticket(String issue,
			RDFNode problem_ticket, Model m) {
    
		Resource r = m.getResource(problem_ticket.toString());
		String problem_issue = "http://cs8764/neu/edu/Problem/Issue";
		Property issue_property = m.getProperty(problem_issue);
		String old_value = r.getProperty(issue_property).getObject().toString();
		String new_val = old_value+", "+ issue.toString();
		
		r.addProperty(issue_property, new_val);
	}

	/**
	 * Get the count of incident tickets which have same attributes as current
	 * tickets.
	 * 
	 * @param y
	 *            Issue Ticket URI
	 * @param issue_model
	 *            Issue Model
	 * @param p
	 *            Product
	 * @param c1
	 *            Sub category 1
	 * @param c2
	 *            Sub category 2
	 * @return count of incident tickets having same attributes
	 */
	public static int is_there_problem(String y, Model issue_model,
			String p, String c1, String c2) {

		int count = 0;

		String queryString = "SELECT ?node WHERE {?node <http://cs8764/neu/edu/Issue/product> "
				+ "<"
				+ p.toString()
				+ ">"
				+ "."
				+ "?node <http://cs8764/neu/edu/Issue/sub_cat1> "
				+ "<"
				+ c1.toString()
				+ ">"
				+ "."
				+ "?node <http://cs8764/neu/edu/Issue/sub_cat2> "
				+ "<"
				+ c2.toString() + ">" + "}";

		// System.out.println(queryString);

		Query query = QueryFactory.create(queryString);

		QueryExecution qexec = QueryExecutionFactory.create(query, issue_model);
		try {
			ResultSet rs = qexec.execSelect();
			while (rs.hasNext()) {

				QuerySolution rb = rs.nextSolution();
				count++;
			}
		} finally {
			qexec.close();
		}
		return count;
	}
	
	/**
	 * Resolves the incident ticket using CARE loop.
	 * 
	 * @param issue_model
	 *            Issue Model
	 * @param x
	 *            Issue Feature URI
	 * @param y
	 *            Issue URI
	 * @param loop
	 *            Object of class Care
	 */
	public static void run_loop(Model issue_model, String x, String y, Care loop)
	{
		while (true) {
			change_status(issue_model, y, 2);
			loop.issue_Identification(x, y);
			loop.issue_verification(x, y);
			if (loop.isIssueVerified()) {
				change_status(issue_model, y, 3);
				break;
			}
		}

		boolean completed = false;
		while (!completed) {
			for (;;) {
				loop.issue_cause_determination(x, y);
				if (loop.isCauseDeterminedWithhighConfidence()) {
					break;
				}
			}
			for (;;) {
				loop.issue_solution_plan(x, y);
				if (loop.isVerifiedSolution()) {
					change_status(issue_model, y, 4);
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
	
	/**
	 * Find all issues from issue model and convert it into a string.
	 * 
	 * @param issue_model
	 *            Issue Model
	 * @return list of string s each string in s is an issue, and attributes are
	 *         separated by ",,"
	 */
	public static List<String> get_all_issues(Model issue_model){
		ArrayList<String> issues = new ArrayList<String>();
		String queryString = "SELECT ?node ?feature ?product ?cat1 ?cat2 "
				+ "WHERE {?node <http://cs8764/neu/edu/Issue/feature> ?feature. "
				+ "?node <http://cs8764/neu/edu/Issue/product> ?product. "
				+ "?node <http://cs8764/neu/edu/Issue/sub_cat1> ?cat1. "
				+ "?node <http://cs8764/neu/edu/Issue/sub_cat2> ?cat2 }";

		Query query = QueryFactory.create(queryString);

		QueryExecution qexec = QueryExecutionFactory.create(query, issue_model);
		
		// For each issue fetch its attributes, create a string of attributes
		// and store it in array
		try {
			ResultSet rs = qexec.execSelect();
			while (rs.hasNext()) {
				QuerySolution rb = rs.nextSolution();
				RDFNode x = rb.get("feature");
				RDFNode y = rb.get("node");
				RDFNode p = rb.get("product");
				RDFNode c1 = rb.get("cat1");
				RDFNode c2 = rb.get("cat2");

				String s = x.toString() + ",," + y.toString() + ",,"
						+ p.toString() + ",," + c1.toString() + ",,"
						+ c2.toString();
				issues.add(s);

			}
		} finally {
			qexec.close();
		}
		
		return issues;
	}
	
	/**
	 * This function solves each incident tickets.
	 * 
	 * @param issue_model
	 *            Issue Model
	 * @param issues
	 *            Issue detected from issue model and stored as
	 *            list of strings
	 * @param rd
	 *            Object of RandomData
	 * @param problem_model
	 *            Problem Model
	 * @param known_issue_model
	 *            Known Issue Model
	 */
	public static void solve_incident_ticket(Model issue_model,
			List<String> issues, RandomData rd, Model problem_model,
			Model known_issue_model) {
		Care loop = new Care();

		//Model issue_model = Models.get(6);
		for (String s : issues) {
			String param[] = s.split(",,");
			String x = param[0];
			String y = param[1];
			String p = param[2];
			String c1 = param[3];
			String c2 = param[4];

			// Check if Solution to the issue exists
			String issue = if_exist_KI(known_issue_model, p, c1, c2);

			// if Solution already known display it
			if (!"".equals(issue)) {
				System.out
						.println("There exist a know Issue, refer solution of Incident ticket "
								+ issue + " for work around solution");
			}

			// If solution does not exist, try to resolve it
			else {
				int count = is_there_problem(y, issue_model, p, c1, c2);
				// If the issue is is found multiple times, create a problem
				// ticket and know issue
				if (count > 2) {
					if (!check_is_problem_ticket_present(problem_model, p, c1,
							c2, y)) {
						Resource known_issue = rd.create_KI_resource(
								known_issue_model, p.toString(), c1.toString(),
								c2.toString(), y.toString());
						rd.create_model_resource(problem_model, p.toString(),
								c1.toString(), c2.toString(), y.toString(),
								known_issue);
					}
				}

				// CARE loop
				run_loop(issue_model, x, y, loop);
			}
		}
	}
	
	public static void main(String[] args) {
		//create Object of random data class
		RandomData rd = new RandomData();
		
		//Generated all Models and data and store it in ArrayList
		ArrayList<Model> Models = (ArrayList<Model>) rd.createRandomData();
	
	/*  Model product_model = Models.get(0);
		Model sub_cat1_model = Models.get(2);
		Model sub_cat2_model = Models.get(3);
		Model feature_model = Models.get(4);
		Model status_model = Models.get(5);*/
		
		Model user_model = Models.get(1);
		Model issue_model = Models.get(6);
		Model issue_model1 = Models.get(7);
		Model problem_model = rd.create_problem_model();
		Model known_issue_model = rd.create_known_issue_model();
		
		//Fetch all issues from issue_model
		ArrayList<String> issues = new ArrayList<String>();
		issues = (ArrayList<String>) get_all_issues(issue_model);
		
		//For each issue, run care loop
		solve_incident_ticket(issue_model, issues, rd, problem_model, known_issue_model);
		
		//Once all issue have been resolved, work on problem tickets
		solve_problem_tickets(problem_model, user_model, known_issue_model);
		
		// once the problem is resolved we again create a ticket having
		// attributes(product, sub cat1, subcat2) same as that of resolved
		// problem ticket. Since the problem is resolved known issue associated
		// with it has also been removed. Now when we try to resolve this
		// incident ticket, there would be no known issue and so CARE loop will
		// be used to find the solution.
		
		ArrayList<String> issues1 = new ArrayList<String>();
		issues1 = (ArrayList<String>) get_all_issues(issue_model1);
		solve_incident_ticket(issue_model1, issues1, rd, problem_model, known_issue_model);		
	}
}
