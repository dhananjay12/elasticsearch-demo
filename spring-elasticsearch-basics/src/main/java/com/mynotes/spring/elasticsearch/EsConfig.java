package com.mynotes.spring.elasticsearch;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {

	@Bean
    public TransportClient client() {
        
        	Settings settings = Settings.builder()
    				.put("cluster.name", "dj-es-cluster")
                 .put("client.transport.sniff", true).build();
         TransportClient client = null;
         try {
             client = new PreBuiltTransportClient(settings)
    					.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1", 9300)));
         return client;
        } catch (Exception e) {
           e.printStackTrace();
        }
		return client;
    }
	

}
