CREATE TABLE public.book (
	id int8 NOT NULL,
	last_change_date timestamp(6) NULL,
	creation_date timestamp(6) NOT NULL,
	remove_date timestamp(6) NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT book_pkey PRIMARY KEY (id)
);


CREATE TABLE public.book_question (
	"type" varchar(31) NOT NULL,
	book_id int8 NOT NULL,
	question_id int8 NOT NULL,
	last_change_date timestamp(6) NULL,
	creation_date timestamp(6) NOT NULL,
	remove_date timestamp(6) NULL,
	answered bool NULL,
	answer bool NULL,
	selected_answer_id int8 NULL,
	CONSTRAINT book_question_pkey PRIMARY KEY (book_id, question_id),
	CONSTRAINT fkbfdmjb0nljxtledfh9fgldfho FOREIGN KEY (book_id) REFERENCES public.book(id),
	CONSTRAINT fkbkdquevryq7mm0o3bhkk120qs FOREIGN KEY (question_id) REFERENCES public.question(id),
	CONSTRAINT fkdu2pren21sjtojf9vs951vxrc FOREIGN KEY (selected_answer_id) REFERENCES public.incorrect_answer(id)
);