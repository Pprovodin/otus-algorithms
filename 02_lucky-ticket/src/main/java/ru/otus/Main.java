package ru.otus;

import org.apache.commons.lang3.time.StopWatch;

public class Main {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        for (int N = 1; N <= 10; N++) {
            LuckyTicketsForN luckyTicketsForN = new LuckyTicketsForN();
            stopWatch.reset();
            stopWatch.start();
            luckyTicketsForN.getLuckyTicketCleverRecursion(N);
            stopWatch.stop();

            System.out.println("N=" + N + "; time spent " + stopWatch.getTime() + "ms; result " + luckyTicketsForN.getCount());
        }
    }
}
