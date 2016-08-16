import java.io.*;

class FileObjectInline implements Serializable {
    
    String objectProperty;

    public static void main (String [] args) {
        new FileObjectInline().go();
    }

    /* PARA PROBAR LA IMPRESION DEL UN OBJETO SERIALIZADO */
    void imprimir() {
        objectProperty = "En el metodo";
        System.out.print("Este es un mensaje desde un "
            + "metodo del archivo. \n"
            + "Ah, y la propiedad actual es: "
            + objectProperty + "\n\n"
        );
    }
    
    void go() {
        try {
            System.out.print("Escribe algo:");

  /* *************** GRABACION DE TEXTO ******************* */
            
            /* ENTRADA DE TEXTO */
            String entrada = 
                new BufferedReader(
                    new InputStreamReader(
                        System.in 
                    )
                ).readLine();


            /* CREACION DEL MANEJADOR DE ARCHIVO DE ESCRITURA */
            BufferedWriter bw =
                new BufferedWriter(
                    new FileWriter(
                        "Texto.txt"
                    )
                );
            
            /* GRABACION DE ARCHIVO */
            bw.write(entrada);
            bw.close();
            

            /* CREACION DEL MANEJADOR DE ARCHIVO DE LECTURA */
            BufferedReader br =
                new BufferedReader(
                    new FileReader(
                        "Texto.txt"
                    )
                );
            
            /* LECTURA DEL ARCHIVO */
            String fuente =  br.readLine();
            br.close();

            /* IMPRESION DE LO LEIDO */
            System.out.println("Lo que se grabo fue: "
                + fuente );

  /* *************** GRABACION DE OBJETO ******************* */
                
            /* CREACION DE OBJETO */
            FileObjectInline thisClass =
                new FileObjectInline();
            thisClass.objectProperty = "IGNACIO Y ELIZABETH";

            /* CREACION DEL MANEJADOR DE OBJETO DE ESCRITURA */
            ObjectOutputStream oos =
                new ObjectOutputStream(
                    new FileOutputStream(
                        "Objeto.ser"
                    )
                );
            
            /* GRABACION DE LA PROPIEDAD */
            oos.writeObject(thisClass);
            oos.close();
            
            
            /* CREACION DEL MANEJADOR DE OBJETO DE LECTURA */
            ObjectInputStream ois =
                new ObjectInputStream(
                    new FileInputStream(
                        "Objeto.ser"
                    )
                );
            
            /* LECTURA DE LA PROPIEDAD */
            FileObjectInline myObj = 
                    (FileObjectInline) ois.readObject();
            ois.close();

            /* IMPRESION DE LA PROPIEDAD LEIDA */
            System.out.println("La propiedad del objeto es: "
                + myObj.objectProperty );

            /* USANDO EL METODO DE LA CLASE */
            myObj.imprimir();
                
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
           
            try {
            /* ESTA ES LA DESPEDIDA DEL PROGRAMA */
            System.out.print("\nPresiona <ENTER> para salir");
            String despedida = 
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
    
}