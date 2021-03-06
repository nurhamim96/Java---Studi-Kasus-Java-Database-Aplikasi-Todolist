package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

import javax.sql.DataSource;

public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodolistRepository todolistRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        Todolist todo = new Todolist();
        todo.setTodo("Test");

        todolistRepository.add(todo);
    }

    @Test
    void testGetAll() {
        todolistRepository.add(new Todolist("Ibad"));
        todolistRepository.add(new Todolist("Nurhamim"));

        Todolist[] todolists = todolistRepository.getAll();
        for (var todo : todolists) {
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }
    }

    @Test
    void testRemove() {
        System.out.println(todolistRepository.remove(1));
        System.out.println(todolistRepository.remove(2));
        System.out.println(todolistRepository.remove(3 ));
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
