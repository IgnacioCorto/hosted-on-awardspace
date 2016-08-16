import java.util.ArrayList;

class RemoteControl {
    ArrayList<Command> cmds;
    Command undoCmd;
    int cmdTotal;
    
    RemoteControl(ArrayList<Command> cmdList) {
        cmds = cmdList;
        cmdTotal = cmds.size();
        System.out.println("Comandos:" + cmdTotal);
    }
    
    void doCommand(int id) {
         if (id > -1 && id < cmdTotal) {
            Command runCmd = cmds.get(id);
            runCmd.execute();
            undoCmd = runCmd;
         } else {
            System.out.println("Este comando no existe");
         }
    }

    void undoCommand() {
        undoCmd.undo();
    }

    
}