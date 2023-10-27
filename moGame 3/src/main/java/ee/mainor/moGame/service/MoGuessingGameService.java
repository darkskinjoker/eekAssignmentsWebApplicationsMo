package ee.mainor.moGame.service;

import ee.mainor.moGame.dto.MoCreateGameRequest;
import ee.mainor.moGame.dto.MoGameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MoGuessingGameService {

    private Map<Integer, Integer> games = new HashMap<>();
    private Random random = new Random();

    public Integer createGame(MoCreateGameRequest gameCreateRequest) {
        Integer id = random.nextInt();
        games.put(id, gameCreateRequest.getCorrectAnswer());
        return id;
    }

    public MoGameResponse guessNumber(Integer gameId, Integer guessableNumber) {
        Integer correctAnswer = games.get(gameId);
        MoGameResponse gameResponse = new MoGameResponse();
        if (guessableNumber.equals(correctAnswer)) {
            gameResponse.setText("Winner");
        } else {
            gameResponse.setText("loser");
        }

        return gameResponse;
    }

}