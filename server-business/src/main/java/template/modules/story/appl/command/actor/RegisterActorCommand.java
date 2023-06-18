package template.modules.story.appl.command.actor;

import org.springframework.stereotype.Service;
import template.modules.story.domain.model.actor.Actor;

@Service
public class RegisterActorCommand {

    public Actor insert(Actor actor) {
        return Actor.empty();
    }
}
