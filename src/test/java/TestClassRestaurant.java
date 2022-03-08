import com.cetin.education.spring.primefaces.masterjsf.chapterthree.requestscope.Waiter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-04
 */
public class TestClassRestaurant {
    private static final String TOMATO_SOUP =  "Tomato_Soup";
    private static final String POTATO_SOUP =  "Patato_Soup";
    private EJBContainer container;

    @EJB
    private Waiter joe;

    @Before
    public void startContainer() throws Exception {
        container = EJBContainer.createEJBContainer();
        container.getContext().bind("inject", this);
    }

    @Test
    public void orderSoup(){
        String soup = joe.orderSoup(TOMATO_SOUP);
        assertEquals(TOMATO_SOUP, soup);
        soup = joe.orderSoup(POTATO_SOUP);
        assertEquals(POTATO_SOUP, soup);
    }

    @After
    public void closeContainer() throws Exception {
        container.close();
    }

}
