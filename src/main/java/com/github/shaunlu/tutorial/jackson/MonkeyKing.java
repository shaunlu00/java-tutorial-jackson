package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MonkeyKing {
    private String name = "Sun Wukong";
    private Weapon weapon = new Weapon("1000m", "1000kg");
    @JsonSerialize(using = WeaponSerializer.class)
    public static class Weapon {
        private String length;
        private String weight;
        public Weapon(){}
        public Weapon(String length, String weight) {
            this.length = length;
            this.weight = weight;
        }

        public String getLength() {
            return length;
        }

        public String getWeight() {
            return weight;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public static class WeaponSerializer extends StdSerializer<Weapon> {

        public WeaponSerializer(Class<Weapon> t) {
            super(t);
        }

        public WeaponSerializer() {
            this(null);
        }

        @Override
        public void serialize(Weapon weapon, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String value = "Power Stick:" + weapon.getLength() + "-" + weapon.getWeight();
            jsonGenerator.writeString(value);
        }
    }
}
