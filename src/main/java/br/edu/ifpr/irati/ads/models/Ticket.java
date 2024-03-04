package br.edu.ifpr.irati.ads.models;

import br.edu.ifpr.irati.ads.models.enums.StatusTicketEnum;
import br.edu.ifpr.irati.ads.models.user.Admin;
import br.edu.ifpr.irati.ads.models.user.Default;
import br.edu.ifpr.irati.ads.models.user.Helper;
import br.edu.ifpr.irati.ads.models.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "ticket")
public class Ticket implements Comparable<Ticket> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-ticket")
    @SequenceGenerator(name = "seq-ticket", sequenceName = "TICKET_SEQ", allocationSize = 1, initialValue = 1)
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private Helper responsible;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private User createdBy;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Theme theme;
    @Column(name = "endDateWithDays")
    private int endDateWithDays;

    @Enumerated(EnumType.STRING)
    private StatusTicketEnum status;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Message> messages;

    public Ticket() {
        id = 0;
        title = "";
        description = "";
        createdBy = new User();
        theme = new Theme();
        endDateWithDays = 0;
        status = StatusTicketEnum.ABERTO;
    }

    public Ticket(int id, String title, String description, User createdBy, Theme theme, int endDateWithDays, StatusTicketEnum status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.theme = theme;
        this.endDateWithDays = endDateWithDays;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Helper getResponsible() {
        return responsible;
    }

    public void setResponsible(Helper responsible) {
        this.responsible = responsible;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }


    public int getEndDateWithDays() {
        return endDateWithDays;
    }

    public void setEndDateWithDays(int endDateWithDays) {
        this.endDateWithDays = endDateWithDays;
    }

    public StatusTicketEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTicketEnum status) {
        this.status = status;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.id - o.id;
    }
}
