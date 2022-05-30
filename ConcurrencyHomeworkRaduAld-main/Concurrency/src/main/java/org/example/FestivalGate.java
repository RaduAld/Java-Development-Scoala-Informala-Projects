package org.example;

import java.util.LinkedList;
import java.util.List;

public class FestivalGate {
    List<FestivalAttendeeThread> ticketAttendeeList = new LinkedList<>();

    public List<FestivalAttendeeThread> getTicketTypeList() {
        return ticketAttendeeList;
    }

    public void generateTickets() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                synchronized (this) {
                    TicketType ticketType = TicketType.getRandomTicket();
                    FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, this);
                    this.ticketAttendeeList.add(festivalAttendee);
                }
            }
            Thread.sleep(500);
        }
    }
}
