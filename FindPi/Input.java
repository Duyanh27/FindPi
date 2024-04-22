package FindPi;
import java.util.Scanner;

public class Input {
    private int numTerms;
    private int numThreads;

    public void scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms (K) to use for approximation: ");
        this.numTerms = scanner.nextInt();
        System.out.print("Enter the number of threads: ");
        this.numThreads = scanner.nextInt();
        scanner.close();
    }

    public int getNumTerms() {
        return numTerms;
    }

    public int getNumThreads() {
        return numThreads;
    }
}
