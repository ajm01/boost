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
package io.openliberty.boost.boosters;

import org.w3c.dom.Document;
import io.openliberty.boost.BoosterPackConfigurator;

public class MPRESTCLIENTBoosterPackConfigurator implements BoosterPackConfigurator {

	//default to the EE8 feature
	static String mpRestClient11 = "mpRestClient-1.1";
	
	String featureGAV = null;

    @Override
    public void writeConfigToServerXML(Document doc) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFeatureString(String featureStr){
    	// if it is the 1.0 version = EE7 feature level
    	if (featureStr.equals(BoosterPacksParent.MPRESTCLIENT_BOOSTER_PACK_STRING_20)) {
    		featureGAV = mpRestClient11;
    	} //else if (featureStr.equals(BoosterPacksParent.JAXRS_BOOSTER_PACK_STRING_20 )){
    		//featureGAV = jaxrs21;
    	//}
    }
    
    @Override
    public String getFeatureString() {
    	return featureGAV;
    }
}
