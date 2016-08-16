import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

class JavaIOFile {

    public static void main (String [] args) {
        JavaIOFile obj = new JavaIOFile();
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
            File f = new File("./");
            File test = new File("IWBRMAP");
            test.mkdir();
            area1.append(f.getAbsolutePath());

            if( f.isDirectory() ){
                String [] dirContents = f.list();
                for (int i = 0; i < dirContents.length; i++) {
                    area1.append(dirContents[i]+"\n");
                }
            }
            
            boolean iwbrmapDeleted = test.delete();
            if (iwbrmapDeleted) {
                area1.append("Directory IWBRMAP has been deleted with success!! \n");
            }

        
        } catch (Exception ex) {
            area1.append( ex.toString() );
            ex.printStackTrace();
        }
    }
    
}
