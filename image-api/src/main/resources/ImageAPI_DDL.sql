-- Table: public.images

-- DROP TABLE IF EXISTS public.images;

CREATE TABLE IF NOT EXISTS public.images
(
    id bigint NOT NULL DEFAULT nextval('images_id_seq'::regclass),
    image_code bytea NOT NULL,
    created_at timestamp without time zone,
    CONSTRAINT images_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;
