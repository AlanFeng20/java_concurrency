package com.company.suspend;

import com.company.Task;

public class TaskSuspend extends Task {
    @Override
    public void run() {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
