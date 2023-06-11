package com.undecided.projectTemplate.modules.story.appl.command.actor;

import com.undecided.projectTemplate.modules.story.domain.model.actor.Actor;
import org.springframework.stereotype.Service;

@Service
public class RegisterActorCommand {

    public Actor insert(Actor actor) {
        return Actor.empty();
    }
}
