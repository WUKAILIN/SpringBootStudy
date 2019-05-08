package com.springboot.demo.elasticsearch.rest.controller;

import com.springboot.demo.elasticsearch.rest.service.ElasticSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ElasticsearchRestController {
    @Autowired
    private ElasticSearchService elasticSearchServiceImpl;
    @RequestMapping("/getAllDocument")
    @ResponseBody
    public String queryAllDocument() throws IOException {
        return elasticSearchServiceImpl.queryAllDocument();
    }
    @RequestMapping("/getDocumentDetailById")
    @ResponseBody
    public String queryDocumentDetailById(@PathVariable String id) throws IOException {
        return elasticSearchServiceImpl.queryDocumentMessageById(id);
    }
}
