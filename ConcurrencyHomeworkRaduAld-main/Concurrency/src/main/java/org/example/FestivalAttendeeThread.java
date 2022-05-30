package org.example;

public class FestivalAttendeeThread extends Thread {

    private TicketType ticketType;
    private FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }
}
