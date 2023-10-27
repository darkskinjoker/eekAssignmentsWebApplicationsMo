package ee.mainor.moGame.web;

import ee.mainor.moGame.dto.MoCreateGameRequest;
import ee.mainor.moGame.dto.MoGameResponse;
import ee.mainor.moGame.service.MoGuessingGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class MoGuessingGameController {

    private final MoGuessingGameService guessingGameService;

    @PostMapping
    public Integer createGame(@RequestBody MoCreateGameRequest gameCreateRequest) {
        return guessingGameService.createGame(gameCreateRequest);
    }

    @GetMapping("{gameId}/guess/{number}")
    public MoGameResponse guess(@PathVariable Integer gameId, @PathVariable Integer number) {
        return guessingGameService.guessNumber(gameId, number);
    }


}