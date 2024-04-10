package Pi;

public class SumTask implements Runnable {
    private long from, to = 0;
    private double result = 0;

    //Setter for SumTask
    public SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (long i = from; i <= to; i++) {
            result += Math.pow(-1, i) / (2 * i + 1);
        }
    }

    //Getter for SumTask
    public double getResult() {
        return result;
    }
}
