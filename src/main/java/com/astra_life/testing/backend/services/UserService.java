package com.astra_life.testing.backend.services;

import com.astra_life.testing.backend.dtos.UserDto;
import com.astra_life.testing.backend.models.UserModel;
import com.astra_life.testing.backend.repositories.UserRepo;
import com.astra_life.testing.backend.tools.CommonTools;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public Map<String, Object> createData(UserDto request) {
        Map<String, Object> res = new HashMap<>();
        try {
            UserModel model = new UserModel();
            BeanUtils.copyProperties(request, model, "user_id");
            model.setCreated(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Date())));
            userRepo.save(model);
            res.put("data", ResponseEntity.status(HttpStatus.OK).body(userRepo.save(model)));
            return res;
        } catch (Exception e) {
            res.put("message", ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
            return res;
        }
    }

    public Map<String, Object> readData(Pageable page) {
        Map<String, Object> res = new HashMap<>();
        try {
            Page<UserModel> models = userRepo.findAll(page);
            List<UserDto> returner = new ArrayList<>();
            for (UserModel model : models) {
                UserDto dto = new UserDto();
                BeanUtils.copyProperties(model, dto);
                returner.add(dto);
            }
            res.put("data", ResponseEntity.status(HttpStatus.OK).body(models));
            return res;

        } catch (Exception e) {
            res.put("message", ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
            return res;
        }
    }

    public Map<String, Object> findDataById(UserModel model) {
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", ResponseEntity.status(HttpStatus.OK).body(model));
            return res;
        } catch (Exception e) {
            res.put("message", ResponseEntity.notFound().build());
            return res;
        }
    }

    public Map<String, Object> deleteData(UserModel model) {
        Map<String, Object> res = new HashMap<>();
        try {
            userRepo.delete(model);
            res.put("data", ResponseEntity.status(HttpStatus.OK).body(model));
            return res;

        } catch (Exception e) {
            res.put("message", ResponseEntity.notFound().build());
            return res;
        }
    }

    public Map<String, Object> updateData(UserModel model, UserDto request) {
        Map<String, Object> res = new HashMap<>();
        try {
            BeanUtils.copyProperties(request, model, "user_id");
            model.setCreated(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Date())));
            userRepo.save(model);
            res.put("data", ResponseEntity.status(HttpStatus.OK).body(userRepo.save(model)));
            return res;
        } catch (Exception e) {
            res.put("message", ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
            return res;
        }
    }
}
