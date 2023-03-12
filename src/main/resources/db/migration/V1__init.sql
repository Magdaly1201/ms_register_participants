CREATE TABLE participant_meetup(
    id CHARACTER VARYING(36) NOT NULL primary key,
    username CHARACTER VARYING(255) NOT NULL,
    meet_id INTEGER NOT NULL,
    created_at timestamp not null

);