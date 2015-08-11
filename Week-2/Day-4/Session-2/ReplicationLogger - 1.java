/* W2-D4-S2 : ReplicationLogger.java */

package com.adobe.training.core;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.event.jobs.JobProcessor;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.replication.ReplicationAction;

@Service(value = EventHandler.class)
@Component(immediate = true)
@Property(name = "event.topics", value = ReplicationAction.EVENT_TOPIC)

public class ReplicationLogger implements EventHandler, JobProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReplicationLogger.class);
	@Override
	public void handleEvent(Event event) {
		LOGGER.debug("********handling event");
		process (event);
	}
	@Override
	public boolean process(Event event) {
		LOGGER.debug("********processing job");
		return true;
	}
}

/* W2-D4-S2 : ReplicationLogger.java ends*/