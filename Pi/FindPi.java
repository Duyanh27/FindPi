package Pi;
public class FindPi {
    public static void main(String[] args) throws InterruptedException {
        final long K = 1000000000; // The number want to sum
        int numberOfThreads = 10000; // Number of threads to use
        long segmentSize = K / numberOfThreads;

        //Create array of tasks and threads
        SumTask[] tasks = new SumTask[numberOfThreads];
        Thread[] threads = new Thread[numberOfThreads];

        //Dividing task
        for (int i = 0; i < numberOfThreads; i++) {
            long from = i * segmentSize;
            long to = (i + 1) * segmentSize;
            tasks[i] = new SumTask(from, to);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        //Calculate the total of Pi
        double pi = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join(); // Wait for thread to finish
            pi += tasks[i].getResult();
        }

        pi *= 4;

        System.out.println("Total sum: " + pi);
        double difNum = Math.PI - pi;
        System.out.printf("Difference from original Pi: %f ", difNum );
    }
}
