import java.util.Calendar;

class MyCalendar {
    public static void main(String [] args) {
        Calendar calendario = Calendar.getInstance();
        System.out.println("Funciono el Calendario! \n");
        
        calendario.set(1982,7,30,23,59,59);
        System.out.println( ".set(1982,7,30,23,59,59) + .getTime() : "+calendario.getTime() );

        calendario.add(calendario.DATE, -1);
        System.out.println( ".add(calendario.DATE, -1) : "+calendario.getTime() );

        System.out.println( ".getTimeInMillis() : "+calendario.getTimeInMillis() );
        System.out.println( ".get(calendario.MONTH) \"-1\" : "+calendario.get(calendario.MONTH) );
        System.out.println( ".get(1) \"Year\" : "+calendario.get(1) );

        calendario.roll(calendario.MONTH, 6);
        System.out.println( ".roll(calendario.MONTH, 6) \"at 7\" : "+calendario.getTime() );
        
    }
}