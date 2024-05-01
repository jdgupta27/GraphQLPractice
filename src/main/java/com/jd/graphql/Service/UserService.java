package com.jd.graphql.Service;

import com.jd.graphql.Helper.ExceptionHelper;
import com.jd.graphql.Model.User;
import com.jd.graphql.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    //create user
    public User createUser(User user){
        return userRepo.save(user);
    }

    //get all user
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    // get single user
    public User getUser(int userId){
        return userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }
    // update user
    // delete user
    public boolean deleteUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
