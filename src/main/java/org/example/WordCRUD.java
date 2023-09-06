package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    Scanner s = new Scanner(System.in);
    ArrayList<Word> w_list;

    public WordCRUD(){
        w_list = new ArrayList<>();
    }

    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    public void addItem() {
        Word tmp = (Word)add();
        w_list.add(tmp);
        System.out.println("새 단어가 단어장에 추가되었습니다. ");
    }

    public void listAll() {
        System.out.println("--------------------------------");
        for(int i = 0; i < w_list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(w_list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }
}
