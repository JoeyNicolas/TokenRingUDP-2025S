//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.io.IOException;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class TokenRingTest {
//
//    @Test
//    public void testNodeFailureHandling() throws IOException {
//        // Mock DatagramSocket
//        DatagramSocket mockSocket = Mockito.mock(DatagramSocket.class);
//
//        // Mock Token
//        Token mockToken = Mockito.mock(Token.class);
//        when(mockToken.length()).thenReturn(2); // Simulate 2 nodes in the ring
//        when(mockToken.poll()).thenReturn(new Token.Endpoint("127.0.0.1", 10001));
//        when(mockToken.send(any(), anyString(), anyInt(), anyInt())).thenReturn(false); // Simulate failure
//
//        // Simulate removing a failed node
//        doAnswer(invocation -> {
//            String ip = invocation.getArgument(0);
//            int port = invocation.getArgument(1);
//            assertEquals("127.0.0.1", ip);
//            assertEquals(10001, port);
//            return null;
//        }).when(mockToken).removeNode(anyString(), anyInt());
//
//        // Call the loop method (or refactor it to testable units)
//        TokenRing.loop(mockSocket, "127.0.0.1", 10000, true);
//
//        // Verify that the failed node was removed
//        verify(mockToken, times(1)).removeNode("127.0.0.1", 10001);
//    }
//}