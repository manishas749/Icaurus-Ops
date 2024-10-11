package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveAllChecklistElement {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Attribute {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("item_id")
        @Expose
        private Integer itemId;
        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("sort_order")
        @Expose
        private Integer sortOrder;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("custom_field")
        @Expose
        private CustomField customField;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public Integer getItemId() {
            return itemId;
        }

        public void setItemId(Integer itemId) {
            this.itemId = itemId;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Integer getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(Integer sortOrder) {
            this.sortOrder = sortOrder;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public CustomField getCustomField() {
            return customField;
        }

        public void setCustomField(CustomField customField) {
            this.customField = customField;
        }

    }

    public class CustomField {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("model")
        @Expose
        private String model;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("is_default")
        @Expose
        private Boolean isDefault;
        @SerializedName("allow_description")
        @Expose
        private Boolean allowDescription;
        @SerializedName("default_value")
        @Expose
        private String defaultValue;
        @SerializedName("possible_values")
        @Expose
        private String[] possibleValues;
        @SerializedName("display_as")
        @Expose
        private String displayAs;
        @SerializedName("is_multiple")
        @Expose
        private Boolean isMultiple;
        @SerializedName("is_required")
        @Expose
        private Boolean isRequired;
        @SerializedName("min_value")
        @Expose
        private Double minValue;
        @SerializedName("max_value")
        @Expose
        private Double maxValue;
        @SerializedName("min_length")
        @Expose
        private Integer minLength;
        @SerializedName("max_length")
        @Expose
        private Integer maxLength;
        @SerializedName("user_roles")
        @Expose
        private String[] userRoles;
        @SerializedName("allow_gallery")
        @Expose
        private Boolean allowGallery;
        @SerializedName("allowed_media_types")
        @Expose
        private String allowedMediaTypes;
        @SerializedName("sort_order")
        @Expose
        private Integer sortOrder;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Boolean getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(Boolean isDefault) {
            this.isDefault = isDefault;
        }

        public Boolean getAllowDescription() {
            return allowDescription;
        }

        public void setAllowDescription(Boolean allowDescription) {
            this.allowDescription = allowDescription;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
        }

        public String[] getPossibleValues() {
            return possibleValues;
        }

        public void setPossibleValues(String[] possibleValues) {
            this.possibleValues = possibleValues;
        }

        public String getDisplayAs() {
            return displayAs;
        }

        public void setDisplayAs(String displayAs) {
            this.displayAs = displayAs;
        }

        public Boolean getIsMultiple() {
            return isMultiple;
        }

        public void setIsMultiple(Boolean isMultiple) {
            this.isMultiple = isMultiple;
        }

        public Boolean getIsRequired() {
            return isRequired;
        }

        public void setIsRequired(Boolean isRequired) {
            this.isRequired = isRequired;
        }

        public Double getMinValue() {
            return minValue;
        }

        public void setMinValue(Double minValue) {
            this.minValue = minValue;
        }

        public Double getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(Double maxValue) {
            this.maxValue = maxValue;
        }

        public Integer getMinLength() {
            return minLength;
        }

        public void setMinLength(Integer minLength) {
            this.minLength = minLength;
        }

        public Integer getMaxLength() {
            return maxLength;
        }

        public void setMaxLength(Integer maxLength) {
            this.maxLength = maxLength;
        }

        public String[] getUserRoles() {
            return userRoles;
        }

        public void setUserRoles(String[] userRoles) {
            this.userRoles = userRoles;
        }

        public Boolean getAllowGallery() {
            return allowGallery;
        }

        public void setAllowGallery(Boolean allowGallery) {
            this.allowGallery = allowGallery;
        }

        public String getAllowedMediaTypes() {
            return allowedMediaTypes;
        }

        public void setAllowedMediaTypes(String allowedMediaTypes) {
            this.allowedMediaTypes = allowedMediaTypes;
        }

        public Integer getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(Integer sortOrder) {
            this.sortOrder = sortOrder;
        }

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("item_type_id")
        @Expose
        private Integer itemTypeId;
        @SerializedName("parent_id")
        @Expose
        private Integer parentId;
        @SerializedName("sort_order")
        @Expose
        private Integer sortOrder;
        @SerializedName("sequence_no")
        @Expose
        private String sequenceNo;
        @SerializedName("checklist_id")
        @Expose
        private Integer checklistId;
        @SerializedName("associated_checklist_uuid")
        @Expose
        private Object associatedChecklistUuid;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("item")
        @Expose
        private Item item;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getItemTypeId() {
            return itemTypeId;
        }

        public void setItemTypeId(Integer itemTypeId) {
            this.itemTypeId = itemTypeId;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public Integer getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(Integer sortOrder) {
            this.sortOrder = sortOrder;
        }

        public String getSequenceNo() {
            return sequenceNo;
        }

        public void setSequenceNo(String sequenceNo) {
            this.sequenceNo = sequenceNo;
        }

        public Integer getChecklistId() {
            return checklistId;
        }

        public void setChecklistId(Integer checklistId) {
            this.checklistId = checklistId;
        }

        public Object getAssociatedChecklistUuid() {
            return associatedChecklistUuid;
        }

        public void setAssociatedChecklistUuid(Object associatedChecklistUuid) {
            this.associatedChecklistUuid = associatedChecklistUuid;
        }

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

    }

    public class Item {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("ppes")
        @Expose
        private List<Ppes> ppes = null;
        @SerializedName("hazards")
        @Expose
        private List<Hazards> hazards = null;
        @SerializedName("attributes")
        @Expose
        private List<Attribute> attributes = null;
        @SerializedName("placeholders")
        @Expose
        private List<Placeholder> placeholders = null;
        @SerializedName("references")
        @Expose
        private List<Reference> references = null;
        @SerializedName("reference_links")
        @Expose
        private List<ReferenceLink> referenceLinks = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Ppes> getPpes() {
            return ppes;
        }

        public void setPpes(List<Ppes> ppes) {
            this.ppes = ppes;
        }

        public List<Hazards> getHazards() {
            return hazards;
        }

        public void setHazards(List<Hazards> hazards) {
            this.hazards = hazards;
        }

        public List<Attribute> getAttributes() {
            return attributes;
        }

        public void setAttributes(List<Attribute> attributes) {
            this.attributes = attributes;
        }

        public List<Placeholder> getPlaceholders() {
            return placeholders;
        }

        public void setPlaceholders(List<Placeholder> placeholders) {
            this.placeholders = placeholders;
        }

        public List<Reference> getReferences() {
            return references;
        }

        public void setReferences(List<Reference> references) {
            this.references = references;
        }

        public List<ReferenceLink> getReferenceLinks() {
            return referenceLinks;
        }

        public void setReferenceLinks(List<ReferenceLink> referenceLinks) {
            this.referenceLinks = referenceLinks;
        }

        public class PlaceholderDate {
            Integer id;
            String uuid;
            String name;
            String placeholder;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPlaceholder() {
                return placeholder;
            }

            public void setPlaceholder(String placeholder) {
                this.placeholder = placeholder;
            }
        }

        public class Placeholder {
            Integer id;
            Integer item_id;
            Integer item_type_id;
            Integer sort_order;
            boolean is_deleted;
            PlaceholderDate placeholder;


            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getUuid() {
                return uuid;
            }

            public Integer getItem_id() {
                return item_id;
            }

            public void setItem_id(Integer item_id) {
                this.item_id = item_id;
            }

            public Integer getItem_type_id() {
                return item_type_id;
            }

            public void setItem_type_id(Integer item_type_id) {
                this.item_type_id = item_type_id;
            }

            public Integer getSort_order() {
                return sort_order;
            }

            public void setSort_order(Integer sort_order) {
                this.sort_order = sort_order;
            }

            public boolean isIs_deleted() {
                return is_deleted;
            }

            public void setIs_deleted(boolean is_deleted) {
                this.is_deleted = is_deleted;
            }

            public PlaceholderDate getPlaceholder() {
                return placeholder;
            }

            public void setPlaceholder(PlaceholderDate placeholder) {
                this.placeholder = placeholder;
            }
        }

        public class Ppes {
            @SerializedName("id")
            @Expose
            Integer id;
            @SerializedName("ppe_id")
            @Expose
            Integer ppeId;
            @SerializedName("uuid")
            @Expose
            String uuid;
            @SerializedName("is_deleted")
            @Expose
            boolean isDeleted;
            @SerializedName("created_at")
            @Expose
            public String createdAt;
            @SerializedName("updated_at")
            @Expose
            public String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getPpeId() {
                return ppeId;
            }

            public void setPpeId(Integer ppeId) {
                this.ppeId = ppeId;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public boolean isDeleted() {
                return isDeleted;
            }

            public void setDeleted(boolean deleted) {
                isDeleted = deleted;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }

        public class Hazards {
            @SerializedName("id")
            @Expose
            Integer id;
            @SerializedName("hazard_id")
            @Expose
            Integer hazardId;
            @SerializedName("uuid")
            @Expose
            String uuid;
            @SerializedName("is_deleted")
            @Expose
            boolean isDeleted;
            @SerializedName("created_at")
            @Expose
            public String createdAt;
            @SerializedName("updated_at")
            @Expose
            public String updatedAt;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getHazardId() {
                return hazardId;
            }

            public void setHazardId(Integer hazardId) {
                this.hazardId = hazardId;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public boolean isDeleted() {
                return isDeleted;
            }

            public void setDeleted(boolean deleted) {
                isDeleted = deleted;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }

        public class Reference {
            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("uuid")
            @Expose
            public String uuid;
            @SerializedName("item_type_id")
            @Expose
            public Integer itemTypeId;
            @SerializedName("item_id")
            @Expose
            public Integer itemId;
            @SerializedName("display_filename")
            @Expose
            public String displayFilename;
            @SerializedName("filename")
            @Expose
            public String filename;
            @SerializedName("filesize")
            @Expose
            public Integer filesize;
            @SerializedName("content_type")
            @Expose
            public String contentType;
            @SerializedName("md5_checksum")
            @Expose
            public String md5Checksum;
            @SerializedName("is_resource")
            @Expose
            public Boolean isResource;
            @SerializedName("is_deleted")
            @Expose
            public Boolean isDeleted;
            @SerializedName("created_at")
            @Expose
            public String createdAt;
            @SerializedName("updated_at")
            @Expose
            public String updatedAt;
            @SerializedName("links")
            @Expose
            public Links links;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public Integer getItemTypeId() {
                return itemTypeId;
            }

            public void setItemTypeId(Integer itemTypeId) {
                this.itemTypeId = itemTypeId;
            }

            public Integer getItemId() {
                return itemId;
            }

            public void setItemId(Integer itemId) {
                this.itemId = itemId;
            }

            public String getDisplayFilename() {
                return displayFilename;
            }

            public void setDisplayFilename(String displayFilename) {
                this.displayFilename = displayFilename;
            }

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public Integer getFilesize() {
                return filesize;
            }

            public void setFilesize(Integer filesize) {
                this.filesize = filesize;
            }

            public String getContentType() {
                return contentType;
            }

            public void setContentType(String contentType) {
                this.contentType = contentType;
            }

            public String getMd5Checksum() {
                return md5Checksum;
            }

            public void setMd5Checksum(String md5Checksum) {
                this.md5Checksum = md5Checksum;
            }

            public Boolean getResource() {
                return isResource;
            }

            public void setResource(Boolean resource) {
                isResource = resource;
            }

            public Boolean getDeleted() {
                return isDeleted;
            }

            public void setDeleted(Boolean deleted) {
                isDeleted = deleted;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public Links getLinks() {
                return links;
            }

            public void setLinks(Links links) {
                this.links = links;
            }
        }

        public class ReferenceLink {

            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("uuid")
            @Expose
            public String uuid;
            @SerializedName("link_title")
            @Expose
            public String linkTitle;
            @SerializedName("link")
            @Expose
            public String link;
            @SerializedName("is_deleted")
            @Expose
            private Boolean isDeleted;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getLinkTitle() {
                return linkTitle;
            }

            public void setLinkTitle(String linkTitle) {
                this.linkTitle = linkTitle;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public Boolean getDeleted() {
                return isDeleted;
            }

            public void setDeleted(Boolean deleted) {
                isDeleted = deleted;
            }
        }
    }

    public class Links {

        @SerializedName("self")
        @Expose
        public String self;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }
    }


}

