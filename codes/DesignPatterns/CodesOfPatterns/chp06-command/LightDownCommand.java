class LightDownCommand implements Command {

    Light operatingLight;
    
    LightDownCommand(Light l) {
        operatingLight = l;
    }
    
    public void execute() {
        operatingLight.obscurecer(2);
        operatingLight.estado();
    }

    public void undo() {
        operatingLight.aclarar(2);
        operatingLight.estado();
    }
    
}