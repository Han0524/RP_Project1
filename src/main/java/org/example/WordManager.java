package org.example;

import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;

    public WordManager() {
        wordCRUD = new WordCRUD();
    }

    public void start(){
        //wordCRUD.loadFile();
        while(true){
            int menu = selectMenu();

            if(menu == 1){
                wordCRUD.listAll();
            }
            else if(menu == 2){
                wordCRUD.partList();
            }
            else if(menu == 3){
                wordCRUD.searchItem();
            }
            else if(menu == 4){
                wordCRUD.addItem();
            }
            else if(menu == 5){//update
                wordCRUD.updateItem();
            }
            else if(menu == 6){//delete
                wordCRUD.deleteItem();
            }
            else if(menu == 7){
                wordCRUD.saveFile();
            }
            else if(menu == 0){
                System.out.println("단어장 프로그램을 종료합니다.");
                break;
            }
        }
    }

    private int selectMenu() {
        System.out.print("*** 영단어 마스터 ***\n" +
                "*********************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n" +
                "*********************\n" +
                "=> 원하는 메뉴는? ");

        return s.nextInt();
    }
}
