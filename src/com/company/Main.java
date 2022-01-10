package com.company;

import com.company.lock.TaskLock;
import com.company.suspend.TaskSuspend;

public class Main {
    static Runnable[] runnables = {new TaskSuspend(), new TaskLock()};

    public static void main(String[] args) {
        for (Runnable runnable : runnables) {
            runnable.run();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
