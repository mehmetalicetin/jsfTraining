package com.cetin.education.spring.primefaces.masterjsf.chaptersix;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-31
 */
public class PlayersService {
    @Inject
    private PlayersSessionBean playersSessionBean;
    private PlayersDataModel playersDataModel;
    private String criteria = "all";
    private String copy_criteria = "none";
    private int allRowsCount = 0;
    private int rowsOnPage;


    /*You pass the filter criteria to the EJB component (copy_criteria acts as
        a flag—you don't want to count the number of rows each time the user
        navigates through table pages using the same filter), as shown in the
        following code:
    * */
    private void lazyDataLoading(int first) {
        if (!copy_criteria.equals(criteria)) {
            allRowsCount = playersSessionBean.countPlayersAction(criteria);
            copy_criteria = criteria;
        }
        Set<Players> dataHashSet = playersSessionBean.loadPlayersAction(first, rowsOnPage, criteria);
        playersDataModel = new PlayersDataModel(dataHashSet, allRowsCount, rowsOnPage);
    }
}
