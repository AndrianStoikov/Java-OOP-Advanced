package P02_FileStream;

public class File extends Stream {

    private String name;
    private int length;
    private int bytesSent;

    public File(int length, int bytesSent) {
        super(length, bytesSent);
    }
}
