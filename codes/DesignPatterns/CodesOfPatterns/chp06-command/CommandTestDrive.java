import java.util.ArrayList;

class CommandTestDrive {

    public static void main (String[] args) {

        Light luz = new Light(5);
        ArrayList<Command> list = new ArrayList<Command>();
        
        list.add( new LightOnCommand(luz) );
        list.add( new LightOffCommand(luz) );
        list.add( new LightUpCommand(luz) );
        list.add( new LightDownCommand(luz) );
        
        RemoteControl r = new RemoteControl(list);
        
        r.doCommand(0);
        r.doCommand(1);
        r.doCommand(2);
        r.doCommand(3);
        r.doCommand(4);
        r.undoCommand();
    
    }

}