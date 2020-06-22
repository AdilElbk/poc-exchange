package ma.sopra.pocexchange.pocxchangeoffice.entities;

public class XmlValidationError {
	private int columnLineNumber;
	private int rowLineNumber;
	private String message;
	
	public int getColumnLineNumber() {
		return columnLineNumber;
	}
	public void setColumnLineNumber(int columnLineNumber) {
		this.columnLineNumber = columnLineNumber;
	}
	public int getRowLineNumber() {
		return rowLineNumber;
	}
	public void setRowLineNumber(int rowLineNumber) {
		this.rowLineNumber = rowLineNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public XmlValidationError(int i, int j, String message) {
		super();
		this.columnLineNumber = i;
		this.rowLineNumber = j;
		this.message = message;
	}
	public XmlValidationError() {
		// TODO Auto-generated constructor stub
	}
	
	
}
