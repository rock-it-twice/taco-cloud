delete FROM Ingredient_ref;
delete FROM Taco;
delete FROM Taco_Order;

delete FROM Ingredient;
insert INTO Ingredient (id, name, type)
    values ('FLTO', 'Flour Tortilla', 'WRAP');
insert INTO Ingredient (id, name, type)
    values ('COTO', 'Corn Tortilla', 'WRAP');
insert INTO Ingredient (id, name, type)
    values ('GRBF', 'Ground Beef', 'PROTEIN');
insert INTO Ingredient (id, name, type)
    values ('CARN', 'Carnitas', 'PROTEIN');
insert INTO Ingredient (id, name, type)
    values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert INTO Ingredient (id, name, type)
    values ('LETC', 'Lettuce', 'VEGGIES');
insert INTO Ingredient (id, name, type)
    values ('CHED', 'Cheddar', 'CHEESE');
insert INTO Ingredient (id, name, type)
    values ('JACK', 'Lamber Jack', 'CHEESE');
insert INTO Ingredient (id, name, type)
    values ('SLSA', 'Salsa', 'SAUCE');
insert INTO Ingredient (id, name, type)
    values ('SRCR', 'Sour Cream', 'SAUCE');