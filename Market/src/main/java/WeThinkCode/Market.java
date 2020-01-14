package WeThinkCode;

import WeThinkCode.businessLogic.BusLogic;
import WeThinkCode.configurations.Configuration;
import WeThinkCode.model.InstruMod;
import WeThinkCode.utilities.DispMarkData;
import WeThinkCode.utilities.InstruCreate;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static WeThinkCode.utilities.InstruCreate._instrumentList;

public class Market
{
    private SocketChannel socketChannel;
    private Selector selector;
    private static String _response;
    private BusLogic BusLogic;
    private static List<InstruMod> _instruList;

    public Market()
    {
        try
        {
            this.init();
        }
        catch (Exception exc)
        {
            System.out.println(this.getClass().getSimpleName() + " [Exception]: " + exc.getMessage());
        }
    }

    private void init() throws Exception
    {
        _instruList = InstruCreate.createInstrumentList();
        InetAddress inetAddress = InetAddress.getByName(Configuration.SERVER_ADDRESS);
        InetSocketAddress inetSocket = new InetSocketAddress(inetAddress, Configuration.SERVER_PORT);
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(inetSocket);
        socketChannel.register(selector, (SelectionKey.OP_CONNECT | SelectionKey.OP_READ));

        while (true)
        {
            if (selector.selectNow() > 0)
            {
                boolean Set = KeysProc(selector.selectedKeys());
                if (Set == true)
                    break ;
            }
        }

    }

    private boolean KeysProc(Set<SelectionKey> readySet) throws Exception
    {
        Iterator<SelectionKey> it = readySet.iterator();

        while (it.hasNext())
        {
            SelectionKey setKey = it.next();
            it.remove();

            if(setKey.isConnectable())
            {
                //This requires a connect process function found in the core module
                boolean conn = SocketTools.ProcConn(setKey);
                DispMarkData.Print(_instruList);
                if(conn == false)
                {
                    return (true);
                }
            }

            if(setKey.isReadable())
            {
                //This requires a connect process function found in the core module
                String message = SocketTools.ProcessRead(setKey);
                String address = socketChannel.getLocalAddress().toString();
                String[] fixedMessage = message.split("\\|");

                if (fixedMessage != null && fixedMessage.length > 0 && fixedMessage[0].equals(address.split(":")[1]))
                {
                    System.out.println("[Broker]: " + message);
                    BusLogic = new BusLogic(fixedMessage[1], fixedMessage[2], Integer.parseInt(fixedMessage[3]), Integer.parseInt(fixedMessage[4]), _instrumentList);
                    _response = BusLogic.LogicInitialization(message);
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                }
            }

            if (setKey.isWritable())
            {
                String response = _response;

                if (response != null && response.length() > 0)
                {
                    SocketChannel socketChannel = (SocketChannel) setKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.wrap(response.getBytes());
                    socketChannel.write(byteBuffer);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
            }
        }
        return (false);
    }
}
