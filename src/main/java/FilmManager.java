public class FilmManager {
    private String[] items = new String[0];
    private int limit;

    public FilmManager() {              //Пустой конструктор
        this.limit = 5;
    }

    public FilmManager(int limit) {     //Конструктор
        this.limit = limit;
    }

    public void addFilm(String item) {                  //метод добавления фильмов
        String[] tmp = new String[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;//в последнюю ячейку
        items = tmp;//запомнить в поле массив
    }

    public String[] findAll() {                        //метод показа добавленных фильмов
        return items;
    }

    public String[] findLast() {                      //метод показа фильмов с конца, кол-во задаётся
        int resultLength;//кол-во выводимых фильмов
        if (items.length < limit) {
            resultLength = items.length;
        } else {
            resultLength = limit;
        }
        String[] last = new String[resultLength];
        for (int i = 0; i < last.length; i++) {
            last[i] = items[items.length - 1 - i];  //запись по мере заполнеия массива в обратном относительно пополнения порядке
        }
        return last;
    }
}
