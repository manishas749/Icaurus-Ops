package c.anurag.network.beans.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class LoginResponse {
    @SerializedName("data")
    @Expose
    private Login data;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public Login getData() {
        return data;
    }

    public void setData(Login data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public class Meta {
        @SerializedName("account")
        @Expose
        private Account account;

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        public class Account {
            @SerializedName("uuid")
            @Expose
            private String uuid;
            @SerializedName("name")
            @Expose
            private Object name;
            @SerializedName("url")
            @Expose
            private Object url;

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getUrl() {
                return url;
            }

            public void setUrl(Object url) {
                this.url = url;
            }
        }
    }

    public class Login {
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("group_id")
        @Expose
        private int groupId;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("full_name")
        @Expose
        private String fullName;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("is_deleted")
        @Expose
        private boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("is_administrator")
        @Expose
        private boolean isAdministrator;

        public boolean getIsAdministrator() {
            return isAdministrator;
        }

        public void setIsAdministrator(boolean isAdministrator) {
            this.isAdministrator = isAdministrator;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(boolean isDeleted) {
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
    }
}
