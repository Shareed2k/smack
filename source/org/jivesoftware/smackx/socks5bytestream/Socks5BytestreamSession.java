package org.jivesoftware.smackx.socks5bytestream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import org.jivesoftware.smackx.bytestreams.BytestreamSession;

/**
 * Socks5BytestreamSession class represents a SOCKS5 Bytestream session.
 * 
 * @author Henning Staib
 */
public class Socks5BytestreamSession implements BytestreamSession {

    /* the underlying socket of the SOCKS5 Bytestream */
    private final Socket socket;

    /* flag to indicate if this session is a direct or mediated connection */
    private final boolean isDirect;

    protected Socks5BytestreamSession(Socket socket, boolean isDirect) {
        this.socket = socket;
        this.isDirect = isDirect;
    }

    /**
     * Returns <code>true</code> if the session is established through a direct connection between
     * the initiator and target, <code>false</code> if the session is mediated over a SOCKS proxy.
     * 
     * @return <code>true</code> if session is a direct connection, <code>false</code> if session is
     *         mediated over a SOCKS5 proxy
     */
    public boolean isDirect() {
        return this.isDirect;
    }

    /**
     * Returns <code>true</code> if the session is mediated over a SOCKS proxy, <code>false</code>
     * if this session is established through a direct connection between the initiator and target.
     * 
     * @return <code>true</code> if session is mediated over a SOCKS5 proxy, <code>false</code> if
     *         session is a direct connection
     */
    public boolean isMediated() {
        return !this.isDirect;
    }

    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    public int getReadTimeout() throws IOException {
        try {
            return this.socket.getSoTimeout();
        }
        catch (SocketException e) {
            throw new IOException("Error on underlying Socket");
        }
    }

    public void setReadTimeout(int timeout) throws IOException {
        try {
            this.socket.setSoTimeout(timeout);
        }
        catch (SocketException e) {
            throw new IOException("Error on underlying Socket");
        }
    }

    public void close() throws IOException {
        this.socket.close();
    }

}
