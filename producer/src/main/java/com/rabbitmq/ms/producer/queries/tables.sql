# Book
CREATE TABLE books (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       isbn VARCHAR(20) NOT NULL,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       author VARCHAR(150) NOT NULL,
                       publisher VARCHAR(150),
                       publication_year INT,
                       language VARCHAR(50),
                       category VARCHAR(100),
                       price DECIMAL(10,2) NOT NULL,
                       created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
                           ON UPDATE CURRENT_TIMESTAMP,

                       PRIMARY KEY (id),
                       UNIQUE KEY uk_books_isbn (isbn),
                       INDEX idx_books_author (author),
                       INDEX idx_books_category (category),
                       INDEX idx_books_title (title)
);

