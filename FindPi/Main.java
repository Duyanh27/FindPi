package FindPi;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //input
        Input input = new Input();
        input.scan();

        //prepare
        TaskSeperation taskSeperation = new TaskSeperation();
        List<Task> tasks = taskSeperation.separate(input);

        //calculate
        Calculator cal = new Calculator();
        cal.setTasks(tasks);

        long startTime = System.currentTimeMillis(); // Start time
        Double rs = cal.calculate();
        long endTime = System.currentTimeMillis(); // End time

        long elapsedTime = endTime - startTime; // Calculate elapsed time

        //display
        WebView view = new WebView();
        view.display(rs, elapsedTime);
    }

}
