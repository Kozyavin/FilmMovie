import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    @Test
    public void FindAllTest() {
        FilmManager manager = new FilmManager();           //тест метода вывода всего списка фильмов в порядке добавления

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");
        manager.addFilm("Тролли.Мировой тур");
        manager.addFilm("Номер один");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентльмены", "Человек-неведимка", "Тролли.Мировой тур", "Номер один"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FindOneCurrentTest() {
        FilmManager manager = new FilmManager();           //тест метода вывода всего списка фильмов в порядке добавления

        manager.addFilm("Бладшот");


        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test1() {                               //тест метода findLast с конструктором (пустым) и параметром кол-ва фильмов по умолчанию -5
        FilmManager manager = new FilmManager();

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");
        manager.addFilm("Тролли.Мировой тур");
        manager.addFilm("Номер один");

        String[] expected = {"Человек-неведимка", "Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {                               //тест метода findLast с конструктором и параметром limit=4
        FilmManager manager = new FilmManager(4);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");
        manager.addFilm("Тролли.Мировой тур");
        manager.addFilm("Номер один");

        String[] expected = {"Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {                               //тест метода findLast с конструктором и параметром limit=5 (Граничное значение)
        FilmManager manager = new FilmManager(5);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");
        manager.addFilm("Тролли.Мировой тур");
        manager.addFilm("Номер один");

        String[] expected = {"Человек-неведимка", "Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {                               //тест метода findLast с конструктором и параметром limit=6 (Класс эксивалентности выше лимита по умолчанию)
        FilmManager manager = new FilmManager(6);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");
        manager.addFilm("Тролли.Мировой тур");
        manager.addFilm("Номер один");

        String[] expected = {"Тролли.Мировой тур", "Человек-неведимка", "Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test5() {                               //тест метода findLast с конструктором и параметром limit=8. Лимит больше ,чем фильмов
        FilmManager manager = new FilmManager(8);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");
        manager.addFilm("Тролли.Мировой тур");
        manager.addFilm("Номер один");

        String[] expected = {"Номер один", "Тролли.Мировой тур", "Человек-неведимка", "Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test6() {                               //тест метода findLast с конструктором и параметром limit=1.
        FilmManager manager = new FilmManager(1);

        manager.addFilm("Бладшот");


        String[] expected = {"Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}

/*public class FilmBillTest {

    FilmBill unit1 = new FilmBill(3,"Бладшот", "боевик");
    FilmBill unit2 = new FilmBill(3,"Вперёд", "мультфильм");
    FilmBill unit3 = new FilmBill(3,"Отель Белград", "комедия");
    FilmBill unit4 = new FilmBill(3,"Человек-неведимка", "ужасы");
    FilmBill unit5 = new FilmBill(3,"Тролли.Мировой тур", "мультфильм");
    FilmBill unit6 = new FilmBill(3,"Номер один", "комедия");

    @Test
    public void test(){
        FilmRepository repo = new FilmRepository();
        repo.saveFilm(unit1);
        repo.saveFilm(unit2);
        repo.saveFilm(unit3);
        repo.saveFilm(unit4);
        repo.saveFilm(unit5);
        repo.saveFilm(unit6);

        FilmBill[] expected = {unit1,unit2,unit3,unit4,unit5,unit6};
        FilmBill[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);



    }*/
