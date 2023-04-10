
public class HillThread extends Thread{
    //This is a thread that performs a search using heuristics and such

    String threadname;
    ThreadGroup group;
    int n;
    HillThread(String threadname, ThreadGroup group, int n)
    {
        super(group, threadname);
        this.threadname = threadname;
        this.n = n;
        start();
    }

    public void run()
    {
        System.out.println("THREAD " + threadname + " ENABLED. BEGINNING SEARCH...");

        HillClimbingSearch hcs = new HillClimbingSearch(n);
	        
        try{
        hcs.runSearch();
        if (hcs.getFinalSolution() != null){
            System.out.println("THREAD " + threadname+ " HAS ACQUIRED THE SOLUTION: ");
            hcs.printState(hcs.getFinalSolution());
            group.interrupt(); //this doesn't kill the other threads
            }
        } catch(Exception e){
            System.out.println("THREAD " + threadname + " CEASED SOLVING.");
        }
    }
}