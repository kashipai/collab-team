package springMvcLibrary.Model;

public class Library 
{
	int id;
	String name;
	String author;
	int cost;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public Library() {}
	
	public Library(int isbn, String bName, String bAuthor, int cost)
	{
		this.id = isbn;
		this.name = bName;
		this.author = bAuthor;
		this.cost = cost;
	}
	
	
}
