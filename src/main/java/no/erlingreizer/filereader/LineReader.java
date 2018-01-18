package no.erlingreizer.filereader;


import java.io.*;
import java.nio.charset.Charset;


/***
 * Class that will read line after line from a file. Example of use:
 * 
 * <pre>
 * <code>
 * 	LineReader.withLineHandler(new LineHandler() {
 * 	&#064;Override
 * 	public void handleLine(int lineNumber, String s) {
 * 		filInnhold.put(lineNumber, s);
 * 	}
 * }).parse("c:\\file.txt");
 *  
 * </code>
 * </pre>
 * 
 */
public class LineReader {
	private final LineHandler lineReaderCallback;
	private Charset charset = Charset.defaultCharset();

	private LineReader(final LineHandler lineReaderCallback) {
		this.lineReaderCallback = lineReaderCallback;
	}

	private void readFile(String fileName) {
		try
            (BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)),
                    charset))){
                String line;
                int lineCounter = 1;
                while ((line = bfr.readLine()) != null) {
                    lineReaderCallback.handleLine(lineCounter, line);
                    lineCounter++;
                }
            } catch(FileNotFoundException e){
                throw new RuntimeException(e);
            } catch(IOException e){
                throw new RuntimeException(e);
            }

	}

	/***
	 * Factory method that builds a linereader with the specified LineHandler
	 * @param lineHandler
	 * @return
	 */
	public static LineReader withLineHandler(
			final LineHandler lineHandler) {
	    if (lineHandler == null){
	        throw new IllegalArgumentException("Linehandler cannot be null");
        }
		return new LineReader(lineHandler);
	}

	/***
	 * @param filename
	 *            The file to parse
	 */
	public void parseFile(final String filename) {
        if (filename == null){
            throw new IllegalArgumentException("Filename cannot be null");
        }
		readFile(filename);

	}

	public LineReader withCharsetEncoding(final Charset charset) {
        if (charset == null){
            throw new IllegalArgumentException("Charset cannot be null");
        }
		this.charset = charset;
		return this;
	}

}
