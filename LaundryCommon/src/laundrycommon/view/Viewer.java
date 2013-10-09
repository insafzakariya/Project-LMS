package laundrycommon.view;

import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import laundrycommon.model.Model;

/**
 * @author Prashan
 */
public abstract class Viewer extends javax.swing.JInternalFrame {
    private TableRowSorter<TableModel> tableSorter; //TableRowSorter for sorting and filtering the table
    protected DefaultTableModel browserDTM;         //TableModel of the table.
    private final String browserTitle;              //Title of the browser internal frame
    private ArrayList<Model> list = new ArrayList<>();

    /**
     * Creates new form CustomerBrowser
     */
    public Viewer(String title) {
        initComponents();
        //
        //Initialize browser table
        //
        browserDTM = (DefaultTableModel) new DefaultTableModel();           //Initialize field customerBrowserDTM
        viewerTable.setModel(browserDTM);
        tableSorter = new TableRowSorter<TableModel>(browserDTM);    //Create TableRowSorter using customerBrowserDTM as the underlying Model
        viewerTable.setRowSorter(tableSorter);
        
        //
        //Initialize other components.
        //
        setTitle(browserTitle = title + " Browser");         //Set the title
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        viewerTableScrollPane = new javax.swing.JScrollPane();
        viewerTable = new javax.swing.JTable();
        searchTextFieldPanel = new javax.swing.JPanel();
        searchCombo = new javax.swing.JComboBox();
        searchTextField = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setFrameIcon(null);

        viewerTable.setAutoCreateRowSorter(true);
        viewerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        viewerTable.setShowHorizontalLines(false);
        viewerTable.getTableHeader().setReorderingAllowed(false);
        viewerTableScrollPane.setViewportView(viewerTable);

        searchTextFieldPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        searchCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchComboKeyTyped(evt);
            }
        });
        searchTextFieldPanel.add(searchCombo);

        searchTextField.setColumns(40);
        searchTextField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchTextFieldCaretUpdate(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyTyped(evt);
            }
        });
        searchTextFieldPanel.add(searchTextField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchTextFieldPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewerTableScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(searchTextFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(viewerTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchTextFieldCaretUpdate
        try {
            tableSorter.setRowFilter(RowFilter.regexFilter("(?i)\\b" + searchTextField.getText(), searchCombo.getSelectedIndex()));
        } catch (java.util.regex.PatternSyntaxException sx) {
            return;
        }
    }//GEN-LAST:event_searchTextFieldCaretUpdate

    private void searchComboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchComboKeyTyped
        if (evt.getKeyChar() == 10) {
            searchTextField.requestFocus();
        }
    }//GEN-LAST:event_searchComboKeyTyped

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyTyped
        if (evt.getKeyChar() == 10 && viewerTable.getRowCount() > 0) {
            viewerTable.requestFocus();
            viewerTable.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_searchTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox searchCombo;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel searchTextFieldPanel;
    protected javax.swing.JTable viewerTable;
    private javax.swing.JScrollPane viewerTableScrollPane;
    // End of variables declaration//GEN-END:variables

    /**
     * Populates the table with data taken from DB Called by extending browser
     * classes to populate the browser table with data relevant to that browser
     * This method first refreshes the modelList(ArrayList) with data taken from
     * the DB and then calls populateTableFromList()
     */
    protected final void populateTableFromDB() {
        populateTableFromlList();
    }

    //
    // Populates the table with data taken from the list(ArrayList).
    //
    protected abstract void populateTableFromlList();
        
}
