-- Table: public.room_fair

-- DROP TABLE IF EXISTS public.room_fair;

CREATE TABLE IF NOT EXISTS public.room_fair
(
    id integer NOT NULL DEFAULT nextval('room_fairs_id_seq'::regclass),
    value double precision,
    season character varying(32) COLLATE pg_catalog."default",
    CONSTRAINT room_fairs_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.room_fair
    OWNER to postgres;