package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;
import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stas on 9/23/16.
 */
public class View extends JFrame implements ActionListener
{
    private JTabbedPane tabbedPane =  new JTabbedPane();
    private JTextPane htmlTextPane =  new JTextPane() ;
    private JEditorPane plainTextPane = new JEditorPane();
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);


    public View ()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ie)
        {
            ie.printStackTrace();
            ExceptionHandler.log(ie);
        }

    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public UndoManager getUndoManager()
    {
        return undoManager;
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public void init()
    {
        initGui();
        FrameListener fm = new FrameListener(this);
        super.addWindowListener(fm);
        setVisible(true);

    }
    public void exit()
    {
        controller.exit();
    }

    public void initMenuBar()
    {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }

    public void initEditor()
    {
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
        htmlTextPane.setContentType("text/html");
        tabbedPane.add("HTML",new JScrollPane(htmlTextPane));
        JScrollPane jScrollPane2 = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст",jScrollPane2);
        tabbedPane.setPreferredSize(new Dimension(400,400));//?
        TabbedPaneChangeListener tb = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tb);

    }

    public void initGui()
    {
        initMenuBar();
        initEditor();
        pack();
    }

    public void undo()
    {
        try
        {
            undoManager.undo();
        }
        catch (CannotUndoException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }


    public void redo()
    {
        try
        {
            undoManager.redo();
        }
        catch (CannotRedoException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }

    public void resetUndo()
    {
        undoManager.discardAllEdits();
    }


    public boolean isHtmlTabSelected()
    {
        return  tabbedPane.getSelectedIndex() ==0;

    }

    public  void selectHtmlTab()
    {
        tabbedPane.setSelectedIndex(0);
        resetUndo();

    }

    public void update()
    {
        htmlTextPane.setDocument(controller.getDocument());

    }

    public  void showAbout()
    {
        JOptionPane.showMessageDialog(null,"Message","Title",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       String itemCaused = e.getActionCommand();
        switch (itemCaused)
        {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case  "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }

    public void selectedTabChanged()
    {
        if (tabbedPane.getSelectedIndex() == 0)
        {
            controller.setPlainText(plainTextPane.getText());
        }
        else if (tabbedPane.getSelectedIndex() == 1)
        {
            plainTextPane.setText(controller.getPlainText());

        }
        resetUndo();
    }
}
