import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListHandlerTest {

    @Test
    void countList() {
        ListHandler listHandler = new ListHandler();
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        assertEquals(2, listHandler.countList(list));

    }
}