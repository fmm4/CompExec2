/* The following code was generated by JFlex 1.6.1 */
package Lexer;
/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/UFPE/2015.2/IF688 - Teo. Implement. Ling. Computacionais/Workspace/Comp-Exec2/src/Lexer/CompEx2.flex</tt>
 */
class CompEx2 {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\1\2\0\1\1\22\0\1\1\1\43\3\0\1\44"+
    "\1\42\1\0\1\12\1\12\1\3\1\11\1\12\1\11\1\7\1\2"+
    "\1\5\11\6\1\0\1\12\1\43\1\13\1\43\2\0\4\4\1\10"+
    "\25\4\1\16\1\0\1\12\1\0\1\4\1\0\1\21\1\25\1\17"+
    "\1\33\1\27\1\40\1\4\1\37\1\26\2\4\1\20\1\4\1\32"+
    "\1\35\1\23\1\4\1\41\1\22\1\31\1\24\1\34\1\36\1\30"+
    "\2\4\1\12\1\15\1\14\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\4\2\5\1\6\1\4"+
    "\1\6\2\1\14\4\1\1\1\3\1\7\5\0\5\4"+
    "\1\10\11\4\2\0\3\11\12\4\1\0\4\4\1\12"+
    "\4\4";

  private static int [] zzUnpackAction() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\45\0\45\0\112\0\45\0\157\0\224\0\271"+
    "\0\45\0\336\0\u0103\0\u0128\0\u014d\0\u0172\0\u0197\0\u01bc"+
    "\0\u01e1\0\u0206\0\u022b\0\u0250\0\u0275\0\u029a\0\u02bf\0\u02e4"+
    "\0\u0309\0\u032e\0\u0103\0\45\0\u0353\0\224\0\u0378\0\u039d"+
    "\0\u03c2\0\u03e7\0\u040c\0\u0431\0\u0456\0\u047b\0\157\0\u04a0"+
    "\0\u04c5\0\u04ea\0\u050f\0\u0534\0\u0559\0\u057e\0\u05a3\0\u05c8"+
    "\0\u05ed\0\u0612\0\u0612\0\45\0\u0637\0\u065c\0\u0681\0\u06a6"+
    "\0\u06cb\0\u06f0\0\u0715\0\u073a\0\u075f\0\u0784\0\u07a9\0\u07ce"+
    "\0\u07f3\0\u0818\0\u083d\0\u0862\0\u05ed\0\u0887\0\u08ac\0\u08d1"+
    "\0\u08f6";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\5\1\11\1\13\1\14\1\15\1\2\1\16"+
    "\2\6\1\17\1\20\1\6\1\21\1\22\1\23\1\6"+
    "\1\24\1\25\1\6\1\26\1\6\1\27\1\6\1\30"+
    "\1\31\1\32\1\33\1\5\47\0\1\34\1\35\45\0"+
    "\3\6\1\0\1\6\6\0\23\6\10\0\2\36\1\37"+
    "\42\0\2\10\1\37\41\0\3\6\1\0\1\12\1\40"+
    "\5\0\23\6\16\0\1\5\46\0\1\41\44\0\1\5"+
    "\33\0\3\6\1\0\1\6\6\0\1\6\1\42\21\6"+
    "\7\0\3\6\1\0\1\6\6\0\12\6\1\43\10\6"+
    "\7\0\3\6\1\0\1\6\6\0\5\6\1\44\15\6"+
    "\7\0\3\6\1\0\1\6\6\0\16\6\1\45\4\6"+
    "\7\0\3\6\1\0\1\6\6\0\13\6\1\46\5\6"+
    "\1\47\1\6\7\0\3\6\1\0\1\6\6\0\1\6"+
    "\1\50\7\6\1\51\11\6\7\0\3\6\1\0\1\6"+
    "\6\0\20\6\1\52\1\6\1\53\7\0\3\6\1\0"+
    "\1\6\6\0\10\6\1\54\12\6\7\0\3\6\1\0"+
    "\1\6\6\0\16\6\1\55\4\6\7\0\3\6\1\0"+
    "\1\6\6\0\20\6\1\56\2\6\7\0\3\6\1\0"+
    "\1\6\6\0\2\6\1\57\20\6\7\0\3\6\1\0"+
    "\1\6\6\0\10\6\1\60\12\6\45\0\1\5\2\0"+
    "\45\61\5\0\1\62\1\63\1\37\42\0\1\64\1\65"+
    "\2\0\1\40\51\0\1\11\32\0\3\6\1\0\1\6"+
    "\6\0\2\6\1\66\20\6\7\0\3\6\1\0\1\6"+
    "\6\0\2\6\1\67\20\6\7\0\3\6\1\0\1\6"+
    "\6\0\6\6\1\70\14\6\7\0\3\6\1\0\1\6"+
    "\6\0\16\6\1\71\4\6\7\0\3\6\1\0\1\6"+
    "\6\0\12\6\1\47\10\6\7\0\3\6\1\0\1\6"+
    "\6\0\3\6\1\72\17\6\7\0\3\6\1\0\1\6"+
    "\6\0\12\6\1\73\10\6\7\0\3\6\1\0\1\6"+
    "\6\0\7\6\1\74\13\6\7\0\3\6\1\0\1\6"+
    "\6\0\5\6\1\72\15\6\7\0\3\6\1\0\1\6"+
    "\6\0\17\6\1\47\3\6\7\0\3\6\1\0\1\6"+
    "\6\0\7\6\1\75\13\6\7\0\3\6\1\0\1\6"+
    "\6\0\7\6\1\76\13\6\7\0\3\6\1\0\1\6"+
    "\6\0\1\6\1\50\21\6\7\0\3\6\1\0\1\6"+
    "\6\0\12\6\1\77\10\6\3\0\3\61\1\100\41\61"+
    "\5\0\1\62\1\63\43\0\2\65\42\0\3\6\1\0"+
    "\1\6\6\0\3\6\1\74\17\6\7\0\3\6\1\0"+
    "\1\6\6\0\12\6\1\101\10\6\7\0\3\6\1\0"+
    "\1\6\6\0\1\6\1\101\21\6\7\0\3\6\1\0"+
    "\1\6\6\0\1\6\1\102\21\6\7\0\3\6\1\0"+
    "\1\6\6\0\10\6\1\47\12\6\7\0\3\6\1\0"+
    "\1\6\6\0\10\6\1\103\12\6\7\0\3\6\1\0"+
    "\1\6\6\0\3\6\1\47\17\6\7\0\3\6\1\0"+
    "\1\6\6\0\14\6\1\47\6\6\7\0\3\6\1\0"+
    "\1\6\6\0\1\6\1\72\21\6\7\0\3\6\1\0"+
    "\1\6\6\0\5\6\1\104\15\6\3\0\2\61\1\105"+
    "\1\100\41\61\4\0\3\6\1\0\1\6\6\0\7\6"+
    "\1\106\13\6\7\0\3\6\1\0\1\6\6\0\10\6"+
    "\1\107\12\6\7\0\3\6\1\0\1\6\6\0\13\6"+
    "\1\110\7\6\7\0\3\6\1\0\1\6\6\0\22\6"+
    "\1\111\7\0\3\6\1\0\1\6\6\0\1\47\22\6"+
    "\7\0\3\6\1\0\1\6\6\0\2\6\1\111\20\6"+
    "\7\0\3\6\1\0\1\6\6\0\14\6\1\74\6\6"+
    "\7\0\3\6\1\0\1\6\6\0\13\6\1\47\7\6"+
    "\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2331];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\1\11\3\1\1\11\22\1\1\11"+
    "\5\0\17\1\2\0\1\1\1\11\13\1\1\0\11\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  CompEx2(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 162) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    	System.out.println("Leitura terminada.");

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
        return YYEOF;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.out.print(yytext());
            }
          case 11: break;
          case 2: 
            { /*Fazer nada*/
            }
          case 12: break;
          case 3: 
            { System.out.println("Token Operador		("+yytext()+")");
            }
          case 13: break;
          case 4: 
            { System.out.println("Token ID		("+yytext()+")");
            }
          case 14: break;
          case 5: 
            { System.out.println("Token Literal Inteiro	("+yytext()+")");
            }
          case 15: break;
          case 6: 
            { System.out.println("Token Delimitador	("+yytext()+")");
            }
          case 16: break;
          case 7: 
            { System.out.println("!!ERRO!! Token Desconhecido");
            }
          case 17: break;
          case 8: 
            { System.out.println("Token Palavra Chave	("+yytext()+")");
            }
          case 18: break;
          case 9: 
            { System.out.println("Token Literal Float	("+yytext()+")");
            }
          case 19: break;
          case 10: 
            { System.out.println("Token Comentario reconhecido e ignorado.");
            }
          case 20: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java CompEx2 [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        CompEx2 scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new CompEx2(reader);
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
