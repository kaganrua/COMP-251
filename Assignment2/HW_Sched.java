import java.util.*;

class Assignment implements Comparator<Assignment>{
	int number;
	int weight;
	int deadline;
	
	
	protected Assignment() {
	}
	
	protected Assignment(int number, int weight, int deadline) {
		this.number = number;
		this.weight = weight;
		this.deadline = deadline;
	}
	
	
	
	/**
	 * This method is used to sort to compare assignment objects for sorting. 
	 * Return -1 if a1 > a2
	 * Return 1 if a1 < a2
	 * Return 0 if a1 = a2 
	 */
	@Override
	public int compare(Assignment a1, Assignment a2) {
		// TODO Implement this
		if(a1.weight > a2.weight)
		{
			return -1;
		}
		else if(a1.weight < a2.weight)
		{
			return 1;
		}
		
		
		return 0;
	}
}

public class HW_Sched {
	ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
	int m;
	int lastDeadline = 0;
	
	protected HW_Sched(int[] weights, int[] deadlines, int size) {
		for (int i=0; i<size; i++) {
			Assignment homework = new Assignment(i, weights[i], deadlines[i]);
			this.Assignments.add(homework);
			if (homework.deadline > lastDeadline) {
				lastDeadline = homework.deadline;
			}
		}
		m =size;
	}
	
	
	/**
	 * 
	 * @return Array where output[i] corresponds to the assignment 
	 * that will be done at time i.
	 */
	public int[] SelectAssignments() {
		//TODO Implement this
		
		//Sort assignments
		//Order will depend on how compare function is implemented
		Collections.sort(Assignments, new Assignment());
		
		// If schedule[i] has a value -1, it indicates that the 
		// i'th timeslot in the schedule is empty
		int[] homeworkPlan = new int[lastDeadline];
		for (int i=0; i < homeworkPlan.length; ++i) {
			homeworkPlan[i] = -1;
		}
		
	    int availableSlots = lastDeadline;
		
		int j = 0 ;
		
		while(availableSlots > 0 && j < Assignments.size())
		{
			int curDeadline = Assignments.get(j).deadline;
			
			int k = curDeadline-1;
			while(k >= 0)
			{
				
				if(homeworkPlan[k] == -1)
				{
					homeworkPlan[k] = Assignments.get(j).number;
					availableSlots--;
					break;
				}
				k--;
				
				
			}
			j++;
			
			
		}

		/*		int currentTime = lastDeadline;
		
		int j =0;
		
		while(j<currentTime)
		{
			if(homeworkPlan[j] == -1)
			{
				if(Assignments.get(j).deadline > j)
				{
					homeworkPlan[j] = Assignments.get(j).number;
				}
			}

			
			
			else
			{
				if(Assignments.get(j).weight > Assignments.get(homeworkPlan[j]).weight )
				{
					homeworkPlan[j] = Assignments.get(j).number;
				}
			}
			j++;
*/		
		
		
		
	
		
		return homeworkPlan;
	}
	
	public static void main(String args[])
	{
		Assignment assignment1 = new Assignment(1, 12, 5);
		Assignment assignment2 = new Assignment(2, 17, 7);
		Assignment assignment3 = new Assignment(3, 2, 3);
		
		ArrayList<Assignment> assign = new ArrayList<>();
		
		assign.add(assignment1);
		assign.add(assignment2);
		assign.add(assignment3);
		Collections.sort(assign, new Assignment());
		int i = 0;
		while(i < assign.size())
		{
			System.out.println(assign.get(i).number);
			i++;
			
		}
	}
}
	
