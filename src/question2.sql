CREATE TABLE users (
                                 id INT PRIMARY KEY,
                                 name VARCHAR(50),
                                 parent_id INT
);

INSERT INTO users (id, name, parent_id) VALUES
                                                     (1, 'Zaki', 2),
                                                      (2, 'Ilham', NULL),
                                                      (3, 'Irwan', 2),
                                                      (4, 'Arka', 3);

SELECT
    t1.id,
    t1.name,
    t2.name AS parent_name
FROM
    users t1
        LEFT JOIN
    users t2
ON
    t1.parent_id = t2.id;