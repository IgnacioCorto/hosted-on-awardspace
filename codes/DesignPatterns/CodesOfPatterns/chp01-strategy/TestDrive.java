import java.io.*;

class TestDrive {
    public static void main(String [] args) {
        Interface c1 = new Client01();
        Interface c2 = new Client02();
        Interface m = new Mierda();
        Ancestor anc = new Ancestor();
        
        anc.setIt(c1);
        anc.performIt();
        anc.setIt(c2);
        anc.performIt();
        anc.setIt(m);
        anc.performIt();
        
        "1/1/1".split("/");
        
        try {
            new BufferedReader(
                    new InputStreamReader(
                        System.in
                    )
            ).readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}