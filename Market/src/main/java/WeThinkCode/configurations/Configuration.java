package WeThinkCode.configurations;

public class Configuration
{
    public static String SERVER_ADDRESS;
    public static Integer SERVER_PORT;

    public Configuration()
    {
        this.init();
    }

    private void init()
    {
        SERVER_ADDRESS = "127.0.0.1";
        SERVER_PORT = 5001;
    }
}
