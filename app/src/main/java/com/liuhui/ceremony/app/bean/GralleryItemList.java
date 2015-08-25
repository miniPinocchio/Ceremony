package com.liuhui.ceremony.app.bean;

import java.util.List;

/**
 * 相册列表Bean
 * Created by anany on 15/8/24.
 */
public class GralleryItemList {

    /**
     * list : [{"id":"2","addtime":"1439543557","desc":"美美的晒一下","userid":"1","fengmian":"uploadfiles/album/01/a001.jpg","imgurl":["uploadfiles/album/01/a002.jpg","uploadfiles/album/01/a003.jpg","uploadfiles/album/01/a004.jpg"]}]
     */
    private List<ListEntity> list;

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class ListEntity {
        /**
         * id : 2
         * addtime : 1439543557
         * desc : 美美的晒一下
         * userid : 1
         * fengmian : uploadfiles/album/01/a001.jpg
         * imgurl : ["uploadfiles/album/01/a002.jpg","uploadfiles/album/01/a003.jpg","uploadfiles/album/01/a004.jpg"]
         */
        private String id;
        private String addtime;
        private String desc;
        private String userid;
        private String fengmian;
        private List<String> imgurl;

        public void setId(String id) {
            this.id = id;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setFengmian(String fengmian) {
            this.fengmian = fengmian;
        }

        public void setImgurl(List<String> imgurl) {
            this.imgurl = imgurl;
        }

        public String getId() {
            return id;
        }

        public String getAddtime() {
            return addtime;
        }

        public String getDesc() {
            return desc;
        }

        public String getUserid() {
            return userid;
        }

        public String getFengmian() {
            return fengmian;
        }

        public List<String> getImgurl() {
            return imgurl;
        }
    }
}
