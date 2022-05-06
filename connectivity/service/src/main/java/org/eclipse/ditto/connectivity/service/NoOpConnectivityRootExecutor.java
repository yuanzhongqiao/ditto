/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.ditto.connectivity.service;

import akka.actor.ActorContext;
import akka.actor.ActorSystem;

/**
 * Connectivity root executor that does purposefully nothing.
 */
public class NoOpConnectivityRootExecutor extends CustomConnectivityRootExecutor{

    /**
     * @param actorSystem the actor system in which to load the extension.
     */
    protected NoOpConnectivityRootExecutor(final ActorSystem actorSystem) {
        super(actorSystem);
    }

    @Override
    public void execute(final ActorContext actorContext) {
        // Do nothing.
    }
}
