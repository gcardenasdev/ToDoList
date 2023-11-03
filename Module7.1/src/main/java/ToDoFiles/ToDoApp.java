package ToDoFiles;

import entity.TodolistitemsEntity;
import jakarta.persistence.*;

import java.util.List;

public class ToDoApp {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");


    static void addListItem(String listItem){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        if(listItem != null) {

            try {
                transaction = entityManager.getTransaction();
                transaction.begin();

                TodolistitemsEntity toDoList = new TodolistitemsEntity();

                toDoList.setListitem(listItem);

                entityManager.persist(toDoList);

                transaction.commit();
            } catch (Exception ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                entityManager.close();
            }

        }
    }

    static void deleteListItem(int itemToDelete){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;


            TodolistitemsEntity toDoList = null;
            try {

                transaction = entityManager.getTransaction();
                transaction.begin();

                toDoList = entityManager.find(TodolistitemsEntity.class, itemToDelete);

                entityManager.remove(toDoList);

                transaction.commit();

            } catch (Exception ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                entityManager.close();
            }

        }



    public static List<TodolistitemsEntity> viewList(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String stQuery = "SELECT e FROM TodolistitemsEntity e WHERE e.listitemId IS NOT NULL";
        TypedQuery<TodolistitemsEntity> tq = entityManager.createQuery(stQuery, TodolistitemsEntity.class);
        List<TodolistitemsEntity> items;
        items = tq.getResultList();

        return items;

    }
}

