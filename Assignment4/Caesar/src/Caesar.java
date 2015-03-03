import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.security.AccessControlException;
import java.security.AccessController;

/**
 * Created by kyle on 3/3/15.
 *
 * Usage as follows `java Caesar key infile [outfile]`
 */
public class Caesar {
    File inFile;
    File outFile;
    int key;

    public Caesar(File inFile, File outFile, int key){
        this.inFile = inFile;
        this.outFile = outFile;
        this.key = key;
    }

    public static void main(String[] args) {
        if(args.length != 3)
        {
            System.out.println("Proper Usage is: java Caesar key infile [outfile]");
            System.exit(0);
        }
        try {
            File inFile = new File(args[1]);
            if(!inFile.exists() || inFile.isDirectory()){
                throw new FileNotFoundException();
            }

            //check file permissions
            FilePermission inPermission = new FilePermission(args[1], "read");
            FilePermission outPermission = new FilePermission(args[2], "write");

            AccessController.checkPermission(inPermission);
            AccessController.checkPermission(outPermission);
        } catch (AccessControlException e){
            System.out.println("improper permissions for input or output file");
        } catch (FileNotFoundException e){
            System.out.println("input file doesn't exist");
        }

    }
}
