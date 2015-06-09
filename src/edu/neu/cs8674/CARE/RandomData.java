package edu.neu.cs8674.CARE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class RandomData extends Object {
	public List<Model> createRandomData(){
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

		// Random data generation for status
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
		Property id_property1 = feature_model.getProperty(feature_id);
		Property name_property1 = feature_model.getProperty(feature_name);
		Resource log = feature_model.createResource(Feature + "#" + 0)
				.addProperty(id_property, 0 + "")
				.addProperty(name_property, "Log file");
		Resource stack_trace = feature_model.createResource(Feature + "#" + 1)
				.addProperty(id_property, 1 + "")
				.addProperty(name_property, "Stack trace");

		// Random data generation for Issue(incident)
		Model issue_model = ModelFactory.createDefaultModel();
		for (int i = 0; i < 5; i++) {
			Property id_property2 = issue_model.getProperty(issue_id);
			Property user_property = issue_model.getProperty(user);
			Property status_property = issue_model.getProperty(status);
			Property feature_property = issue_model.getProperty(feature);
			Property product_property = issue_model.getProperty(product);
			Property sub_cat1_property = issue_model.getProperty(sub_cat1);
			Property sub_cat2_property = issue_model.getProperty(sub_cat2);

			Resource issue = issue_model.createResource(Issue + "#" + i)
					.addProperty(user_property, user_model.getResource(User+"#"+get_random_number(10)))
					.addProperty(product_property, product_model.getResource(Product+"#"+get_random_number(10)))
					.addProperty(sub_cat1_property, sub_cat1_model.getResource(Sub_cat1+"#"+get_random_number(10)))
					.addProperty(sub_cat2_property, sub_cat2_model.getResource(Sub_cat2+"#"+get_random_number(10)))
					.addProperty(feature_property, feature_model.getResource(Feature+"#"+get_random_number(1)))
					.addProperty(status_property, status_model.getResource(Status+"#1"));

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
		//RDFDataMgr.write(System.out, feature_model, Lang.NTRIPLES);
		//System.out.println(" ---------------------------------------------- ");
		//RDFDataMgr.write(System.out, issue_model, Lang.NTRIPLES);
		
		return return_value;

	}

	public int get_random_number(int n) {
		Random random = new Random();
		return random.nextInt(n);
	}
}