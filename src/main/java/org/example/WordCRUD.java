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
    public void partList() {
        ArrayList<Word> s_list = new ArrayList<>();

        System.out.print("=> 검색할 단어 수준 : ");
        int w_level = s.nextInt();

        int j = 0;

        System.out.println("--------------------------------");
        for(int i = 0; i < w_list.size(); i++){
            if(w_list.get(i).getLevel() == w_level){
                System.out.print((j+1) + " ");
                System.out.println(w_list.get(i).toString());
                s_list.add(w_list.get(i));
                j++;
            }
        }
        System.out.println("--------------------------------");
    }
    public void searchItem() {
        ArrayList<Word> s_list = new ArrayList<>();

        System.out.print("=> 검색할 단어 검색 : ");
        String s_word = s.nextLine();

        int j = 0;

        System.out.println("--------------------------------");
        for(int i = 0; i < w_list.size(); i++){
            if(w_list.get(i).getWord().contains(s_word)){
                System.out.print((j+1) + " ");
                System.out.println(w_list.get(i).toString());
                s_list.add(w_list.get(i));
                j++;
            }
        }
        System.out.println("--------------------------------");
    }
    public void updateItem() {
        ArrayList<Word> s_list = new ArrayList<>();

        System.out.print("=> 수정할 단어 검색 : ");
        String s_word = s.nextLine();

        int j = 0;

        System.out.println("--------------------------------");
        for(int i = 0; i < w_list.size(); i++){
            if(w_list.get(i).getWord().contains(s_word)){
                System.out.print((j+1) + " ");
                System.out.println(w_list.get(i).toString());
                s_list.add(w_list.get(i));
                j++;
            }
        }
        System.out.println("--------------------------------");

        System.out.print("=> 수정할 번호 선택 : ");
        int number = s.nextInt();
        s.nextLine();//버퍼 비우기

        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();

        s_list.get(number-1).setMeaning(meaning);

        System.out.println("단어가 수정되었습니다. ");

    }

    public void deleteItem() {
        ArrayList<Word> s_list = new ArrayList<>();

        System.out.print("=> 삭제할 단어 검색 : ");
        String s_word = s.nextLine();

        int j = 0;

        System.out.println("--------------------------------");
        for(int i = 0; i < w_list.size(); i++){
            if(w_list.get(i).getWord().contains(s_word)){
                System.out.print((j+1) + " ");
                System.out.println(w_list.get(i).toString());
                s_list.add(w_list.get(i));
                j++;
            }
        }
        System.out.println("--------------------------------");

        System.out.print("=> 삭제할 번호 선택 : ");
        int number = s.nextInt();
        s.nextLine();//버퍼 비우기

        System.out.print("=> 정말로 삭제하실래요?(Y/n) : ");
        String ask = s.nextLine();

        if(ask.toLowerCase().equals("y")){
            w_list.remove(s_list.get(number-1));
            System.out.println("단어가 삭제되었습니다. ");
        }
        else{
            System.out.println("취소되었습니다. ");
        }


    }
}
