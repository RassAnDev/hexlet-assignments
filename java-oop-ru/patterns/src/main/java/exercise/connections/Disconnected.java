package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection connection;

    public Disconnected(TcpConnection connection) {
        this.connection = connection;
    }

    public String getCurrentState() {
        return "disconnected";
    }

    public void connect() {
        System.out.println("The connection has been set up.");
        this.connection.setConnectionState(new Connected(this.connection));
    }

    public void disconnect() {
        System.out.println("Error! The connection has already been disconnected");
    }

    public void write(String data) {
        System.out.println("Error! Status 'disconnected' don't allow to write data.");
    }
}
// END
