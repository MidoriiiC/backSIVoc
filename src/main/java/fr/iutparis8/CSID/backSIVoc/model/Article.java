package fr.iutparis8.CSID.backSIVoc.model;

public class Article {

	private int id;
	private String title;
	private String content;
	private String author;
	private String date;
	private String hour;
	private String illustration;

	public Article(int id, String title, String content, String author, String date, String hour, String illustration) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.hour = hour;
		this.illustration = illustration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getIllustration() {
		return illustration;
	}

	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}

}
