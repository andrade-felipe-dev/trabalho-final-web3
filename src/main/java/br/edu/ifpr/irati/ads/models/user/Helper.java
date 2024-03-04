package br.edu.ifpr.irati.ads.models.user;

import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.enums.StatusTicketEnum;
import br.edu.ifpr.irati.ads.models.enums.TypeUserEnum;
import br.edu.ifpr.irati.ads.models.exception.InvalidStatusException;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HELPER")
public class Helper extends User {
    public Helper(int id, String name, String email) {
        super(id, name, email);
    }

    public Helper() {
        super(0, "", "");
    }

    public void freshStatusTicket(StatusTicketEnum status, Ticket ticket) throws InvalidStatusException {
        if (status.equals(StatusTicketEnum.FINALIZADO)) {
            throw new InvalidStatusException();
        }

        ticket.setStatus(status);
    }
}
