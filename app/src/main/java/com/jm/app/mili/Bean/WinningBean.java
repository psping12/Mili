package com.jm.app.mili.Bean;

/**
 * Created by Administrator on 2016/5/3.
 */
public class WinningBean {
    private int Imageview;
    private String tv_name, tv_issue, tv_issueNuber, tv_participation, tv_participationNuber, tv_prize_winner, tv_prize_winnerName, tv_in_all, tv_in_allNuber, tv_lucky_number, tv_lucky_numberName, tv_details;


    public WinningBean(int imageview, String tv_name, String tv_issue, String tv_issueNuber, String tv_participation, String tv_participationNuber, String tv_prize_winner, String tv_prize_winnerName, String tv_in_all, String tv_in_allNuber, String tv_lucky_number, String tv_lucky_numberName, String tv_details) {
        Imageview = imageview;
        this.tv_name = tv_name;
        this.tv_issue = tv_issue;
        this.tv_issueNuber = tv_issueNuber;
        this.tv_participation = tv_participation;
        this.tv_participationNuber = tv_participationNuber;
        this.tv_prize_winner = tv_prize_winner;
        this.tv_prize_winnerName = tv_prize_winnerName;
        this.tv_in_all = tv_in_all;
        this.tv_in_allNuber = tv_in_allNuber;
        this.tv_lucky_number = tv_lucky_number;
        this.tv_lucky_numberName = tv_lucky_numberName;
        this.tv_details = tv_details;
    }


    public int getImageview() {
        return Imageview;
    }

    public void setImageview(int imageview) {
        Imageview = imageview;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_issue() {
        return tv_issue;
    }

    public void setTv_issue(String tv_issue) {
        this.tv_issue = tv_issue;
    }

    public String getTv_participation() {
        return tv_participation;
    }

    public void setTv_participation(String tv_participation) {
        this.tv_participation = tv_participation;
    }

    public String getTv_participationNuber() {
        return tv_participationNuber;
    }

    public void setTv_participationNuber(String tv_participationNuber) {
        this.tv_participationNuber = tv_participationNuber;
    }

    public String getTv_prize_winner() {
        return tv_prize_winner;
    }

    public void setTv_prize_winner(String tv_prize_winner) {
        this.tv_prize_winner = tv_prize_winner;
    }

    public String getTv_prize_winnerName() {
        return tv_prize_winnerName;
    }

    public void setTv_prize_winnerName(String tv_prize_winnerName) {
        this.tv_prize_winnerName = tv_prize_winnerName;
    }

    public String getTv_in_all() {
        return tv_in_all;
    }

    public void setTv_in_all(String tv_in_all) {
        this.tv_in_all = tv_in_all;
    }

    public String getTv_in_allNuber() {
        return tv_in_allNuber;
    }

    public void setTv_in_allNuber(String tv_in_allNuber) {
        this.tv_in_allNuber = tv_in_allNuber;
    }

    public String getTv_lucky_number() {
        return tv_lucky_number;
    }

    public void setTv_lucky_number(String tv_lucky_number) {
        this.tv_lucky_number = tv_lucky_number;
    }

    public String getTv_lucky_numberName() {
        return tv_lucky_numberName;
    }

    public void setTv_lucky_numberName(String tv_lucky_numberName) {
        this.tv_lucky_numberName = tv_lucky_numberName;
    }

    public String getTv_details() {
        return tv_details;
    }

    public void setTv_details(String tv_details) {
        this.tv_details = tv_details;
    }
}
