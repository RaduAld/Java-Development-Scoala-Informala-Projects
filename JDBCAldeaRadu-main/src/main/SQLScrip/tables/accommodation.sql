-- Table: public.accommodation

-- DROP TABLE IF EXISTS public.accommodation;

CREATE TABLE IF NOT EXISTS public.accommodation
(
    id integer NOT NULL DEFAULT nextval('accommodations_id_seq'::regclass),
    type character varying(32) COLLATE pg_catalog."default",
    bed_type character varying(32) COLLATE pg_catalog."default",
    max_guests integer,
    description character varying(512) COLLATE pg_catalog."default",
    CONSTRAINT accomodations_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.accommodation
    OWNER to postgres;