package com.scut.blockchain;

import com.scut.blockchain.Pojo.Trans;

import java.util.List;

public class Result {
    public Result(int statecode) {
        this.statecode = statecode;
    }

    public int getStatecode() {
        return statecode;
    }

    public void setStatecode(int statecode) {
        this.statecode = statecode;
    }

    public String getScore_number() {
        return score_number;
    }

    public void setScore_number(String score_number) {
        this.score_number = score_number;
    }

    public List<Trans> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<Trans> datalist) {
        this.datalist = datalist;
    }

    private int statecode;
    private String score_number;
    private List<Trans> datalist;
}
