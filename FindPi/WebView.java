package FindPi;

public class WebView {
    public void display(Double result, long elapsedTime) {
        System.out.println("Approximated value of Pi: " + result);
        System.out.println("Math.PI value: " + Math.PI);
        System.out.println("Difference: " + Math.abs(result - Math.PI));
        System.out.println("Elapsed Time: " + elapsedTime + " ms");
    }
}
