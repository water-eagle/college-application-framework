package kr.ac.shingu.appfrm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMsgRepository extends CrudRepository<ChatMsg, Long> {
    
}
