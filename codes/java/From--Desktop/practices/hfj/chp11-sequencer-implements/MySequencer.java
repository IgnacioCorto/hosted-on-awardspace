import javax.sound.midi.*;

class MySequencer /* throws MidiUnavailableException  */ {

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println
                    ("I have gotten my first Sequencer!!");
            throw new Exception("Remember this --> "
                    + "Ancestors Exceptions goes "
                    + "after Descendants Exceptions "
                    + "in the try/catch/finally block!!");
        } catch (MidiUnavailableException ex) {
            System.out.println("Boom Boom!!");
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        } finally {
            System.out.println ("In the 'finally' block...");
        } 
    }

    public static void main(String [] args) {
        MySequencer mt = new MySequencer();
        mt.play();
        System.out.println (
                "PS: remembar the \"Handle|Declare\" Law");
    }
}