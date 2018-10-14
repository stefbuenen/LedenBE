package nl.nextprogram.ledenBE.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import nl.nextprogram.ledenBE.api.LidEndPoint;
import nl.nextprogram.ledenBE.api.PostcodeEndPoint;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		register(LidEndPoint.class);
		register(PostcodeEndPoint.class);
	}

}
