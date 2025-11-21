import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        // using scanner to read the input
        Scanner scanner = new Scanner(System.in);
        String directoryPath = "";
        boolean isValidPath = false;

        System.out.println("^^ Welcome to the Directory Analysis System ^^");
        System.out.println("  (Course: STIWK3014 Real-time Programming)");
        System.out.println("------------------------------");

        //while looping until user type correct
        while (!isValidPath) {
            System.out.print("Please enter the directory path you want to analyze (e.g., C:\\\\Users\\\\User\\\\Project): ");
            directoryPath = scanner.nextLine().trim();

            if (directoryPath.isEmpty()) {
                System.out.println("Error: Input cannot be empty, please enter again .");
                continue; // restart looping
            }

            // if user type correct , jump out the "while loop"
            isValidPath = true;
        }

        DirectoryAnalyzer analyzer = new DirectoryAnalyzer();

        // try and catch the error
        try {
            System.out.println("\n---Start analyzing the table of contents: " + directoryPath + " ---");
            analyzer.analyzeDirectory(directoryPath);
            System.out.println("--- Finish Analyzing  ---\n");

            // 4. show result
            System.out.println("=============================================");
            System.out.println("Analyzing Result:");
            System.out.println("Number of Java Files = " + analyzer.getJavaFileCount());
            System.out.println("Number of Issues     = " + analyzer.getIssueFileCount());
            System.out.println("=============================================");

        } catch (IllegalArgumentException e) {
            // if catching error like unexpected directory...
            System.err.println("\n[Fatal Error] Directory path processing failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\n[System Error] An unknown error occurred while analyzing the directory: " + e.getMessage());
            e.printStackTrace();
        } finally {
        }
    }
}