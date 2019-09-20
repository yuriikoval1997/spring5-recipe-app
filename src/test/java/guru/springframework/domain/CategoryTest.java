package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    private Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void setGetId(){
        Long expected = 4L;
        category.setId(4L);
        assertEquals(expected, category.getId());
    }

    @Test
    public void setGetDescription(){
        String expected = "Two shots of vodka.";
        category.setDescription("Two shots of vodka.");
        assertEquals(expected, category.getDescription());
    }
}