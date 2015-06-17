package edu.neu.cs8674.CARE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * @author SUMIT
 *
 */
public class RandomData extends Object {
	/**
	 * @return List of Models (Product, user, status, feature, sub category 1,
	 *         sub category 2,Issue) with all resources in it
	 */
	public List<Model> createRandomData() {
		// Product class having attributes name and id
		String Product = "http://cs8764/neu/edu/Product";
		String product_id = "http://cs8764/neu/edu/Product/id";
		String product_name = "http://cs8764/neu/edu/Product/name";

		// User class having attributes name and id
		String User = "http://cs8764/neu/edu/User";
		String user_id = "http://cs8764/neu/edu/User/id";
		String user_name = "http://cs8764/neu/edu/User/name";

		// Status class having attributes id and name
		String Status = "http://cs8764/neu/edu/Status";
		String status_id = "http://cs8764/neu/edu/Status/id";
		String status_name = "http://cs8764/neu/edu/Status/name";

		// Feature class having attributes id and name
		String Feature = "http://cs8764/neu/edu/Feature";
		String feature_id = "http://cs8764/neu/edu/Feature/id";
		String feature_name = "http://cs8764/neu/edu/Feature/name";

		// Sub category1 class having attributes id and name
		String Sub_cat1 = "http://cs8764/neu/edu/Sub_cat1";
		String sub_cat1_id = "http://cs8764/neu/edu/Sub_cat1/id";
		String sub_cat1_name = "http://cs8764/neu/edu/Sub_cat1/name";

		// Sub category2 class having attributes id and name
		String Sub_cat2 = "http://cs8764/neu/edu/Sub_cat2";
		String sub_cat2_id = "http://cs8764/neu/edu/Sub_cat2/id";
		String sub_cat2_name = "http://cs8764/neu/edu/Sub_cat2/name";

		// Class Issue and its attributes
		String Issue = "http://cs8764/neu/edu/Issue";
		String issue_id = "http://cs8764/neu/edu/Issue/id";
		String user = "http://cs8764/neu/edu/Issue/user";
		String status = "http://cs8764/neu/edu/Issue/status";
		String feature = "http://cs8764/neu/edu/Issue/feature";
		String product = "http://cs8764/neu/edu/Issue/product";
		String sub_cat1 = "http://cs8764/neu/edu/Issue/sub_cat1";
		String sub_cat2 = "http://cs8764/neu/edu/Issue/sub_cat2";
			
		// Random data generation for products
		Model product_model = ModelFactory.createDefaultModel();
		for (int i = 0; i < 10; i++) {
			Property id_property = product_model.getProperty(product_id);
			Property name_property = product_model.getProperty(product_name);

			Resource prod = product_model.createResource(Product + "#" + i)
					.addProperty(id_property, i + "")
					.addProperty(name_property, "product" + i);

		}

		// Random data generation for user
		Model user_model = ModelFactory.createDefaultModel();
		for (int i = 0; i < 10; i++) {
			Property id_property = user_model.getProperty(user_id);
			Property name_property = user_model.getProperty(user_name);

			Resource usr = user_model.createResource(User + "#" + i)
					.addProperty(id_property, i + "")
					.addProperty(name_property, "User" + i);

		}

		// Random data generation for sub cat 1
		Model sub_cat1_model = ModelFactory.createDefaultModel();
		for (int i = 0; i < 10; i++) {
			Property id_property = sub_cat1_model.getProperty(sub_cat1_id);
			Property name_property = sub_cat1_model.getProperty(sub_cat1_name);

			Resource usr = sub_cat1_model.createResource(Sub_cat1 + "#" + i)
					.addProperty(id_property, i + "")
					.addProperty(name_property, "sub_cat1_" + i);

		}

		// Random data generation for sub cat 2
		Model sub_cat2_model = ModelFactory.createDefaultModel();
		for (int i = 0; i < 10; i++) {
			Property id_property = sub_cat2_model.getProperty(sub_cat2_id);
			Property name_property = sub_cat2_model.getProperty(sub_cat2_name);

			Resource usr = sub_cat2_model.createResource(Sub_cat2 + "#" + i)
					.addProperty(id_property, i + "")
					.addProperty(name_property, "sub_cat2_" + i);

		}

/*		Generating for resource for status
		There four status
		1. Submitted
		2.In Progress
		3.Resolved
		4.Closed*/
		Model status_model = ModelFactory.createDefaultModel();
		Property id_property = sub_cat2_model.getProperty(status_id);
		Property name_property = sub_cat2_model.getProperty(status_name);
		Resource submitted = status_model.createResource(Status + "#" + 1)
				.addProperty(id_property, 1 + "")
				.addProperty(name_property, "submitted");
		Resource in_progress = status_model.createResource(Status + "#" + 2)
				.addProperty(id_property, 2 + "")
				.addProperty(name_property, "In Progress");
		Resource resolved = status_model.createResource(Status + "#" + 3)
				.addProperty(id_property, 3 + "")
				.addProperty(name_property, "Resolved");
		Resource Closed = status_model.createResource(Status + "#" + 4)
				.addProperty(id_property, 4 + "")
				.addProperty(name_property, "Closed");

		// Random data generation for status
		Model feature_model = ModelFactory.createDefaultModel();
		for (int i = 0; i < 10; i++) {
			Property id_property1 = feature_model.getProperty(feature_id);
			Property name_property1 = feature_model.getProperty(feature_name);
			Resource log = feature_model.createResource(Feature + "#" + i)
					.addProperty(id_property, i + "")
					.addProperty(name_property, "feature" + i);
		}

		
		Model issue_model = ModelFactory.createDefaultModel();
		int j = 10;
		// Random data generation for Issue(incident)
		/*for (int i = 0; i < 5; i++) {
			Property id_property2 = issue_model.getProperty(issue_id);
			Property user_property = issue_model.getProperty(user);
			Property status_property = issue_model.getProperty(status);
			Property feature_property = issue_model.getProperty(feature);
			Property product_property = issue_model.getProperty(product);
			Property sub_cat1_property = issue_model.getProperty(sub_cat1);
			Property sub_cat2_property = issue_model.getProperty(sub_cat2);

			Resource issue = issue_model
					.createResource(Issue + "#" + i)
					.addProperty(
							user_property,
							user_model.getResource(User + "#"
									+ get_random_number(10)))
					.addProperty(
							product_property,
							product_model.getResource(Product + "#"
									+ get_random_number(10)))
					.addProperty(
							sub_cat1_property,
							sub_cat1_model.getResource(Sub_cat1 + "#"
									+ get_random_number(10)))
					.addProperty(
							sub_cat2_property,
							sub_cat2_model.getResource(Sub_cat2 + "#"
									+ get_random_number(10)))
					.addProperty(
							feature_property,
							feature_model.getResource(Feature + "#"
									+ get_random_number(10)))
					.addProperty(status_property,
							status_model.getResource(Status + "#1"));
		}*/
		
		// Generating mutiple tickets with same issue, for testing problem and
		// Known issue workflow
		while (j >= 10 && j < 15) {
			Property id_property2 = issue_model.getProperty(issue_id);
			Property user_property = issue_model.getProperty(user);
			Property status_property = issue_model.getProperty(status);
			Property feature_property = issue_model.getProperty(feature);
			Property product_property = issue_model.getProperty(product);
			Property sub_cat1_property = issue_model.getProperty(sub_cat1);
			Property sub_cat2_property = issue_model.getProperty(sub_cat2);

			Resource issue1 = issue_model
					.createResource(Issue + "#" + j)
					.addProperty(user_property,
							user_model.getResource(User + "#1"))
					.addProperty(product_property,
							product_model.getResource(Product + "#1"))
					.addProperty(sub_cat1_property,
							sub_cat1_model.getResource(Sub_cat1 + "#1"))
					.addProperty(sub_cat2_property,
							sub_cat2_model.getResource(Sub_cat2 + "#1"))
					.addProperty(feature_property,
							feature_model.getResource(Feature + "#1"))
					.addProperty(status_property,
							status_model.getResource(Status + "#1"));

			j++;

		}

		ArrayList<Model> return_value = new ArrayList<Model>();
		return_value.add(product_model);
		return_value.add(user_model);
		return_value.add(sub_cat1_model);
		return_value.add(sub_cat2_model);
		return_value.add(feature_model);
		return_value.add(status_model);
		return_value.add(issue_model);

		// RDFDataMgr.write(System.out, product_model, Lang.NTRIPLES);
		// RDFDataMgr.write(System.out, user_model, Lang.NTRIPLES);
		// RDFDataMgr.write(System.out, sub_cat1_model, Lang.NTRIPLES);
		// RDFDataMgr.write(System.out, sub_cat2_model, Lang.NTRIPLES);
		// RDFDataMgr.write(System.out, status_model, Lang.NTRIPLES);
		// RDFDataMgr.write(System.out, feature_model, Lang.NTRIPLES);
		// System.out.println(" ---------------------------------------------- ");
		// RDFDataMgr.write(System.out, issue_model, Lang.NTRIPLES);

		return return_value;

	}
	
	/**
	 * @return Default Model which can be used to store problem resources
	 */
	public Model create_problem_model(){
		Model problem_model = ModelFactory.createDefaultModel();
		return problem_model;
	}

	/**
	 * Creates Resource for Problem Model
	 * 
	 * @param m
	 *            Problem Model
	 * @param product
	 *            Product which has an issue
	 * @param cat1
	 *            Sub category 1
	 * @param cat2
	 *            Sub category 2
	 * @param issue
	 *            Issue String URI
	 * @param KI
	 *            Known issue resource
	 */
	public void create_model_resource(Model m, String product, String cat1,
			String cat2, String issue, Resource KI) {
		String Problem = "http://cs8764/neu/edu/Problem";
		String problem_product = "http://cs8764/neu/edu/Problem/product";
		String problem_sub_cat1 = "http://cs8764/neu/edu/Problem/sub_cat1";
		String problem_sub_cat2 = "http://cs8764/neu/edu/Problem/sub_cat2";
		String problem_issue = "http://cs8764/neu/edu/Problem/Issue";
		String user = "http://cs8764/neu/edu/Problem/user";
		String changes = "http://cs8764/neu/edu/Problem/changes";
		String cost = "http://cs8764/neu/edu/Problem/cost";
		String known_issue = "http://cs8764/neu/edu/Problem/KI";

		Property product_property = m.getProperty(problem_product);
		Property sub_cat1_property = m.getProperty(problem_sub_cat1);
		Property sub_cat2_property = m.getProperty(problem_sub_cat2);
		Property issue_property = m.getProperty(problem_issue);
		Property user_property = m.getProperty(user);
		Property changes_property = m.getProperty(changes);
		Property cost_property = m.getProperty(cost);
		Property KI_property = m.getProperty(known_issue);

		Resource prob = m.createResource(Problem + "#" + get_random_number(20))
				.addProperty(product_property, product)
				.addProperty(sub_cat1_property, cat1)
				.addProperty(sub_cat2_property, cat2)
				.addProperty(issue_property, issue)
				.addProperty(user_property, "")
				.addProperty(changes_property, "")
				.addProperty(cost_property, "").addProperty(KI_property, KI);
	}
	
	/**
	 * Generate Random Number between 0 and N
	 * 
	 * @param n
	 *            Any Integer
	 * @return Returns a random number between (0, n)
	 */
	public int get_random_number(int n) {
		Random random = new Random();
		return random.nextInt(n);
	}

	/**
	 * Assigns a user to work on problem ticket. It randomly chooses any user
	 * from user model
	 * 
	 * @param m
	 *            Problem Model
	 * @param x
	 *            Node containing Problem ticket
	 * @param user_model
	 *            User Model
	 */
	public void assign_problem_tik_to_user(Model m, RDFNode x, Model user_model) {

		String user = "http://cs8764/neu/edu/Problem/user";
		Resource r = m.getResource(x.toString());
		String u = "http://cs8764/neu/edu/User#"+get_random_number(10);
		System.out.println("User "+u+" has been assigned the problem ticket");
		Resource r1 = user_model.getResource(u);
		Property user_property = m.getProperty(user);
		r.addProperty(user_property,r1 );
		//System.out.println("**********");
		//System.out.println(r.getProperty(user_property).getObject());
		
	}

	/**
	 * Update problem ticket with change that needs to be done to fix the
	 * problem.
	 * 
	 * @param m
	 *            Problem Model
	 * @param x
	 *            Node containing Problem ticket
	 * @param change
	 *            Change that needs to be done to fix the problem
	 */
	public void add_change(Model m, RDFNode x, String change) {
		String changes = "http://cs8764/neu/edu/Problem/changes";
		//String cst = "http://cs8764/neu/edu/Problem/cost";
		Property changes_property = m.getProperty(changes);
		//Property cost_property = m.getProperty(cst);
		
		Resource r = m.getResource(x.toString());
		r.addProperty(changes_property, change);
		//r.addProperty(cost_property, cost);
			
	}
	
	/**
	 * Update problem ticket with cost that would be incurred to implement the
	 * change.
	 * 
	 * @param m
	 *            Problem Model
	 * @param x
	 *            Node containing Problem ticket
	 * @param change
	 *            cost that would be incurred
	 */
	public void add_cost(Model m, RDFNode x, String cost) {
		//String changes = "http://cs8764/neu/edu/Problem/changes";
		String cst = "http://cs8764/neu/edu/Problem/cost";
		//Property changes_property = m.getProperty(changes);
		Property cost_property = m.getProperty(cst);
		
		Resource r = m.getResource(x.toString());
		//r.addProperty(changes_property, change);
		r.addProperty(cost_property, cost);
			
	}

	/**
	 * Update problem ticket with user who would be working on this problem,
	 * Change that needs to be done to fix the problem, cost that would be
	 * incurred to implement the change.
	 * 
	 * @param m
	 *            Problem Model
	 * @param x
	 *            Node containing Problem ticket
	 * @param user
	 *            random user from user model that would work on this problem
	 *            ticket
	 * @param change
	 *            Change that needs to be done to fix the problem
	 * @param cost
	 *            cost that would be incurred
	 */
	public void add_details(Model m, String x, String user,
			String change, String cost) {
		String u = "http://cs8764/neu/edu/Problem/user";
		String changes = "http://cs8764/neu/edu/Problem/changes";
		String cst = "http://cs8764/neu/edu/Problem/cost";
		
		Property user_property = m.getProperty(u);
		Property cost_property = m.getProperty(cst);
		Property changes_property = m.getProperty(changes);
		
		Resource r = m.getResource(x.toString());
		
		r.addProperty(changes_property, change);
		r.addProperty(cost_property, cost);
		r.addProperty(user_property, user);
		
		
	}

	/**
	 * @return Default Model to store Know issue data
	 */
	public Model create_known_issue_model() {
		Model known_issue_model = ModelFactory.createDefaultModel();
		return known_issue_model;
	}
	
	
	/**
	 * Create a Known Issue resource.
	 * 
	 * @param m
	 *            Known Issue Model
	 * @param product
	 *            Product which has an issue
	 * @param cat1
	 *            sub category 1
	 * @param cat2
	 *            sub category 2
	 * @param issue
	 *            Issue ticket URI associated with this
	 * @return Known Issue resource
	 */
	public Resource create_KI_resource(Model m, String product, String cat1, String cat2, String issue)
	{
		System.out.println("new KI created");
		String KI = "http://cs8764/neu/edu/KI";
		String KI_product = "http://cs8764/neu/edu/KI/product";
		String KI_sub_cat1 = "http://cs8764/neu/edu/KI/sub_cat1";
		String KI_sub_cat2 = "http://cs8764/neu/edu/KI/sub_cat2";
		String KI_issue = "http://cs8764/neu/edu/KI/Issue";
		String is_valid = "http://cs8764/neu/edu/KI/is_valid";
		
		Property product_property = m.getProperty(KI_product);
		Property sub_cat1_property = m.getProperty(KI_sub_cat1);
		Property sub_cat2_property = m.getProperty(KI_sub_cat2);
		Property issue_property = m.getProperty(KI_issue);
		Property is_valid_property = m.getProperty(is_valid);

		
		Resource Ki = m.createResource(KI + "#" + get_random_number(20))
				.addProperty(product_property, product)
				.addProperty(sub_cat1_property, cat1)
				.addProperty(sub_cat2_property, cat2)
				.addProperty(issue_property, issue)
				.addProperty(is_valid_property,"y" );
		
		return Ki;

	}

}