package br.com.myfirstblog.blog.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.myfirstblog.blog.models.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    public Iterable<User> findByEmailContainingIgnoreCase(String email);
}
