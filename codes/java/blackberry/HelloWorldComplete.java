import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

class HelloWorld extends net.rim.device.api.ui.UiApplication 
{
    public static void main(String[] args)
    {
        HelloWorld instance = new HelloWorld();
        instance.enterEventDispatcher();
    }  
    public HelloWorld() 
    {
        pushScreen(new SalutationScreen());
    }
}

/**
  * You can put next code in another file.
  * Don't forget those 'import' lines
  */

class SalutationScreen extends MainScreen
{
    public SalutationScreen()
    {
        super();
        LabelField applicationTitle = 
            new LabelField("Hello World Title");
        setTitle(applicationTitle);
        RichTextField helloWorldTextField = new RichTextField("Hello World!");
        add(helloWorldTextField);
    }
    public boolean onClose()
    {
        Dialog.alert("Bye World!");    
        System.exit(0);
           return true;
    }
}

