package com.abapblog.adt.quickfix.assist.syntax.statements.lineEnd;

import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.swt.graphics.Image;

import com.abapblog.adt.quickfix.assist.syntax.statements.IAssistRegex;
import com.abapblog.adt.quickfix.assist.syntax.statements.StatementAssist;

public class LineBreakAtEndOfMethod extends StatementAssist implements IAssistRegex {
	private static final String lineBreakAtEndPattern = "(?s)(\\s)*(\\r?\\n)+(\\s)*(\\))(\\s)*(\\r?\\n)*(\\s)*$";
	private static final String replaceCallMethodPattern = " )";

	public LineBreakAtEndOfMethod(IQuickAssistInvocationContext context) {
		super(context);
	}

	@Override
	public String getMatchPattern() {
		return lineBreakAtEndPattern;
	}

	@Override
	public String getReplacePattern() {
		return replaceCallMethodPattern;
	}

	@Override
	public String getChangedCode() {
		return CodeReader.CurrentStatement.replaceAllPattern(getMatchPattern(), getReplacePattern());
	}

	@Override
	public String getAssistShortText() {
		return "Remove line break at end of statement";
	}

	@Override
	public String getAssistLongText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getAssistIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canAssist() {
		if (CodeReader.CurrentStatement.matchPattern(getMatchPattern())) {
			return true;
		}
		return false;
	}

	@Override
	public int getStartOfReplace() {
		return CodeReader.CurrentStatement.getBeginOfStatement();
	}

	@Override
	public int getReplaceLength() {
		return CodeReader.CurrentStatement.getStatementLength();
	}

}
