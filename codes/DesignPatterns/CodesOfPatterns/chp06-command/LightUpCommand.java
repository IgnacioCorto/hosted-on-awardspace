class LightUpCommand implements Command {

    Light operatingLight;
    
    LightUpCommand(Light l) {
        operatingLight = l;
    }
    
    public void execute() {
        operatingLight.aclarar(2);
        operatingLight.estado();
    }

    public void undo() {
        operatingLight.obscurecer(2);
        operatingLight.estado();
    }
    
}