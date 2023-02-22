package br.com.myfirstblog.blog.models.services;

import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myfirstblog.blog.models.entities.User;
import br.com.myfirstblog.blog.models.repositories.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    //CRUD Begin
    public User createUser(User user){
        if(emailExists(user.getEmail())){
            throw new RuntimeException("Email já existente");
        }else{
            return userRepository.save(user);
        }
    }

    public void deleteUser(int id){
        Optional<User> userDOptional = userRepository.findById(id);
        if(userDOptional.isPresent()){
            userDOptional.get().setDeleted(false);
        }else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }
    //CRUD end

    public Boolean emailExists(String email){
        Iterable<User> users = userRepository.findByEmailContainingIgnoreCase(email);
        if(IterableUtils.size(users) == 0){
            return false;
        }
        return true;
    }
    
}
