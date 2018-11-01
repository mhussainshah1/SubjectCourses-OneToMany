package com.example.lesson10;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Size(min = 4)
  @Column(unique = true)
  private String title;

  @OneToMany(mappedBy = "subject")
  public Set<Course> courses;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<Course> getCourses() {
    return courses;
  }

  public void setCourses(Set<Course> courses) {
    this.courses = courses;
  }
}
