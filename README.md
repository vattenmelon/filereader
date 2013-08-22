filereader
==========
  	LineReader.withLineHandler(new LineHandler() {
  	@Override
  	public void handleLine(int lineNumber, String s) {
  		filInnhold.put(lineNumber, s);
  	}
    }).parse("c:\\file.txt");
