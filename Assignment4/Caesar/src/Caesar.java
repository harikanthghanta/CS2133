import java.io.File;

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
    }
}
