package com.network.good.serviceImpl;

import com.network.good.Enum.UserStateEnum;
import com.network.api.beans.User;
import com.network.good.dto.UpdatePassw;
import com.network.good.dto.UpdateRes;
import com.network.good.service.IUserService;
import com.network.good.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;
    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public boolean deleteById(int id) {
        if(userDao.selectById(id)!=null){
            userDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User searchById(int id, int start, int end) {
        return userDao.searchById(id,start,end);
    }

    @Override
    public int getTotalLines() {
        return userDao.getTotalLines();
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public List<User> selectUsersBypage(int start, int end) {
        return userDao.selectUsersBypage(start,end);
    }

    @Override
    public boolean updateUser(User user) {
        int id=user.getId();
        User user1=userDao.selectById(id);
        if(user1!=null){
            if(user.getSlevelName().equals("")){
                String slevelName=user1.getSlevelName();
                user.setSlevelName(slevelName);
            }
            if(user.getGlevelName().equals("")){
                String glevelName=user1.getGlevelName();
                user.setGlevelName(glevelName);
            }
            userDao.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public int verifyUser(User user) {
        String name=user.getName();
        User user1=userDao.selectByName(name);
        if(user1==null){
            return -1;//代表用户名不存在
        }
        else{
            if(user1.getPassword().equals(user.getPassword())){
                return 0;//代表登陆成功
            }
            else
                return -2;//代表密码不正确
        }
    }

    @Override
    public User message(int id) {
        return userDao.selectById(id);
    }

    @Override
    public UpdateRes updateUserpassw(UpdatePassw updatePassw) {
      String name=updatePassw.getName();
      User user=userDao.selectByName(name);

      if(user==null){
          return new UpdateRes(false,UserStateEnum.Username_ERROR);//用户不存在
      }
      else{
          String oldPassw=updatePassw.getOldpassw();
          if(user.getPassword().equals(oldPassw)){
              String newPassw=updatePassw.getNewpassw();
              String verifyPassw=updatePassw.getVerifypassw();
              if (newPassw.equals(verifyPassw)) {
                  int id=user.getId();
                  userDao.updatePassword(id,newPassw);
                  return new UpdateRes(true,UserStateEnum.SUCCESS);
              }
              else{
                  return new UpdateRes(false,UserStateEnum.VERIFY_ERROP);
              }
          }
          else{
              return new UpdateRes(false,UserStateEnum.Password_ERROR);
          }
      }
    }
}
