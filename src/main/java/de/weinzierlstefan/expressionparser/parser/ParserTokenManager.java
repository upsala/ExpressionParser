/* Generated By:JavaCC: Do not edit this line. ParserTokenManager.java */
package de.weinzierlstefan.expressionparser.parser;
import java.util.*;

/** Token Manager. */
public class ParserTokenManager implements ParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 9:
         jjmatchedKind = 4;
         return jjMoveNfa_0(0, 0);
      case 10:
         jjmatchedKind = 2;
         return jjMoveNfa_0(0, 0);
      case 13:
         jjmatchedKind = 3;
         return jjMoveNfa_0(0, 0);
      case 32:
         jjmatchedKind = 1;
         return jjMoveNfa_0(0, 0);
      case 33:
         jjmatchedKind = 53;
         return jjMoveNfa_0(0, 0);
      case 37:
         jjmatchedKind = 57;
         return jjMoveNfa_0(0, 0);
      case 38:
         jjmatchedKind = 48;
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 40:
         jjmatchedKind = 25;
         return jjMoveNfa_0(0, 0);
      case 41:
         jjmatchedKind = 26;
         return jjMoveNfa_0(0, 0);
      case 42:
         jjmatchedKind = 55;
         return jjMoveNfa_0(0, 0);
      case 43:
         jjmatchedKind = 42;
         return jjMoveNfa_0(0, 0);
      case 44:
         jjmatchedKind = 33;
         return jjMoveNfa_0(0, 0);
      case 45:
         jjmatchedKind = 43;
         return jjMoveNfa_0(0, 0);
      case 46:
         jjmatchedKind = 34;
         return jjMoveNfa_0(0, 0);
      case 47:
         jjmatchedKind = 56;
         return jjMoveNfa_0(0, 0);
      case 58:
         jjmatchedKind = 32;
         return jjMoveNfa_0(0, 0);
      case 59:
         jjmatchedKind = 31;
         return jjMoveNfa_0(0, 0);
      case 60:
         jjmatchedKind = 36;
         return jjMoveStringLiteralDfa1_0(0x8012000000000L);
      case 61:
         jjmatchedKind = 41;
         return jjMoveStringLiteralDfa1_0(0x40000000000000L);
      case 62:
         jjmatchedKind = 35;
         return jjMoveStringLiteralDfa1_0(0x10004000000000L);
      case 63:
         jjmatchedKind = 39;
         return jjMoveNfa_0(0, 0);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x440L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 79:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 87:
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 88:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 91:
         jjmatchedKind = 29;
         return jjMoveNfa_0(0, 0);
      case 93:
         jjmatchedKind = 30;
         return jjMoveNfa_0(0, 0);
      case 94:
         jjmatchedKind = 49;
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x440L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 120:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 123:
         jjmatchedKind = 27;
         return jjMoveNfa_0(0, 0);
      case 124:
         jjmatchedKind = 47;
         return jjMoveStringLiteralDfa1_0(0x100000000000L);
      case 125:
         jjmatchedKind = 28;
         return jjMoveNfa_0(0, 0);
      case 126:
         jjmatchedKind = 50;
         return jjMoveNfa_0(0, 0);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(0, 0);
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x200000000000L) != 0L)
         {
            jjmatchedKind = 45;
            jjmatchedPos = 1;
         }
         break;
      case 60:
         if ((active0 & 0x8000000000000L) != 0L)
         {
            jjmatchedKind = 51;
            jjmatchedPos = 1;
         }
         break;
      case 61:
         if ((active0 & 0x2000000000L) != 0L)
         {
            jjmatchedKind = 37;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x4000000000L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 1;
         }
         break;
      case 62:
         if ((active0 & 0x10000000000L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x10000000000000L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x40000000000000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 1;
         }
         break;
      case 73:
         return jjMoveStringLiteralDfa2_0(active0, 0x20L);
      case 78:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 79:
         return jjMoveStringLiteralDfa2_0(active0, 0x300L);
      case 82:
         if ((active0 & 0x80L) != 0L)
         {
            jjmatchedKind = 7;
            jjmatchedPos = 1;
         }
         break;
      case 83:
         if ((active0 & 0x400L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 1;
         }
         break;
      case 94:
         if ((active0 & 0x400000000000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 1;
         }
         break;
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x20L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x300L);
      case 114:
         if ((active0 & 0x80L) != 0L)
         {
            jjmatchedKind = 7;
            jjmatchedPos = 1;
         }
         break;
      case 115:
         if ((active0 & 0x400L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 1;
         }
         break;
      case 124:
         if ((active0 & 0x100000000000L) != 0L)
         {
            jjmatchedKind = 44;
            jjmatchedPos = 1;
         }
         break;
      default :
         break;
   }
   return jjMoveNfa_0(0, 1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(0, 1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(0, 1);
   }
   switch(curChar)
   {
      case 68:
         if ((active0 & 0x40L) != 0L)
         {
            jjmatchedKind = 6;
            jjmatchedPos = 2;
         }
         break;
      case 82:
         if ((active0 & 0x100L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 2;
         }
         break;
      case 84:
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 9;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x20L);
      case 100:
         if ((active0 & 0x40L) != 0L)
         {
            jjmatchedKind = 6;
            jjmatchedPos = 2;
         }
         break;
      case 114:
         if ((active0 & 0x100L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 2;
         }
         break;
      case 116:
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 9;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x20L);
      default :
         break;
   }
   return jjMoveNfa_0(0, 2);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(0, 2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(0, 2);
   }
   switch(curChar)
   {
      case 72:
         if ((active0 & 0x20L) != 0L)
         {
            jjmatchedKind = 5;
            jjmatchedPos = 3;
         }
         break;
      case 104:
         if ((active0 & 0x20L) != 0L)
         {
            jjmatchedKind = 5;
            jjmatchedPos = 3;
         }
         break;
      default :
         break;
   }
   return jjMoveNfa_0(0, 3);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int strKind = jjmatchedKind;
   int strPos = jjmatchedPos;
   int seenUpto;
   input_stream.backup(seenUpto = curPos + 1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { throw new Error("Internal Error"); }
   curPos = 0;
   int startsAt = 0;
   jjnewStateCnt = 24;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  else if (curChar == 39)
                     jjCheckNAddTwoStates(1, 2);
                  if (curChar == 48)
                     jjAddStates(3, 4);
                  break;
               case 1:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 2:
                  if (curChar == 39 && kind > 16)
                     kind = 16;
                  break;
               case 3:
                  if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 4:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 5:
                  if (curChar == 34 && kind > 17)
                     kind = 17;
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  jjAddStates(5, 6);
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddStates(0, 2);
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(12);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(13, 14);
                  break;
               case 14:
                  if (curChar != 46)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAddTwoStates(15, 16);
                  break;
               case 15:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAddTwoStates(15, 16);
                  break;
               case 17:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(18);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAdd(18);
                  break;
               case 19:
                  if (curChar == 48)
                     jjAddStates(3, 4);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if ((0x3000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjstateSet[jjnewStateCnt++] = 23;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 20)
                        kind = 20;
                     jjCheckNAdd(7);
                  }
                  else if (curChar == 123)
                     jjCheckNAdd(9);
                  break;
               case 1:
                  jjAddStates(7, 8);
                  break;
               case 4:
                  jjAddStates(9, 10);
                  break;
               case 6:
               case 7:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjCheckNAdd(7);
                  break;
               case 8:
                  if (curChar == 123)
                     jjCheckNAdd(9);
                  break;
               case 9:
                  if ((0xdfffffffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(9, 10);
                  break;
               case 10:
                  if (curChar == 125 && kind > 24)
                     kind = 24;
                  break;
               case 16:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(11, 12);
                  break;
               case 20:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(21);
                  break;
               case 21:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(21);
                  break;
               case 22:
                  if ((0x400000004L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjstateSet[jjnewStateCnt++] = 23;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(7, 8);
                  break;
               case 4:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(9, 10);
                  break;
               case 9:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(5, 6);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 24 - (jjnewStateCnt = startsAt)))
         break;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { break; }
   }
   if (jjmatchedPos > strPos)
      return curPos;

   int toRet = Math.max(curPos, seenUpto);

   if (curPos < toRet)
      for (i = toRet - Math.min(curPos, seenUpto); i-- > 0; )
         try { curChar = input_stream.readChar(); }
         catch(java.io.IOException e) { throw new Error("Internal Error : Please send a bug report."); }

   if (jjmatchedPos < strPos)
   {
      jjmatchedKind = strKind;
      jjmatchedPos = strPos;
   }
   else if (jjmatchedPos == strPos && jjmatchedKind > strKind)
      jjmatchedKind = strKind;

   return toRet;
}
static final int[] jjnextStates = {
   12, 13, 14, 20, 22, 9, 10, 1, 2, 4, 5, 17, 18, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, "\50", 
"\51", "\173", "\175", "\133", "\135", "\73", "\72", "\54", "\56", "\76", "\74", 
"\74\75", "\76\75", "\77", "\74\76", "\75", "\53", "\55", "\174\174", "\46\46", 
"\136\136", "\174", "\46", "\136", "\176", "\74\74", "\76\76", "\41", "\75\76", "\52", 
"\57", "\45", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3ffffffff1b5fe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[24];
private final int[] jjstateSet = new int[48];
protected char curChar;
/** Constructor. */
public ParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public ParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 24; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
