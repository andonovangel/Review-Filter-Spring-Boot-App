package com.reviews.reviews.bootsrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reviews.reviews.model.Review;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    ObjectMapper mapper = new ObjectMapper();
    public static List<Review> reviews;

    @PostConstruct
    public void init() throws IOException {
        reviews = mapper.readValue(new File("C:\\Users\\PC\\Desktop\\EmbedSocial Backend Internship\\Reviews\\src\\main\\resources\\json\\reviews.json"),
                new TypeReference<List<Review>>(){});
    }
}
