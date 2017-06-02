package br.com.developer;

import java.net.MalformedURLException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = { "br.com.developer" }, multicoreSupport = true)
public class SolrConfig {

    @Bean
    public SolrClient solrClient() throws MalformedURLException, IllegalStateException {
        return new HttpSolrClient("http://localhost:8983/solr/");
    }
}
