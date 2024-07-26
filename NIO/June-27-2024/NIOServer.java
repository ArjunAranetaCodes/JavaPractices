import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public void start() throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));
        SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        
        System.out.println("NIOServer started...");

        while (true) {
            int numSelectedKeys = selector.selectNow();
            if (numSelectedKeys > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    
                    if (!key.isValid()) continue;
                    
                    if (key.isAcceptable()) {
                        SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                        clientChannel.configureBlocking(false);
                        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                        clientChannel.register(selector, SelectionKey.OP_READ, buffer);
                    } else if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        channel.read(buffer);
                        System.out.println("Received message: " + new String(buffer.array()));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NIOServer nioServer = new NIOServer();
        nioServer.start();
    }
}