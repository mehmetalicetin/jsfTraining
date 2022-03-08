package com.cetin.education.spring.primefaces.masterjsf.chaptersix;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.CollectionDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-26
 */
@Named(value = "playersDT")
@ViewScoped
@Data
public class PlayersBean implements Serializable {
    List<Players> data = new ArrayList<>();
    final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    String sortType = "asc";

    int selectedPlayerKey;

    //Collection
    List<Players> dataArrayList = new ArrayList<>();

    List<Players> dataLinkedList = new LinkedList<>();

    Set<Players> dataHashSet = new HashSet<>();

    Set<Players> dataTreeSet = new TreeSet<>();

    Set<Players> dataLinkedHashSet = new LinkedHashSet<>();

    Map<Integer, Players> dataMap = new HashMap<>();

    Map<Integer, Players> dataLinkedHashMap = new LinkedHashMap<>();

    Map<Integer, Players> dataTreeMap = new TreeMap<>();

    private SortDataModel<Players> sortDataModel;

    Map<Players, Set<Trophies>> dataHashMap = new HashMap<>();

    HtmlDataTable table = new HtmlDataTable();

    int rowsOnPage = 1 ;

    private String criteria;

    //filtering table by css
//    public void addTableFilter() {
//        if (!criteria.equals("all")) {
//            String c = "";
//            for (int i = 0; i < table.getRowCount(); i++) {
//                table.setRowIndex(i);
//                Players player = (Players) table.getRowData();
//                if (criteria.equals("<26")) {
//                    if (player.getAge() >= 26) {
//                        c = c + "rowhide,";
//                    } else {
//                        c = c + "rowshow,";
//                    }
//                }
//                if (criteria.equals(">=26")) {
//                    if (player.getAge() < 26) {
//                        c = c + "rowhide,";
//                    } else {
//                        c = c + "rowshow,";
//                    }
//                }
//            }
//            String css = "rowshow";
//            if (!c.isEmpty()) {
//                css = c.substring(0, c.length() - 1);
//            }
//            rowsOnPage = table.getRowCount();
//            table.setRowClasses(css);
//            table.setFirst(0);
//        } else {
//            removeTableFilter();
//        }
//    }
//
//    public void removeTableFilter() {
//        String css = "rowshow";
//        rowsOnPage = 1; //any constant in [1, rowCount]
//        table.setRowClasses(css);
//        table.setFirst(0);
//    }

    public void addTableFilter() {
        initHashSet();
        Iterator<Players> i = dataHashSet.iterator();
        while (i.hasNext()) {
            Players player = i.next();
            if (criteria.equals("<26")) {
                if (player.getAge() >= 26) {
                    i.remove();
                }
            }
            if (criteria.equals(">=26")) {
                if (player.getAge() < 26) {
                    i.remove();
                }
            }
        }
        table.setFirst(0);
    }

    private void initHashSet() {
        try {
            final Players NOVAK_DJOKOVIC = new Players(1, "NOVAK DJOKOVIC", (byte) 26, "Belgrade, Serbia", "Monte Carlo, Monaco",
                    (short) 188, (byte) 80, "Boris Becker, Marian Vajda", sdf.parse("22.05.1987"), 2);
            final Players RAFAEL_NADAL = new Players(2, "RAFAEL NADAL", (byte) 27, "Manacor, Mallorca, Spain", "Manacor, Mallorca, Spain",
                    (short) 185, (byte) 85, "Toni Nadal", sdf.parse("03.06.1986"), 1);
            final Players TOMAS_BERDYCH = new Players(3, "TOMAS BERDYCH", (byte) 28, "Valasske Mezirici, Czech", "Monte Carlo, Monaco",
                    (short) 196, (byte) 91, "Tomas Krupa", sdf.parse("17.09.1985"), 7);
            dataHashSet.add(NOVAK_DJOKOVIC);
            dataHashSet.add(RAFAEL_NADAL);
            dataHashSet.add(TOMAS_BERDYCH);
        } catch(ParseException e){
            e.printStackTrace();
        }
    }

    public void goToFirstPage() {
        table.setFirst(0);
    }

    public void goToNextPage() {
        table.setFirst(table.getFirst() + table.getRows());
    }

    public void goToPreviousPage() {
        table.setFirst(table.getFirst() - table.getRows());
    }

    public void goToLastPage() {
        int totalRows = table.getRowCount();
        int displayRows = table.getRows();
        int full = totalRows / displayRows;
        int modulo = totalRows % displayRows;
        if (modulo > 0) {
            table.setFirst(full * displayRows);
        } else {
            table.setFirst((full - 1) * displayRows);
        }
    }

    public PlayersBean() {
    }

    @PostConstruct
    private void init() {
        try {
            final Players NOVAK_DJOKOVIC = new Players(1,"NOVAK DJOKOVIC", (byte) 26, "Belgrade, Serbia", "Monte Carlo, Monaco",
                    (short) 188, (byte) 80, "Boris Becker, Marian Vajda", sdf.parse("22.05.1987"), 2);
            final Players RAFAEL_NADAL = new Players(2,"RAFAEL NADAL", (byte) 27, "Manacor, Mallorca, Spain", "Manacor, Mallorca, Spain",
                    (short) 185, (byte) 85, "Toni Nadal", sdf.parse("03.06.1986"), 1);
            final Players TOMAS_BERDYCH = new Players(3,"TOMAS BERDYCH", (byte) 28, "Valasske Mezirici, Czech", "Monte Carlo, Monaco",
                    (short) 196, (byte) 91, "Tomas Krupa", sdf.parse("17.09.1985"), 7);
            data.add(NOVAK_DJOKOVIC);
            data.add(RAFAEL_NADAL);
            data.add(TOMAS_BERDYCH);
            dataHashSet.add(NOVAK_DJOKOVIC);
            dataHashSet.add(RAFAEL_NADAL);
            dataHashSet.add(TOMAS_BERDYCH);
            dataMap.put(1, NOVAK_DJOKOVIC);
            dataMap.put(2,RAFAEL_NADAL);
            dataMap.put(3,TOMAS_BERDYCH);
           // sortDataModel = new SortDataModel<>(new CollectionDataModel<>(dataHashSet));

            Set<Trophies> t1 = new HashSet<>();
            t1.add(new Trophies("Beijing"));
            t1.add(new Trophies("Dubai"));
            t1.add(new Trophies("Istanbul"));
            dataHashMap.put(NOVAK_DJOKOVIC, t1);


        } catch (ParseException ex) {
            Logger.getLogger(PlayersBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Players> getPlayers(){
        return dataMap.values().stream().collect(Collectors.toList());
    }

    public void sortDataByName(final String dir) {
        Collections.sort(data, (one, two) -> {
            if (dir.equals("asc"))
                return one.getPlayer().compareTo(two.getPlayer());
            else
                return two.getPlayer().compareTo(one.getPlayer());
        });
    }

    public void sortDataByRanking() {
        Collections.sort(data, (one, two) -> {
            if (sortType.equals("asc"))
                return one.getRanking() - two.getRanking();
            else
                return -1 * (one.getRanking() - two.getRanking());
        });
        sortType = sortType.equals("asc") ? "dsc" : "asc";
    }

    public void sortDataByDate(final String dir) {
        Collections.sort(data, (one, two) -> {
            if (dir.equals("asc")) {
                return one.getBorn().compareTo(two.getBorn());
            } else {
                return two.getBorn().compareTo(one.getBorn());
            }
        });
    }

    public void delete(Players players) {
        if (players != null && data.contains(players))
            data.remove(players);
    }

    public void edit(Players players) {
        if (players != null && data.contains(players))
            players.setEdited(true);
    }

    public void save(Players players) {
        if(players != null){
            Optional<Players> players1 = data.stream().filter(x->x.getRanking() == players.getRanking()).findAny();
            players1.ifPresent(x->{
                x.setPlayer(players.getPlayer());
            });
            players.setEdited(false);
        }
    }

    public void showSelectedPlayer(){
        final Optional<Players> players = data.stream().filter(x -> x.getKey() == selectedPlayerKey).findAny();
        players.ifPresent(x-> System.out.println("Selected Player Key "+ x));
    }
}
