   
package net.codejava;



import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pages")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberr;
    
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private String content;
    
    private String chapter;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public Page() {
    }

    public Page(int numberr, String content, String chapter, Book book) {
        this.numberr = numberr;
        this.content = content;
        this.chapter = chapter;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberr() {
        return numberr;
    }

    public void setNumberr(int numberr) {
        this.numberr = numberr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return id.equals(page.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", number=" + numberr +
                ", content='" + content + '\'' +
                ", chapter='" + chapter + '\'' +
                ", book=" + book +
                '}';
    }
}