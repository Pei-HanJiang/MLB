package org.example;

import java.util.*;
import java.lang.*;

import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;


public class Baseball {
    Vector<String> inningA;
    Vector<String> inningB;
    Vector<String> playerA;
    Vector<String> playerB;

    public Baseball(Vector inningA, Vector inningB,Vector PlayerA,Vector PlayerB){
        this.inningA = inningA;
        this.inningB = inningB;
        this.playerA = PlayerA;
        this.playerB = PlayerB;
    }

    private int Sum(Vector<String> vec, int index){
        int temp = 0;
        //有可能加到Ｘ 做例外
        for(int i = 0 ; i < index ; i++){
            if(!((vec.get(i)).equals("X"))) temp += Integer.valueOf(vec.get(i));
        }
        return temp;
    }

    public int score() throws Exception {
        //攻守交換 => 上下半局
        //A先攻, B後攻
        int ScoreA = 0;
        int ScoreB = 0;
        //算九上結束兩隊的分數
        ScoreA = Sum(inningA, 9);
        //九下, 跳過加分
        ScoreB = Sum(inningB, 8);
        //game status
        if(ScoreB > ScoreA){
            if(!(inningB.get(8)).equals("X")){
                throw new Exception("Game suppose to end");
            }else{
                //有X但後面還有比分
                if(inningB.size() > 9){
                    throw new Exception("Game shouldn't continue");
                }
            }
        }else{
            if((inningB.get(8)).equals("X")){
                throw new Exception("Game suppose to continue");
            }
        }
        //score status
        int result1 = Sum(inningA, inningA.size()) - Sum(playerA, playerA.size());
        int result2 = Sum(inningB, inningB.size()) - Sum(playerB, playerB.size());
        if(!(result1 == 0 && result2 == 0)) throw new Exception("Player score different from team score");

        return Sum(inningA, inningA.size()) - Sum(inningB, inningB.size());

    }




}
