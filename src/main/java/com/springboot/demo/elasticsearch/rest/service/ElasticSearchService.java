package com.springboot.demo.elasticsearch.rest.service;

import java.io.IOException;


public interface ElasticSearchService {
public String queryAllDocument() throws IOException;
 public String queryDocumentMessageById(String id) throws IOException;
}
