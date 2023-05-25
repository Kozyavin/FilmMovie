import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    //////////////////////////////////////////тестирование метода findAll с пустым конструктором////////////////////////////
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
        FilmManager manager = new FilmManager();       //тест метода вывода всего списка фильмов в порядке добавления, когда всего 1 фильм

        manager.addFilm("Бладшот");


        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //////////////////////////////////////////тестирование метода findLast с пустым конструктором////////////////////////////
    @Test
    public void MoreLimitNullConstructorTest() {     //тест метода findLast с конструктором (пустым). Кол-во фильмов > чем в конструкторе.
        FilmManager manager = new FilmManager();

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");
        manager.addFilm("Тролли.Мировой тур");


        String[] expected = {"Человек-неведимка", "Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void MinLimitNullConstructorTest() {       //тест метода findLast с конструктором (пустым). Кол-во фильмов < чем в конструкторе.
        FilmManager manager = new FilmManager();

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");


        String[] expected = {"Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void OnBoundaryLimitNullConstructorTest() {    //тест метода findLast с конструктором (пустым). Кол-во фильмов = кол-во фильмов в конструкторе
        FilmManager manager = new FilmManager();

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");


        String[] expected = {"Человек-неведимка", "Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void MinFilmsNullConstructorTest() {    //тест метода findLast с конструктором (пустым). Кол-во фильмов = 1
        FilmManager manager = new FilmManager();

        manager.addFilm("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
//////////////////////////////////////////тестирование метода findLast с конструктором, где задаём лимит///////////////////////
    @Test
    public void MoreLimitFindLastTest() {          //тест метода findLast с конструктором и параметром limit=4, а фильмов 5
        FilmManager manager = new FilmManager(4);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-неведимка");


        String[] expected = {"Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MinLimitFindLastTest() {         //тест метода findLast с конструктором и параметром limit=4, а фильмов 3
        FilmManager manager = new FilmManager(4);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");


        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void OnBoundaryLimitFindLastTest() {       //тест метода findLast с конструктором и параметром limit=4, фильмов 4
        FilmManager manager = new FilmManager(4);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель Белград");
        manager.addFilm("Джентльмены");


        String[] expected = {"Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MinFilmsFindLastTest() {         //тест метода findLast с конструктором и параметром limit=1, фильмов 1
        FilmManager manager = new FilmManager(1);

        manager.addFilm("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void NullLimitFindLastTest() {         //тест метода findLast с конструктором и параметром limit=0, фильмов 1
        FilmManager manager = new FilmManager(0);

        manager.addFilm("Бладшот");

        String[] expected = new String[0];
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}

