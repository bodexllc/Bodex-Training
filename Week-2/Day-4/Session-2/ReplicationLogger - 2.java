/* W2-D4-S2 : ReplicationLogger.java */

package com.adobe.training.core;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.event.jobs.JobProcessor;
import org.apache.sling.jcr.resource.JcrResourceResolverFactory;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@SuppressWarnings("deprecation")
@Service(value = EventHandler.class)
@Component(immediate = true)
@Property(name = "event.topics", value = ReplicationAction.EVENT_TOPIC)
public class ReplicationLogger implements EventHandler, JobProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReplicationLogger.class);
	@Reference
	private JcrResourceResolverFactory jcrResourceResolverFactory;
	@Override
	public void handleEvent(Event event) {
		LOGGER.info("********handling event");
		process (event);
	}
	@Override
	public boolean process(Event event) {
		LOGGER.info("********processing job");
		ReplicationAction action = ReplicationAction.fromEvent(event);
		ResourceResolver resourceResolver = null;
		if (action.getType().equals(ReplicationActionType.ACTIVATE)) {
			try {
				resourceResolver = jcrResourceResolverFactory.getAdministrativeResourceResolver(null);
				final PageManager pm = resourceResolver.adaptTo(PageManager.class);
				final Page page = pm.getContainingPage(action.getPath());
				if(page != null) {
					LOGGER.info("********activation of page {}", page.getTitle());
				}
			}
			catch (LoginException e) {
				e.printStackTrace();
			}
			finally {
				if(resourceResolver != null && resourceResolver.isLive()) {
					resourceResolver.close();
				}
			}
		}
		return true;
	}
}

/* W2-D4-S2 : ReplicationLogger.java ends */