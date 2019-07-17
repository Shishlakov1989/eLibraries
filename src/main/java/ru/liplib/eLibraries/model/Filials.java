package ru.liplib.eLibraries.model;

public enum Filials {
    BUNINA ("БИЦ им. И.А. Бунина"),
    SMURGISA ("БИЦ им. Е. Смургиса"),
    BARTENEVKA ("БИЦ П.П. Бартенева"),
    BICNK ("БИЦ национальных культур"),
    RUDNICHNIY ("БИЦ Рудничный"),
    LEVOBEREZHNIY ("БИЦ Левобережный"),
    STSH ("БИЦ им. П.П. Семенова-Тян-Шанского"),
    SOCIALNIY ("БИЦ Социальный"),
    BSCH ("БИЦ семейного чтения"),
    VIB ("Военно-историческая библиотека"),
    SOKOLSKAYA ("Библиотека Сокольская"),
    SOLNECHNAYA ("Библиотека Солнечная"),
    PREOBRAZHENIE ("Библиотека Преображение"),
    ERUDIT ("Эрудит"),
    DACHNIY ("Библиотека На Дачном"),
    MATIRA ("Библиотека Матырская"),
    ESENINKA ("ЦГБ им. С.А. Есенина"),
    PRISHVINKA ("ЦГДБ им. М.М. Пришвина");

    private String title;

    Filials(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return title;
    }
}
