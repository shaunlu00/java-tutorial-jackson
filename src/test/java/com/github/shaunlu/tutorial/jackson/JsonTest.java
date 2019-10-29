package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Map;

public class JsonTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testJsonIgnore() throws JsonProcessingException {
        Employee employee = new Employee(1000L, "peter", 35, "1x0192ks1921", new Employee.Job("job desc"));
        System.out.println(objectMapper.writeValueAsString(employee));
    }

    @Test
    public void testJsonProperty() throws JsonProcessingException {
        Product product = new Product("k1001", "MacBook");
        System.out.println(objectMapper.writeValueAsString(product));
    }

    @Test
    public void testJsonFormat() throws JsonProcessingException {
        Product product = new Product("k1001", "MacBook");
        System.out.println(objectMapper.writeValueAsString(product));
    }

    @Test
    public void testJsonInclude() throws JsonProcessingException {
        Product product = new Product("k1001", "MacBook");
        System.out.println(objectMapper.writeValueAsString(product));
    }

    @Test
    public void testJsonView() throws JsonProcessingException {
        User user = new User("111", "1988-10-10", "shaun", "shaun@test.com");
        System.out.println(objectMapper
                .writerWithView(UserJsonView.Public.class)
                .writeValueAsString(user));
        System.out.println(objectMapper
                .writerWithView(UserJsonView.Internal.class)
                .writeValueAsString(user));
    }

    @Test
    public void testJsonGetter() throws JsonProcessingException {
        Company company = new Company("Siemens", "Germany", "John");
        company.getCompanyProperties().put("headquarter", "Munich");
        company.getCompanyProperties().put("Number of employee", "100000");
        System.out.println(objectMapper.writeValueAsString(company));
    }

    @Test
    public void testJsonOrder() throws JsonProcessingException {
        Company company = new Company("Siemens", "Germany", "John");
        System.out.println(objectMapper.writeValueAsString(company));
    }

    @Test
    public void testJsonRawValue() throws JsonProcessingException {
        Company company = new Company("Siemens", "Germany", "John");
        company.setCompanyEmployee("[{\"name\":\"peter\"}, {\"name\":\"john\"}]");
        System.out.println(objectMapper.writeValueAsString(company));
    }

    @Test
    public void testJsonValue() throws JsonProcessingException {
        Student student = new Student("Shaun");
        System.out.println(objectMapper.writeValueAsString(student));
    }

    @Test
    public void testJsonSerializer() throws JsonProcessingException {
        MonkeyKing monkeyKing = new MonkeyKing();
        System.out.println(objectMapper.writeValueAsString(monkeyKing));
    }

    @Test
    public void testJsonCreator() throws JsonProcessingException {
        String str = "{\"SEEX\" : \"Male\", \"LIVPLACE\" : \"Africa\"}";
        Elephant elephant = objectMapper.readValue(str, Elephant.class);
    }

    @Test
    public void testJsonAnySetter() throws JsonProcessingException {
        String str = "{\"name\" : \"riji\", \"Other\":{\"Weight\":\"1T\"}}";
        Tiger tiger = objectMapper.readValue(str, Tiger.class);
        System.out.println("'Other' property is mapped as:" + tiger.getProperties().get("Other").getClass());
        Map other = (Map) tiger.getProperties().get("Other");
        System.out.println("Other.Weight is '" + other.get("Weight") + "'");
    }

    @Test
    public void testJsonDeserializer() throws JsonProcessingException {
        String str = "{\"singer\" : \"Taylor\", \"writer\":\"Steve:Jackson\" }";
        Song song = objectMapper.readValue(str, Song.class);
        System.out.println("This song is written by " + song.getWriter().getName());
    }

    @Test
    public void testJsonAlias() throws JsonProcessingException {
        String str = "{\"CCORE\" : \"Intel\"}";
        Computer computer = objectMapper.readValue(str, Computer.class);
        System.out.println("This core is " + computer.getCore());
    }
}
