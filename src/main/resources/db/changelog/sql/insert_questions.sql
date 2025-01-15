-- Truncando tabelas
TRUNCATE TABLE public.incorrect_answer CASCADE;
TRUNCATE TABLE public.question CASCADE;
TRUNCATE TABLE public.category CASCADE;
TRUNCATE TABLE public.discipline CASCADE;

INSERT INTO public.discipline (id, last_change_date, creation_date, remove_date, "name")
VALUES (2, NULL, now(), NULL, 'ANALISTA - SFN - 2014');
INSERT INTO public.discipline (id, last_change_date, creation_date, remove_date, "name")
VALUES (1, NULL, now(), NULL, 'ANALISTA - GESTAO - 2014');

-- Inserts para a tabela public.category

-- Módulos
INSERT INTO public.category (discipline_id, id, creation_date, "name") VALUES (1, 1, now(), 'MÓDULO I – SISTEMA FINANCEIRO NACIONAL');
INSERT INTO public.category (discipline_id, id, creation_date, "name") VALUES (1, 2, now(), 'MÓDULO II – ATUAÇÃO DO BANCO CENTRAL DO BRASIL');

-- Unidades do Módulo I
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 3, now(), 'UNIDADE 1 – EVOLUÇÃO DO SFN. ÓRGÃOS NORMATIVOS E  ENTIDADES SUPERVISORAS', 1);
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 4, now(), 'UNIDADE 2 – ENTIDADES OPERADORAS', 1);
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 5, now(), 'UNIDADE 3 – OUTROS PARTICIPANTES E TEMAS RELEVANTES NO SFN', 1);
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 6, now(), 'UNIDADE 4 – EXECUTOR DAS POLÍTICAS MONETÁRIA E CAMBIAL E AUTONOMIA DOS BANCOS CENTRAIS E DO BANCO CENTRAL DO BRASIL', 1);

-- Unidades do Módulo II
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 7, now(), 'UNIDADE 1 – ORIGENS DOS BANCOS CENTRAIS; HISTÓRIA DO BANCO CENTRAL DO BRASIL;', 2);
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 8, now(), 'UNIDADE 2 – FUNÇÃO DO BANCO CENTRAL DO BRASIL COMO BANCO DOS BANCOS', 2);
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 9, now(), 'UNIDADE 3 – FUNÇÃO DO BANCO CENTRAL DO BRASIL COMO SUPERVISOR E FISCALIZADOR DO SFN', 2);
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 10, now(), 'UNIDADE 4 – EXECUTOR DAS POLÍTICAS MONETÁRIA E CAMBIAL E AUTONOMIA DOS BANCOS CENTRAIS E DO BANCO CENTRAL DO BRASIL', 2);
INSERT INTO public.category (discipline_id, id, creation_date, "name", parent_category_id) VALUES (1, 11, now(), 'UNIDADE 5 – MODELOS DE BANCOS CENTRAIS EM OUTROS PAÍSES E ORGANISMOS E INSTITUIÇÕES FINANCEIRAS INTERNACIONAIS', 2);



-- Inserts para a tabela public.question - Módulo I

-- Unidade 1 - EVOLUÇÃO DO SFN. ÓRGÃOS NORMATIVOS E ENTIDADES SUPERVISORAS (category_id = 3)
INSERT INTO public.question (type, id, creation_date, category_id, difficulty, explanation, question, correct_answer_boolean) VALUES
('BOOLEAN', 1, now(), 3, 'MEDIUM', 'No sistema de cartas patentes, o CMN estabelecia um limite máximo para o número de instituições financeiras, e o ingresso dependia da aquisição de pontos existentes [1].', 'No sistema de cartas patentes, o CMN fixava um quantitativo máximo de instituições financeiras, e o ingresso no sistema dependia da aquisição dos pontos existentes.', true),
('BOOLEAN', 2, now(), 3, 'MEDIUM', 'A Constituição Federal de 1988 não alterou a forma de entrada de instituições no SFN [1].', 'A Constituição Federal de 1988 não trouxe mudanças significativas para o funcionamento do SFN.', false),
('BOOLEAN', 3, now(), 3, 'MEDIUM', 'Até 1988, o ingresso no SFN dependia da aquisição de pontos existentes para o tipo de instituição desejada, além de outros critérios [1].', 'Até a promulgação da Constituição Federal de 1988, o ingresso no SFN era livre e dependia apenas da aprovação do Banco Central.', false),
('BOOLEAN', 4, now(), 3, 'MEDIUM', 'O texto de apoio cita a obra "Economia Monetária" de Lopes e Rossetti como fonte de referência para a evolução histórica do SFN [2].', 'A principal fonte de referência para a evolução histórica do SFN, segundo o texto, foi a obra "Economia Monetária" de Lopes e Rossetti.', true),
('BOOLEAN', 5, now(), 3, 'MEDIUM', 'A obra de Lopes e Rossetti, "Economia Monetária", foi editada e atualizada para incorporar as últimas alterações normativas até dezembro de 2013 [2].', 'O texto original da obra "Economia Monetária" de Lopes e Rossetti não sofreu edições ou atualizações para este material.', false);

-- Unidade 2 - ENTIDADES OPERADORAS (category_id = 4)
INSERT INTO public.question (type, id, creation_date, category_id, difficulty, explanation, question, correct_answer_boolean) VALUES
('BOOLEAN', 6, now(), 4, 'MEDIUM', 'Seguradoras assumem a obrigação de pagar indenização ao segurado em caso de risco, recebendo um prêmio por isso [3].', 'Seguradoras assumem a obrigação de pagar uma indenização ao segurado no caso de um risco, mediante o recebimento de um prêmio.', true),
('BOOLEAN', 7, now(), 4, 'MEDIUM', 'As sociedades de arrendamento mercantil não são consideradas intermediários financeiros [4].', 'Sociedades de arrendamento mercantil não são consideradas intermediárias financeiras.', false),
('BOOLEAN', 8, now(), 4, 'MEDIUM', 'Administradoras de consórcio são entidades operadoras do SFN [4].', 'Administradoras de consórcio não fazem parte das entidades operadoras do SFN.', false),
('BOOLEAN', 9, now(), 4, 'MEDIUM', 'Entidades abertas de previdência complementar atuam como intermediários financeiros [4].', 'Entidades abertas de previdência complementar não atuam como intermediários financeiros no SFN.', false),
('BOOLEAN', 10, now(), 4, 'MEDIUM', 'Sociedades corretoras de câmbio são intermediários financeiros [4].', 'Sociedades corretoras de câmbio não são consideradas intermediários financeiros.', false);

-- Unidade 3 - OUTROS PARTICIPANTES E TEMAS RELEVANTES NO SFN (category_id = 5)
INSERT INTO public.question (type, id, creation_date, category_id, difficulty, explanation, question, correct_answer_boolean) VALUES
('BOOLEAN', 11, now(), 5, 'MEDIUM', 'O FGC garante depósitos à vista, de poupança e a prazo, entre outros, até o limite de R$ 250 mil por CPF/CNPJ [5].', 'O Fundo Garantidor de Crédito (FGC) garante depósitos à vista, de poupança e a prazo, entre outros, até o limite de R$ 250 mil por CPF/CNPJ.', true),
('BOOLEAN', 12, now(), 5, 'MEDIUM', 'A adesão de instituições financeiras ao FGC é opcional [5].', 'A adesão das instituições financeiras ao FGC é opcional.', false),
('BOOLEAN', 13, now(), 5, 'MEDIUM', 'O SCR armazena informações sobre operações de crédito, avais e fianças de clientes com responsabilidade total igual ou superior a R$ 1.000,00 [6].', 'O Sistema de Informações de Crédito (SCR) armazena informações de clientes com responsabilidade total superior a R$ 5.000,00.', false),
('BOOLEAN', 14, now(), 5, 'MEDIUM', 'O SCR é o principal instrumento do BCB para acompanhar as carteiras de crédito das instituições financeiras [6].', 'O SCR não é utilizado pelo BCB para o acompanhamento das carteiras de crédito das instituições financeiras.', false),
('BOOLEAN', 15, now(), 5, 'MEDIUM', 'O Sistema Brasileiro de Poupança e Empréstimo (SBPE) é formado por instituições financeiras que concedem financiamentos habitacionais [7].', 'O Sistema Brasileiro de Poupança e Empréstimo (SBPE) é formado por instituições financeiras que concedem financiamentos para outros fins que não o habitacional.', false);

-- Unidade 4 - EXECUTOR DAS POLÍTICAS MONETÁRIA E CAMBIAL E AUTONOMIA DOS BANCOS CENTRAIS E DO BANCO CENTRAL DO BRASIL (category_id = 6)
INSERT INTO public.question (type, id, creation_date, category_id, difficulty, explanation, question, correct_answer_boolean) VALUES
('BOOLEAN', 16, now(), 6, 'MEDIUM', 'O Banco Central do Brasil (BCB) é o único emissor de moeda no país [8].', 'A Casa da Moeda do Brasil é a única responsável pela emissão de moeda no país.', false),
('BOOLEAN', 17, now(), 6, 'MEDIUM', 'O Banco Central do Brasil (BCB) atua para ampliar e melhorar o acesso da população a serviços financeiros [9].', 'O Banco Central do Brasil (BCB) não possui atuação para ampliar o acesso a serviços financeiros para a população.', false),
('BOOLEAN', 18, now(), 6, 'MEDIUM', 'A Estratégia Nacional de Educação Financeira (Enef) visa fortalecer a cidadania e a solidez do SFN [10].', 'A Estratégia Nacional de Educação Financeira (Enef) não possui relação com a solidez do SFN.', false),
('BOOLEAN', 19, now(), 6, 'MEDIUM', 'O Comitê Nacional de Educação Financeira (Conef) é responsável por definir e coordenar a execução da Enef [10].', 'O Comitê Nacional de Educação Financeira (Conef) não possui responsabilidade sobre a execução da Enef.', false),
('BOOLEAN', 20, now(), 6, 'MEDIUM', 'O Banco Central do Brasil não participa do Comitê Nacional de Educação Financeira (Conef) [10].', 'O Banco Central do Brasil não faz parte do Comitê Nacional de Educação Financeira (Conef).', false);





-- Inserts para a tabela public.question - Módulo I (tipo multiple)

-- Unidade 1 - EVOLUÇÃO DO SFN. ÓRGÃOS NORMATIVOS E ENTIDADES SUPERVISORAS (category_id = 3)
INSERT INTO public.question (type, id, creation_date, category_id, difficulty, explanation, question, correct_answer_multiple) VALUES
('MULTIPLE', 21, now(), 3, 'MEDIUM', 'O sistema de cartas patentes estabelecia um quantitativo máximo de instituições financeiras, e o ingresso dependia da aquisição de pontos existentes. [Pag. 3]', 'Qual característica marcava o sistema de cartas patentes no SFN?', 'O CMN fixava um quantitativo máximo de instituições, e o ingresso dependia da aquisição dos pontos existentes.'),
('MULTIPLE', 22, now(), 3, 'MEDIUM', 'A Constituição de 1988 mudou significativamente a quantidade de instituições financeiras no sistema. [Pag. 3]', 'Qual foi um dos impactos da Constituição Federal de 1988 no SFN?', 'Mudança significativa quanto à quantidade de instituições financeiras existentes no sistema.'),
('MULTIPLE', 23, now(), 3, 'MEDIUM', 'Até 1988, o ingresso no SFN dependia da aquisição de pontos existentes para o tipo de instituição desejada. [Pag. 3]', 'Como era o processo de ingresso no SFN antes de 1988?', 'Dependia da aquisição dos pontos existentes para o tipo de instituição em questão, além de outros critérios.'),
('MULTIPLE', 24, now(), 3, 'MEDIUM', 'O texto cita a obra "Economia Monetária" de Lopes e Rossetti como referência para a evolução do SFN. [Pag. 8]', 'Qual obra é citada como referência para a evolução histórica do SFN?', 'Economia Monetária, de Lopes e Rossetti.'),
('MULTIPLE', 25, now(), 3, 'MEDIUM', 'As reformas de 1964-1965 e a promulgação da constituição de 1988 são marcos importantes da evolução do SFN. [Pag. 2, 3]', 'Quais são os dois marcos temporais relevantes na evolução do SFN?', 'As reformas de 1964-1965 e a Constituição Federal de 1988.'),
('MULTIPLE', 26, now(), 3, 'MEDIUM', 'Após 1994, o SFN passou por um período de estabilidade e modernização. [Pag. 3]', 'Qual a característica do SFN após 1994?', 'Um período de estabilidade e modernização.'),
('MULTIPLE', 27, now(), 3, 'MEDIUM', 'O CMN tinha o poder de estabelecer um limite máximo de instituições financeiras por meio do sistema de cartas patentes. [Pag. 3]', 'Quem estabelecia o limite máximo de instituições financeiras no sistema de cartas patentes?', 'O Conselho Monetário Nacional (CMN).'),
('MULTIPLE', 28, now(), 3, 'MEDIUM', 'O sistema de cartas patentes garantia que novas instituições entrassem no sistema a partir da aquisição de pontos existentes. [Pag. 3]', 'Como era o processo de entrada de novas instituições no sistema de cartas patentes?', 'A entrada dependia da aquisição de pontos existentes.'),
('MULTIPLE', 29, now(), 3, 'MEDIUM', 'A Constituição de 1988 promoveu uma mudança significativa no sistema financeiro em relação a quantidade de instituições. [Pag. 3]', 'Qual foi o efeito da Constituição de 1988 no número de instituições financeiras?', 'Estabeleceu uma mudança significativa na quantidade de instituições financeiras existentes no sistema.'),
('MULTIPLE', 30, now(), 3, 'MEDIUM', 'O sistema de cartas patentes foi extinto com a promulgação da Constituição de 1988. [Pag. 3]', 'Quando o sistema de cartas patentes foi extinto?', 'Com a promulgação da Constituição Federal de 1988.');

-- Unidade 2 - ENTIDADES OPERADORAS (category_id = 4)
INSERT INTO public.question (type, id, creation_date, category_id, difficulty, explanation, question, correct_answer_multiple) VALUES
('MULTIPLE', 31, now(), 4, 'MEDIUM', 'Seguradoras assumem a obrigação de pagar indenização, recebendo um prêmio por isso. [Pag. 4]', 'Qual a função principal de uma seguradora?', 'Assumir a obrigação de pagar uma indenização mediante o recebimento de um prêmio.'),
('MULTIPLE', 32, now(), 4, 'MEDIUM', 'Cooperativas de crédito podem ser singulares, centrais ou confederações. [Pag. 5]', 'Como se dividem as cooperativas de crédito?', 'Singulares, centrais e confederações.'),
('MULTIPLE', 33, now(), 4, 'MEDIUM', 'Cooperativas singulares prestam serviços financeiros apenas aos seus associados. [Pag. 5]', 'A quem as cooperativas singulares de crédito prestam serviços financeiros?', 'Apenas aos seus associados.'),
('MULTIPLE', 34, now(), 4, 'MEDIUM', 'As regras prudenciais para cooperativas de crédito são mais estritas para aquelas com quadro social mais heterogêneo. [Pag. 5]', 'Em relação às regras prudenciais, qual tipo de cooperativa de crédito está sujeita às normas mais estritas?', 'As cooperativas de livre admissão, cujo quadro social é mais heterogêneo.'),
('MULTIPLE', 35, now(), 4, 'MEDIUM', 'Administradoras de consórcio, entidades abertas de previdência e sociedades de arrendamento são intermediários financeiros. [Pag. 6]', 'Quais entidades são consideradas intermediários financeiros?', 'Administradoras de consórcio, entidades abertas de previdência complementar e sociedades de arrendamento mercantil.'),
('MULTIPLE', 36, now(), 4, 'MEDIUM', 'Sociedades corretoras de câmbio atuam como intermediários no mercado cambial. [Pag. 6]', 'Qual a função das sociedades corretoras de câmbio?', 'Atuar como intermediárias no mercado cambial.'),
('MULTIPLE', 37, now(), 4, 'MEDIUM', 'Sociedades de capitalização são outras entidades que atuam no SFN. [Pag. 6]', 'Qual o papel das sociedades de capitalização no SFN?', 'São entidades que atuam no SFN.'),
('MULTIPLE', 38, now(), 4, 'MEDIUM', 'Entidades abertas de previdência complementar são intermediários financeiros. [Pag. 6]', 'Como as entidades abertas de previdência complementar atuam no SFN?', 'Atuam como intermediários financeiros.'),
('MULTIPLE', 39, now(), 4, 'MEDIUM', 'As sociedades corretoras de títulos e valores mobiliários atuam no mercado de capitais. [Pag. 6]', 'Qual a função das sociedades corretoras de títulos e valores mobiliários?', 'Atuar no mercado de capitais.'),
  ('MULTIPLE', 40, now(), 4, 'MEDIUM', 'Os fundos de pensão também são importantes entidades operadoras do SFN. [Pag. 6]', 'Qual o papel dos fundos de pensão no SFN?', 'São importantes entidades operadoras do SFN.');


-- Unidade 3 - OUTROS PARTICIPANTES E TEMAS RELEVANTES NO SFN (category_id = 5)
INSERT INTO public.question (type, id, creation_date, category_id, difficulty, explanation, question, correct_answer_multiple) VALUES
('MULTIPLE', 41, now(), 5, 'MEDIUM', 'O FGC protege depositantes e investidores até o limite de R$ 250 mil por CPF/CNPJ. [Pag. 9]', 'Qual a missão institucional do FGC?', 'Proteger depositantes e investidores até os limites estabelecidos, contribuir para a estabilidade do SFN e prevenir crises bancárias.'),
('MULTIPLE', 42, now(), 5, 'MEDIUM', 'A adesão ao FGC é compulsória para instituições financeiras e associações de poupança. [Pag. 9]', 'A adesão ao FGC por instituições financeiras e associações de poupança é:', 'Compulsória.'),
('MULTIPLE', 43, now(), 5, 'MEDIUM', 'O SCR é o principal instrumento do BCB para acompanhar as carteiras de crédito. [Pag. 11]', 'Qual a principal função do SCR?', 'Acompanhar as carteiras de crédito das instituições financeiras.'),
('MULTIPLE', 44, now(), 5, 'MEDIUM', 'O SCR coleta informações sobre operações de crédito acima de R$ 1.000,00. [Pag. 11]', 'A partir de qual valor as operações de crédito são registradas no SCR?', 'Responsabilidade total igual ou superior a R$ 1.000,00.'),
('MULTIPLE', 45, now(), 5, 'MEDIUM', 'O SBPE é formado por instituições financeiras que concedem financiamentos habitacionais. [Pag. 13]', 'Qual o principal objetivo do SBPE?', 'Concessão de financiamentos habitacionais.'),
('MULTIPLE', 46, now(), 5, 'MEDIUM', 'O BCB atua para ampliar o acesso da população a serviços financeiros desde a década de 1990. [Pag. 13]', 'Desde quando o BCB atua para ampliar o acesso a serviços financeiros?', 'Desde a década de 1990.'),
('MULTIPLE', 47, now(), 5, 'MEDIUM', 'As contas simplificadas foram criadas para inclusão financeira de pessoas de baixa renda. [Pag. 13]', 'Qual o objetivo da criação das contas simplificadas?', 'Promover a inclusão financeira da população de menor renda.'),
('MULTIPLE', 48, now(), 5, 'MEDIUM', 'A portabilidade de salário e crédito é um direito do consumidor. [Pag. 14]', 'O que é garantido pela regulação para o consumidor?', 'A portabilidade gratuita do salário, dos dados cadastrais e do crédito.'),
  ('MULTIPLE', 49, now(), 5, 'MEDIUM', 'A Estratégia Nacional de Educação Financeira (Enef) busca fortalecer a cidadania e a solidez do SFN. [Pag. 15]', 'Qual o objetivo da Estratégia Nacional de Educação Financeira (Enef)?', 'Promover a educação financeira e contribuir para o fortalecimento da cidadania e do SFN.'),
  ('MULTIPLE', 50, now(), 5, 'MEDIUM', 'O Protocolo Verde busca reunir padrões internacionais de sustentabilidade para instituições financeiras. [Pag. 16]', 'O que o Protocolo Verde busca reunir?', 'Os principais padrões internacionais de sustentabilidade para as instituições que operam no país.');

-- Unidade 4 - EXECUTOR DAS POLÍTICAS MONETÁRIA E CAMBIAL E AUTONOMIA DOS BANCOS CENTRAIS E DO BANCO CENTRAL DO BRASIL (category_id = 6)
INSERT INTO public.question (type, id, creation_date, category_id, difficulty, explanation, question, correct_answer_multiple) VALUES
('MULTIPLE', 51, now(), 6, 'MEDIUM', 'A Casa da Moeda do Brasil produz o dinheiro, mas o BCB emite a moeda. [Pag. 20]', 'Quem é responsável pela emissão de moeda no Brasil?', 'O Banco Central do Brasil (BCB).'),
('MULTIPLE', 52, now(), 6, 'MEDIUM', 'O BCB atua para ampliar o acesso a serviços financeiros. [Pag. 20]', 'Qual é um dos objetivos do BCB em relação aos serviços financeiros?', 'Ampliar e melhorar o acesso da população a serviços financeiros.'),
('MULTIPLE', 53, now(), 6, 'MEDIUM', 'A Lei nº 12.865/2013 criou as instituições de pagamento e a conta de pagamento. [Pag. 20]', 'Qual lei criou as instituições de pagamento e a conta de pagamento?', 'A Lei nº 12.865/2013.'),
('MULTIPLE', 54, now(), 6, 'MEDIUM', 'O BCB realiza fóruns anuais para tratar da inclusão financeira. [Pag. 20]', 'Qual a periodicidade dos fóruns do BCB sobre inclusão financeira?', 'Anual.'),
('MULTIPLE', 55, now(), 6, 'MEDIUM', 'O BCB é o executor da política monetária. [Pag. 22]', 'Qual a principal função do BCB em relação à política monetária?', 'Executor da política monetária.'),
('MULTIPLE', 56, now(), 6, 'MEDIUM', 'Os recolhimentos compulsórios são um instrumento da política monetária. [Pag. 24]', 'O que são recolhimentos compulsórios?', 'Um instrumento da política monetária.'),
('MULTIPLE', 57, now(), 6, 'MEDIUM', 'A taxa Selic é a taxa média ajustada dos financiamentos diários apurados no Selic. [Pag. 25]', 'O que é a taxa Selic?', 'A taxa média ajustada dos financiamentos diários apurados no Selic para títulos públicos federais.'),
('MULTIPLE', 58, now(), 6, 'MEDIUM', 'O sistema de metas para a inflação foi adotado em 1999. [Pag. 22]', 'Quando o sistema de metas para a inflação foi adotado no Brasil?', 'Em 1999.'),
('MULTIPLE', 59, now(), 6, 'MEDIUM', 'O descumprimento da meta de inflação exige justificativa pública do presidente do BCB. [Pag. 25]', 'O que acontece em caso de descumprimento da meta de inflação?', 'O presidente do BCB divulga publicamente as razões do descumprimento.'),
('MULTIPLE', 60, now(), 6, 'MEDIUM', 'As taxas PTAX são calculadas com base em dados de instituições credenciadas pelo BCB. [Pag. 27]', 'Como são calculadas as taxas PTAX?', 'Com base em dados obtidos mediante consultas às instituições credenciadas pelo BCB (dealers).');

-- Inserts para a tabela public.incorrect_answer - Módulo I
-- Unidade 1
INSERT INTO public.incorrect_answer (id, question_id, creation_date, answer) VALUES
(1, 21, now(), 'A livre emissão de moeda por qualquer instituição.'),
(2, 21, now(), 'A inexistência de limites para a abertura de agências.'),
(3, 21, now(), 'A total liberdade para atuação de bancos estrangeiros.'),
(4, 21, now(), 'A definição de taxas de juros pelo mercado.'),
(5, 22, now(), 'Aumento do controle estatal sobre as instituições financeiras.'),
(6, 22, now(), 'Criação de novas moedas para o sistema financeiro.'),
(7, 22, now(), 'A abolição de qualquer tipo de supervisão financeira.'),
(8, 22, now(), 'Permitiu a livre entrada de instituições financeiras sem critérios.'),
(9, 23, now(), 'Era totalmente livre e dependia apenas do interesse dos investidores.'),
(10, 23, now(), 'Dependia apenas da aprovação do Ministério da Fazenda.'),
(11, 23, now(), 'Era baseado em sorteio público sem outros critérios.'),
(12, 23, now(), 'Apenas critérios técnicos e financeiros eram levados em conta.'),
(13, 24, now(), 'História Econômica do Brasil, de Celso Furtado.'),
(14, 24, now(), 'Formação Econômica do Brasil, de Caio Prado Júnior.'),
(15, 24, now(), 'O Capital, de Karl Marx.'),
(16, 24, now(), 'A Riqueza das Nações, de Adam Smith.'),
(17, 25, now(), 'A criação do Banco Central e do Banco do Brasil.'),
(18, 25, now(), 'O início da República e a era Vargas.'),
(19, 25, now(), 'A independência do Brasil e a abolição da escravidão.'),
(20, 25, now(), 'A inflação de 1980 e o Plano Real.'),
(21, 26, now(), 'Um período de instabilidade e inflação crescente.'),
(22, 26, now(), 'Um período de retração econômica e desconfiança do mercado.'),
(23, 26, now(), 'Um período de total desregulamentação do sistema financeiro.'),
(24, 26, now(), 'Um período de extrema centralização da atividade bancária.'),
(25, 27, now(), 'O Banco Central do Brasil (BCB).'),
(26, 27, now(), 'O Ministério da Fazenda.'),
(27, 27, now(), 'O Congresso Nacional.'),
(28, 27, now(), 'O Poder Judiciário.'),
(29, 28, now(), 'Por meio da apresentação de projetos ao Banco Central.'),
(30, 28, now(), 'Por meio de leilões públicos.'),
(31, 28, now(), 'A partir de uma autorização do Ministério da Fazenda.'),
(32, 28, now(), 'Por meio de concurso público para instituições financeiras.'),
(33, 29, now(), 'Não houve mudança no número de instituições financeiras após a Constituição de 1988.'),
(34, 29, now(), 'Houve uma diminuição do número de instituições financeiras.'),
(35, 29, now(), 'Houve um aumento do controle estatal sobre as instituições.'),
(36, 29, now(), 'Permitiu a entrada de qualquer instituição sem critérios.'),
(37, 30, now(), 'Com a criação do Banco Central do Brasil.'),
(38, 30, now(), 'Com o Plano Real.'),
(39, 30, now(), 'Com a criação do Ministério da Fazenda.'),
(40, 30, now(), 'Com a redemocratização do país.');

-- Unidade 2
INSERT INTO public.incorrect_answer (id, question_id, creation_date, answer) VALUES
(41, 31, now(), 'Gerenciar riscos financeiros de outras instituições.'),
(42, 31, now(), 'Captar recursos para o governo.'),
(43, 31, now(), 'Conceder crédito rural.'),
(44, 31, now(), 'Realizar operações de câmbio.'),
(45, 32, now(), 'Públicas, privadas e mistas.'),
(46, 32, now(), 'Nacionais, regionais e locais.'),
(47, 32, now(), 'Urbanas, rurais e industriais.'),
(48, 32, now(), 'De crédito, de investimento e de poupança.'),
(49, 33, now(), 'Ao público em geral.'),
(50, 33, now(), 'A outras instituições financeiras.'),
(51, 33, now(), 'Ao governo federal.'),
(52, 33, now(), 'A empresas de grande porte.'),
(53, 34, now(), 'As cooperativas rurais.'),
(54, 34, now(), 'As cooperativas de crédito mútuo.'),
(55, 34, now(), 'As cooperativas com poucos associados.'),
(56, 34, now(), 'As cooperativas de crédito estaduais.'),
(57, 35, now(), 'Apenas bancos comerciais e de investimento.'),
(58, 35, now(), 'Somente corretoras de títulos e valores mobiliários.'),
(59, 35, now(), 'Apenas seguradoras e fundos de pensão.'),
(60, 35, now(), 'Somente as cooperativas de crédito.'),
(61, 36, now(), 'Captar depósitos à vista.'),
(62, 36, now(), 'Emitir moeda.'),
(63, 36, now(), 'Supervisionar outras instituições financeiras.'),
(64, 36, now(), 'Conceder crédito habitacional.'),
(65, 37, now(), 'Realizar operações de crédito rural.'),
(66, 37, now(), 'Captar recursos por meio de títulos públicos.'),
(67, 37, now(), 'Conceder financiamentos de longo prazo.'),
(68, 37, now(), 'Apenas gerir fundos de pensão.'),
(69, 38, now(), 'Apenas como corretoras de seguros.'),
(70, 38, now(), 'Apenas como administradoras de consórcios.'),
(71, 38, now(), 'Apenas como distribuidoras de valores mobiliários.'),
(72, 38, now(), 'Apenas como gestoras de recursos de terceiros.'),
(73, 39, now(), 'Apenas no mercado de câmbio.'),
(74, 39, now(), 'Apenas no mercado imobiliário.'),
(75, 39, now(), 'Apenas no mercado de derivativos.'),
(76, 39, now(), 'Apenas no mercado de crédito.'),
(77, 40, now(), 'São responsáveis pela emissão de moeda.'),
(78, 40, now(), 'São órgãos supervisores do SFN.'),
(79, 40, now(), 'São responsáveis pela política cambial.'),
(80, 40, now(), 'São responsáveis pela política fiscal.');

-- Unidade 3
INSERT INTO public.incorrect_answer (id, question_id, creation_date, answer) VALUES
(81, 41, now(), 'Garantir a segurança de todas as operações financeiras.'),
(82, 41, now(), 'Regular o mercado de câmbio.'),
(83, 41, now(), 'Definir as taxas de juros do país.'),
(84, 41, now(), 'Realizar operações de open market.'),
(85, 42, now(), 'Voluntária.'),
(86, 42, now(), 'Condicional a avaliação de risco.'),
(87, 42, now(), 'Apenas para bancos de investimento.'),
(88, 42, now(), 'Apenas para cooperativas de crédito.'),
(89, 43, now(), 'Controlar a inflação.'),
(90, 43, now(), 'Realizar operações de câmbio.'),
(91, 43, now(), 'Regular o mercado de derivativos.'),
(92, 43, now(), 'Emitir moeda.'),
(93, 44, now(), 'Acima de R$ 5.000,00.'),
(94, 44, now(), 'Acima de R$ 10.000,00.'),
(95, 44, now(), 'Acima de R$ 50.000,00.'),
(96, 44, now(), 'Acima de R$ 100.000,00.'),
(97, 45, now(), 'Concessão de crédito para capital de giro.'),
(98, 45, now(), 'Concessão de crédito para compra de veículos.'),
(99, 45, now(), 'Concessão de crédito para viagens.'),
(100, 45, now(), 'Concessão de crédito para consumo.'),
(101, 46, now(), 'Desde a década de 1980.'),
(102, 46, now(), 'Desde a década de 2000.'),
(103, 46, now(), 'Desde a década de 1970.'),
(104, 46, now(), 'Desde a década de 1960.'),
(105, 47, now(), 'Para conceder crédito com juros menores.'),
(106, 47, now(), 'Para aumentar a arrecadação de impostos.'),
(107, 47, now(), 'Para facilitar o acesso ao crédito rural.'),
(108, 47, now(), 'Para aumentar o número de contas bancárias.'),
(109, 48, now(), 'A cobrança de tarifas para liquidação antecipada de crédito.'),
(110, 48, now(), 'A proibição da portabilidade de dados cadastrais.'),
(111, 48, now(), 'A obrigação de abrir conta em banco específico para receber salário.'),
(112, 48, now(), 'A proibição da portabilidade gratuita de crédito.'),
(113, 49, now(), 'Apenas fortalecer a cidadania.'),
(114, 49, now(), 'Apenas aumentar a solidez do SFN.'),
(115, 49, now(), 'Apenas promover o desenvolvimento econômico.'),
(116, 49, now(), 'Apenas controlar a inflação.'),
(117, 50, now(), 'Apenas os padrões de emissão de carbono.'),
(118, 50, now(), 'Apenas os padrões de análise de riscos socioambientais.'),
(119, 50, now(), 'Apenas os padrões de relatórios de sustentabilidade.'),
(120, 50, now(), 'Apenas os padrões de investimentos sustentáveis.');

-- Unidade 4
INSERT INTO public.incorrect_answer (id, question_id, creation_date, answer) VALUES
(121, 51, now(), 'O Ministério da Fazenda.'),
(122, 51, now(), 'O Tesouro Nacional.'),
(123, 51, now(), 'A Caixa Econômica Federal.'),
(124, 51, now(), 'O Banco do Brasil.'),
(125, 52, now(), 'Apenas para grandes empresas.'),
(126, 52, now(), 'Apenas para o setor financeiro.'),
(127, 52, now(), 'Apenas para o setor público.'),
(128, 52, now(), 'Apenas para instituições de grande porte.'),
(129, 53, now(), 'A Lei nº 4.595/1964.'),
(130, 53, now(), 'A Lei nº 11.101/2005.'),
(131, 53, now(), 'A Lei Complementar nº 101/2000.'),
(132, 53, now(), 'A Lei nº 8.666/1993.'),
(133, 54, now(), 'Semestral.'),
(134, 54, now(), 'Mensal.'),
(135, 54, now(), 'A cada dois anos.'),
(136, 54, now(), 'A cada trimestre.'),
(137, 55, now(), 'Executor da política fiscal.'),
(138, 55, now(), 'Executor da política cambial.'),
(139, 55, now(), 'Executor da política tributária.'),
(140, 55, now(), 'Executor da política de comércio exterior.'),
(141, 56, now(), 'Um instrumento da política fiscal.'),
(142, 56, now(), 'Um instrumento da política cambial.'),
(143, 56, now(), 'Um instrumento da política comercial.'),
(144, 56, now(), 'Um instrumento da política de crédito.'),
(145, 57, now(), 'A taxa de juros básica da economia.'),
(146, 57, now(), 'A taxa de câmbio utilizada pelo BCB.'),
(147, 57, now(), 'A taxa de juros utilizada em operações de crédito rural.'),
(148, 57, now(), 'A taxa de juros dos depósitos em poupança.'),
(149, 58, now(), 'Em 1994.'),
(150, 58, now(), 'Em 2002.'),
(151, 58, now(), 'Em 1988.'),
(152, 58, now(), 'Em 2010.'),
(153, 59, now(), 'O presidente do BCB é demitido.'),
(154, 59, now(), 'O BCB é automaticamente dissolvido.'),
(155, 59, now(), 'O Ministro da Fazenda assume a presidência do BCB.'),
(156, 59, now(), 'Nenhuma medida é tomada.'),
(157, 60, now(), 'Por meio de sorteio público.'),
(158, 60, now(), 'Por decisão do Conselho Monetário Nacional (CMN).'),
(159, 60, now(), 'Por decisão do Congresso Nacional.'),
(160, 60, now(), 'Por decisão do Ministério da Fazenda.');

