package com.practice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
    private String contentId;
    private String name;
    private String type;
    private List<JsonNode> value;
    private String refNum;
    private String locale;
    private String md5;
    private List<String> tags;
    private String source;
    private List<String> generatedTags;
    private int version;
    private List<String> translations;
    private List<String> siteVariants;
    private boolean globalContent;
    private boolean defaultContent = false;
    private String createdBy;
    private int translationsCount;
    private String translationType;
    private boolean localized;
    private String status;

    @JsonDeserialize(using = DateToTimestampDeserializer.class)
    private Long updatedDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Map<String, Object>> locations;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Map<String, Object>> categories;

    private Map<String, Object> autoTaggedRelations;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<JsonNode> getValue() {
        return value;
    }

    public void setValue(List<JsonNode> value) {
        this.value = value;
    }

    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGeneratedTags() {
        return generatedTags;
    }

    public void setGeneratedTags(List<String> generatedTags) {
        this.generatedTags = generatedTags;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public List<Map<String, Object>> getLocations() {
        return locations;
    }

    public void setLocations(List<Map<String, Object>> locations) {
        this.locations = locations;
    }

    public List<Map<String, Object>> getCategories() {
        return categories;
    }

    public void setCategories(List<Map<String, Object>> categories) {
        this.categories = categories;
    }

    public Map<String, Object> getAutoTaggedRelations() {
        return autoTaggedRelations;
    }

    public void setAutoTaggedRelations(Map<String, Object> autoTaggedRelations) {
        this.autoTaggedRelations = autoTaggedRelations;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    public List<String> getSiteVariants() {
        return siteVariants;
    }

    public void setSiteVariants(List<String> siteVariants) {
        this.siteVariants = siteVariants;
    }

    public boolean isGlobalContent() {
        return globalContent;
    }

    public void setGlobalContent(boolean globalContent) {
        this.globalContent = globalContent;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getTranslationsCount() {
        return translationsCount;
    }

    public void setTranslationsCount(int translationsCount) {
        this.translationsCount = translationsCount;
    }

    public String getTranslationType() {
        return translationType;
    }

    public void setTranslationType(String translationType) {
        this.translationType = translationType;
    }

    public boolean isLocalized() {
        return localized;
    }

    public void setLocalized(boolean localized) {
        this.localized = localized;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isDefaultContent() {
        return defaultContent;
    }

    public void setDefaultContent(boolean defaultContent) {
        this.defaultContent = defaultContent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId='" + contentId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", refNum='" + refNum + '\'' +
                ", locale='" + locale + '\'' +
                ", md5='" + md5 + '\'' +
                ", tags=" + tags +
                ", generatedTags=" + generatedTags +
                ", version=" + version +
                ", translations=" + translations +
                ", siteVariants=" + siteVariants +
                ", globalContent=" + globalContent +
                ", defaultContent=" + defaultContent +
                ", createdBy='" + createdBy + '\'' +
                ", translationsCount=" + translationsCount +
                ", translationType='" + translationType + '\'' +
                ", localized=" + localized +
                ", source=" + source +
                ", status='" + status + '\'' +
                ", updatedDate=" + updatedDate +
                ", locations=" + locations +
                ", categories=" + categories +
                ", autoTaggedRelations=" + autoTaggedRelations +
                '}';
    }
}
