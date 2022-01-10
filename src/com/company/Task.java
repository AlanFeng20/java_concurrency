package com.company;

public abstract class Task implements Runnable{
    {
        System.out.println("Task:"+getClass().getSimpleName());
    }
}
