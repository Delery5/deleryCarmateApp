package com.delerycarmate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    // The SessionFactory is injected by Spring
    @Autowired
    private SessionFactory sessionFactory;

    // Gets the current Hibernate session
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    // Persist (save) an entity to the database
    public void persist(Object entity) {
        getSession().persist(entity);
    }

    // Delete an entity from the database
    public void delete(Object entity) {
        getSession().delete(entity);
    }
}

/*
Explanation of the SessionFactory:

The SessionFactory is a crucial component in Hibernate, serving as a factory for Session objects. It is a heavyweight object that is created once and typically shared across the application.
The SessionFactory is responsible for creating and managing the lifecycle of Session instances, which are lightweight and used to interact with the database.

Key Points about SessionFactory:
1. Configuration: The SessionFactory is configured with database connection settings, entity mappings, and other properties required by Hibernate. This configuration is typically done once at application startup.
2. Thread-Safety: The SessionFactory is designed to be thread-safe and is typically instantiated once and used throughout the application.
3. Session Creation: The primary role of the SessionFactory is to create Session objects. These Session objects are used to perform CRUD (Create, Read, Update, Delete) operations on the database.
4. Resource Management: The SessionFactory manages the lifecycle of Sessions and ensures that resources like database connections are efficiently utilized.

In this AbstractDao class, the SessionFactory is injected by Spring, and it is used to obtain the current Session (bound to the current transaction context). This Session is then used to perform persistence operations like saving and deleting entities.
*/

