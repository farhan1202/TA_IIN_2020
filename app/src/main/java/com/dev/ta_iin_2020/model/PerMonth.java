package com.dev.ta_iin_2020.model;

import java.util.List;

public class PerMonth {

    /**
     * status : 200
     * message : Success Fetch Data
     * data : [{"bulan":"8","tahun":"2020","total":"56000"},{"bulan":"8","tahun":"2021","total":"10000"}]
     */

    private String status;
    private String message;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bulan : 8
         * tahun : 2020
         * total : 56000
         */

        private String bulan;
        private String tahun;
        private String total;

        public String getBulan() {
            return bulan;
        }

        public void setBulan(String bulan) {
            this.bulan = bulan;
        }

        public String getTahun() {
            return tahun;
        }

        public void setTahun(String tahun) {
            this.tahun = tahun;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }
}
