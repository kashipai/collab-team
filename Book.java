package jpa_oneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "BOOK")
public class Book {
	@Id 
	@Column(name = "bookId")
    private int bookId;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
    
    public Book() {
    	
    }
 
    public Book(int bookId, String title,Author author) {
		super();
		this.bookId = bookId;
		this.title = title;	
		this.author=author;
	}

	public int getId() {
        return bookId;
    }
 
    public void setId(int id) {
        this.bookId = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    
	@Override
	public String toString() {
		return "Book: bookId= " + bookId + ", Title: " + title +" By "+author ;
	}
    
}