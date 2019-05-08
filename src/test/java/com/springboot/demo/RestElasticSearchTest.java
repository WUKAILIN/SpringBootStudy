package com.springboot.demo;

import com.springboot.demo.elasticsearch.rest.service.ElasticSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RestElasticSearchTest {
    @Autowired
    private ElasticSearchService elasticSearchServiceImpl;
    @Test
    public void testSearchAllDocument() throws IOException {
        elasticSearchServiceImpl.queryAllDocument();
    }
    @Test
    public void testSearchDocumentById() throws IOException {
        elasticSearchServiceImpl.queryDocumentMessageById("5");
    }
}
