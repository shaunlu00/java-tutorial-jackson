package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class Song {

    private String singer;
    @JsonDeserialize(using = WriterDeserializer.class)
    private Writer writer;

    public static class Writer {
        private String name;
        private String company;

        public Writer(){}

        public Writer(String name, String company) {
            this.name = name;
            this.company = company;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public static class WriterDeserializer extends StdDeserializer<Writer> {
        public WriterDeserializer() {
            this(null);
        }
        public WriterDeserializer(Class<Writer> t) {
            super(t);
        }
        @Override
        public Writer deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
            String jsonStr = jsonparser.getText();
            String name = jsonStr.split(":")[0];
            String company = jsonStr.split(":")[1];
            return new Writer(name, company);
        }
    }
}
