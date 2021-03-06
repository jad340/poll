package com.jad340.projects.poll.controller

import com.jad340.projects.poll.domain.Poll
import com.jad340.projects.poll.domain.Token
import com.jad340.projects.poll.domain.view.TokenString
import org.springframework.http.ResponseEntity

interface PollController {

    ResponseEntity<List<Token>> createPoll(Poll poll)

    ResponseEntity deletePoll(Token adminToken)

    ResponseEntity<Poll> getPoll(Token token)

    ResponseEntity setName(TokenString tokenString)

    ResponseEntity setDescription(TokenString tokenString)
}