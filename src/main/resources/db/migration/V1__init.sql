CREATE TABLE participant_meetup(
    id BINARY(16) NOT NULL PRIMARY KEY,
    username CHARACTER VARYING(255) NOT NULL,
    meet_id INTEGER NOT NULL,
    created_at timestamp not null
);