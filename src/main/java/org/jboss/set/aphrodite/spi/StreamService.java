package org.jboss.set.aphrodite.spi;

import java.util.List;

import org.jboss.set.aphrodite.Aphrodite;
import org.jboss.set.aphrodite.config.AphroditeConfig;
import org.jboss.set.aphrodite.domain.Codebase;
import org.jboss.set.aphrodite.domain.Repository;
import org.jboss.set.aphrodite.domain.Stream;
import org.jboss.set.aphrodite.domain.StreamComponent;

public interface StreamService {

    /**
     * Initialize the stream service.
     *
     * @throws NotFoundException
     */
    boolean init(Aphrodite aphrodite, AphroditeConfig config) throws NotFoundException;

    /**
     * Returns all streams discovered by this service.
     *
     * @return a list of all streams discovered by this <code>StreamService</code>, or an empty list if no streams exist.
     */
    List<Stream> getStreams();

    /**
     * Get a specific <code>Stream</code> object based upon its String name.
     *
     * @param streamName the name of the <code>Stream</code> to be returned.
     * @return Stream the <code>Stream</code> object which corresponds to the specified streamName
     *                if it exists, otherwise null.
     */
    Stream getStream(String streamName);

    /**
     * Retrieve all Repositories across all Streams.  Note, that only Repository objects with distinct URLs are returned.
     * This method should never return the same repository twice.
     *
     * @return a list of unique Repositories.
     */
    List<Repository> getDistinctURLRepositories();

    /**
     * Retrieve the URLs of all Repositories associated with a given Stream. Note, that only Repository objects with
     * distinct URLs are returned. This method should never return the same repository twice.
     *
     * @param streamName the name of the <code>Stream</code> containing the returned repositories.
     * @return a list of unique Repositories.
     */
    List<Repository> getDistinctURLRepositoriesByStream(String streamName);

    /**
     * Find all the streams associated to the given repository and codebase
     *
     * @param repository the <code>Repository</code> to search against.
     * @param codebase the <code>Codebase</code> to search against.
     * @return a list of named <code>Stream</code> objects.
     */
    List<Stream> getStreamsBy(Repository repository, Codebase codebase);

    /**
     * Get the StreamComponent which specifies the given repository and codebase. Note, this returns the first matching
     * component in the Stream data.
     *
     * @param repository the Repository to be searched against.
     * @param codebase the codebase to be searched against.
     * @return the StreamComponent associated with the given repository and codebase, or null if a StreamComponent does not exist
     */
    StreamComponent getComponentBy(Repository repository, Codebase codebase);
}
