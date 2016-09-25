package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by stas on 9/24/16.
 */
public class UndoMenuListener implements MenuListener
{
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener (View view,JMenuItem undoMenuItem, JMenuItem redoMenuItem)
    {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
        undoMenuItem.setText("Отменить");
        redoMenuItem.setText("Вернуть");

    }

    @Override
    public void menuSelected(MenuEvent e)
    {
        if (!view.canUndo())
        {
            undoMenuItem.setEnabled(false);

        }
        else
        {
            undoMenuItem.setEnabled(true);
        }

        if (!view.canRedo())
        {
            redoMenuItem.setEnabled(false);
        }
        else
        {
            redoMenuItem.setEnabled(true);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e)
    {

    }

    @Override
    public void menuCanceled(MenuEvent e)
    {

    }
}
