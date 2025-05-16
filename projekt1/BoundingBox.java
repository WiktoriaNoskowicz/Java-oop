public record BoundingBox(Float x, Float y, Float width, Float height) {

}//record to specjalny typ klasy, uproszczony, niemutowalny
//wszystkie obiekty kotych chcemy używac musza byc przekazane jako argumenty
//rekord nie moze dziedziczyc po innych klasach
//rekordy sa automatycznie final -> nie mozemy ich modyfikowac ale mozna implements Interface!!!!!
//dla rekordów java automatycznie tworzy konstruktor ale napisac swoj -> musi miec te same argumenty


