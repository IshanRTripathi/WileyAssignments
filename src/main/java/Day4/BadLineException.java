package Day4;

public class BadLineException extends Exception implements AutoCloseable{
    private String badLine;

    BadLineException(String message, String badLine){
        super(message);
        this.badLine= badLine;
    }

    public String getBadLine()
    {
        return badLine;
    }

    @Override
    public void close() throws Exception {

    }
}
