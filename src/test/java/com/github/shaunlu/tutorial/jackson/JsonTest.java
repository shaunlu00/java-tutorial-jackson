package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Test
    public void testJsonArray() throws JsonProcessingException {
        String str = "[{\"id\":\"w\"}, {\"id\":\"r\"}]";
        UserPermission[] permissions = objectMapper.readValue(str, UserPermission[].class);
        System.out.println("This first permission is " + permissions[0].getId());
    }

    @Test
    public void testJsonCollection() throws JsonProcessingException {
        String str = "[{\"id\":\"w\"}, {\"id\":\"r\"}]";
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, UserPermission.class);
        List<UserPermission> permissions = objectMapper.readValue(str, collectionType);
        System.out.println("This first permission is " + permissions.get(0).getId());
    }

    @Test
    public void testJsonTypeInfo() throws JsonProcessingException {
        String str1 = objectMapper.writeValueAsString(new Swim("breaststroke"));
        String str2 = objectMapper.writeValueAsString(new Basketball("Micheal"));
        System.out.println(str1 + str2);
    }

    @Test
    public void testJsonTypeInfoDeserialization() throws JsonProcessingException {
        String str = "{\"@type\":\"swim\",\"name\":\"Swim\",\"swimType\":\"breaststroke\"}";
        Sports sports = objectMapper.readValue(str, Sports.class);
        System.out.println("Sports is" + sports.getClass().getName());
    }

    @Test
    public void testJsonTypeInfoArrayDeserialization() throws JsonProcessingException {
        String str = "[{\"@type\":\"swim\",\"name\":\"Swim\",\"swimType\":\"breaststroke\"}, " +
                "{\"@type\":\"basketball\",\"name\":\"Basketball\",\"pg\":\"Micheal\"}]";
        List<Sports> sportsList = objectMapper.readValue(str, objectMapper.getTypeFactory().constructCollectionType(List.class, Sports.class));
        System.out.println("Sports[0] is " + sportsList.get(0).getClass().getName() + "\n"
                            + "Sports[1] is " + sportsList.get(1).getClass().getName());
    }

    @Test
    public void testJsonEnum() throws JsonProcessingException {
        Status status = Status.IN_PROGRESS;
        System.out.println(objectMapper.writeValueAsString(status));
    }

    @Test
    public void testJsonEnum2() throws JsonProcessingException {
        String str = "2";
        State state = objectMapper.readValue(str, State.class);
        System.out.println(objectMapper.writeValueAsString(state));
    }

    @Test
    public void testJsonDate() throws JsonProcessingException {
        Date date = new Date();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        System.out.println(objectMapper.writeValueAsString(date));
    }

    @Test
    public void testJsonDate2() throws JsonProcessingException {
        class Temp {
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss dd-MM-yyyy")
            Date date = new Date();
            public Date getDate() {
                return date;
            }
        }
        System.out.println(objectMapper.writeValueAsString(new Temp()));
    }

    @Test
    public void testJsonJava8Date() throws JsonProcessingException{
        LocalDateTime dateTime = LocalDateTime.of(2019, 05, 01, 13, 31, 0);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        System.out.println(objectMapper.writeValueAsString(dateTime));
    }

    @Test
    public void testJsonNode() throws JsonProcessingException{
        String str = "{\"name\":\"peter\", \"age\":\"20\"}";
        JsonNode jsonNode = objectMapper.readTree(str);
        System.out.println(jsonNode.get("name").asText());
        System.out.println(jsonNode.get("age").asInt());
    }
}
