<#import "blocks/page.ftl" as p>

<@p.main "Добавить читателя">
    <div>
        <form method="post" action="">
            <label for="fio">FIO</label>
            <input type="text" name="fio" id="fio" />
            <label for="birthdate">Birthdate</label>
            <input type="date" name="birthdate" id="birthdate" />
            <label for="hasLitres">Litres</label>
            <input type="checkbox" name="hasLitres" id="hasLitres" />
            <label for="hasNonfiction">Non-fiction</label>
            <input type="checkbox" name="hasNonfiction" id="hasNonfiction" />
            <label for="libNum">Library number</label>
            <input type="number" name="libNum" id="libNum" />
            <input type="hidden" name="_csrf" value="{{_csrf.token}}">
            <button type="submit">Добавить</button>
        </form>
    </div>
</@p.main>