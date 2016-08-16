import javax.swing.*;
import javax.swing.event.*;
//import java.awt.*;
import java.awt.event.*;

class MyJTextField extends JPanel {

    JTextArea area1 ;
    JCheckBox chk1;
    JList lst1;

    public static void main (String [] args) {
        MyJTextField obj = new MyJTextField();
        obj.executeProgram();
    }

    void mySleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (Exception ex) {}
    }
    
    void executeProgram () {
        JFrame frm = new JFrame("Hola");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(400,300);
        
        JPanel pnl1 = new JPanel();
        frm.getContentPane().add(pnl1);
       
        JTextField txt1 = new JTextField("iwbrmap-a");
        JTextField txt2 = new JTextField("iwbrmap-b");

        pnl1.add(txt1);
        pnl1.add(txt2);
        
        area1 = new JTextArea(10,20);
        
        JScrollPane scrl1 = new JScrollPane(area1);
        area1.setLineWrap(true);
        scrl1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrl1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnl1.add(scrl1);

        
        chk1 = new JCheckBox("Append \"IWBRMAP\"");
        pnl1.add(chk1);
        chk1.addItemListener(new ChkListen());

        String [] keywords = {"I ","will ","be ","rich, ","millionaire, ","and ","powerfull" };
        lst1 = new JList(keywords);
        lst1.setVisibleRowCount(3);
        lst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lst1.addListSelectionListener(new ListListen());
        pnl1.add(lst1 );

        JScrollPane scrl2 = new JScrollPane(lst1);
        scrl2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrl2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnl1.add(scrl2);
        
        frm.setVisible(true); // Here, I put the frame visible
        
        txt1.setText(""+txt2.getText()+" #2");
        txt1.selectAll();
        mySleep(1000);
        txt2.requestFocus();
        
        
        area1.setText("Starting...");
        area1.append(" ...Ending");
        area1.selectAll();
    }
    
    class ChkListen implements ItemListener {
        public void itemStateChanged(ItemEvent ev) {
            if( chk1.isSelected() ) {
                area1.append("\"I will be Rich, Millionaire, and Powerful!!\"");
                chk1.setSelected(false);
            }
        }
    }
    
    class ListListen implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent ev) {
            if( !lst1.getValueIsAdjusting() ) {
                area1.append( (String) lst1.getSelectedValue() );
            }
        }
    }

   

}