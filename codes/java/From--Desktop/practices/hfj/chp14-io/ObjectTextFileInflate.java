import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

class ObjectTextFileInflate {

    public static void main (String [] args) {
        ObjectTextFileInflate obj = new ObjectTextFileInflate();
        obj.executeProgram();
    }

    void mySleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (Exception ex) {}
    }
    
    /* The program starts here : */
    
    void executeProgram () {
        JFrame frm1 = new JFrame("Practica de Archivos");
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm1.setSize(400,300);
        
        JPanel pnl1 = new JPanel();
        frm1.getContentPane().add(pnl1);

        JTextArea area1 = new JTextArea(10,20);
        area1.setLineWrap(true);
        pnl1.add(area1);

        JScrollPane scrl1 = new JScrollPane(area1);
        scrl1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrl1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnl1.add(scrl1);
        
        frm1.setVisible(true); // Here, I put the frame visible

        try {
            //ObjectoEjemplo obj2 = new ObjectoEjemplo();

            FileInputStream fs = new FileInputStream("foo-object.txt");
            ObjectInputStream os = new ObjectInputStream(fs);
            ObjectoEjemplo obj2 = (ObjectoEjemplo) os.readObject();
            os.close();
            area1.append("The data of \"obj2\" are : \n"
                    + obj2.un_dato + " and " + obj2.otro_dato
                    );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

class ObjectoEjemplo implements Serializable {
    int un_dato = 1;
    int otro_dato = 2;
    transient int dato_invisible = 2;
}
