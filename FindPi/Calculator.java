package FindPi;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculator {
    private List<Task> tasks;

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public double calculate() {
        double pi = 0.0;
        ExecutorService executor = Executors.newFixedThreadPool(tasks.size());

        List<Future<Double>> results = new ArrayList<>();
        for (Task task : tasks) {
            results.add(executor.submit(new Callable<Double>() {
                public Double call() {
                    double partialSum = 0.0;
                    for (int i = task.start; i <= task.end; i++) {
                        if (i % 2 == 0) {  // Check if 'i' is even
                            partialSum += 1.0 / (2 * i + 1);
                        } else {  // 'i' is odd
                            partialSum -= 1.0 / (2 * i + 1);
                        }
                    }
                    return partialSum;
                }
            }));
        }

        // Wait for all futures to complete and aggregate the results
        for (Future<Double> result : results) {
            try {
                pi += result.get();
            } catch (Exception e) {
                System.err.println("Failed in calculating Pi: " + e.getMessage());
            }
        }

        executor.shutdown();
        return pi * 4; // multiply by 4 to get the final value of Pi
    }
}
