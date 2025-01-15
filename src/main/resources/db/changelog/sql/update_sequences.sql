
SELECT setval('public.category_id_seq', (SELECT MAX(id) FROM public.category) + 1, false);
SELECT setval('public.discipline_id_seq', (SELECT MAX(id) FROM public.discipline) + 1, false);
SELECT setval('public.question_id_seq', (SELECT MAX(id) FROM public.question) + 1, false);
SELECT setval('public.incorrect_answer_id_seq', (SELECT MAX(id) FROM public.incorrect_answer) + 1, false);
