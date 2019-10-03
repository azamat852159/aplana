package task6;

/*
* Есть входной файл с набором слов, написанных через пробел
* Необходимо:
* Прочитать слова из файла.
* Отсортировать в алфавитном порядке.
* Посчитать сколько раз каждое слово встречается в файле. Вывести статистику на консоль
* Найти слово с максимальным количеством повторений. Вывести на консоль это слово и сколько раз оно встречается в файле
*
* */

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class readFile {
    public static void main(String[] args){
        List<String> list;
        List<hepler> heplerList = new ArrayList<>();
        list =readFile.crateFistFromFile();
        if(list != null){
            heplerList = findTheSame(list);
            deleteTheSame(heplerList);
            hepler MaxHelper = heplerList.stream().max((x,y)->x.getNumberOfRepet()-y.getNumberOfRepet()).get();
            System.out.println("Слово: <" + MaxHelper.getWord()+"> встречается максимальное количество раз/раза: " + MaxHelper.getNumberOfRepet());
        }
    }

    static List<hepler> deleteTheSame(List<hepler> list){
        for (int i = 1; i <list.size() ; i++) {
            if(list.get(i).getWord().equals(list.get(i-1).getWord())){
                list.remove(i);
                --i;
            }
        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.println("Слово: <"+list.get(i).getWord() + "> встречается " + list.get(i).getNumberOfRepet() +" раз/раза");
        }
        return list;
    }

    static List<hepler> findTheSame(List<String> list){
        int i = 1;
        List<hepler> listHelper = new ArrayList<>();
        for (int j = 0; j <list.size() - 1 ; j++) {
            i = 1;
            listHelper.add(new hepler());
            listHelper.get(listHelper.size()-1).setWord(list.get(j));
            for (int k = j + 1; k < list.size() ; k++) {
                if (list.get(j).equals(list.get(k))){
                    i++;
                }
            }
            listHelper.get(listHelper.size()-1).setNumberOfRepet(i);
        }
        return listHelper;
    }

    static List<String> crateFistFromFile(){
        List<String> list;
        try {
            BufferedReader bufferedReader = new BufferedReader( new FileReader("src\\task6\\file.txt"));
            list = Arrays.asList(bufferedReader.readLine().split(" "));
            list = list.stream().sorted().collect(Collectors.toList());
            return list;
        } catch (IOException e) {
            System.out.println("нет файла");
        }
        return null;
    }
}

class hepler{
    private String word;
    private int numberOfRepet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        hepler hepler = (hepler) o;
        return Objects.equals(word, hepler.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNumberOfRepet() {
        return numberOfRepet;
    }

    public void setNumberOfRepet(int numberOfRepet) {
        this.numberOfRepet = numberOfRepet;
    }

    @Override
    public String toString() {
        return "hepler{" +
                "word='" + word + '\'' +
                ", numberOfRepet=" + numberOfRepet +
                '}';
    }
}