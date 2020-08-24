package com.socialnet.tshirt.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.socialnet.tshirt.domain.Message;
import com.socialnet.tshirt.domain.Views;
import com.socialnet.tshirt.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    @JsonView(Views.Name.class)
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message elementById(@PathVariable("id") Message message){
        return message;
    }

    @PostMapping
    public Message addElement(@RequestBody Message message){
        message.setCreationDate(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message updateInst(@PathVariable("id") Message messageFromDb,
                              @RequestBody Message messsage){
        BeanUtils.copyProperties(messsage, messageFromDb, "id");
        return messageRepo.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable("id") Message message){
        messageRepo.delete(message);
    }
}
