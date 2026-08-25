package com.socops.data;

import java.util.List;

/**
 * Central catalogue of every icebreaker prompt that can appear on a board.
 * Exactly 24 entries — one fewer than the 25-cell grid, because the
 * centre cell is always the free space.
 */
public final class IcebreakerPrompts {

    public static final String FREE_CELL_LABEL = "ESPAÇO LIVRE";

    public static final List<String> ALL_PROMPTS = List.of(
            "tem uma música favorita para cantar junto",
            "já riu tanto que ficou sem fôlego",
            "sabe contar uma piada boa",
            "prefere filme a série",
            "tem um meme para qualquer situação",
            "já dançou em público sem planejar",
            "conhece um jogo de cartas divertido",
            "tem uma recomendação de filme",
            "já inventou um apelido engraçado",
            "sabe fazer uma imitação",
            "tem uma habilidade inútil impressionante",
            "já participou de um karaokê",
            "conhece uma brincadeira de infância",
            "tem uma história engraçada de viagem",
            "já fez alguém rir hoje",
            "mostre uma pose de comemoração",
            "faça uma disputa de pedra, papel e tesoura",
            "ensine um truque de cinco segundos",
            "conte qual seria seu superpoder divertido",
            "invente um nome para esta rodada",
            "encontre alguém com o mesmo gosto musical",
            "descubra o hobby mais inusitado de alguém",
            "forme uma dupla e crie um grito de torcida",
            "escolha uma palavra e faça alguém usá-la numa frase"
    );

    private IcebreakerPrompts() {
        /* catalogue only — no instances */
    }
}
