package com.liuhui.ceremony.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 情礼攻略 方案实体类
 * Created by anany on 15/8/20.
 */
public class GiftSchemeBean implements Serializable{

    /**
     * idealist : [{"id":"7","title":"遇到森系菇凉，就送她这些美物吧","fengmian":"uploadfiles/image/201508/1.jpg","userid":"0","nickname":"","avatar":"","praisenum":"3","commentnum":"0","favoritenum":"0","hits":"2","share":"0","keywords":"菇凉","gifturl":"","showgift":"0","updatetime":"1440294834"},{"id":"6","title":"暑期大作战","fengmian":"uploadfiles/idea/003.jpg","userid":"10","nickname":"我本天才","avatar":"","praisenum":"2","commentnum":"2","favoritenum":"0","hits":"11","share":"0","keywords":"暑期大作战","gifturl":"","showgift":"","updatetime":"1439774765"},{"id":"5","title":"前方高能，夏日里的美腿制造机来袭...","fengmian":"uploadfiles/idea/002.jpg","userid":"1","nickname":"小宇2","avatar":"uploadfiles/member/1/image/201506/1.png","praisenum":"3","commentnum":"1","favoritenum":"0","hits":"50","share":"0","keywords":"","gifturl":"","showgift":"","updatetime":"1436173528"},{"id":"1","title":"让爸爸再结婚一次...","fengmian":"uploadfiles/idea/001.jpg","userid":"1","nickname":"小宇2","avatar":"uploadfiles/member/1/image/201506/1.png","praisenum":"2","commentnum":"5","favoritenum":"0","hits":"88","share":"0","keywords":"婚纱,照片书","gifturl":"","showgift":"","updatetime":"1436171717"}]
     * catlist : [{"catid":"7","catname":"情礼故事"},{"catid":"1","catname":"精选方案"}]
     * typelist : [{"typeid":"1","typename":"情礼情境"},{"typeid":"2","typename":"情礼对象"},{"typeid":"3","typename":"对象爱好"},{"typeid":"4","typename":"节日送礼"}]
     * tags : [{"id":"1","name":"婚纱","letter":"hunsha","listorder":"0"},{"id":"2","name":"照片书","letter":"zhaopianshu","listorder":"0"},{"id":"3","name":"活动","letter":"huodong","listorder":"0"},{"id":"4","name":"暑期大作战","letter":"shuqidazuozhan","listorder":"0"},{"id":"5","name":"菇凉","letter":"guliang","listorder":"0"},{"id":"6","name":"车票","letter":"chepiao","listorder":"0"},{"id":"7","name":"中秋","letter":"zhongqiu","listorder":"0"}]
     * listsize : 4
     */

    private String listsize;
    private List<IdealistEntity> idealist;
    private List<CatlistEntity> catlist;
    private List<TypelistEntity> typelist;
    private List<TagsEntity> tags;

    public void setListsize(String listsize) {
        this.listsize = listsize;
    }

    public void setIdealist(List<IdealistEntity> idealist) {
        this.idealist = idealist;
    }

    public void setCatlist(List<CatlistEntity> catlist) {
        this.catlist = catlist;
    }

    public void setTypelist(List<TypelistEntity> typelist) {
        this.typelist = typelist;
    }

    public void setTags(List<TagsEntity> tags) {
        this.tags = tags;
    }

    public String getListsize() {
        return listsize;
    }

    public List<IdealistEntity> getIdealist() {
        return idealist;
    }

    public List<CatlistEntity> getCatlist() {
        return catlist;
    }

    public List<TypelistEntity> getTypelist() {
        return typelist;
    }

    public List<TagsEntity> getTags() {
        return tags;
    }

    public static class IdealistEntity {
        /**
         * id : 7
         * title : 遇到森系菇凉，就送她这些美物吧
         * fengmian : uploadfiles/image/201508/1.jpg
         * userid : 0
         * nickname :
         * avatar :
         * praisenum : 3
         * commentnum : 0
         * favoritenum : 0
         * hits : 2
         * share : 0
         * keywords : 菇凉
         * gifturl :
         * showgift : 0
         * updatetime : 1440294834
         */

        private String id;
        private String title;
        private String fengmian;
        private String userid;
        private String nickname;
        private String avatar;
        private String praisenum;
        private String commentnum;
        private String favoritenum;
        private String hits;
        private String share;
        private String keywords;
        private String gifturl;
        private String showgift;
        private String updatetime;

        public void setId(String id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setFengmian(String fengmian) {
            this.fengmian = fengmian;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setPraisenum(String praisenum) {
            this.praisenum = praisenum;
        }

        public void setCommentnum(String commentnum) {
            this.commentnum = commentnum;
        }

        public void setFavoritenum(String favoritenum) {
            this.favoritenum = favoritenum;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setGifturl(String gifturl) {
            this.gifturl = gifturl;
        }

        public void setShowgift(String showgift) {
            this.showgift = showgift;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getFengmian() {
            return fengmian;
        }

        public String getUserid() {
            return userid;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getPraisenum() {
            return praisenum;
        }

        public String getCommentnum() {
            return commentnum;
        }

        public String getFavoritenum() {
            return favoritenum;
        }

        public String getHits() {
            return hits;
        }

        public String getShare() {
            return share;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getGifturl() {
            return gifturl;
        }

        public String getShowgift() {
            return showgift;
        }

        public String getUpdatetime() {
            return updatetime;
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

    public static class TypelistEntity {
        /**
         * typeid : 1
         * typename : 情礼情境
         */

        private String typeid;
        private String typename;

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public String getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        @Override
        public String toString() {
            return "TypelistEntity{" +
                    "typeid='" + typeid + '\'' +
                    ", typename='" + typename + '\'' +
                    '}';
        }
    }

    public static class TagsEntity {
        /**
         * id : 1
         * name : 婚纱
         * letter : hunsha
         * listorder : 0
         */

        private String id;
        private String name;
        private String letter;
        private String listorder;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public void setListorder(String listorder) {
            this.listorder = listorder;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLetter() {
            return letter;
        }

        public String getListorder() {
            return listorder;
        }

        @Override
        public String toString() {
            return "TagsEntity{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", letter='" + letter + '\'' +
                    ", listorder='" + listorder + '\'' +
                    '}';
        }
    }
}
