/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package org.apache.xmlrpc.test;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcLocalStreamTransportFactory;
import org.apache.xmlrpc.client.XmlRpcTransportFactory;
import org.apache.xmlrpc.server.XmlRpcHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcLocalStreamServer;
import org.apache.xmlrpc.server.XmlRpcServer;


/** Implementation of {@link org.apache.xmlrpc.test.BaseTest}
 * for testing the {@link org.apache.xmlrpc.client.XmlRpcLocalStreamTransport}.
 */
public class LocalStreamTransportProvider extends LocalTransportProvider {
    private final XmlRpcLocalStreamServer server;

    /** Creates a new instance.
	 * @param pMapping The test servers handler mapping.
	 */
	public LocalStreamTransportProvider(XmlRpcHandlerMapping pMapping) {
		super(pMapping);
		server = new XmlRpcLocalStreamServer();
		Silencer.silence(server);
	}

	protected XmlRpcTransportFactory getTransportFactory(XmlRpcClient pClient) {
        XmlRpcLocalStreamTransportFactory factory
			= new XmlRpcLocalStreamTransportFactory(pClient, server);
		return factory;
	}

    public XmlRpcServer getServer() {
        return server;
    }
}
