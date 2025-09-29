
CREATE TABLE IF NOT EXISTS Note (
    id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    description text,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
