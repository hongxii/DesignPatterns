package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :Hongxii
 * @date : 2019/2/15 16:53
 */
public class aaaaaaa {



    public static void main(String[] args) {

        int group = 1;

        List GROUP_NOCHECK = new ArrayList();
        GROUP_NOCHECK.add(1);
        GROUP_NOCHECK.add(3);
        GROUP_NOCHECK.add(5);
        GROUP_NOCHECK.add(8);

        if (GROUP_NOCHECK.contains(group)) {

        } else if (group == 2) {


        } else if (group == 4) {


        } else if (group == 6) {


        } else if (group == 7) {


        }else {

        }

        for (int i = 0; i <10; i++) {
            continue;
        }


        switch (group) {
            case 1:;
            case 2: System.out.println(group);
            case 3: System.out.println(group);
        }




    }
}
