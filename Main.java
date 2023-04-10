import java.util.Scanner;
import java.lang.ThreadGroup;
public class Main {
	
	


	public static void main(String[] args) {
		
	       
		    int n = 0; 
	        try (Scanner s=new Scanner(System.in)) {
	        	while (true){
	        		System.out.println("Enter the number of Queens :");
	        		n = s.nextInt();
	        		if ( n == 2 || n ==3) {
	        			System.out.println("No Solution possible for "+ n +" Queens. Please enter another number");
	        		}
	        		else
	        			break;
	        	}
	        }
	        long timestamp1 = System.currentTimeMillis();
	        
	        System.out.println("Solution to "+ n +" queens using hill climbing search:");
	        
			//Multithread begins here

			ThreadGroup searches = new ThreadGroup("parent");
  
        	//ThreadGroup searches_child = new ThreadGroup(searches, "child");

			//start 4 threads
			HillThread t1 = new HillThread("one", searches, n);
			HillThread t2 = new HillThread("two", searches, n);
			HillThread t3 = new HillThread("three", searches, n);
			HillThread t4 = new HillThread("four", searches, n);

	        //HillClimbingSearch hcs = new HillClimbingSearch(n);
	        
	        //hcs.runSearch();
	        
	        //if (hcs.getFinalSolution() != null)
	        //	hcs.printState(hcs.getFinalSolution());
	        
	        
	        
	        //Printing the solution

			System.out.println(searches.activeCount());


			while(searches.activeCount() != 0){ //this is to keep it waiting until all threads are complete. bad solution
				if(searches.activeCount() < 4){ //most important part!!!!
					searches.interrupt();
				}
			}
			long timestamp2 = System.currentTimeMillis();
				
			long timeDiff = timestamp2 - timestamp1;
			System.out.println("Execution Time: "+timeDiff+" ms");
	       
	    }
}