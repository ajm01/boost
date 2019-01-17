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

package io.openliberty.boost.common.config;

import java.util.ArrayList;
import java.util.List;

public final class BoostProperties {

    public static final String DATASOURCE_DATABASE_NAME = "boost.datasource.databaseName";
    public static final String DATASOURCE_SERVER_NAME = "boost.datasource.serverName";
    public static final String DATASOURCE_PORT_NUMBER = "boost.datasource.portNumber";
    public static final String DATASOURCE_USER = "boost.datasource.user";
    public static final String DATASOURCE_PASSWORD = "boost.datasource.password";
    
    /**
     * Return a list of all boost properties
     * @return
     */
    public static List<String> getAllSupportedProperties() {
    	
    	List<String> supportedProperties = new ArrayList<String>();
    	
    	supportedProperties.add(DATASOURCE_DATABASE_NAME);
    	supportedProperties.add(DATASOURCE_SERVER_NAME);
    	supportedProperties.add(DATASOURCE_PORT_NUMBER);
    	supportedProperties.add(DATASOURCE_USER);
    	supportedProperties.add(DATASOURCE_PASSWORD);
    	
    	return supportedProperties;
    }
    
    /**
     * Return a list of all properties that need to be encrypted
     * @return
     */
    public static List<String> getPropertiesToEncrypt() {
    	
        List<String> propertiesToEncrypt = new ArrayList<String>();
    	
    	propertiesToEncrypt.add(DATASOURCE_PASSWORD);
    	
    	return propertiesToEncrypt;
    }
    
}
