package net.andy.customer.entities;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {
    private Long id;
    private Long customerId;
    private String note;

    public Note() {

    }

    public Note(Long customerId) {
        this.customerId = customerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() { return customerId; }

    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

}
