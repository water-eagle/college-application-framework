package kr.ac.shingu.appfrm.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_msg")
public class ChatMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "msg_id", nullable = false)
    private Long msgId;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "chat_content", nullable = false)
    private String chatContent;

    @Column(name = "chat_cre_time", nullable = false)
    private LocalDateTime chatCreTime;

    public ChatMsg() {}

    public ChatMsg(long msgId, String nickname, String chatContent, LocalDateTime chatCreTime) {
        super();
        this.msgId = msgId;
        this.nickname = nickname;
        this.chatContent = chatContent;
        this.chatCreTime = chatCreTime;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public LocalDateTime getChatCreTime() {
        return chatCreTime;
    }

    public void setChatCreTime(LocalDateTime chatCreTime) {
        this.chatCreTime = chatCreTime;
    }

    @Override
    public String toString() {
        return "ChatMsg [msgId=" + msgId + ", nickname=" + nickname + ", chatContent=" + chatContent + ", chatCreTime="
                + chatCreTime + "]";
    }
}
