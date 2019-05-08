package com.springboot.demo.elasticsearch.rest.service.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.elasticsearch.rest.service.ElasticSearchService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    private RestTemplate restTemplate=new RestTemplate();

    /**
     * 检索索引为esindex,类型为estype下的所有文档
     * @return 检索文档内容字符串
     */
    @Override
    public String queryAllDocument() throws IOException {
        String postStr="http://localhost:9200/esindex/estype/_search";
        /**
         * 使用RestTemplate发送请求，并获取响应
         * 第一个参数为请求URL,第二个参数为响应类型
         */
        String resultStr=restTemplate.getForObject(postStr,String.class);
        ObjectMapper objMapper=new ObjectMapper();
        JsonFactory jsonFactory=objMapper.getFactory();
        JsonParser jsonParser=jsonFactory.createParser(resultStr);
        //读取解析结果
        JsonNode rootNode=objMapper.readTree(jsonParser);
        JsonNode contentNode=rootNode.get("hits");

        String resultContent=rootNode.get("hits").toString();
       System.out.println("resultContent------"+resultContent);
        return resultContent.toString();
    }

    /**
     * 检索索引为esindex,类型为estype下文档标识(DocumentId)匹配的文档详情
     * @param id：文档标识
     * @return 文档详情
     * @throws IOException
     */
    @Override
    public String queryDocumentMessageById(String id) throws IOException {
        /**
         *添加查询参数(文档标识)
         */
        Map<String,Object> param=new HashMap<String,Object>();
       param.put("id",id) ;
       String postStr="http://localhost:9200/esindex/estype/{id}";
        /**
         * 使用RestTemplate发送请求，并获取响应
         * 第一个参数为请求URL,第二个参数为响应类型,第三个参数为查询参数集合
         */
        String resultStr=restTemplate.getForObject(postStr,String.class,param);
        ObjectMapper objMapper=new ObjectMapper();
        JsonFactory jsonFactory=objMapper.getFactory();
        JsonParser jsonParser=jsonFactory.createParser(resultStr);
        //读取解析结果
        JsonNode rootNode=objMapper.readTree(jsonParser);
        JsonNode content=rootNode.get("_source");
        System.out.println("resultDetail------"+content.toString());
        return content.toString();
    }


}
