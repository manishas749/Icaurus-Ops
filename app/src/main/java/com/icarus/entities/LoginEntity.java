package com.icarus.entities;

import java.util.List;


public class LoginEntity {
    private Login data;
    private Meta meta;
    private String message;
    private String name;
    private String url;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Login getData() {
        return data;
    }

    public void setData(Login data) {
        this.data = data;
    }

    public LoginEntity.Meta getMeta() {
        return meta;
    }

    public void setMeta(LoginEntity.Meta meta) {
        this.meta = meta;
    }


    public class Meta {
        private LoginEntity.Meta.Account account;

        private List<LocationEntity> locations;

        public List<LocationEntity> getLocations() {
            return locations;
        }

        public void setLocations(List<LocationEntity> locations) {
            this.locations = locations;
        }

        public LoginEntity.Meta.Account getAccount() {
            return account;
        }

        public void setAccount(LoginEntity.Meta.Account account) {
            this.account = account;
        }

        public class Account {
            private String uuid;
            private Object name;
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

}
