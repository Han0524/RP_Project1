package org.example;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    Scanner s = new Scanner(System.in);
    ArrayList<Word> w_list;
    Connection conn;

    public WordCRUD(){
        w_list = new ArrayList<>();
        conn = DBConnection.getConnection();
    }

    public void loadData(){

        w_list.clear();

        String selectAll = "select * from dictionary";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectAll);
            while(true){
                if(!rs.next()) break;
                int id = rs.getInt("id");
                int level = rs.getInt("level");
                String word = rs.getString("word");
                String meaning = rs.getString("meaning");
                w_list.add(new Word(id, level, word, meaning));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        loadData();
        System.out.println("--------------------------------");
        for(int i = 0; i < w_list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(w_list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }
    public void partList() {
        ArrayList<Word> s_list = new ArrayList<>();

        System.out.print("레벨(1:초급, 2:중급, 3:고급) 선택 : ");
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

        System.out.print("=> 정말로 삭제하시겠습니까?(Y/n) : ");
        String ask = s.nextLine();

        if(ask.toLowerCase().equals("y")){
            w_list.remove(s_list.get(number-1));
            System.out.println("단어가 삭제되었습니다. ");
        }
        else{
            System.out.println("취소되었습니다. ");
        }


    }

    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("Dictionary.txt"));

            for(Word one : w_list){
                pr.write(one.toFileString() + "\n");
            }

            System.out.println("==> 데이터 저장 완료");
            pr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*public void loadFile() {
        try {
            BufferedReader wr = new BufferedReader(new FileReader("Dictionary.txt"));
            String sen;
            int count = 0;

            while((sen = wr.readLine()) != null){
                String data[] = sen.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];

                w_list.add(new Word(0, level,word,meaning));
                count++;
            }

            System.out.println(count+"개의 데이터 로딩 완료");
            wr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
