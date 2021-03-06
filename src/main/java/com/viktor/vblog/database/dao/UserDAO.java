package com.viktor.vblog.database.dao;

import com.viktor.vblog.database.entity.Role;
import com.viktor.vblog.database.entity.User;
import com.viktor.vblog.util.HibernateUtil;
import com.viktor.vblog.util.SetUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDAO extends AbstractDAO<User> {

    public UserDAO() {
        super(User.class);
    }

    public User findByUsername(final String username) {
        final String QUERY = "select u from User u where u.username = :username";
        User user = null;
        Transaction transaction;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.createQuery(QUERY, User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            return null;
        }
        return user;
    }


    public List<User> findByRole(final Role role) {
        final Set<Role> roles = new HashSet<>();
        roles.add(role);
        return findByRoleList(roles);
    }

    public List<User> findByRoleName(final String roleName) {
        final Set<Role> roles = new HashSet<>();
        Role role = new RoleDAO().findByName(roleName);
        if (role != null) {
            roles.add(role);
        }
        return findByRoleList(roles);
    }

    public List<User> findByRoleList(final Set<Role> roles) {
        // Screw you JPA
        List<User> users = findAll();
        return users.stream().filter(u -> SetUtil.inter(u.getRoles(), roles).size() > 0).collect(Collectors.toList());
    }
}