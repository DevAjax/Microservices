package com.backend.usersapi.models;

import org.springframework.data.annotation.Id;

import java.util.Map;

public class UserSet {
    @Id
    private String id;
    private String userIdentifier;
    private Map<String, String> set;

    public UserSet() {
    }

    public UserSet(String userIdentifier, Map<String, String> set) {
        this.userIdentifier = userIdentifier;
        this.set = set;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Map<String, String> getSet() {
        return set;
    }

    public void setSet(Map<String, String> set) {
        this.set = set;
    }


    @Override
    public String toString() {
        return "UserSet{" +
                "id=" + id +
                ", userIdentifier='" + userIdentifier + '\'' +
                ", set=" + set +
                '}';

    }
}
