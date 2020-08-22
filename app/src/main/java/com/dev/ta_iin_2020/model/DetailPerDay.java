package com.dev.ta_iin_2020.model;

import java.util.List;

public class DetailPerDay {

    /**
     * status : 200
     * message : Success Fetch Data
     * data : [{"kode_infaq":"U10000","nominal":"10000","banyak":"3","tanggal":"13","bulan":"8","tahun":"2020"},{"kode_infaq":"U5000","nominal":"5000","banyak":"4","tanggal":"13","bulan":"8","tahun":"2020"},{"kode_infaq":"U2000","nominal":"2000","banyak":"3","tanggal":"13","bulan":"8","tahun":"2020"},{"kode_infaq":"U10000","nominal":"10000","banyak":"3","tanggal":"18","bulan":"8","tahun":"2020"},{"kode_infaq":"U5000","nominal":"5000","banyak":"1","tanggal":"18","bulan":"8","tahun":"2020"},{"kode_infaq":"U2000","nominal":"2000","banyak":"1","tanggal":"18","bulan":"8","tahun":"2020"},{"kode_infaq":"U2000","nominal":"2000","banyak":"1","tanggal":"22","bulan":"8","tahun":"2020"},{"kode_infaq":"U10000","nominal":"10000","banyak":"2","tanggal":"22","bulan":"8","tahun":"2020"},{"kode_infaq":"U5000","nominal":"5000","banyak":"2","tanggal":"22","bulan":"8","tahun":"2020"},{"kode_infaq":"U10000","nominal":"10000","banyak":"1","tanggal":"13","bulan":"8","tahun":"2021"}]
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
         * kode_infaq : U10000
         * nominal : 10000
         * banyak : 3
         * tanggal : 13
         * bulan : 8
         * tahun : 2020
         */

        private String kode_infaq;
        private String nominal;
        private String banyak;
        private String tanggal;
        private String bulan;
        private String tahun;

        public String getKode_infaq() {
            return kode_infaq;
        }

        public void setKode_infaq(String kode_infaq) {
            this.kode_infaq = kode_infaq;
        }

        public String getNominal() {
            return nominal;
        }

        public void setNominal(String nominal) {
            this.nominal = nominal;
        }

        public String getBanyak() {
            return banyak;
        }

        public void setBanyak(String banyak) {
            this.banyak = banyak;
        }

        public String getTanggal() {
            return tanggal;
        }

        public void setTanggal(String tanggal) {
            this.tanggal = tanggal;
        }

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
    }
}
