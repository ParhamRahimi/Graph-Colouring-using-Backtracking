package utility.input_output;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Parham on 21-Jan-18.
 */
public class OutputFileWriter {
    public OutputFileWriter(String fileName, int[] colors) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        String newLine = System.getProperty("line.separator");

        for (int i = 0; i < colors.length; i++) {
            fileWriter.write( (i + 1) + "," + colors[i] + newLine);
        }
        fileWriter.close();
    }
}
