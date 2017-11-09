package myteststuff.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by aziring on 9/5/17.
 */
//@Entity
//@Table(name = "NOTES")
public class NotesEntity {

    private int id;
    private String notes;
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name="ID", unique=true, nullable=false)
//  public int getId() {
//    return id;
//  }
//
//  public void setId(int id) {
//    this.id = id;
//  }
//
//  @Column(name = "NOTES",nullable = false)
//  public String getNotes() {
//    return notes;
//  }
//
//  public void setNotes(String notes) {
//    this.notes = notes;
//  }
}
