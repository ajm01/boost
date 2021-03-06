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
package io.openliberty.boost.common.boosters;

import io.openliberty.boost.common.BoostException;
import io.openliberty.boost.common.BoostLoggerI;
import io.openliberty.boost.common.boosters.AbstractBoosterConfig.BoosterCoordinates;
import io.openliberty.boost.common.runtimes.RuntimeI;
import io.openliberty.boost.common.config.ServerConfigGenerator;

import static io.openliberty.boost.common.config.ConfigConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@BoosterCoordinates(AbstractBoosterConfig.BOOSTERS_GROUP_ID + ":jpa")
public class JPABoosterConfig extends AbstractBoosterConfig {

    String libertyFeature = null;

    public JPABoosterConfig(Map<String, String> dependencies, BoostLoggerI logger) throws BoostException {
        String version = dependencies.get(getCoordinates(this.getClass()));
        if (version.equals(EE_7_VERSION)) {
            libertyFeature = JPA_21;
        } else if (version.equals(EE_8_VERSION)) {
            libertyFeature = JPA_22;
        }
    }

    @Override
    public String getLibertyFeature() {
        return libertyFeature;
    }

    @Override
    public void addServerConfig(ServerConfigGenerator config) {
        // No config to write
    }

    @Override
    public List<String> getDependencies(RuntimeI runtime) {
        return new ArrayList<String>();
    }
}
