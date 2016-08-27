package com.javarush.test.level28.lesson15.big01.view;

import javax.swing.table.AbstractTableModel;

/**
 * Created by stas on 8/27/16.
 */
public class PTableModel
{

    /*
        ArrayList<Person> pp = new ArrayList<Person>();
        PersonDAO pd = new PersonDAO_H2();

        @Override
        public String getColumnName(int col)
        {
            String[] name = {"ID","FName","LName","Age"};
            return name[col];
        }

        @Override
        public int getColumnCount()
        {
            return 4;
        }

        @Override
        public int getRowCount()
        {
            return pp.size();
        }

        @Override
        public Object getValueAt(int row, int col)
        {
            Person p = pp.get(row);
            Object ret = null;
            switch ( col )
            {
                case 0: ret = p.id; break;
                case 1: ret = p.fname; break;
                case 2: ret = p.lname; break;
                case 3: ret = p.age; break;
            }
            return ret;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex)
        {
            return true;
        }

        @Override
        public void fireTableDataChanged()
        {
            read();
            super.fireTableDataChanged();
        }*/
}
