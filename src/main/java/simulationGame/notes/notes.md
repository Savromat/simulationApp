# Entity - базовый класс для все сущностей игрового мира
У всех сущностей есть:
- цвет Color color;
- символ Symbol symbol;
- координата Coordinates coordinates;
- флаг boolean hasMoved (сущность может сделать ход или нет).
- недостаток - наверное, базовый класс перегружен методами и переменными (уточнить на ревью).

# Symbol - enum
- В данном классе-перечислении указаны используемые сущностями символы.

# Color - enum
- В данном классе-перечислении указаны используемые сущностями цвета.

# Coordinates - record
- Т.к. данный класс содержит два поля private final, то сделаем из него неизменяемую модель данных (record)
- Данный класс отвечает за хранение и предоставления координат, а также измененных на 1 шаг координат
- Для упрощения принимаем, что все сущности делают ход только на одну клетку вверх/вниз/вправо/влево.
- Coordinates будет ключем в хэшмапе поля (immutable data type)

# Rock, Tree, Grass - классы-наследники Entity

# Creature - абстрактный класс-наследник Entity
- является родителем для сущностей, которые могут делать ходы по карте, и имеет 
абстрактный метод makeMove().

# Herbivore - наследник Creature, травоядное
- Herbivore имеет поле здоровье, может принимать урон от хищника;
- может передвигаться -> оверрайдит метод makeMove();

# Predator - наследник Creature, хищник
- имеет свойство - сила атаки
- может передвигаться -> перезаписывает  метод makeMove();

# GameField - класс, который является игровым полем, на котором размещаются и делаю ходы сущности.
- в конструкторе при создании экземпляра данного класса можем задать параметры игрового поля;
- класс содержит методы, связанные с работой игрового поля 
(проверка на границы поля, удалить с поля, разместить на поле и т.д.).

# BFS - класс, который содержит алгоритм поиска цели

# ConsoleRenderer - класс, к/й ответственен за рендеринг поля в консоль

# Simulation - класс, к/й отвечает за цикличное воспроизведение Симуляции игрового мира
- многопоточность делал с чатЖПТ, понимаю поверхностно (только с объяснений нейронки).




