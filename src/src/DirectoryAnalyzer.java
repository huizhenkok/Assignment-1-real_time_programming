import java.io.File;
import java.util.Objects;

public class DirectoryAnalyzer {


    private final String ISSUE_KEYWORD_1 = "Issue";
    private final String ISSUE_KEYWORD_2 = "Problem";

    private int javaFileCount = 0;
    private int issueFileCount = 0;


    public DirectoryAnalyzer() {

    }


    public void analyzeDirectory(String path) throws Exception {
        File directory = new File(path);


        if (!directory.exists()) {
            throw new IllegalArgumentException("Error: The entered path does not exist.");
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Error: Path is not a directory or folder");
        }


        this.javaFileCount = 0;
        this.issueFileCount = 0;

        traverseDirectory(directory);
    }


    private void traverseDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files == null) {
            System.err.println("Warning: Unable to read the directory contents or directory is empty:" + directory.getAbsolutePath());
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                traverseDirectory(file);
            } else {
                String fileName = file.getName();

                //check java file
                if (fileName.toLowerCase().endsWith(".java")) {
                    javaFileCount++;
                }

                // 2.check issue file
                if (fileName.contains(ISSUE_KEYWORD_1) || fileName.contains(ISSUE_KEYWORD_2)) {
                    issueFileCount++;
                }
            }
        }
    }

    // getter ways
    public int getJavaFileCount() {
        return javaFileCount;
    }

    public int getIssueFileCount() {
        return issueFileCount;
    }

}