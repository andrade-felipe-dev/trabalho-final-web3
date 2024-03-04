package br.edu.ifpr.irati.ads.models.user;

import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.enums.TypeUserEnum;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User{
    public Admin(int id, String name, String email) {
        super(id, name, email);
    }

    public Admin() {
        super(0, "", "");
    }

    public void freshTermTicket(Ticket ticket, int days) {
        ticket.setEndDateWithDays(days);
    }

    public void deletegateToResponsability(Helper helper, Ticket ticket) {
        ticket.setResponsible(helper);
    }

    public void generateReport() {

    }
}
