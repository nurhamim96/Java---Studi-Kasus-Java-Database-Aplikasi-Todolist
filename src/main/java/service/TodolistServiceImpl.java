package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        Todolist[] model = todolistRepository.getAll();

        System.out.println("TODOLIST");
        for (var todolist : model) {
            System.out.println(todolist.getId() + " . " + todolist.getTodo());
        }
    }

    @Override
    public void addTodolist(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success) {
            System.out.println("SUKSES MENGHAPUS TODO : " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS TODO : " + number);
        }
    }
}
