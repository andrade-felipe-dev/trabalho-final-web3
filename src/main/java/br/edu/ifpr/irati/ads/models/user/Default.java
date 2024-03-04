package br.edu.ifpr.irati.ads.models.user;

import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.enums.StatusTicketEnum;
import br.edu.ifpr.irati.ads.models.enums.TypeUserEnum;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DEFAULT")
public class Default extends User{
    public Default(int id, String name, String email) {
        super(id, name, email);
    }

    public Default() {
        super(0, "", "");
    }

    public void closeTicket(Ticket ticket) {
        ticket.setStatus(StatusTicketEnum.FINALIZADO);
    }
}
