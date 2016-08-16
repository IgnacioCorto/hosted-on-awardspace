class ICTestDrive {
	public static void main(String [] args) {

		// CREANDO **SUB-MENU**
        
        myMenu subMenu = new myMenu("Menu Secundario");
        
        myItem [] subOpciones = {
            new myItem("Opcion A"),
            new myItem("Opcion B"),
            new myItem("Opcion C"),
        };
        
        subMenu.addList(subOpciones);    

		// CREANDO **MENU-PRINCIPAL**
        
        myMenu menuTest = new myMenu("Menu Principal");
        
        myComponent [] opciones = {
            new myItem("Archivo"),
            new myItem("Editar"),
            new myItem("Buscar"),
            subMenu,
        };
        
        menuTest.addList(opciones);
        
        myIterator it_old = menuTest.createIterator();

        myCompositeIterator it =
            new myCompositeIterator(it_old);
        
        while(it.hasNext()) {
            myComponent comp = (myComponent) it.next();
            System.out.println ( comp.getName() );
        }
        
	}
}
