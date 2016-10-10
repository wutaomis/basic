package json2xml;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.StringWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Jackson2XmlT {
	private static Logger log = LogManager.getLogger(Jackson2XmlT.class);
//    private ObjectMapper objectMapper = new ObjectMapper();  
//    private XmlMapper xmlMapper = new XmlMapper();  
//	/** 
//     * json string convert to xml string 
//     */  
//    private String json2xml(String jsonStr)throws Exception{  
//        JsonNode root = objectMapper.readTree(jsonStr);  
//        String xml = xmlMapper.writeValueAsString(root);  
//        return xml;  
//    }  
//      
//    /** 
//     * xml string convert to json string 
//     */  
//    private String xml2json(String xml)throws Exception{  
//        StringWriter w = new StringWriter();  
//        JsonParser jp = xmlMapper.getFactory().createParser(xml);  
//        JsonGenerator jg = objectMapper.getFactory().createGenerator(w);  
//        while (jp.nextToken() != null) {  
//            jg.copyCurrentEvent(jp);  
//        }  
//        jp.close();  
//        jg.close();  
//        return w.toString();  
//    }  
	@Test
	public void xml2json() throws Exception
	{
		String xml = "<ap><id>1</id><name>张三</name></ap>";  
       // String json = xml2json(xml);
        log.info("xml:　" + xml);
       // log.info("json:　" + json);
//        Assert.assertEquals("{\"id\":1,\"name\":\"张三\"}", json);  
//        String xml2 = "<ObjectNode xmlns=\"\"><Items><RequestInterfaceSku><Sku_ProductNo>sku_0004</Sku_ProductNo></RequestInterfaceSku><RequestInterfaceSku><Sku_ProductNo>sku_0005</Sku_ProductNo></RequestInterfaceSku></Items></ObjectNode>";  
//        String json2 = xml2json(xml2);  
//        //expected2是我们想要的格式，但实际结果确实expected1，所以用jackson实现xml直接转换为json在遇到数组时是不可行的  
//        String expected1 = "{\"Items\":{\"RequestInterfaceSku\":{\"Sku_ProductNo\":\"sku_0004\"},\"RequestInterfaceSku\":{\"Sku_ProductNo\":\"sku_0005\"}}}";  
//        String expected2 = "{\"Items\":{\"RequestInterfaceSku\":[{\"Sku_ProductNo\":\"sku_0004\"},{\"Sku_ProductNo\":\"sku_0005\"}]}}";  
//        Assert.assertEquals(expected1, json2);  
//        Assert.assertEquals(expected2, json2);  
	}
}
