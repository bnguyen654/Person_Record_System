package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
  
public class GUI extends javax.swing.JFrame {
    static Person currPerson = null;
    static ArrayList<Person> pResultList = new ArrayList<Person>();
    static ArrayList<Person> people = TestPeople.genList(5);
    static ArrayList<UUID> ids = TestPeople.getIds();
    
    public GUI() {
        initComponents();
        for (int i= 0; i < people.size(); i++) {
            Person p = people.get(i);
            System.out.println("Person " + (i+1) + " is: " + p.fname + " " + p.lname + " with birthday of " +
                p.fBirthday() + ".");
        }
        update();
        LookupQuery.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                refresh();
            }

            public void removeUpdate(DocumentEvent e) {
                refresh();
            }

            public void changedUpdate(DocumentEvent e) {
                refresh();
            }
            
            public void refresh(){
                refine(LookupQuery.getText());
                update();
                //System.out.println("Text changed at " + System.currentTimeMillis());
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabs = new javax.swing.JTabbedPane();
        LookupPanel = new javax.swing.JPanel();
        LookupTable = new javax.swing.JScrollPane();
        LookupResults = new javax.swing.JTable();
        LookupQuery = new javax.swing.JTextField();
        InfoPanel = new javax.swing.JPanel();
        infoTableScroll = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        AccessingRecord = new javax.swing.JLabel();
        RecordIndicator = new javax.swing.JLabel();
        RecordName = new javax.swing.JLabel();
        RecordFName = new javax.swing.JLabel();
        RecordLName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update(evt);
            }
        });

        LookupResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UUID", "Last", "First", "Birthday", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LookupResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LookupResultsMousePressed(evt);
            }
        });
        LookupTable.setViewportView(LookupResults);

        LookupQuery.setToolTipText("Refine results bu name.");
        LookupQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LookupQueryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LookupPanelLayout = new javax.swing.GroupLayout(LookupPanel);
        LookupPanel.setLayout(LookupPanelLayout);
        LookupPanelLayout.setHorizontalGroup(
            LookupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LookupPanelLayout.createSequentialGroup()
                .addGroup(LookupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LookupPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LookupTable, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
                    .addComponent(LookupQuery))
                .addContainerGap())
        );
        LookupPanelLayout.setVerticalGroup(
            LookupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LookupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LookupQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LookupTable, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tabs.addTab("Lookup", null, LookupPanel, "Search for people and list records.");

        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"First Name:", null, "Last Name:", null},
                {"Middle Name:", null, "Alias(es):", null},
                {"Birthday:", "", null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infoTableScroll.setViewportView(infoTable);

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                .addContainerGap())
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tabs.addTab("Info", null, InfoPanel, "Display general info of person.");

        AccessingRecord.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        AccessingRecord.setText("Accessing Record:");

        RecordIndicator.setText("None");

        RecordName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        RecordName.setText("Name:");

        RecordFName.setText("-");

        RecordLName.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AccessingRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RecordIndicator)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RecordName)
                        .addGap(18, 18, 18)
                        .addComponent(RecordFName)
                        .addGap(18, 18, 18)
                        .addComponent(RecordLName)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccessingRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RecordIndicator)
                    .addComponent(RecordName)
                    .addComponent(RecordFName)
                    .addComponent(RecordLName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LookupQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LookupQueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LookupQueryActionPerformed

    private void update(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update
        update();
    }//GEN-LAST:event_update

    public void update() {
        refreshIndicators();
        refreshList();
        refreshInfo();
        //System.out.println("Updated at " + System.currentTimeMillis());
    }
     
    private void LookupResultsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LookupResultsMousePressed
        tableSelection(evt);
        //System.out.println("Table selected at " + System.currentTimeMillis());
    }//GEN-LAST:event_LookupResultsMousePressed

    public void tableSelection(java.awt.event.MouseEvent evt){
        if(evt.getClickCount() >=2 ) {
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            changePerson(getRecord(UUID.fromString((String) target.getValueAt(row, 0))));
            Tabs.setSelectedIndex(1);
        }
        update();
    }
    
    public void refreshIndicators(){
        if (currPerson != null) {
            RecordIndicator.setText(currPerson.id.toString());
            RecordFName.setText(currPerson.fname);
            RecordLName.setText(currPerson.lname);
        } else {
            RecordIndicator.setText("None");
            RecordFName.setText("-");
            RecordLName.setText("-");
        }
    }
    public void refreshInfo(){
        DefaultTableModel tbl = (DefaultTableModel) infoTable.getModel();
        if (currPerson == null) {
            //tbl.setValueAt("-", 0, 1);
            //tbl.setValueAt("-", 0, 3);
            //tbl.setValueAt("-", 1, 1);
            //tbl.setValueAt("-", 2, 1);
        } else {
            tbl.setValueAt(currPerson.fname, 0, 1);
            tbl.setValueAt(currPerson.lname, 0, 3);
            tbl.setValueAt(currPerson.mname, 1, 1);
            tbl.setValueAt(currPerson.fBirthday(), 2, 1);
        }
    }
    private void refreshList(){
        clearList();
        if (pResultList.isEmpty()) {
            for (Person person : people) {
                pResultList.add(person);
            }
        }
        for (Person pResult : pResultList) {
            addList(pResult);
        } 
    }
    
    public void refine(String n) {
       pResultList.clear();
        for (Person p : people) {
            if (p.fname.toLowerCase().contains(n.toLowerCase()) || p.lname.toLowerCase().contains(n.toLowerCase())) {
                pResultList.add(p);
            }
        }
        update();
    }
    public void changePerson(Person p) {
        currPerson = p;
    }
    public void removeList(int row) {
        DefaultTableModel tbl = (DefaultTableModel) LookupResults.getModel();
        tbl.removeRow(row);
    }
    public void clearList(){
        DefaultTableModel tbl = (DefaultTableModel) LookupResults.getModel();
        while (tbl.getRowCount() > 0) {
            tbl.removeRow(0);
        }
        
    }
    public void addList(Person p) {
        DefaultTableModel tbl = (DefaultTableModel) LookupResults.getModel();
        String UUID = p.getRecordID().toString();
        String lname = p.lname;
        String fname = p.fname;
        String bdate = p.fBirthday();
        tbl.addRow(new String[] {UUID,lname,fname,bdate,"None."});
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
        
    public static void reloadFromFile(){
        people = loadList();
        ids = loadIDs();
    }
    public static Person getRecord(UUID id) {
        return people.get(ids.indexOf(id));
    }
    public static Person getRecord(int index) {
        return people.get(index);
    }
    public static ArrayList<Person> loadList() {
        try {
            System.out.println("-----------------\nAttempting to load records from file...");
            FileInputStream fin = new FileInputStream("Records.prec");
            ObjectInputStream objin = new ObjectInputStream(fin);
            ArrayList<Person> obj = (ArrayList<Person>) objin.readObject();
            objin.close();
            System.out.println("Records loaded from file.");
            return obj;
        } catch (FileNotFoundException e) {
            System.out.println("Default save file not found. Creating new one.");
            makeFile("Records.prec");
        } catch (IOException e) {
            System.out.println("Error reading records from file.");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error loading records from file.");
        }
        return loadList();
    }
    public static void makeFile(String n) {
        try {
            File f = new File(n);
            f.createNewFile();
            System.out.println("File created.");
        } catch (IOException e) {
            System.out.println("File error when creating new file.");
            e.printStackTrace();
        }
        saveLists();
     }
    public static void saveLists() {
        try {
            System.out.println("-----------------\nAttempting to save records to file...");
            FileOutputStream fout = new FileOutputStream("Records.prec");
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(people);
            objout.close();
            System.out.println("Save complete.");
        } catch (FileNotFoundException e) {
            System.out.println("Default save file not found. Creating new one.");
            makeFile("Records.prec");
            saveLists();
        } catch (IOException e) {
           System.out.println("Error loading file.");
           e.printStackTrace();
        }
        //IDs
        try {
            System.out.println("-----------------\nAttempting to save IDs to file...");
            FileOutputStream fout = new FileOutputStream("IDs.prec");
            ObjectOutputStream objout = new ObjectOutputStream(fout);
            objout.writeObject(ids);
            objout.close();
            System.out.println("Save complete.");
        } catch (FileNotFoundException e) {
            System.out.println("Default save file not found. Creating new one.");
            makeFile("IDs.prec");
            saveLists();
        } catch (IOException e) {
           System.out.println("Error loading file.");
           e.printStackTrace();
        }
    }

    private static ArrayList<UUID> loadIDs() {
        try {
            System.out.println("-----------------\nAttempting to load IDs from file...");
            FileInputStream fin = new FileInputStream("IDs.prec");
            ObjectInputStream objin = new ObjectInputStream(fin);
            ArrayList<UUID> obj = (ArrayList<UUID>) objin.readObject();
            objin.close();
            System.out.println("Records loaded from file.");
            return obj;
        } catch (FileNotFoundException e) {
            System.out.println("Default save file not found. Creating new one.");
            makeFile("IDs.prec");
        } catch (IOException e) {
            System.out.println("Error reading IDs from file.");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error loading IDs from file.");
        }
        return loadIDs();
    }
    
    public static void addPerson(String fname, String lname) {
        System.out.println("-----------------\nAttempting to add " + fname + " " + lname + " to lists...");
        Person p = new Person(fname, lname);
        people.add(p);
        p.setIndex(people.indexOf(p));
        ids.add(p.index, p.id);
        System.out.println(fname + " " + lname + " added to lists.");
        saveLists();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel AccessingRecord;
    private static javax.swing.JPanel InfoPanel;
    private static javax.swing.JPanel LookupPanel;
    private static javax.swing.JTextField LookupQuery;
    private static javax.swing.JTable LookupResults;
    private static javax.swing.JScrollPane LookupTable;
    private javax.swing.JLabel RecordFName;
    private static javax.swing.JLabel RecordIndicator;
    private javax.swing.JLabel RecordLName;
    private javax.swing.JLabel RecordName;
    private static javax.swing.JTabbedPane Tabs;
    private javax.swing.JTable infoTable;
    private javax.swing.JScrollPane infoTableScroll;
    // End of variables declaration//GEN-END:variables
}
