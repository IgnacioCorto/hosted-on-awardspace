import java.io.*;

class FISDTestDrive {
    public static void main ( String [] args ) {
    int c;
    try {
        InputStream in = 
            new FilterInputStreamDecorator (
                new BufferedInputStream (
                    new FileInputStream(
                        "test.txt"
                    )
                )
            );

        while ( (c=in.read()) >= 0)  {
            System.out.print ((char) c);
        }
    }
    catch (IOException ex) { ex.printStackTrace(); }
    }
}

class FilterInputStreamDecorator extends FilterInputStream {
    
    public FilterInputStreamDecorator(InputStream in) {
        super(in);
    }
    
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    public int read(byte[] b, int offset, int len) 
            throws IOException {
        int result = super.read(b, offset, len);
        for (int i = 0; i < offset+result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
    
}