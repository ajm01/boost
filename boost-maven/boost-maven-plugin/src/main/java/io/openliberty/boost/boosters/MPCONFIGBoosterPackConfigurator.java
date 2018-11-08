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

public class MPCONFIGBoosterPackConfigurator implements BoosterPackConfigurator {

	
	static String mpConfig13 = "mpConfig-1.3";
	
	String featureGAV = null;

    @Override
    public void writeConfigToServerXML(Document doc) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFeatureString(String featureStr){
    	if (featureStr.equals(BoosterPacksParent.MPCONFIG_BOOSTER_PACK_STRING_20 )) {
    		featureGAV = mpConfig13;
    	} //else if (featureStr.equals(BoosterPacksParent.JAXRS_BOOSTER_PACK_STRING_20 )){
    		//featureGAV = jaxrs21;
    	//}
    }
    
    @Override
    public String getFeatureString() {
    	return featureGAV;
    }
}
