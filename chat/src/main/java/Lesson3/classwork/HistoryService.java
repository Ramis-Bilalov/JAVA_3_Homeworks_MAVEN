package Lesson3.classwork;

import java.util.List;

public interface HistoryService {

    List<String> getHistory();

    List<String> getHistory(int limit);

    void saveHistory(List<String> History);

}
