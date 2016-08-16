class StateTestDrive {

    EstadoMaquina sinToken;       // SIN TOKEN
    EstadoMaquina conToken;       // CON TOKEN
    EstadoMaquina sinMentas;      // SIN MENTAS
    EstadoMaquina mentaVendida;   // MENTA VENDIDA
        
    EstadoMaquina miEstado = sinToken;
    int inventarioMenta = 1;

	StateTestDrive () {

        sinToken      = new SinToken(this);      // SIN TOKEN
        sinMentas     = new SinMentas(this);     // SIN MENTAS
        conToken      = new ConToken(this);      // CON TOKEN
        mentaVendida  = new MentaVendida(this);  // MENTA VENDIDA
    
        if ( inventarioMenta > 0 ) {
            miEstado = sinToken;
        } else {
            miEstado = sinMentas;
        }
        
    }
    
    public static void main(String [] args) {

        StateTestDrive maquina = new StateTestDrive();
        
        maquina.miEstado.expulsarToken();
        maquina.miEstado.insertarToken();
        maquina.miEstado.insertarToken();
        maquina.miEstado.expulsarToken();
        
        maquina.miEstado.insertarToken();
        maquina.miEstado.sacarMenta();
        maquina.miEstado.girarPalanca();
        maquina.miEstado.girarPalanca();
        maquina.miEstado.sacarMenta();
        maquina.miEstado.sacarMenta();
        

	}
}
