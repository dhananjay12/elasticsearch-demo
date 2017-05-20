package com.mynotes.spring.elasticsearch;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringElasticsearchBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticsearchBasicsApplication.class, args);
	}
	
	@Component
	class RibbonRunner implements CommandLineRunner {
		@Autowired
	    private TransportClient client;
		

		@Override
		public void run(String... args) throws Exception {
			String json = "{" + "\"user\":\"kimchy\"," + "\"postDate\":\"2013-01-30\","
					+ "\"message\":\"trying out Elasticsearch\"" + "}";

			IndexResponse response = client.prepareIndex("twitter", "tweet").setSource(json).get();

		}		
		

	}
}
