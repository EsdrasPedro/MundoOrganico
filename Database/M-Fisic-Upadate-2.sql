USE mundo_orgânico;

INSERT INTO address (location, number, reference, complement, user_id)
VALUES 
('Rua Jerônimo Vilela, Campo Grande, Recife', 2, 'casa preta', 'casa',1),
('Rua André Rebouças, Rosarinho, Recife', 0, 'casa rosa', 'apartamento',2),
('Avenida Conselheiro Rosa e Silva, Jaqueira, Recife', 9, 'portao preto', 'casa',3),
('Rua Boa Vontade, Tamarineira, Recife', 8, 'pe de coco', 'apartamento',4),
('Rua das Moças, Arruda, Recife', 10, 'grade roxa', 'casa',5),
('Rua Francisco Berenguer, Hipódromo, Recife', 6, 'farmacia do lado', 'apartamento',6),
('Rua Dom João Costa, Torreão, Recife', 2, 'padaria do lado', 'casa',7),
('Avenida Rui Barbosa, Graças, Recife', 1, 'estatua de gato', 'apartamento',8),
('Rua Real da Torre, Torre, Recife', 9, 'gargula preta', 'casa',9),
('Rua Carlos Gomes, Madalena, Recife', 9, 'sem calçada', 'apartamento',10);

INSERT INTO request (time, date, status, amount, user_id)
VALUES
('10:30:45', '2022-07-28', 'Concluído', 35, 1),
('11:31:46', '2022-07-28', 'Concluído', 49, 2),
('12:32:47', '2022-07-28', 'Concluído', 25, 3),
('13:33:48', '2022-07-28', 'Concluído', 13, 4),
('14:34:49', '2022-07-28', 'Concluído', 21, 5),
('15:35:50', '2022-07-28', 'Concluído', 14, 6),
('16:36:51', '2022-07-28', 'Concluído', 45, 7),
('17:37:52', '2022-07-28', 'Concluído', 37, 8),
('18:38:53', '2022-07-28', 'Concluído', 19, 9),
('19:39:54', '2022-07-28', 'Concluído', 40, 10);

INSERT INTO product (name, description, value, category_id, salesman_id)
VALUES
('Maçã Vermelha', 'Saborosa maçã colhida direto no pé', 5, 1, 1),
('Maçã Verde', 'Saborosa maçã colhida direto no pé', 6, 1, 1),
('Maçã Vermelha', 'Saborosa maçã colhida direto no pé', 4, 1, 2),
('Banana Cumprida', 'Saborosa banana colhida direto no pé', 3, 1, 1),
('Banana Anã', 'Saborosa banana colhida direto no pé', 2, 1, 1),
('Pimentão Verde', 'Saboroso pimentão colhida direto no pé', 3, 2, 1),
('Pimentão Vermelho', 'Saboroso pimentão colhida direto no pé', 4, 2, 2),
('Pimentão Amarelo', 'Saboroso pimentão colhida direto no pé', 5, 2, 1),
('Uva Verde', 'Saborosa uva colhida direto no pé', 7, 1, 2),
('Uva Roxa', 'Saborosa uva colhida direto no pé', 8, 1, 1);


INSERT INTO ordered_items (value, amount, request_id, product_id)
VALUES
(10, 2, 1, 1),
(30, 5, 2, 2),
(56, 14, 3, 3),
(42, 14, 4, 4),
(26, 13, 5, 5),
(60, 20, 6, 6),
(72, 18, 7, 7),
(65, 13, 8, 8),
(77, 11, 9, 9),
(160, 20, 10, 10);

INSERT INTO type (name, category_id)
VALUES
('Banana',1),
('Maçã',1),
('Uva',1),
('Pimentão',2);
