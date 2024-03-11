package br.edu.ifpr.irati.ads.models.user;

import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.enums.TypeUserEnum;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User{
    public Admin(int id, String name, String email) {
        super(id, name, email);
    }

    public Admin() {
        super(0, "", "");
    }

    public void freshTermTicket(Ticket ticket, Date date) {
        ticket.setEndDate(date);
    }

    public void deletegateToResponsability(Helper helper, Ticket ticket) {
        ticket.setResponsible(helper);
    }

    public void generateReport() {

    }
}
