package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by stas on 8/7/16.
 */
 interface Command
{
    void execute() throws InterruptOperationException;
}
