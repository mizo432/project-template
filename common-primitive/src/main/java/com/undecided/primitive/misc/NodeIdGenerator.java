package com.undecided.primitive.misc;

import java.net.InetAddress;

public class NodeIdGenerator {

    private static int nodeId;

    static {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            nodeId = hostName.hashCode();
        } catch (Exception e) {
            nodeId = (int) (Math.random() * (Math.pow(2, 10) - 1));
        }
    }

    public static long generateNodeId() {
        return nodeId;
    }
}
