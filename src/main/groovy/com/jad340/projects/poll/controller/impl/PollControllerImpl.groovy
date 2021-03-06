package com.jad340.projects.poll.controller.impl

import com.jad340.projects.poll.controller.PollController
import com.jad340.projects.poll.domain.Poll
import com.jad340.projects.poll.domain.Token
import com.jad340.projects.poll.domain.view.TokenString
import com.jad340.projects.poll.service.PollService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class PollControllerImpl implements PollController {

    PollService pollService

    @Autowired
    PollControllerImpl(PollService pollService) {
        this.pollService = pollService
    }

    @RequestMapping(value = "/v1/createPoll", method = RequestMethod.POST)
    ResponseEntity<List<Token>> createPoll(@RequestBody Poll poll) {
        new ResponseEntity<>(pollService.createPoll(poll), HttpStatus.CREATED)
    }

    @RequestMapping(value = "/v1/deletePoll", method = RequestMethod.POST)
    ResponseEntity deletePoll(@RequestBody Token adminToken) {
        pollService.deletePoll(adminToken)
    }

    @RequestMapping(value = "/v1/getPoll", method = RequestMethod.POST)
    ResponseEntity<Poll> getPoll(@RequestBody Token token) {
        pollService.getPoll(token)
    }

    @RequestMapping(value = "/v1/setName", method = RequestMethod.POST)
    ResponseEntity setName(@RequestBody TokenString tokenString) {
        pollService.setName(tokenString.token, tokenString.string)
    }

    @RequestMapping(value = "/v1/setDescription", method = RequestMethod.POST)
    ResponseEntity setDescription(@RequestBody TokenString tokenString) {
        pollService.setDescription(tokenString.token, tokenString.string)
    }
}
