package org.example;

import java.util.HashMap;
import java.util.List;

public class FestivalStatisticsThread implements Runnable {

    FestivalGate gate;
    //full, full-vip, free-pass, one-day, one-day-vip
    HashMap<TicketType, Integer> ticketNb = new HashMap<>();

    public FestivalStatisticsThread(FestivalGate gate) {
            this.gate = gate;
            HashMap<TicketType, Integer> ticketNb = new HashMap<>();
            ticketNb.put(TicketType.FULL, 0);
            ticketNb.put(TicketType.FULL_VIP, 0);
            ticketNb.put(TicketType.FREE_PASS, 0);
            ticketNb.put(TicketType.ONE_DAY, 0);
            ticketNb.put(TicketType.ONE_DAY_VIP, 0);
            this.ticketNb = ticketNb;
        }

    @Override
    public String toString() {
        return "FestivalStatisticsThread{" +
                "gate=" + gate +
                ", ticketNb=" + ticketNb +
                '}';
    }

    @Override
    public void run() {
        if (this.gate.getTicketTypeList().isEmpty()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!this.gate.getTicketTypeList().isEmpty()) {
            synchronized (this) {
                List<FestivalAttendeeThread> ticketAttendeeList = gate.getTicketTypeList();
                System.out.println("List is:");
                for (FestivalAttendeeThread f : ticketAttendeeList) {
                    ticketNb.put(f.getTicketType(), ticketNb.get(f.getTicketType())+1);
                    //increments the value of that certain ticketType stored in the hashmap
                }
                int s = 0;
                for (TicketType t : ticketNb.keySet()){
                    s += ticketNb.get(t);
                }
                System.out.println(s + " have entered");
                for (TicketType t : ticketNb.keySet()){
                    System.out.println(t + ": " + ticketNb.get(t));
                }
                System.out.println();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
