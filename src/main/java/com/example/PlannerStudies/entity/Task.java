package com.example.PlannerStudies.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Tarefas-escola")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "Materia")
    private String matter;

    @Column(name = "Titulo")
    private String title;

    @Column(name = "Descricao")
    private String description;

    @Column(name = "Status")
    private boolean isCompleted;

    public Task(Long id, String matter, String title, String description, boolean isCompleted) {
        this.id = id;
        this.matter = matter;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
