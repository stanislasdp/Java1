package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by stas on 9/24/16.
 */
public class TextEditMenuListener implements MenuListener
{
    private View view;


    public TextEditMenuListener(View view)
    {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent e)
    {
         JMenu jMenu =   (JMenu) e.getSource();
        jMenu.getSubElements();
        for (Component comp: jMenu.getMenuComponents())
        {
            comp.setEnabled(view.isHtmlTabSelected());

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
