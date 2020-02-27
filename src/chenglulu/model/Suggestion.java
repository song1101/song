package chenglulu.model;

import java.io.Serializable;

public class Suggestion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int suggestionID;
	private String suggester;
	private String description;
	private int isKnown;
	public int getSuggestionID() {
		return suggestionID;
	}
	public void setSuggestionID(int suggestionID) {
		this.suggestionID = suggestionID;
	}
	public String getSuggester() {
		return suggester;
	}
	public void setSuggester(String suggester) {
		this.suggester = suggester;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIsKnown() {
		return isKnown;
	}
	public void setIsKnown(int isKnown) {
		this.isKnown = isKnown;
	}
	
}
