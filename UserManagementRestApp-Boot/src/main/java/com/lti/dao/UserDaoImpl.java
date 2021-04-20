package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Address;
import com.lti.model.User;
@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	EntityManager em;
	
	
	@Transactional
	public User addOrUpdateUser(User user) {
		User u=em.merge(user);
		return u;
	}

	public User findUserById(int userId) {
		return em.find(User.class, userId);
	}

	public List<User> viewAllUsers() {
		String jpql = "select u from User u";
		Query query = em.createQuery(jpql);
		List<User> users = query.getResultList();

		return users;
	}

	public boolean isValidUser(int userId, String userPassword) {
		User user = em.find(User.class, userId);

		if (user == null) {
			return false;
		}
		if (user.getUserPassword().equals(userPassword)) {
			return true;
		} else {
			return false;
		}
	}
	@Transactional
	public Address addOrUpdateAddressOfAUser(Address address, int userId) {
		User user = findUserById(userId);
        if (user != null) {
            address.setUser(user);
            Address persistedAddress = em.merge(address);
            return persistedAddress;
        }
        return null;
	}

	public Address findAddressById(int addressId) {
		return em.find(Address.class, addressId);
	}

	public Address findAddressByUserId(int userId) {
		 User usr= findUserById(userId);
	        return usr.getAddress();
	}
	@Transactional
	public String updateUserPhone(String userPhone, int userId) {
		//String sql="update tbl_usr set userphone=8767501518 where userid=1002"
				String jpql="update User u set u.userPhone=:up where u.userId=:uid";
				Query query=em.createQuery(jpql);
				query.setParameter("up", userPhone);
				query.setParameter("uid", userId);
				int updatedRows=query.executeUpdate();
				if(updatedRows>0)
					return "Mobile no updated";
				return "update failed";	
			}
}


