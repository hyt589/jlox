package localhost.hyt.tools;

import java.io.IOException;

public class GenerateAst {
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1)
        {
            System.err.println("Usage: generate_ast <output_directory>");
            System.exit(64);
        }
        String outputDir = args[0];
    }
}
