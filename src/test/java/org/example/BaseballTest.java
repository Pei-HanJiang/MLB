package org.example;
import java.util.*;
import java.lang.*;

import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    Vector<String> A = new Vector<String>() {{
        for (int i = 0; i < 9; i++) add("0");
    }};

    Vector<String> B = new Vector<String>() {{
        for (int i = 0; i < 9; i++){
           add(String.valueOf(i));
        }
    }};

    Vector<String> playerA = new Vector<String>() {{
        for (int i = 0; i < 9; i++) add("0");
    }};

    Vector<String> playerB = new Vector<String>() {{
        for (int i = 0; i < 9; i++) add("0");
    }};


    @org.junit.jupiter.api.Test
    void scoreTest1() {
        //test1 九局下該結束卻沒X,拋出例外
        Baseball test1 = new Baseball(A,B,A,B);
        assertThrows(Exception.class, () -> test1.score());

        //test2 九局下半結束，有Ｘ => B贏28分，應回傳-28
        B.set(8, "X");
        try{
            assertEquals( -28 ,test1.score());
        }catch (Exception e){
            System.out.println(e);
        }

        //test3 不應結束但卻有Ｘ
        Baseball test3 = new Baseball(B,A,B,A);
        A.set(8, "X");
        B.set(8, "0");
        assertThrows(Exception.class, () -> test3.score());

        //test4 player的分數與對上得分不一樣
        Baseball test4 = new Baseball(B,A,playerA,playerB);
        assertThrows(Exception.class, ()-> test4.score());

        //test5 player的分數與對上得分一樣
        assertThrows(Exception.class, () -> test1.score());








    }
}