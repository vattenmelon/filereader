package no.erlingreizer.filereader;

@FunctionalInterface
public interface LineHandler {
    /***
     * This method retreives the line number and line content from the filereader. Implement this method
     * to handle the line.
     * @param lineNumber the current line number
     * @param lineContent the actual content of the line
     */
    public void handleLine(int lineNumber, final String lineContent);
}