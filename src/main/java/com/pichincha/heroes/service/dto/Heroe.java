package com.pichincha.heroes.service.dto;

import lombok.AccessLevel;

import java.io.Serializable;
import java.util.List;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@lombok.experimental.FieldDefaults(level = AccessLevel.PRIVATE)
public class Heroe {
    Data data;

    @lombok.Getter
    @lombok.Setter
    @lombok.experimental.FieldDefaults(level = lombok.AccessLevel.PRIVATE)
    public static class Data implements Serializable {
        List<Results> results;
    }


    @lombok.Getter
    @lombok.Setter
    @lombok.experimental.FieldDefaults(level = lombok.AccessLevel.PRIVATE)
    public static class Results implements Serializable {
        String id;
        String name;
        String title;
        String description;
        Thumbnail thumbnail;
        @lombok.Getter
        @lombok.Setter
        @lombok.experimental.FieldDefaults(level = lombok.AccessLevel.PRIVATE)
        public static class Thumbnail implements Serializable {
            String path;
            String extension;
        }
    }
}
