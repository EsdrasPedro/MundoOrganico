USE mundo_orgânico;

INSERT INTO category (name)
VALUES 
('Frutas'),
('Verduras'),
('Hortaliças'),
('Temperos');

INSERT INTO salesman (fantasy_name, cnpj, email, password)
VALUES
('Organic Lovers', '47.774.385/0001-08', 'organiclovers@gmail.com', '123456789'),
('Organikey', '25.934.663/0001-04', 'organikey@gmail.com', '123456789'),
('Organition', '86.337.705/0001-14', 'organition@gmail.com', '123456789'),
('Organination', '66.663.037/0001-08', 'organination@gmail.com', '123456789'),
('Organic', '89.725.623/0001-35', 'organic@gmail.com', '123456789'),
('Organico', '54.444.908/0001-13', 'organico@gmail.com', '123456789'),
('Feira Organica', '61.608.564/0001-04', 'feiraorganica@gmail.com', '123456789'),
('Organilize', '13.748.108/0001-09', 'organilize@gmail.com', '123456789'),
('OrgAmo', '95.360.630/0001-83', 'orgamo@gmail.com', '123456789'),
('OrgVic', '60.130.155/0001-74', 'orgvic@gmail.com', '123456789');

INSERT INTO user (name, cpf, cellphone, email, password)
VALUES
('Elvis Vance', '375.930.764-74', '(81) 99483-3696', 'organiclovers@gmail.com', '123456789'),
('Arthur Arnold', '518.678.608-05', '(81) 99268-1148', 'organikey@gmail.com', '123456789'),
('Tallulah Sheppard', '272.651.524-09', '(81) 99744-3727', 'organition@gmail.com', '123456789'),
('Carissa Hinton', '825.567.651-19', '(81) 99738-6571', 'organination@gmail.com', '123456789'),
('Bianca Erickson', '550.347.213-68', '(81) 99618-7623', 'organic@gmail.com', '123456789'),
('Kadeem Armstrong', '352.759.932-00', '(81) 99806-6700', 'organico@gmail.com', '123456789'),
('Latifah Slater', '172.001.293-80', '(81) 99503-5952', 'feiraorganica@gmail.com', '123456789'),
('Isaac Cook', '758.531.587-24', '(81) 99888-8100', 'organilize@gmail.com', '123456789'),
('Basia Mcfarland', '970.254.596-07', '(81) 99221-5619', 'orgamo@gmail.com', '123456789'),
('Geraldine Bailey', '', '(81) 99278-5549', 'orgvic@gmail.com', '123456789');



