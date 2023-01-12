package ru.otus;

public class Stopwatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    public void start() {
        this.startTime = System.nanoTime();
        this.running = true;
    }

    public void stop() {
        this.stopTime = System.nanoTime();
        this.running = false;
    }

    public long getElapsedTimeInMillis() {
        long elapsed;
        if (running) {
            elapsed = ((System.nanoTime() - startTime) / 1_000_000);
        } else {
            elapsed = ((stopTime - startTime) / 1_000_000);
        }
        return elapsed;
    }

    public long getElapsedTimeInSeconds() {
        long elapsed;
        if (running) {
            elapsed = ((System.nanoTime() - startTime) / 1_000_000_000);
        } else {
            elapsed = ((stopTime - startTime) / 1_000_000_000);
        }
        return elapsed;
    }
}
