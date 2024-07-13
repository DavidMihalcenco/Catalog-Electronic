create table usertable
(
    user_name varchar,
    user_id   integer generated always as identity
        constraint user_pk
            primary key,
    email     varchar,
    image     bytea
);

alter table usertable
    owner to "user";

create table infrastructura
(
    infrastructure_name                   varchar,
    infrastructure_id                     integer generated always as identity
        constraint infrastructura_pk
            primary key,
    infrastructure_lon                    double precision,
    infrastructure_lat                    double precision,
    infrastructure_description            varchar,
    user_id                               integer
        constraint infrastructura_user_user_id_fk
            references usertable,
    infrastructure_email                  varchar,
    infrastructure_phone                  varchar,
    infrastructure_benefits               varchar,
    infrastructure_access_info            varchar,
    infrastructure_tehnical_specification varchar,
    infrastructure_key_words              varchar,
    private_status                        boolean,
    infrastructure_data_publication       date default CURRENT_DATE
);

alter table infrastructura
    owner to "user";

create table offer
(
    offer_name          varchar,
    offer_description   varchar,
    offer_id            integer generated always as identity
        constraint offer_pk
            primary key,
    user_id             integer
        constraint offer_user_user_id_fk
            references usertable,
    offer_context       varchar,
    offer_benefits      varchar,
    offer_utilization   varchar,
    offer_colaborations varchar,
    offer_status        varchar,
    offer_phone         varchar,
    offer_email         varchar,
    offer_key_words     varchar,
    private_status      boolean,
    offer_data_publication date default CURRENT_DATE
);

alter table offer
    owner to "user";

create table infrastructures_images
(
    image_id          integer generated always as identity
        constraint infrastructures_images_pk
            primary key,
    infrastructure_id integer not null
        constraint infrastructures_images_infrastructura_infrastructure_id_fk
            references infrastructura,
    image             bytea
);

alter table infrastructures_images
    owner to "user";

create table offers_images
(
    image_id integer generated always as identity
        constraint offers_images_pk
            primary key,
    offer_id integer not null
        constraint offers_images_offer_offer_id_fk
            references offer,
    image    bytea
);

alter table offers_images
    owner to "user";

