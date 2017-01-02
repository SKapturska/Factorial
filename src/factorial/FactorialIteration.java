package factorial;

public class FactorialIteration implements Runnable{
    private long n;
    private long result;
    private long time;

    public long getResult() {
        return result;
    }
    
     public long getTime() {
        return time;
    }
    
    public FactorialIteration(long n){
        this.n = n;
    }
    
    @Override
    public void run() {
        long startTime = System.nanoTime();
        long tmpResult = 1;
        for (int i = 2; i<=n; i++) {
            tmpResult = tmpResult * i;
        }
        result = tmpResult;
        time = System.nanoTime()- startTime;
    }
    
}
