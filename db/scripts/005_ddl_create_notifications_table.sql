create table j_user_notification (
    id serial primary key,
    messenger text,
    identify text,
    j_user_id int REFERENCES j_user(id)
);