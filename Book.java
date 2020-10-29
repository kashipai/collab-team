package jpa_oneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "BOOK")
public class Book {
	@Id
	@Column(name = "bookId")
    private int bookId;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="authorId")
    private Author author;
 
    public Book() {
    }
 
    
    public Book(int bookId, String title, Author author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
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
 
    public Author getAuthor() {
        return author;
    }
 
    public void setAuthor(Author author) {
        this.author = author;
    }

	@Override
	public String toString() {
		return "Book: bookId= " + bookId + ", Title: " + title + ", by " + author;
	}
    
}