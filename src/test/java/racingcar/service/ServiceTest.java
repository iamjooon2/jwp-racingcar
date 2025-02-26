package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import racingcar.dto.ResultDTO;
import racingcar.dto.request.RacingGameRequest;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTest {

    @Autowired
    private RacingCarService racingCarService;

    @Test
    void 이름과_시도횟수를_받아_우승자와_결과를_반환한다() {
        //given
        final RacingGameRequest racingGameRequest = new RacingGameRequest("jayon,gavi,huchu", 10);

        //when
        final ResultDTO result = racingCarService.play(List.of("jayon", "gavi", "huchu"), 10);

        //then
        assertAll(
                () -> assertThat(result.getWinners()).isNotEmpty(),
                () -> assertThat(result.getCarDTOs()).hasSize(3)
        );
    }
}
