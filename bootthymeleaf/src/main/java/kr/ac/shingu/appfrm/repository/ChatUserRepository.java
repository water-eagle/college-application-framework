package kr.ac.shingu.appfrm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChatUserRepository extends CrudRepository<ChatUser, String> {
    public List<ChatUser> findAllChatUser();
}
