package springbook.learningtest.spring.ioc.property;

import javax.annotation.Resource;
import java.util.*;

public class CollectionProperty {
    @Resource
    private List<String> names2;
    @Resource
    private Set<String> genders2;
    @Resource
    private Map<String, Integer> ages2;
    @Resource
    private Properties settings2;

    public List<String> getNames2() {
        return names2;
    }

    public Set<String> getGenders2() {
        return genders2;
    }

    public Map<String, Integer> getAges2() {
        return ages2;
    }

    public Properties getSettings2() {
        return settings2;
    }

    private List<String> names;
    private Set<String> genders;
    private Map<String, Integer> ages;
    private Properties settings;
    private String nullName;

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setGenders(Set<String> genders) {
        this.genders = genders;
    }

    public Set<String> getGenders() {
        return genders;
    }

    public void setAges(Map<String, Integer> ages) {
        this.ages = ages;
    }

    public Map<String, Integer> getAges() {
        return ages;
    }

    public void setSettings(Properties settings) {
        this.settings = settings;
    }

    public Properties getSettings() {
        return settings;
    }

    public void setNullName(String nullName) {
        this.nullName = nullName;
    }

    public String getNullName() {
        return nullName;
    }
}