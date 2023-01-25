/**
 * @author valar_morghulis on 25/01/23.
 * @project multi-module-gradle
 * @description
 */
// import statement
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TraceClasses
{
    public void printFileNames(File[] a, int i, int lvl, StringBuilder path, String outputFile)
    {
        if(i == a.length)
        {
            return;
        }
        for (int j = 0; j < lvl; j++)
        {
            System.out.print("\t");
        }
        if(a[i].isFile())
        {
            String fileName = a[i].getName();
            TraceClasses.executeCommands(path.toString(), fileName, outputFile);
        }
        else if(a[i].isDirectory())
        {
            path.append("/").append(a[i].getName()).append("/");
            printFileNames(Objects.requireNonNull(a[i].listFiles()), 0, lvl + 1, path, outputFile);
        }
        printFileNames(a, i + 1, lvl, path, outputFile);
    }
    public static void main(String[] argvs)
    {
        //String path = "module3/build/classes/java";
        String projectPath = argvs[0];
        String modulePath = argvs[1];
        File fObj = new File(modulePath);
        String absolutePath = fObj.getAbsolutePath();
        String outputFile = new File(projectPath).getAbsolutePath();
        TraceClasses obj = new TraceClasses();
        if(fObj.exists() && fObj.isDirectory())
        {
            File[] a = fObj.listFiles();
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.println("Displaying Files from the directory: " + fObj);
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            obj.printFileNames(Objects.requireNonNull(a), 0, 0, new StringBuilder(absolutePath), outputFile);
        }
    }

    public static void executeCommands(String commandAndArgs, String fileName, String outputFile){
        Process process;
        String command = "jdeps -verbose " + fileName + " >> " + outputFile + "/output.txt";
        String outputSegregator = "echo \"**********************************************************************************"
                + "***********************************\""
                + " >> " + outputFile + "/output.txt";
        ProcessBuilder pb = new ProcessBuilder();
        ProcessBuilder pb1 = new ProcessBuilder();
        pb.command("sh", "-c", command);
        pb1.command("sh", "-c", outputSegregator);
        pb.directory(new File(commandAndArgs)); //Set current directory
        try {
            process = pb.start();
            Thread.sleep(5000);
           String result = new String(process.getInputStream().readAllBytes());
           System.out.println(result);
           pb1.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
