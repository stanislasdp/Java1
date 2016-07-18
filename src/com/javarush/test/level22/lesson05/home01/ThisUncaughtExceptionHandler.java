package com.javarush.test.level22.lesson05.home01;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string)
    {
        return null;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string)
    {
       //return String.format(string,e.getCause().getCause().getCause(),e.getCause());
        return null;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string)
    {
       // return String.format(string,t.getName(),e.getClass().getSimpleName(),t.getClass().getSimpleName());
        return String.format(string,t.getName(),e.getClass().getSimpleName(),e.getMessage());
        //return null;
    }
}

