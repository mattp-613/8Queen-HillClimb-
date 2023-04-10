
public class HillThread extends Thread{
    //This is a thread that performs a search using heuristics and such

    String threadname;
    ThreadGroup group;
    HillThread(String threadname, ThreadGroup group)
    {
        super(group, threadname);
        this.threadname = threadname;
        start();
    }

    public void run()
    {
        System.out.println("THREAD " + threadname + " ENABLED. BEGINNING SEARCH.");

    }
}