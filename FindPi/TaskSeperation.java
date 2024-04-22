package FindPi;
import java.util.ArrayList;
import java.util.List;

public class TaskSeperation {
    public List<Task> separate(Input input) {
        List<Task> tasks = new ArrayList<>();
        int numTasks = input.getNumThreads(); // Use user-defined number of threads
        int termsPerTask = input.getNumTerms() / numTasks;

        for (int i = 0; i < numTasks; i++) {
            int start = i * termsPerTask;
            int end = (i + 1) * termsPerTask - 1;
            if (i == numTasks - 1) end = input.getNumTerms() - 1; // last task may take more terms
            tasks.add(new Task(start, end));
        }
        return tasks;
    }
}
