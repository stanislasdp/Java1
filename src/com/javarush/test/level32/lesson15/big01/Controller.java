package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by stas on 9/23/16.
 */
public class Controller
{
    private View view;

    private HTMLDocument document;//model
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void init()
    {
     createNewDocument();
    }

    public  void resetDocument()
    {
        if (document != null)
        {
            document.removeUndoableEditListener(view.getUndoListener());
        }
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
            document.addUndoableEditListener(view.getUndoListener());
            view.update();

    }

    public void setPlainText(String text)
    {
        try
        {
            resetDocument();
            StringReader stringReader = new StringReader(text);
            new HTMLEditorKit().read(stringReader,document,0);
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

   public String getPlainText()
    {
        StringWriter stringWriter = new StringWriter();
        try
        {

            new HTMLEditorKit().write(stringWriter,document,0,document.getLength());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
       ;
        return stringWriter.toString();
    }


    public void createNewDocument()
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

   public void openDocument()
   {
       view.selectHtmlTab();
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.setFileFilter(new HTMLFileFilter());
       int response = fileChooser.showOpenDialog(view);

       if (response == JFileChooser.APPROVE_OPTION)
       {
           currentFile = fileChooser.getSelectedFile();
           resetDocument();
           view.setTitle(currentFile.getName());

           try (FileReader fileReader = new FileReader(currentFile);)
           {

                new HTMLEditorKit().read(fileReader,document,0);
           }
           catch (Exception e)
           {

               ExceptionHandler.log(e);
           }
           view.resetUndo();


       }
   }

    public  void saveDocument()
    {
        if (currentFile ==  null)
        {
            saveDocumentAs();
            return;
        }
        view.selectHtmlTab();
        try (FileWriter fileWriter = new FileWriter(currentFile);)
        {

            new HTMLEditorKit().write(fileWriter,document,0,document.getLength());

        }
        catch (Exception e)
        {

            ExceptionHandler.log(e);
        }

    }

    public void saveDocumentAs()
    {
      view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        fileChooser.setDialogTitle("Save File");
        int response = fileChooser.showSaveDialog(view);
        if (response == JFileChooser.APPROVE_OPTION)
        {
            currentFile = fileChooser.getSelectedFile();
           view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile);)
            {

                new HTMLEditorKit().write(fileWriter,document,0,document.getLength());

            }
            catch (Exception e)
            {

                ExceptionHandler.log(e);
            }

        }
    }


    public void exit()
    {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
