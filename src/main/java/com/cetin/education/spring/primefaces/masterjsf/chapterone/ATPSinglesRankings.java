package com.cetin.education.spring.primefaces.masterjsf.chapterone;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-29
 */
public class ATPSinglesRankings {
    public List<String> getSinglesRankings() {
        List<String> atp_ranking= new ArrayList<>();
        atp_ranking.add("1 Nadal, Rafael (ESP)");
        return atp_ranking;
    }

    public List<String> getSinglesRankingsReversed(){
        List<String> atp_ranking= new ArrayList<>();
        atp_ranking.add("5 Del Potro, Juan Martin (ARG)");
        atp_ranking.add("4 Murray, Andy (GBR)");
        return atp_ranking;
    }

    public List<String> getSinglesRankingsUpperCase(){
        List<String> atp_ranking= new ArrayList<>();
        atp_ranking.add("5 Del Potro, Juan Martin (ARG)".toUpperCase());
        atp_ranking.add("4 Murray, Andy (GBR)".toUpperCase());
        return atp_ranking;
    }
}
