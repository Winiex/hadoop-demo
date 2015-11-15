package com.bachiscoding.hadoop.demo.ipc;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * Created by winiex on 10/13/2015.
 */
public interface IPCProtocol extends VersionedProtocol {
    long versionID = 1L;

    Text appendAndEcho(Text input);
}
