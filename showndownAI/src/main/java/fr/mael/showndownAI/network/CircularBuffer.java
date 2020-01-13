package fr.mael.showndownAI.network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CircularBuffer {

    Logger logger = LogManager.getLogger();

    String[] buffer;
    int pollPointer = 0;
    int offerPointer = 0;
    int maxSize;
    boolean closed = false;

    public CircularBuffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new String[maxSize];
    }

    public synchronized void close() {
        closed = true;
        notifyAll();
    }

    public synchronized boolean isClosed() {
        return closed && (pollPointer == offerPointer);
    }

    public void offer(String message)
        throws InterruptedException {

        if (closed) {
            throw new BufferClosedException();
        }
        for (;;) {
            synchronized (this) {
                int nextOffer = next(this.offerPointer);
                if (nextOffer != pollPointer) {
                    buffer[offerPointer] = message;
                    offerPointer = nextOffer;
                    notifyAll();
                    return;
                }
                wait();
            }

        }
    }

    public String poll()
        throws InterruptedException {
        for (;;) {
            synchronized (this) {
                if (pollPointer != offerPointer) {
                    String ret = buffer[pollPointer];
                    buffer[pollPointer] = null;
                    pollPointer = next(pollPointer);
                    notifyAll();
                    return ret;
                }
                if (closed) {
                    return null;
                }
                wait();
            }

        }
    }

    private int next(int pos) {
        return (pos + 1) % this.maxSize;
    }
}