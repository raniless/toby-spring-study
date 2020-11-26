package springbook.learningtest.spring.ioc.property;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionPropertyTest {
    private ApplicationContext context;
    private CollectionProperty collectionProperty;
    @Before
    public void setUp() {
        context = new GenericXmlApplicationContext("propertyTestContext.xml");
        collectionProperty = context.getBean("collectionProperty", CollectionProperty.class);
    }

    @Test
    public void collectionDITest() {
        //<list>
        assertEquals(new ArrayList<String>(Arrays.asList("Spring","IoC","DI")), collectionProperty.getNames());

        //<set>
        assertEquals(new HashSet<String>(Arrays.asList("Male","Female")), collectionProperty.getGenders());

        //<map>
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Kim", 30);
        ages.put("Lee", 35);
        ages.put("Ahn", 40);
        assertEquals(ages, collectionProperty.getAges());

        //<props>
        Properties settings = new Properties();
        settings.setProperty("username", "Spring");
        settings.setProperty("password", "Book");
        assertEquals(settings, collectionProperty.getSettings());
    }

    @Test
    public void springUtilTagBeanTest() {
        assertNotNull(collectionProperty.getNames2());
        assertNotNull(collectionProperty.getGenders2());
        assertNotNull(collectionProperty.getAges2());
        assertNotNull(collectionProperty.getSettings2());
    }

    @Test
    public void nullValueTest() {
        assertNull(collectionProperty.getNullName());
    }
}
