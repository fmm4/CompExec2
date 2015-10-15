/* The following code was generated by JFlex 1.6.1 */

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/UFPE/2015.2/IF688 - Teo. Implement. Ling. Computacionais/Workspace/Compilador_Minijava/src/main/lexer.flex</tt>
 */
public class Lexer implements sym, java_cup.runtime.Scanner {

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
    "\11\0\1\1\1\1\1\55\1\55\1\1\22\0\1\1\1\51\3\0"+
    "\1\54\1\50\1\0\1\16\1\17\1\3\1\11\1\14\1\12\1\7"+
    "\1\2\1\5\11\6\1\0\1\13\1\52\1\15\1\53\2\0\4\4"+
    "\1\10\25\4\1\22\1\0\1\23\1\0\1\4\1\0\1\26\1\32"+
    "\1\24\1\40\1\34\1\45\1\4\1\44\1\33\2\4\1\25\1\4"+
    "\1\37\1\42\1\30\1\4\1\46\1\27\1\36\1\31\1\41\1\43"+
    "\1\35\2\4\1\20\1\47\1\21\7\0\1\55\u1fa2\0\1\55\1\55"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\2\6\1\7"+
    "\1\5\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\14\5\2\1\1\23\1\24"+
    "\1\25\1\26\4\0\1\27\5\5\1\30\11\5\1\31"+
    "\1\32\1\33\1\34\1\35\2\0\3\36\4\5\1\37"+
    "\4\5\1\40\4\5\1\0\4\5\1\41\1\5\1\42"+
    "\1\43\1\44\3\5\1\45\1\46\4\5\1\47\1\50"+
    "\1\5\1\51\1\52\2\5\1\53\1\54\1\55";

  private static int [] zzUnpackAction() {
    int [] result = new int[112];
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
    "\0\0\0\56\0\56\0\134\0\56\0\212\0\270\0\346"+
    "\0\56\0\u0114\0\56\0\56\0\56\0\56\0\u0142\0\56"+
    "\0\56\0\56\0\56\0\56\0\56\0\u0170\0\u019e\0\u01cc"+
    "\0\u01fa\0\u0228\0\u0256\0\u0284\0\u02b2\0\u02e0\0\u030e\0\u033c"+
    "\0\u036a\0\u0398\0\u03c6\0\u03f4\0\u0422\0\u0450\0\56\0\u047e"+
    "\0\270\0\u04ac\0\u04da\0\56\0\u0508\0\u0536\0\u0564\0\u0592"+
    "\0\u05c0\0\212\0\u05ee\0\u061c\0\u064a\0\u0678\0\u06a6\0\u06d4"+
    "\0\u0702\0\u0730\0\u075e\0\56\0\56\0\56\0\56\0\56"+
    "\0\u078c\0\u07ba\0\u07ba\0\56\0\u07e8\0\u0816\0\u0844\0\u0872"+
    "\0\u08a0\0\212\0\u08ce\0\u08fc\0\u092a\0\u0958\0\212\0\u0986"+
    "\0\u09b4\0\u09e2\0\u0a10\0\u0a3e\0\u0a6c\0\u0a9a\0\u0ac8\0\u0af6"+
    "\0\212\0\u0b24\0\212\0\212\0\212\0\u0b52\0\u0b80\0\u0bae"+
    "\0\u078c\0\212\0\u0bdc\0\u0c0a\0\u0c38\0\u0c66\0\212\0\212"+
    "\0\u0c94\0\212\0\212\0\u0cc2\0\u0cf0\0\212\0\212\0\212";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[112];
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
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\2\6\1\27\1\30"+
    "\1\6\1\31\1\32\1\33\1\6\1\34\1\35\1\6"+
    "\1\36\1\6\1\37\1\6\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\62\0\1\50\56\0\3\6"+
    "\1\0\1\6\13\0\23\6\14\0\2\51\1\52\53\0"+
    "\2\10\1\52\52\0\3\6\1\0\1\12\2\53\11\0"+
    "\23\6\24\0\1\54\44\0\3\6\1\0\1\6\13\0"+
    "\1\6\1\55\21\6\13\0\3\6\1\0\1\6\13\0"+
    "\12\6\1\56\10\6\13\0\3\6\1\0\1\6\13\0"+
    "\5\6\1\57\15\6\13\0\3\6\1\0\1\6\13\0"+
    "\16\6\1\60\4\6\13\0\3\6\1\0\1\6\13\0"+
    "\13\6\1\61\5\6\1\62\1\6\13\0\3\6\1\0"+
    "\1\6\13\0\1\6\1\63\7\6\1\64\11\6\13\0"+
    "\3\6\1\0\1\6\13\0\20\6\1\65\1\6\1\66"+
    "\13\0\3\6\1\0\1\6\13\0\10\6\1\67\12\6"+
    "\13\0\3\6\1\0\1\6\13\0\16\6\1\70\4\6"+
    "\13\0\3\6\1\0\1\6\13\0\20\6\1\71\2\6"+
    "\13\0\3\6\1\0\1\6\13\0\2\6\1\72\20\6"+
    "\13\0\3\6\1\0\1\6\13\0\10\6\1\73\12\6"+
    "\56\0\1\74\56\0\1\75\22\0\1\76\55\0\1\77"+
    "\55\0\1\100\40\0\56\101\5\0\1\102\1\103\1\52"+
    "\53\0\1\104\1\105\2\0\2\53\47\0\3\6\1\0"+
    "\1\6\13\0\2\6\1\106\20\6\13\0\3\6\1\0"+
    "\1\6\13\0\2\6\1\107\20\6\13\0\3\6\1\0"+
    "\1\6\13\0\6\6\1\110\14\6\13\0\3\6\1\0"+
    "\1\6\13\0\16\6\1\111\4\6\13\0\3\6\1\0"+
    "\1\6\13\0\12\6\1\112\10\6\13\0\3\6\1\0"+
    "\1\6\13\0\3\6\1\113\17\6\13\0\3\6\1\0"+
    "\1\6\13\0\12\6\1\114\10\6\13\0\3\6\1\0"+
    "\1\6\13\0\7\6\1\115\13\6\13\0\3\6\1\0"+
    "\1\6\13\0\5\6\1\116\15\6\13\0\3\6\1\0"+
    "\1\6\13\0\17\6\1\117\3\6\13\0\3\6\1\0"+
    "\1\6\13\0\7\6\1\120\13\6\13\0\3\6\1\0"+
    "\1\6\13\0\7\6\1\121\13\6\13\0\3\6\1\0"+
    "\1\6\13\0\1\6\1\122\21\6\13\0\3\6\1\0"+
    "\1\6\13\0\12\6\1\123\10\6\7\0\3\101\1\124"+
    "\52\101\5\0\1\102\1\103\54\0\2\105\53\0\3\6"+
    "\1\0\1\6\13\0\3\6\1\125\17\6\13\0\3\6"+
    "\1\0\1\6\13\0\12\6\1\126\10\6\13\0\3\6"+
    "\1\0\1\6\13\0\1\6\1\127\21\6\13\0\3\6"+
    "\1\0\1\6\13\0\1\6\1\130\21\6\13\0\3\6"+
    "\1\0\1\6\13\0\10\6\1\131\12\6\13\0\3\6"+
    "\1\0\1\6\13\0\10\6\1\132\12\6\13\0\3\6"+
    "\1\0\1\6\13\0\3\6\1\133\17\6\13\0\3\6"+
    "\1\0\1\6\13\0\10\6\1\134\12\6\13\0\3\6"+
    "\1\0\1\6\13\0\14\6\1\135\6\6\13\0\3\6"+
    "\1\0\1\6\13\0\1\6\1\136\21\6\13\0\3\6"+
    "\1\0\1\6\13\0\3\6\1\137\17\6\13\0\3\6"+
    "\1\0\1\6\13\0\5\6\1\140\15\6\7\0\2\101"+
    "\1\141\1\124\52\101\4\0\3\6\1\0\1\6\13\0"+
    "\3\6\1\142\17\6\13\0\3\6\1\0\1\6\13\0"+
    "\7\6\1\143\13\6\13\0\3\6\1\0\1\6\13\0"+
    "\7\6\1\144\13\6\13\0\3\6\1\0\1\6\13\0"+
    "\10\6\1\145\12\6\13\0\3\6\1\0\1\6\13\0"+
    "\13\6\1\146\7\6\13\0\3\6\1\0\1\6\13\0"+
    "\10\6\1\147\12\6\13\0\3\6\1\0\1\6\13\0"+
    "\10\6\1\150\12\6\13\0\3\6\1\0\1\6\13\0"+
    "\22\6\1\151\13\0\3\6\1\0\1\6\13\0\1\152"+
    "\22\6\13\0\3\6\1\0\1\6\13\0\1\153\22\6"+
    "\13\0\3\6\1\0\1\6\13\0\2\6\1\154\20\6"+
    "\13\0\3\6\1\0\1\6\13\0\14\6\1\155\6\6"+
    "\13\0\3\6\1\0\1\6\13\0\13\6\1\156\7\6"+
    "\13\0\3\6\1\0\1\6\13\0\13\6\1\157\7\6"+
    "\13\0\3\6\1\0\1\6\13\0\3\6\1\160\17\6"+
    "\7\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3358];
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
    "\1\0\2\11\1\1\1\11\3\1\1\11\1\1\4\11"+
    "\1\1\6\11\21\1\1\11\4\0\1\11\17\1\5\11"+
    "\2\0\1\1\1\11\17\1\1\0\34\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[112];
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
	public Lexer(ComplexSymbolFactory sf, java.io.inputStream is){
		this(is);
		symbolFactory = sf;
	}
	public Lexer(CComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
		symbolFactory = sf;
	}
	
	private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;
	
	public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
	
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("Aviso: " + message + " em : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("Erro na leitura: " + message + " em : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
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
    while (i < 174) {
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
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    	System.out.println("Leitura terminada.");
  yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
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
          { 	return symbolFactory.newSymbol("EOF",sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Token nao identificado: <"+yytext()+">");
            }
          case 46: break;
          case 2: 
            { /*Ignorado*/
            }
          case 47: break;
          case 3: 
            { return symbolFactory.newSymbol("A_DIV",A_DIVI);
            }
          case 48: break;
          case 4: 
            { return symbolFactory.newSymbol("A_MULT",A_MULT);
            }
          case 49: break;
          case 5: 
            { return symbolFactory.newSymbol("IDENTIFICADOR",IDENTIFICADOR);
            }
          case 50: break;
          case 6: 
            { return symbolFactory.newSymbol("LITERAL_INTEIRO",LITERAL_INTEIRO);
            }
          case 51: break;
          case 7: 
            { return symbolFactory.newSymbol("PONTO",PONTO);
            }
          case 52: break;
          case 8: 
            { return symbolFactory.newSymbol("A_PLUS",A_PLUS);
            }
          case 53: break;
          case 9: 
            { return symbolFactory.newSymbol("A_MINUS",A_MINUS);
            }
          case 54: break;
          case 10: 
            { return symbolFactory.newSymbol("PONTOVIRGULA",PONTOVIRGULA);
            }
          case 55: break;
          case 11: 
            { return symbolFactory.newSymbol("VIRGULA",VIRGULA);
            }
          case 56: break;
          case 12: 
            { return symbolFactory.newSymbol("IGUAL",IGUAL);
            }
          case 57: break;
          case 13: 
            { return symbolFactory.newSymbol("PARENT_ESQ",PARENT_ESQ);
            }
          case 58: break;
          case 14: 
            { return symbolFactory.newSymbol("PARENT_DIR",PARENT_DIR);
            }
          case 59: break;
          case 15: 
            { return symbolFactory.newSymbol("CURLY_ESQ",CURLY_ESQ);
            }
          case 60: break;
          case 16: 
            { return symbolFactory.newSymbol("CURLY_DIR",CURLY_DIR);
            }
          case 61: break;
          case 17: 
            { return symbolFactory.newSymbol("COLCHE_ESQ",COLCHE_ESQ);
            }
          case 62: break;
          case 18: 
            { return symbolFactory.newSymbol("COLCHE_DIR",COLCHE_DIR);
            }
          case 63: break;
          case 19: 
            { return symbolFactory.newSymbol("A_FAT",A_FATO);
            }
          case 64: break;
          case 20: 
            { return symbolFactory.newSymbol("OP_LT",OP_LT);
            }
          case 65: break;
          case 21: 
            { return symbolFactory.newSymbol("OP_GT",OP_GT);
            }
          case 66: break;
          case 22: 
            { return symbolFactory.newSymbol("A_MOD",A_MODU);
            }
          case 67: break;
          case 23: 
            { return symbolFactory.newSymbol("OP_EQ",OP_EQ);
            }
          case 68: break;
          case 24: 
            { return symbolFactory.newSymbol("K_IF",K_IF);
            }
          case 69: break;
          case 25: 
            { return symbolFactory.newSymbol("OP_OR",OP_OR);
            }
          case 70: break;
          case 26: 
            { return symbolFactory.newSymbol("OP_AND",OP_AND);
            }
          case 71: break;
          case 27: 
            { return symbolFactory.newSymbol("OP_DIF",OP_DIF);
            }
          case 72: break;
          case 28: 
            { return symbolFactory.newSymbol("OP_LET",OP_LET);
            }
          case 73: break;
          case 29: 
            { return symbolFactory.newSymbol("OP_GET",OP_GET);
            }
          case 74: break;
          case 30: 
            { return symbolFactory.newSymbol("LITERAL_FLUTUANTE",LITERAL_FLUTUANTE);
            }
          case 75: break;
          case 31: 
            { return symbolFactory.newSymbol("T_INT",T_INT);
            }
          case 76: break;
          case 32: 
            { return symbolFactory.newSymbol("K_NEW",K_NEW);
            }
          case 77: break;
          case 33: 
            { return symbolFactory.newSymbol("K_ELSE",K_ELSE);
            }
          case 78: break;
          case 34: 
            { return symbolFactory.newSymbol("K_THIS",K_THIS);
            }
          case 79: break;
          case 35: 
            { return symbolFactory.newSymbol("B_TRUE",B_TRUE);
            }
          case 80: break;
          case 36: 
            { return symbolFactory.newSymbol("T_VOID",T_VOID);
            }
          case 81: break;
          case 37: 
            { return symbolFactory.newSymbol("COMENTARIO",COMENTARIO);
            }
          case 82: break;
          case 38: 
            { return symbolFactory.newSymbol("K_CLASS",K_CLASS);
            }
          case 83: break;
          case 39: 
            { return symbolFactory.newSymbol("K_WHILE",K_WHILE);
            }
          case 84: break;
          case 40: 
            { return symbolFactory.newSymbol("B_FALSE",B_FALSE);
            }
          case 85: break;
          case 41: 
            { return symbolFactory.newSymbol("K_STATIC",K_STATIC);
            }
          case 86: break;
          case 42: 
            { return symbolFactory.newSymbol("K_PUBLIC",K_PUBLIC);
            }
          case 87: break;
          case 43: 
            { return symbolFactory.newSymbol("K_RETURN",K_RETURN);
            }
          case 88: break;
          case 44: 
            { return symbolFactory.newSymbol("T_BOOLEAN",T_BOOLEAN);
            }
          case 89: break;
          case 45: 
            { return symbolFactory.newSymbol("K_EXTENDS",K_EXTENDS);
            }
          case 90: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
