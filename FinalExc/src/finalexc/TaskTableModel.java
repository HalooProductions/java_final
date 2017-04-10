/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author s303004
 */
public class TaskTableModel extends AbstractTableModel {
    public TaskTableModel(ArrayList<Task> o) {
         for (Object item : o) {
             addObject(item);
         }
     }
   
     private final List<Object> objects = new ArrayList<Object>();

     public void addObject(Object obj) {
         addObject(obj, objects.size());
     }

     public void addObject(Object obj, int index) {
         objects.add(index, obj);
         fireTableRowsInserted(index, index);
     }

     public void removeObject(Object obj) {
         int index = objects.indexOf(obj);
         objects.remove(index);
         fireTableRowsDeleted(index, index);
     }

     public Object getObject(int rowIndex) {
         return objects.get(rowIndex);
     }

     @Override
     public int getRowCount() {
         return objects.size();
     }

     @Override
     public int getColumnCount() {
         return 6;
     }

     @Override
     public String getColumnName(int columnIndex) {
         switch (columnIndex) {
             case 0:
                 return "ID";
             case 1:
                 return "User";
             case 2:
                 return "Start date";
             case 3:
                 return "End date";
             case 4:
                 return "Description";
             case 5:
                 return "Place";
             default:
                 throw new IndexOutOfBoundsException();
         }
     }

     @Override
     public Class<?> getColumnClass(int columnIndex) {
         switch (columnIndex) {
             case 0:
                 return Integer.class;
             case 1:
                 return String.class;
             case 2:
                 return String.class;
             case 3:
                 return String.class;
             case 4:
                 return String.class;
             case 5:
                 return String.class;
             default:
                 throw new IndexOutOfBoundsException();
         }
     }

     @Override
     public Object getValueAt(int rowIndex, int columnIndex) {
         Task obj = (Task)objects.get(rowIndex);
         switch (columnIndex) {
             case 0:
                 return obj.getId();
             case 1:
                 return obj.getUser();
             case 2:
                 return obj.getStart();
             case 3:
                 return obj.getEnd();
             case 4:
                 return obj.getDescription();
             case 5:
                 return obj.getPlace();
             default:
                 throw new IndexOutOfBoundsException();
         }
     }
}
