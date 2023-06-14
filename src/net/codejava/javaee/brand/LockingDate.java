package net.codejava.javaee.brand;

public class LockingDate {
	
	
	protected  String year="";
    protected  String feb="";
	protected  String mar="";
	protected  String april="";
	protected  String may="";
	protected String june="";
	protected String july="";
	protected String august="";
	protected String september="";
	protected String october="";
	protected String november="";
	protected String december="";
	protected String january="";
	protected String updated_by="";
	protected String updated_on="";
	protected String timevalue="";
	
	public LockingDate(String year, String feb, String mar, String april, String may, String june, String july,
			String august, String september, String october, String november, String december, String january,
			String updated_by, String updated_on) {
		super();
		this.year = year;
		this.feb = feb;
		this.mar = mar;
		this.april = april;
		this.may = may;
		this.june = june;
		this.july = july;
		this.august = august;
		this.september = september;
		this.october = october;
		this.november = november;
		this.december = december;
		this.january = january;
		this.updated_by = updated_by;
		this.updated_on = updated_on;
		
		
	}
	public LockingDate(String year, String feb, String mar, String april, String may, String june, String july,
			String august, String september, String october, String november, String december, String january,
			String updated_by, String updated_on ,String timevalue) {
		super();
		this.year = year;
		this.feb = feb;
		this.mar = mar;
		this.april = april;
		this.may = may;
		this.june = june;
		this.july = july;
		this.august = august;
		this.september = september;
		this.october = october;
		this.november = november;
		this.december = december;
		this.january = january;
		this.updated_by = updated_by;
		this.updated_on = updated_on;
		this.timevalue=timevalue;
	}

	public String getTimevalue() {
		return timevalue;
	}

	public void setTimevalue(String timevalue) {
		this.timevalue = timevalue;
	}

	public LockingDate(String year) {
		// TODO Auto-generated constructor stub
		super();
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFeb() {
		return feb;
	}

	public void setFeb(String feb) {
		this.feb = feb;
	}

	public String getMar() {
		return mar;
	}

	public void setMar(String mar) {
		this.mar = mar;
	}

	public String getApril() {
		return april;
	}

	public void setApril(String april) {
		this.april = april;
	}

	public String getMay() {
		return may;
	}

	public void setMay(String may) {
		this.may = may;
	}

	public String getJune() {
		return june;
	}

	public void setJune(String june) {
		this.june = june;
	}

	public String getJuly() {
		return july;
	}

	public void setJuly(String july) {
		this.july = july;
	}

	public String getAugust() {
		return august;
	}

	public void setAugust(String august) {
		this.august = august;
	}

	public String getSeptember() {
		return september;
	}

	public void setSeptember(String september) {
		this.september = september;
	}

	public String getOctober() {
		return october;
	}

	public void setOctober(String october) {
		this.october = october;
	}

	public String getNovember() {
		return november;
	}

	public void setNovember(String november) {
		this.november = november;
	}

	public String getDecember() {
		return december;
	}

	public void setDecember(String december) {
		this.december = december;
	}

	public String getJanuary() {
		return january;
	}

	public void setJanuary(String january) {
		this.january = january;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public String getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;
	}
	
	
}

