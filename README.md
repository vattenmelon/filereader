filereader
==========

    final Map<Integer, String> fileContent = new HashMap<>();

  	LineReader.withLineHandler(new LineHandler() {
  	@Override
  	public void handleLine(int lineNumber, String s) {
  		filInnhold.put(lineNumber, s);
  	}
    }).parse("c:\\file.txt");

    or

    LineReader.withLineHandler((int lineNumber, String content) -> fileContent.put(lineNumber, content))
                    .withCharsetEncoding(Charset.availableCharsets().get(UTF_8_ENCODING))
                    .parseFile("c:\\file.txt);


    or

    LineReader.withLineHandler(fileContent::put)
            .withCharsetEncoding(Charset.availableCharsets().get(UTF_8_ENCODING))
            .parseFile("c:\\file.txt);



