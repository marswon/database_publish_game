package cn.sdu.online.findteam.aliwukong.imkit.business;

import com.alibaba.wukong.im.Message;

import cn.sdu.online.findteam.aliwukong.imkit.chat.model.ChatMessage;
import cn.sdu.online.findteam.aliwukong.imkit.chat.model.ImageReceiveMessage;
import cn.sdu.online.findteam.aliwukong.imkit.chat.model.ImageSendMessage;
import cn.sdu.online.findteam.aliwukong.imkit.chat.model.SysmsgMessage;
import cn.sdu.online.findteam.share.DemoUtil;

/**
 * Created by wn on 2015/8/14.
 */
public class ImageMessageCreator {
    public ChatMessage onCreate(Message message) {
        ChatMessage chatMessage = null;
        if(Message.CreatorType.SELF == message.creatorType()){
            if (message.senderId() == DemoUtil.currentOpenId()) {
                chatMessage=new ImageSendMessage();
            }else {
                chatMessage = new ImageReceiveMessage();
            }
        }else if(Message.CreatorType.SYSTEM == message.creatorType()){
            chatMessage = new SysmsgMessage();
        }

        chatMessage.setMessage(message);
        return chatMessage;
    }
}
