class LightOffCommand implements Command {
    Light operatingLight;
    
    LightOffCommand(Light l) {
        operatingLight = l;
    }
    
    public void execute() {
        operatingLight.apagar();
        operatingLight.estado();
    }

    public void undo() {
        operatingLight.encender();
        operatingLight.estado();
    }
    
}