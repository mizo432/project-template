package com.undecided.projectTemplate.resource.buisiness.command.actor;

import com.undecided.projectTemplate.resource.domain.actor.Actor;
import org.springframework.stereotype.Service;

@Service
public class RegisterActorCommand {

    public Actor insert(Actor actor) {
        return Actor.empty();
    }
}
