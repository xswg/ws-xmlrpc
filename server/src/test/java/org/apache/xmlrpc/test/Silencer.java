package org.apache.xmlrpc.test;

import org.apache.xmlrpc.server.XmlRpcErrorLogger;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcStreamServer;

class Silencer {
    private Silencer() {
    }

    static void silence(XmlRpcServer server) {
        try {
            ((XmlRpcStreamServer) server).setErrorLogger(new XmlRpcErrorLogger() {
                @Override
                public void log(String pMessage, Throwable pThrowable) {
                }

                @Override
                public void log(String pMessage) {
                }
            });
        } catch (ClassCastException e) {
            // DO NOTHING
        }
    }
}
