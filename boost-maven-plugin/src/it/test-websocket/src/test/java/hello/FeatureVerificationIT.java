/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package it;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

public class FeatureVerificationIT {
	
	private static final String WEBSOCKET_11_FEATURE = "<feature>websocket-1.1</feature>";
	private static String SERVER_XML = "target/liberty/wlp/usr/servers/BoostServer/server.xml";
    
    @Test
    public void testFeatureVersion() throws Exception {
    	File targetFile = new File(SERVER_XML);
    	assertTrue(targetFile.getCanonicalFile() + "does not exist.", targetFile.exists());
    	
    	// Check contents of file for websocket-1.1 feature
    	boolean found = false;
        BufferedReader br = null;
        try {
        	br = new BufferedReader(new FileReader(SERVER_XML));
        	String line;
        	while ((line = br.readLine()) != null) {
        	    if (line.contains(WEBSOCKET_11_FEATURE)) {
        	    	found = true;
        	    	break;
        	    }
        	}
    	} finally {
    		if (br != null) {
    			br.close();
    		}
    	}
    	
    	assertTrue("The " + WEBSOCKET_11_FEATURE + " feature was not found in the server configuration", found);    
    }
}