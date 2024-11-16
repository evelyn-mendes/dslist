package com.evelyn.dslist.controllers;

import com.evelyn.dslist.dto.GameListDTO;
import com.evelyn.dslist.dto.GameMinDTO;
import com.evelyn.dslist.dto.ReplacementDTO;
import com.evelyn.dslist.entities.Game;
import com.evelyn.dslist.services.GameListService;
import com.evelyn.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @Validated @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}