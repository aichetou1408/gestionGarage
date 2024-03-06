package smart.projet.GestionGarage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.projet.GestionGarage.dao.UserRepository;
import smart.projet.GestionGarage.entity.UserEntity;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity creaUserEntity(UserEntity userEntity){
        return userRepository.save(userEntity); 
    }
    public UserEntity updateUserEntity(UserEntity userEntity, Long id){
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            var newCompany = optionalUserEntity.get();
            newCompany.setUsername(userEntity.getUsername());
            newCompany.setPassword(userEntity.getPassword());
        }

        return null;

    } 
    
}
