package com.blog.Bloggingproject.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Title")
    private String title;
    
    @Column(name = "Content")
    private String content;
    
    @Column(name = "Author")
    private String author;

   @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    public Post() {
    // JPA & Spring ke liye mandatory
    }

    public Post(int id,String title,String content,String author){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return content;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
}
