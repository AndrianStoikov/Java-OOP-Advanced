package P02_FileStream;

public abstract class Stream implements Streamable{
    private int length;
    private int bytesSent;

    protected Stream(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    public int getLength() {
        return length;
    }

    public int getBytesSent() {
        return bytesSent;
    }
}
