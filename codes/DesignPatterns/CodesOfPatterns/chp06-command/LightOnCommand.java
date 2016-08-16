class LightOnCommand implements Command {

    Light operatingLight;
    
    LightOnCommand(Light l) {
        operatingLight = l;
    }
    
    public void execute() {
        operatingLight.encender();
        operatingLight.estado();
    }

    public void undo() {
        operatingLight.apagar();
        operatingLight.estado();
    }
    
}