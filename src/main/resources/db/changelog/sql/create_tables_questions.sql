DROP TABLE IF EXISTS public.discipline CASCADE;
DROP TABLE IF EXISTS public.category CASCADE;
DROP TABLE IF EXISTS public.question CASCADE;
DROP TABLE IF EXISTS public.incorrect_answer CASCADE;



CREATE TABLE public.discipline (
	id serial primary key,
	last_change_date timestamp(6) NULL,
	creation_date timestamp(6) NOT NULL,
	remove_date timestamp(6) NULL,
	"name" varchar(255) NOT NULL
);

CREATE TABLE public.category (
	id serial primary key,
	last_change_date timestamp(6) NULL,
	creation_date timestamp(6) NOT NULL,
	remove_date timestamp(6) NULL,
	"name" varchar(255) NOT NULL,
	parent_category_id int8 NULL,
	discipline_id int8 NULL,
	CONSTRAINT fks2ride9gvilxy2tcuv7witnxc FOREIGN KEY (parent_category_id) REFERENCES public.category(id),
	CONSTRAINT fks2ride9gvilxy2tcuv7witnxb FOREIGN KEY (discipline_id) REFERENCES public.discipline(id)
);

CREATE TABLE public.question (
	"type" varchar(31) NOT NULL,
	id serial primary key,
	last_change_date timestamp(6) NULL,
	creation_date timestamp(6) NOT NULL,
	remove_date timestamp(6) NULL,
	category_id int8 not null,
	difficulty varchar(255) NOT NULL,
	explanation text NULL,
	question text NOT NULL,
	correct_answer_boolean bool NULL,
	correct_answer_multiple text NULL,
	CONSTRAINT question_difficulty_check CHECK (((difficulty)::text = ANY ((ARRAY['EASY'::character varying, 'MEDIUM'::character varying, 'HARD'::character varying])::text[]))),
	CONSTRAINT fk7jaqbm9p4prg7n91dd1uabrvj FOREIGN KEY (category_id) REFERENCES public.category(id)
);

CREATE TABLE public.incorrect_answer (
	id serial primary key,
	last_change_date timestamp(6) NULL,
	creation_date timestamp(6) NOT NULL,
	remove_date timestamp(6) NULL,
	answer text NOT NULL,
	question_id int8 not null,
	CONSTRAINT fkflwcda2rengsndju5f1deywok FOREIGN KEY (question_id) REFERENCES public.question(id)
);