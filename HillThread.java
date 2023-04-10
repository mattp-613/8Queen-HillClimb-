
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
	        
        NQueen[] presentBoard = hcs.generateBoard();
        hcs.presentHeuristic = hcs.findHeuristic(presentBoard);
        // test if the present board is the solution board
        while (hcs.presentHeuristic != 0 && !Thread.currentThread().isInterrupted()) {
            //  Get the next board
            // printState(presentBoard);
            presentBoard = hcs.nextBoard(presentBoard);
            hcs.presentHeuristic  = hcs.heuristic;
        }

            hcs.finalSolution = presentBoard;
            if (hcs.getFinalSolution() != null && !Thread.currentThread().isInterrupted()){
                System.out.println("THREAD " + threadname+ " HAS ACQUIRED THE SOLUTION: ");
                hcs.printState(hcs.getFinalSolution());
            }
            else{
                System.out.println("THREAD " + threadname+ " HAS ENDED BEFORE FINDING THE SOLUTION");
            }
    }
}