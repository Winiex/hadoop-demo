package com.bachiscoding.hadoop.demo.ipc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by winiex on 10/13/2015.
 */
public class IPCClient {
    private IPCProtocol proxy;

    public IPCClient() throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 11001);

        Configuration conf = new Configuration();
        this.proxy = RPC.waitForProxy(IPCProtocol.class, 1, inetSocketAddress, conf);
    }

    public void sendMsg() {
        Text retMsg = this.proxy.appendAndEcho(new Text("Hello"));
        System.out.println(retMsg.toString());
    }

    public void close() {
        RPC.stopProxy(this.proxy);
    }

    public static void main(String[] args) throws IOException {
        IPCClient client = new IPCClient();

        client.sendMsg();
    }
}
