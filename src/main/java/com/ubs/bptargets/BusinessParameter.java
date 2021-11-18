package com.ubs.bptargets;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "businessparameter")
public class BusinessParameter {
    @Id
    //@GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    // The ID to distinguish the different BPs (full number)
    private int id;

    @Column(name = "type")
    // The type of parameter (Text String)
    private String type;

    @Column(name = "category")
    // The category in which the parameter is (Text String)
    private String category;

    @Column(name = "subcategory")
    // The type of sub-category (Mostly empty)
    private String subcategory;

    @Column(name = "description")
    // The description for the parameter (Text String)
    private String description;

    @Column(name = "scope")
    // The scope for the parameter (Short Text (3 Letters) String)
    private String scope;

    @Column(name = "value")
    // The value of the parameter (Boolean and Text, String)
    private String value;

    @Column(name = "state")
    // The state in which the parameter is in (Text String)
    private String state;

    @Column(name = "modified")
    // The last modification date (Date yyyy-mm-dd)
    private LocalDate modified;

    @Column(name = "reason")
    // The reason for the parameter (Text String)
    private String reason;

    /* Constructors */
    // Empty constructor
    public BusinessParameter() {
    }

    // Parameterized constructor
    public BusinessParameter(int id, String type, String category, String subcategory, String description, String scope, String value, String state, LocalDate modified, String reason) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.subcategory = subcategory;
        this.description = description;
        this.scope = scope;
        this.value = value;
        this.state = state;
        this.modified = modified;
        this.reason = reason;
    }

    /* Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /* ToString method */
    @Override
    public String toString() {
        return "BusinessParameter{" +
                "id=" + id +
                ", parameterType='" + type + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subcategory + '\'' +
                ", description='" + description + '\'' +
                ", scope='" + scope + '\'' +
                ", value='" + value + '\'' +
                ", state='" + state + '\'' +
                ", modificationDate=" + modified +
                ", reason='" + reason + '\'' +
                '}';
    }
}
