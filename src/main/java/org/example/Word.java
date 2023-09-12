package org.example;

public class Word {
    private int id;//단어의 번호
    private int level;//단어의 레벨(수준)
    private String word;//단어
    private String meaning;//단어의 뜻

    public Word() {
    }
    public Word(int id, int level, String word,String meaning) {
        this.id = id;
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        String s_level = "";

        for (int i = 0; i < level; i++) s_level += "*";
        String str = String.format("%-3s %15s  %s", s_level, word, meaning);

        return str;
    }
    public String toFileString(){
        return this.level+"|"+this.word+"|"+this.meaning;
    }
}
