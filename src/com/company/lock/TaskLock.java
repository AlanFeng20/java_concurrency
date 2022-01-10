package com.company.lock;

import com.company.Task;

public class TaskLock extends Task {
    @Override
    public void run() {
        final SafeLock.Friend alphonse =
                new SafeLock.Friend("Alphonse");
        final SafeLock.Friend gaston =
                new SafeLock.Friend("Gaston");
        new Thread(new SafeLock.BowLoop(alphonse, gaston)).start();
        new Thread(new SafeLock.BowLoop(gaston, alphonse)).start();
    }
}
