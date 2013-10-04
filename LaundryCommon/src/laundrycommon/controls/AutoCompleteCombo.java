package laundrycommon.controls;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Ranjith Suranga
 */

public class AutoCompleteCombo extends JComboBox {   

    private ArrayList ArrayList;
    private boolean InClass;
    private boolean ShiftDown;
    
    private boolean isShiftDown() {
        return ShiftDown;
    }

    private void setShiftDown(boolean ShiftDown) {
        this.ShiftDown = ShiftDown;
    }

    private boolean isInClass() {
        return InClass;
    }

    private void setInClass(boolean InClass) {
        this.InClass = InClass;
    }

    public AutoCompleteCombo() {
        this.ArrayList = new ArrayList();
        
        // Let's get the text field of the combo box
        final JTextField txt = (JTextField) this.getEditor().getEditorComponent();
        
        setInClass(true);
        this.removeAllItems();
        setInClass(false);
        
        // When focus gains let's select all the text
        txt.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                txt.setSelectionStart(0);
                txt.setSelectionEnd(txt.getText().length());
            }
            
        });
        
        // Let's handle key listener ourself
        txt.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) return;
                
                if (txt.getText().length() > 0 && e.isShiftDown()){
                    if (e.getKeyCode() == KeyEvent.VK_HOME || e.getKeyCode()== KeyEvent.VK_END || 
                            e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
                        setShiftDown(true);
                        return;
                        
                    }
                }else{
                    if (txt.getText().length() > 0){
                        if (isShiftDown()){
                            setShiftDown(false);
                            return;
                        }
                    }
                }
                
                if (e.getKeyCode() == KeyEvent.VK_SHIFT)return;
                
//                if ((e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) && (!txt.getText().trim().equalsIgnoreCase(""))){
//                    return;
//                }
                
                // Let's get the combo box for easy usage
                JComboBox jcb = AutoCompleteCombo.this;
                // Let's get some usefull informations
                String sBefore =txt.getText();
                
                int lCaretPos =  txt.getCaretPosition();
                
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    if (jcb.getItemCount() > 0 && jcb.getSelectedIndex() == -1){
                        jcb.setSelectedIndex(0);
                        jcb.hidePopup();
                    }
                    txt.setSelectionStart(0);
                    txt.setSelectionEnd(txt.getText().length());                    
                    return;
                }                  
                
                // Check whether there are more than one letter in the combo box and there are
                // items in the array list                
                if (txt.getText().length()> 0 && getArrayList().size() > 0){
                    // If so, let 's check whether user has input empty spaces only
                    if (txt.getText().trim().equalsIgnoreCase("")){                        
                        // If so, check for popup visiblity
                        if (!jcb.isPopupVisible()){
                            // No popup is visible, then let's add items to the popup menu
                            // and then let's show it
                            // First remove all current items
                            setInClass(true);
                            jcb.removeAllItems();
                            for (int i = 0; i < getArrayList().size(); i++) {
                                jcb.addItem(getArrayList().get(i));
                            }
                            setInClass(false);
                            jcb.showPopup();
                        }
                        jcb.setSelectedIndex(-1);
                        txt.setText(sBefore);
                        txt.setCaretPosition(lCaretPos);
                    }else{
                        // Big part handling here...
                        // Check whether user input text is in list ?
                        jcb.hidePopup();  
                        String s= txt.getText().substring(0, lCaretPos); // For easy usage
                        setInClass(true);
                        jcb.removeAllItems();                                                
                        for (int i = 0; i < getArrayList().size(); i++) {
                            // Get the item
                            String item = getArrayList().get(i).toString();
                            // Check whether item length is higer than user input text length
                            // Eg : user input :- good
                            // item is : - go
                            // Then no need to add check for that item
                            if (item.length() >= s.length() ){
                                item = item.substring(0, s.length());
                                if (item.equalsIgnoreCase(s)){
                                    jcb.addItem(getArrayList().get(i));
                                }
                            }
                        }
                        setInClass(false);
                        // Show the popup only if there is an item
                        if (jcb.getItemCount() > 0){
                            jcb.showPopup();
                            //jcb.setSelectedIndex(jc);
                            txt.setText((String) jcb.getSelectedItem());
                            //txt
                            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE){
                                txt.setText(s);
                            }
                            txt.setCaretPosition(txt.getText().length());
                            txt.moveCaretPosition(lCaretPos);
                            
                        }else{
                            //if (jcb.getItemCount()> 0) jcb.showPopup();
                            
                            jcb.setSelectedIndex(-1);
                            txt.setText(sBefore);
                            txt.setCaretPosition(lCaretPos); 
                        }                       
                       
                    }
                }else{
                    // No need to show a popup
                    jcb.hidePopup();
                }
                // When escape is pressed, hide the popup plz...
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    if (jcb.isPopupVisible())
                        jcb.hidePopup();
                }
                               
                
                
            }
            
        });
        
    }

    public ArrayList getArrayList() {
        return ArrayList;
    }

    public void setArrayList(ArrayList ArrayList) {
        this.ArrayList = ArrayList;
    }
 
    @Override
    public void addItem(Object item) {
        // Check whether the combo box is editable one or not...
        if (!this.isEditable){
            // If it is not editable, let it handle to super
            super.addItem(item); 
        }else{
            // If it is editable one.. the let's handle it
            if (!this.isInClass()){
                // Let's add it into array list.
                this.ArrayList.add(item);
            }else{
                super.addItem(item);
            }
        }
    }

    @Override
    public void removeItemAt(int anIndex) {
        if (isInClass()){
            super.removeItemAt(anIndex);
        }else{
            getArrayList().remove(anIndex);
        }
        if (this.isPopupVisible()){
            this.hidePopup();
            this.showPopup();
        }else{
            this.hidePopup();
        }        
    }

    @Override
    public void removeAllItems() {
        if (isInClass()){
            super.removeAllItems();
        }else{
            getArrayList().clear();
            super.removeAllItems();
        }
        if (this.isPopupVisible()){
            this.hidePopup();
            this.showPopup();
        }else{
            this.hidePopup();
        }
    }   
    
}
