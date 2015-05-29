package edu.neu.cs8674.CARE;

public class Care {
	public void issue_Identification() {
		System.out.println("Identification phase..");
		Loop_elements e = new Issue_indetification(); 
		e.directive();
		e.fact();
		e.perception();
		e.hypothesis();

	}

	public void issue_verification() {
		System.out.println("Verification phase..");
		Loop_elements e = new Issue_verification();
		e.directive();
		e.fact();
		e.perception();
		e.hypothesis();

	}

	public void issue_cause_determination() {
		System.out.println("Cause determination phase..");
		Loop_elements e = new Cause_determination();
		e.directive();
		e.fact();
		e.perception();
		e.hypothesis();

	}

	public void issue_solution_plan() {
		System.out.println("Issue solution phase..");
		Loop_elements e = new Solution_plan();
		e.directive();
		e.fact();
		e.perception();
		e.hypothesis();

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
		return false;
	}

	private boolean isCauseDeterminedWithhighConfidence() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isIssueVerified() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isCauseDetermined() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		Care loop = new Care();
		
		for (;;) {
			loop.issue_Identification();
			loop.issue_verification();
			if (loop.isIssueVerified()) {
				break;
			}
		}
		boolean completed = false;
		while (!completed) {
			for (;;) {
				loop.issue_cause_determination();
				if (loop.isCauseDeterminedWithhighConfidence()) {
					break;
				}
			}
			for (;;) {
				loop.issue_solution_plan();
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

}
