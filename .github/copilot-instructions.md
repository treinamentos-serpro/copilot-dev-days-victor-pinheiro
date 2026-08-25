# Copilot Instructions

## Projeto

Soc Ops é um bingo social construído com Spring Boot, Thymeleaf e JavaScript sem framework. Preserve a separação entre regras do jogo, controladores e apresentação:

- Mantenha as regras de geração, seleção e vitória em `BoardAssembler`.
- Mantenha os controladores finos e os contratos REST estáveis.
- Mantenha a interação da página em `game.html` e os estilos reutilizáveis em `app.css`.
- Execute `cd socops && ./mvnw test` após alterações de comportamento.

## Guia De Design

A interface do Soc Ops segue uma direção **dark arcade neon**: social, energética e legível durante um evento presencial.

### Linguagem visual

- Use superfícies carvão e quase pretas como base, com textura ou padrões discretos para criar profundidade.
- Use ciano para ações e foco, verde-lima para casas marcadas e âmbar para vitória.
- Evite roxo dominante, gradientes chamativos, cartões aninhados e estética genérica de dashboard.
- Prefira bordas definidas, cantos discretos e brilho controlado; efeitos não devem prejudicar a leitura.
- Reserve tipografia de display para marca, títulos e chamadas. Use uma fonte monoespaçada para labels, status e metadados.
- Defina cores e tipografia com variáveis CSS em `app.css`; evite estilos inline e valores de cor repetidos.

### Composição e conteúdo

- Priorize o fluxo presencial: iniciar rodada, encontrar uma pessoa, marcar uma casa e reconhecer uma vitória.
- Mantenha a grade 5x5 como foco principal da tela de jogo, com dimensões estáveis e sem overflow em telas estreitas.
- Diferencie visualmente estados disponíveis, marcados, espaço livre e sequência vencedora.
- Use texto curto, direto e em português do Brasil na interface visível.
- Preserve os IDs DOM e handlers públicos existentes quando redesenhar componentes controlados pelo JavaScript.

### Interação e acessibilidade

- Use elementos semânticos e botões reais para ações; não substitua comandos por elementos decorativos.
- Todo estado selecionável deve manter `aria-pressed`; o espaço livre deve continuar desabilitado.
- Todo controle precisa de estado `:focus-visible`, contraste suficiente e área de toque confortável.
- Forneça hover e feedback de ação sem depender exclusivamente de cor.
- Respeite `prefers-reduced-motion` e mantenha transições breves e funcionais.
- Garanta que prompts longos quebrem linha sem redimensionar ou deslocar a grade.

### Validação visual

Ao alterar a interface, verifique lobby, rodada ativa, seleção/desseleção, espaço livre, vitória, modal, retorno ao lobby e restauração após reload. Teste também uma viewport mobile, foco por teclado, ausência de overflow horizontal e console sem erros.
