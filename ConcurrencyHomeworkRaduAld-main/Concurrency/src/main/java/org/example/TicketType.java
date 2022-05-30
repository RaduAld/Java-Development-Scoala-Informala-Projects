package org.example;


import java.util.Random;

enum TicketType {
    //full, full-vip, free-pass, one-day, one-day-vip
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    /**
     * Pick a random value of the BaseColor enum.
     *
     * @return a random BaseColor.
     */
    public static TicketType getRandomTicket() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

