/*
 * Copyrights � 2011 by Rohit Harchandani and Risha Chheda
 *
 * Please refer to root level license.txt file 
 * for entire license. 
 */
package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class AddQuizQuestionForm extends FormBean {
	
	private String question;
	private String answer;
	
	
	public String getQuestion()  { return question; }
	public String getAnswer()  { return answer; }
	
	
	public void setQuestion(String s) {	question = trimAndConvert(s,"<>\"");                 }
	public void setAnswer(String s) {	answer = trimAndConvert(s,"<>\"");                  }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (question == null || question.length() == 0) {
			errors.add("Question is required");
		}
		
		if (question.matches(".*[<>\"].*"))
			errors.add("question may not contain angle brackets or quotes.");
		
		if (answer == null || answer.length() == 0) {
			errors.add("Answer is required");
		}
		
		if (answer.matches(".*[<>\"].*"))
			errors.add("answer may not contain angle brackets or quotes.");
		
		return errors;
	}
	
	private String trimAndConvert(String s, String charsToConvert) {
		if (!s.matches("["+charsToConvert+"]")) {
			return s.trim();
		}
		
		StringBuffer b = new StringBuffer();
		for (char c : s.trim().toCharArray()) {
			switch (c) {
				case '<':
					if (charsToConvert.indexOf('<') != -1) {
						b.append("&lt;");
					} else {
						b.append(c);
					}
					break;
				case '>':
					if (charsToConvert.indexOf('>') != -1) {
						b.append("&gt;");
					} else {
						b.append(c);
					}
					break;
				case '&':
					if (charsToConvert.indexOf('&') != -1) {
						b.append("&amp;");
					} else {
						b.append(c);
					}
					break;
				case '"':
					if (charsToConvert.indexOf('"') != -1) {
						b.append("&quot;");
					} else {
						b.append(c);
					}
					break;
				default:
					if (charsToConvert.indexOf(c) != -1) {
						b.append("&#"+c+";");
					} else {
						b.append(c);
					}
			}
		}
		
		return b.toString();
	}
}
