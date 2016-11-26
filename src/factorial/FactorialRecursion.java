package factorial;

public class FactorialRecursion implements Runnable {
    
    private long n;
    private long result;
    private long time;

    public long getResult() {
        return result;
    }

    public long getTime() {
        return time;
    }
        
    FactorialRecursion(long n){
        this.n = n;
    }

    private  long Recursion(long x) {
        if (x == 0) {
            return 1;
        } else {
            return (x * Recursion(x - 1));
        }
    }

@Override
    public void run() {
        long startTime = System.nanoTime();
        result = Recursion(n);
        time = System.nanoTime() - startTime;
    }       
}
