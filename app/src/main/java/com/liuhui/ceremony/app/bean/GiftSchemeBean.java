package com.liuhui.ceremony.app.bean;

import java.util.List;

/**
 *
 * 情礼攻略 方案实体类
 * Created by anany on 15/8/20.
 */
public class GiftSchemeBean {

    /**
     * tags : [{"id":"1","listorder":"0","letter":"hunsha","name":"婚纱"},{"id":"2","listorder":"0","letter":"zhaopianshu","name":"照片书"},{"id":"3","listorder":"0","letter":"huodong","name":"活动"},{"id":"4","listorder":"0","letter":"shuqidazuozhan","name":"暑期大作战"}]
     * friends : [{"total":"","id":"6","hits":"11","title":"暑期大作战","keywords":"暑期大作战","updatetime":"1439774765","gifturl":"","nickname":"我本天才","userid":"10","showgift":"","avatar":"","fengmian":"uploadfiles/member/10/image/201508/1.jpg"},{"total":"","id":"5","hits":"50","title":"前方高能，夏日里的美腿制造机来袭","keywords":"","updatetime":"1436173528","gifturl":"","nickname":"小宇","userid":"1","showgift":"","avatar":"uploadfiles/member/1/image/201506/1.png","fengmian":"uploadfiles/image/201507/3.jpg"},{"total":"6","id":"1","hits":"87","title":"让爸爸再结婚一次","keywords":"婚纱,照片书","updatetime":"1436171717","gifturl":"","nickname":"小宇","userid":"1","showgift":"","avatar":"uploadfiles/member/1/image/201506/1.png","fengmian":"uploadfiles/image/201507/1.jpg"}]
     * typelist : [{"typename":"情礼情境","typeid":"1"},{"typename":"情礼对象","typeid":"2"},{"typename":"对象爱好","typeid":"3"},{"typename":"节日送礼","typeid":"4"}]
     * catlist : [{"catid":"7","catname":"情礼故事"},{"catid":"1","catname":"精选方案"}]
     */
    private List<TagsEntity> tags;
    private List<FriendsEntity> friends;
    private List<TypelistEntity> typelist;
    private List<CatlistEntity> catlist;

    public void setTags(List<TagsEntity> tags) {
        this.tags = tags;
    }

    public void setFriends(List<FriendsEntity> friends) {
        this.friends = friends;
    }

    public void setTypelist(List<TypelistEntity> typelist) {
        this.typelist = typelist;
    }

    public void setCatlist(List<CatlistEntity> catlist) {
        this.catlist = catlist;
    }

    public List<TagsEntity> getTags() {
        return tags;
    }

    public List<FriendsEntity> getFriends() {
        return friends;
    }

    public List<TypelistEntity> getTypelist() {
        return typelist;
    }

    public List<CatlistEntity> getCatlist() {
        return catlist;
    }

    public static class TagsEntity {
        /**
         * id : 1
         * listorder : 0
         * letter : hunsha
         * name : 婚纱
         */
        private String id;
        private String listorder;
        private String letter;
        private String name;

        public void setId(String id) {
            this.id = id;
        }

        public void setListorder(String listorder) {
            this.listorder = listorder;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getListorder() {
            return listorder;
        }

        public String getLetter() {
            return letter;
        }

        public String getName() {
            return name;
        }
    }

    public static class FriendsEntity {
        /**
         * total :
         * id : 6
         * hits : 11
         * title : 暑期大作战
         * keywords : 暑期大作战
         * updatetime : 1439774765
         * gifturl :
         * nickname : 我本天才
         * userid : 10
         * showgift :
         * avatar :
         * fengmian : uploadfiles/member/10/image/201508/1.jpg
         */
        private String total;
        private String id;
        private String hits;
        private String title;
        private String keywords;
        private String updatetime;
        private String gifturl;
        private String nickname;
        private String userid;
        private String showgift;
        private String avatar;
        private String fengmian;

        public void setTotal(String total) {
            this.total = total;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public void setGifturl(String gifturl) {
            this.gifturl = gifturl;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setShowgift(String showgift) {
            this.showgift = showgift;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setFengmian(String fengmian) {
            this.fengmian = fengmian;
        }

        public String getTotal() {
            return total;
        }

        public String getId() {
            return id;
        }

        public String getHits() {
            return hits;
        }

        public String getTitle() {
            return title;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public String getGifturl() {
            return gifturl;
        }

        public String getNickname() {
            return nickname;
        }

        public String getUserid() {
            return userid;
        }

        public String getShowgift() {
            return showgift;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getFengmian() {
            return fengmian;
        }
    }

    public static class TypelistEntity {
        /**
         * typename : 情礼情境
         * typeid : 1
         */
        private String typename;
        private String typeid;

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public String getTypename() {
            return typename;
        }

        public String getTypeid() {
            return typeid;
        }
    }

    public static class CatlistEntity {
        /**
         * catid : 7
         * catname : 情礼故事
         */
        private String catid;
        private String catname;

        public void setCatid(String catid) {
            this.catid = catid;
        }

        public void setCatname(String catname) {
            this.catname = catname;
        }

        public String getCatid() {
            return catid;
        }

        public String getCatname() {
            return catname;
        }
    }
}
