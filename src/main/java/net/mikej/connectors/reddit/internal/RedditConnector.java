package net.mikej.connectors.reddit.internal;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.Sources;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

import net.mikej.connectors.reddit.internal.connection.RedditConnectionProvider;
import net.mikej.connectors.reddit.internal.operations.RedditOperations;
import net.mikej.connectors.reddit.internal.source.CommentSource;
import net.mikej.connectors.reddit.internal.source.PostSource;

@Xml(prefix = "reddit")
@Extension(name = "Reddit")
@ConnectionProviders({ RedditConnectionProvider.class })
@Sources({ CommentSource.class, PostSource.class })
@Operations({ RedditOperations.class })
public class RedditConnector {
}