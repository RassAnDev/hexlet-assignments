package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection implements Connection {
    private Connection connectionState;
    private List<String> buffer = new ArrayList<>();

    public TcpConnection(String ipAddress, int port) {
        this.connectionState = new Disconnected(this);
    }

    public TcpConnection() {

    }

    public void setConnectionState(Connection state) {
        this.connectionState = state;
    }

    public String getCurrentState() {
        return this.connectionState.getCurrentState();
    }

    public void connect() {
        this.connectionState.connect();
    }

    public void disconnect() {
        this.connectionState.disconnect();
        List<String> clonedBuffer = new ArrayList<>(buffer);
        buffer.removeAll(clonedBuffer);
    }

    public void write(String data) {
        this.connectionState.write(data);
        buffer.add(data);
    }

    public static Builder newBuilder() {
        return new TcpConnection().new Builder();
    }

    public class Builder {
        private Connection connectionState;
        private List<String> buffer = new ArrayList<>();

        private Builder() {

        }

        public Builder setConnectionState(Connection state) {
            this.connectionState = state;
            return this;
        }

        public Builder getCurrentState() {
            this.connectionState.getCurrentState();
            return this;
        }

        public Builder connect() {
            this.connectionState.connect();
            return this;
        }

        public Builder disconnect() {
            this.connectionState.disconnect();
            List<String> clonedBuffer = new ArrayList<>(buffer);
            buffer.removeAll(clonedBuffer);
            return this;
        }

        public Builder write(String data) {
            this.connectionState.write(data);
            buffer.add(data);
            return this;
        }

        public TcpConnection build() {
            TcpConnection.this.connectionState = this.connectionState;
            TcpConnection.this.buffer = this.buffer;
            return TcpConnection.this;
        }
    }
}
// END
