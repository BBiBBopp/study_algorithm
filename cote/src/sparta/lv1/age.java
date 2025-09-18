package sparta.lv1;

import java.time.LocalDate;

public class age {
    public int solution(int age) {
        int yearNow = LocalDate.now().getYear();

        return yearNow - age + 1;
    }

}
