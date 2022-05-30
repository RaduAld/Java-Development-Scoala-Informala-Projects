-- Table: public.accommodation_fair_relation

-- DROP TABLE IF EXISTS public.accommodation_fair_relation;

CREATE TABLE IF NOT EXISTS public.accommodation_fair_relation
(
    id integer NOT NULL DEFAULT nextval('accommodation_fair_relations_id_seq'::regclass),
    id_accommodation integer,
    id_room_fair integer,
    CONSTRAINT accomodation_fair_relations_pkey PRIMARY KEY (id),
    CONSTRAINT accomodation_fair_relations_id_accomodation_fkey FOREIGN KEY (id_accommodation)
        REFERENCES public.accommodation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT accomodation_fair_relations_id_room_fair_fkey FOREIGN KEY (id_room_fair)
        REFERENCES public.room_fair (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.accommodation_fair_relation
    OWNER to postgres;