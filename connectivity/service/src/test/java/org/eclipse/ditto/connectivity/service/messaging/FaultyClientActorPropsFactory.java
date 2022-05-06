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
package org.eclipse.ditto.connectivity.service.messaging;

import org.eclipse.ditto.base.model.headers.DittoHeaders;
import org.eclipse.ditto.connectivity.model.Connection;

import com.typesafe.config.Config;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public final class FaultyClientActorPropsFactory extends ClientActorPropsFactory {

    private final boolean allowFirstCreateCommand;
    private final boolean allowCloseCommands;

    /**
     * @param actorSystem the actor system in which to load the extension.
     */
    protected FaultyClientActorPropsFactory(final ActorSystem actorSystem) {
        super(actorSystem);
        allowFirstCreateCommand = actorSystem.settings().config().getBoolean("allowFirstCreateCommand");
        allowCloseCommands = actorSystem.settings().config().getBoolean("allowCloseCommands");
    }

    @Override
    public Props getActorPropsForType(final Connection connection, final ActorRef proxyActor,
            final ActorRef connectionActor,
            final ActorSystem actorSystem, final DittoHeaders dittoHeaders,
            final Config connectivityConfigOverwrites) {

        return FaultyClientActor.props(allowFirstCreateCommand, allowCloseCommands);
    }
}
