package br.edu.ifpr.irati.ads.models;

import br.edu.ifpr.irati.ads.models.user.Admin;
import br.edu.ifpr.irati.ads.models.user.User;
import jakarta.persistence.*;

@Entity(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-ticket")
    @SequenceGenerator(name = "seq-ticket", sequenceName = "TICKET_SEQ", allocationSize = 1, initialValue = 1)
    private int id;

    @Column(name = "message")
    private String message;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ticket ticket;

    @OneToOne(fetch = FetchType.LAZY)
    private User author;
    public Message(int id, String message, Ticket ticket, User author) {
        this.id = id;
        this.message = message;
        this.ticket = ticket;
        this.author = author;
    }

    public Message() {
        id = 0;
        message = "";
        ticket = new Ticket();
        author = new User();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(Admin author) {
        this.author = author;
    }
}
