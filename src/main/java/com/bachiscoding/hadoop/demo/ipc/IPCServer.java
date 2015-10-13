package com.bachiscoding.hadoop.demo.ipc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

import java.io.IOException;

/**
 * Created by winiex on 10/13/2015.
 */
public class IPCServer implements IPCProtocol {

    private Server server;

    public IPCServer() throws IOException, InterruptedException {
        Configuration conf = new Configuration();
        RPC.Builder builder = new RPC.Builder(conf);
        this.server = builder.setInstance(this).setProtocol(IPCProtocol.class)
                .setBindAddress("127.0.0.1").setPort(11001).build();

        this.server.start();
        this.server.join();
    }

    @Override
    public Text appendAndEcho(Text input) {
        String inputString = input.toString();
        String resultString = inputString + " Append";
        return new Text(resultString);
    }

    @Override
    public long getProtocolVersion(String s, long l) throws IOException {
        return IPCProtocol.versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return new ProtocolSignature(IPCProtocol.versionID, null);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new IPCServer();
    }
}
