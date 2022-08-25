-- DROP TABLE IF EXISTS images;

CREATE TABLE IF NOT EXISTS images
(
    id bigint NOT NULL,
    image_code clob NOT NULL,
    created_at timestamp without time zone,
    CONSTRAINT images_pkey PRIMARY KEY (id)
)

