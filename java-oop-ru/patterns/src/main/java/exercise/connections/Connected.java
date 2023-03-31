package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    TcpConnection connection;

    public Connected(TcpConnection connection) {
        this.connection = connection;
    }

    public String getCurrentState() {
        return "connected";
    }

    public void connect() {
        System.out.println("Error! The connection has already set.");
    }

    public void disconnect() {
        this.connection.setConnectionState(new Disconnected(this.connection));
        System.out.println("Disconnection has been done.");
    }

    public void write(String data) {
        System.out.println("Status 'connected' allows to write data.");
    }
}
// END
